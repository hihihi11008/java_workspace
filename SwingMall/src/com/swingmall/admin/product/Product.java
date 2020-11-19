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
	JPanel p_west;//tree �� ����
	JPanel p_center; 
	JTree tree;
	JTable table;
	JScrollPane s1,s2;
	JButton bt_regist;
	
	//����ī�װ�,����ī�װ� 
	ArrayList<String> topCategory;//�ֻ��� ī�װ� �̸��� ��Ե� ����Ʈ top, down, accessory, shoes
	ArrayList<ArrayList> subCategory =new ArrayList<ArrayList>(); //������� ī�װ�  
	
	DBManager dbManager;
	ProductModel model;
	RegistForm registForm;
	
	public Product(AdminMain adminMain) {
		
		super(adminMain);
		
		//ī�װ� �������� 
		getTopCategory();//��������� topCategory�� �ֻ��� ī�װ��� ä������
		for (String name : topCategory) {
			getSubCategory(name);
		}
		
		//��常��� 
		DefaultMutableTreeNode	 top = new DefaultMutableTreeNode("��ǰ����");
		for (int i = 0; i < topCategory.size(); i++) {
			top.add(getCreatedNode(topCategory.get(i), subCategory.get(i)));
		}
		
		
		//����
		p_west = new JPanel();
		p_center = new JPanel();
		tree = new JTree(top);//��带 ���� ���� 
		table = new JTable();
		s1 = new JScrollPane(tree);
		s2 = new JScrollPane(table);
		bt_regist = new JButton("����ϱ�");
		registForm = new RegistForm(this);		//����� ����

 
		
		//��Ÿ��
		s1.setPreferredSize(new Dimension(200, AdminMain.HEIGHT-100));
		p_west.setBackground(Color.white);
		s2.setPreferredSize(new Dimension(AdminMain.WIDTH-200, AdminMain.HEIGHT-300));
		
		//����
		setLayout(new BorderLayout());
		
		p_west.add(s1);
		p_center.add(s2);
		p_center.add(bt_regist);
		
		add(p_west, BorderLayout.WEST);
		add(p_center);//���� �г��� �������̾ƿ��̹Ƿ�, visible(false)�� �ȉ�
		//add(registForm);

		

		getProductList(null);//��� ��ǰ�������� 				
		
		//tree�� �̺�Ʈ�� ������ ���� 
		tree.addTreeSelectionListener((e)->{
//			System.out.println("��..?");
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			if (selectedNode.toString().equals("��ǰ���")) {
				getProductList(null);//��� ��ǰ�������� 				
			}else {
				getProductList(selectedNode.toString());
			}
		});
		
		bt_regist.addActionListener((e)->{
			addRemoveContent(p_center, registForm);
		});

		
	}
	
	//���� ī�װ� �������� 
	public void getTopCategory() {
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		String sql="select * from topcategory";
		
		try {
			pstmt=getAdminMain().getCon().prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			//�迭�� �������� ���ϹǷ�, ArrayList�� ����
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
	
	//���� ī�װ� �������� 
	public void getSubCategory(String name) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList subList= new ArrayList();//����ī�װ��� ��ϵ� ����ī�װ� 
		//System.out.println(name);
		
		String sql="select * from subcategory where topcategory_id=(select topcategory_id from topcategory where name=?)";		
		try {
			pstmt=getAdminMain().getCon().prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				subList.add(rs.getString("name"));
			}
			//��δ������ ������ ����Ʈ�� �߰��س��� 
			subCategory.add(subList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAdminMain().getDbManager().close(pstmt, rs);			
		}
	}
	
	
	//Ʈ����� �����ϱ�                                                        �������                         ������� 
	public DefaultMutableTreeNode getCreatedNode(String parentName, ArrayList childName) {
		//�θ��� �����ϱ�! 
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);
		
		//�Ѱܹ��� �Ű������� ArrayList ��ŭ �ݺ��Ͽ� �θ��忡 �ڽĳ�� ���� 
		if (childName!=null) {
			for (int i = 0; i < childName.size(); i++) {
				parent.add(new DefaultMutableTreeNode(childName.get(i)));
			}			
		}
		return parent;
	}
	
	//��ǰ�������� 
	public void getProductList(String name) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		
		String sql=null;
		if (name==null) {// name�� �ȳѾ���� ��� ��ǰ�������� 
			sql="select * from product";
		}else {	//name���� �Ѿ���� ���� �������� 
			sql="select * from product where subcategory_id=(select subcategory_id from subcategory where name='"+name+"')";
		}
		try {
			pstmt=getAdminMain().getCon().prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//��Ÿ ������ �̿��Ͽ� ProductModel�� column ArrayList�� ä���� 
			ArrayList<String> columnNames= new ArrayList<String>();
			
			ResultSetMetaData meta=rs.getMetaData();
			int columnCount = meta.getColumnCount();// �� �÷��� ���� 
			for (int i = 1; i <= columnCount; i++) {
				//System.out.println(meta.getColumnName(i));
				columnNames.add(meta.getColumnName(i));//�÷������� 
			}
			
			//rs�� ���ڵ带 ProductModel�� record ArrayList�� ä���� 
			ArrayList <ProductVO> productList= new ArrayList<ProductVO>();
			
			while (rs.next()) {
				ProductVO vo= new ProductVO();
				vo.setProduct_id(rs.getInt("product_id"));
				vo.setSubcategory_id(rs.getInt("subcategory_id"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setBrand(rs.getString("band"));// ���̸� �߸������� 
				vo.setPrice(rs.getInt("price"));
				vo.setFilename(rs.getString("filename"));
				vo.setDetail(rs.getString("detail"));
				productList.add(vo);//��� �����ϰ� �ϳ��� ���ڵ尡 ä���� vo�� ArrayList�� �߰����� 
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
	//������ ����Ʈ�� ������ ����Ʈ�� �����ϴ� �޼��� 
	public void addRemoveContent(Component removeObj, Component addObj) {
		this.remove(removeObj);
		this.add(addObj);
		((JPanel)addObj).updateUI();
	}

}
