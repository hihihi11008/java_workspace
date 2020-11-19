package com.swingmall.admin.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.swingmall.admin.AdminMain;
import com.swingmall.admin.Page;
import com.swingmall.util.db.DBManager;



public class Product extends Page{
	JPanel p_west;//tree 올 영역
	JPanel p_center; 
	JTree tree;
	JTable table;
	JScrollPane s1,s2;
	JButton bt_regist;
	
	//상위카테고리,하위카테고리 
	ArrayList<String> topCategory;//최상위 카테고리 이름을 담게될 리스트 top, down, accessory, shoes
	ArrayList<ArrayList> subCategory =new ArrayList<ArrayList>(); //모든하위 카테고리  
	
	DBManager dbManager;
	ProductModel model;
	RegistForm registForm;
	
	public Product(AdminMain adminMain) {
		
		super(adminMain);
		
		//카테고리 가져오기 
		getTopCategory();//멤버변수인 topCategory에 최상위 카테고리가 채워진다
		for (String name : topCategory) {
			getSubCategory(name);
		}
		
		//노드만들기 
		DefaultMutableTreeNode	 top = new DefaultMutableTreeNode("상품정보");
		for (int i = 0; i < topCategory.size(); i++) {
			top.add(getCreatedNode(topCategory.get(i), subCategory.get(i)));
		}
		
		
		//생성
		p_west = new JPanel();
		p_center = new JPanel();
		tree = new JTree(top);//노드를 넣을 예정 
		table = new JTable();
		s1 = new JScrollPane(tree);
		s2 = new JScrollPane(table);
		bt_regist = new JButton("등록하기");
		registForm = new RegistForm(this);		//등록폼 생성

 
		
		//스타일
		s1.setPreferredSize(new Dimension(200, AdminMain.HEIGHT-100));
		p_west.setBackground(Color.white);
		s2.setPreferredSize(new Dimension(AdminMain.WIDTH-200, AdminMain.HEIGHT-300));
		
		//조립
		setLayout(new BorderLayout());
		
		p_west.add(s1);
		p_center.add(s2);
		p_center.add(bt_regist);
		
		add(p_west, BorderLayout.WEST);
		add(p_center);//현재 패널이 보더레이아웃이므로, visible(false)는 안됌
		//add(registForm);

		

		getProductList(null);//모든 상품가져오기 				
		
		//tree는 이벤트가 별도로 지원 
		tree.addTreeSelectionListener((e)->{
//			System.out.println("나..?");
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			if (selectedNode.toString().equals("상품목록")) {
				getProductList(null);//모든 상품가져오기 				
			}else {
				getProductList(selectedNode.toString());
			}
		});
		
		bt_regist.addActionListener((e)->{
			addRemoveContent(p_center, registForm);
		});

		
	}
	
	//상위 카테고리 가져오기 
	public void getTopCategory() {
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		String sql="select * from topcategory";
		
		try {
			pstmt=getAdminMain().getCon().prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			//배열은 유연하지 못하므로, ArrayList에 담자
			topCategory = new ArrayList<String>();
			while (rs.next()) {
				topCategory.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAdminMain().getDbManager().close(pstmt, rs);			
		}
	}
	
	//하위 카테고리 가져오기 
	public void getSubCategory(String name) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList subList= new ArrayList();//상위카테고리에 등록된 하위카테고리 
		//System.out.println(name);
		
		String sql="select * from subcategory where topcategory_id=(select topcategory_id from topcategory where name=?)";		
		try {
			pstmt=getAdminMain().getCon().prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				subList.add(rs.getString("name"));
			}
			//모두담겨지면 이차원 리스트에 추가해놓자 
			subCategory.add(subList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAdminMain().getDbManager().close(pstmt, rs);			
		}
	}
	
	
	//트리노드 생성하기                                                        상위노드                         하위노드 
	public DefaultMutableTreeNode getCreatedNode(String parentName, ArrayList childName) {
		//부모노드 생성하기! 
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);
		
		//넘겨받은 매개변수인 ArrayList 만큼 반복하여 부모노드에 자식노드 부착 
		if (childName!=null) {
			for (int i = 0; i < childName.size(); i++) {
				parent.add(new DefaultMutableTreeNode(childName.get(i)));
			}			
		}
		return parent;
	}
	
	//상품가져오기 
	public void getProductList(String name) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		
		String sql=null;
		if (name==null) {// name이 안넘어오면 모든 상품가져오기 
			sql="select * from product";
		}else {	//name값이 넘어오면 조건 쿼리수행 
			sql="select * from product where subcategory_id=(select subcategory_id from subcategory where name='"+name+"')";
		}
		try {
			pstmt=getAdminMain().getCon().prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//메타 정보를 이용하여 ProductModel의 column ArrayList를 채우자 
			ArrayList<String> columnNames= new ArrayList<String>();
			
			ResultSetMetaData meta=rs.getMetaData();
			int columnCount = meta.getColumnCount();// 총 컬럼의 갯수 
			for (int i = 1; i <= columnCount; i++) {
				//System.out.println(meta.getColumnName(i));
				columnNames.add(meta.getColumnName(i));//컬럼명추출 
			}
			
			//rs의 레코드를 ProductModel의 record ArrayList에 채우자 
			ArrayList <ProductVO> productList= new ArrayList<ProductVO>();
			
			while (rs.next()) {
				ProductVO vo= new ProductVO();
				vo.setProduct_id(rs.getInt("product_id"));
				vo.setSubcategory_id(rs.getInt("subcategory_id"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setBrand(rs.getString("band"));// 열이름 잘못적은것 
				vo.setPrice(rs.getInt("price"));
				vo.setFilename(rs.getString("filename"));
				vo.setDetail(rs.getString("detail"));
				productList.add(vo);//방금 생성하고 하나의 레코드가 채워진 vo를 ArrayList에 추가하자 
			}
			model=new ProductModel();
			model.column=columnNames;
			model.record=productList;
			table.setModel(model);
			table.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAdminMain().getDbManager().close(pstmt, rs);
			
		}
		
	}
	//보여질 컨텐트와 가려질 컨텐트를 제어하는 메서드 
	public void addRemoveContent(Component removeObj, Component addObj) {
		this.remove(removeObj);
		this.add(addObj);
		((JPanel)addObj).updateUI();
	}

}
