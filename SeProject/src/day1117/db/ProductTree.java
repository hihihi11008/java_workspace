
package day1117.db;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProductTree extends JFrame{
	JTree tree;
	JScrollPane scroll;
	
	//�迭�� �ִٸ� Ʈ�� ������ �޼��尡 �˾Ƽ� ���ִ� �ڵ� 
	String[] category = {"����","����","�׼�����","�Ź�"};//����ī�װ� �迭 
	String[][] product= {
			{"Ƽ����","����","��Ʈ","�����"},
			{"û����","�ݹ���","�����","Ÿ����"},
			{"�Ͱ���","�����","����","����"},
			{"����","�ȭ","����Ŀ��","����"}
	};
	
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="user1104";
	String password="user1104";
	Connection con;
	
	//top, down, accessory, shoes
	ArrayList<String> topCategory = new ArrayList<String>();
	ArrayList<ArrayList> subCategory = new ArrayList<ArrayList>();
	public ProductTree() {
		connect();
		
		
		//DB�����Ͽ� �迭���� �����͸� ���� DB�����ͷ� �������� 
		getTopCategory();
		
		//����ī�װ� �޼��带 ����ī�װ� ����ŭ ȣ���ϸ鼭 2���� ArrayList ������ �������� 
		for (int i = 0; i < topCategory.size(); i++) {
			String name=topCategory.get(i);
			ArrayList subList = (ArrayList)getSubCategory(name);
			subCategory.add(subList);
		}
		
		//��� ������ �ܺ� �޼���κ��� �������� 
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("��ǰ����");
//		for (int i = 0; i < category.length; i++) {
//			top.add(getCreatedNode(category[i], product[i]));			
//		}
		for (int i = 0; i < topCategory.size(); i++) {
			String name=topCategory.get(i);
			top.add(getCreatedNode(name, subCategory.get(i)));
		}
		
		tree = new JTree(top);
		scroll = new  JScrollPane(tree);
		
		add(scroll);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect();
				System.exit(0);
			}
		});
		
		setSize(400, 500);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		
	}
	
	//�̸޼��带 ȣ���ϴ� ����� �迭�� �ѱ�� �迭�� ���̸�ŭ ��带 �����Ͽ� ��ȯ���� ���� 
	public DefaultMutableTreeNode getCreatedNode(String parentName, String[] childName) {
		DefaultMutableTreeNode parent=new DefaultMutableTreeNode(parentName);//�θ����
		//�ڽ��� �� ��ŭ ��� ����� �θ� ����
		if (childName!=null) {
			for(int i=0; i<childName.length;i++) {
				parent.add(new DefaultMutableTreeNode(childName[i]));
			}			
		}
		return parent;
	}
	//���� �޼���� �迭�� ó���ϴ� ��������, �̸޼���� �̸��� ������ List������ ó�� 
	public DefaultMutableTreeNode getCreatedNode(String parentName, ArrayList childName) {
		DefaultMutableTreeNode parent=new DefaultMutableTreeNode(parentName);//�θ����
		//�ڽ��� �� ��ŭ ��� ����� �θ� ����
		if (childName!=null) {
			for(int i=0; i<childName.size();i++) {
				parent.add(new DefaultMutableTreeNode(childName.get(i)));
			}			
		}
		return parent;
	}
	
	public void connect() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			if (con==null) {
				JOptionPane.showMessageDialog(this, "������ ���� ����");
				System.exit(0);
			}else {
				this.setTitle(user+"�������� ������ ");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//����ī�װ� �������� 
	public void getTopCategory() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql = "select * from topcategory";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//�迭�� �ݵ�� �� ũ�⸦ ����ؾ��Ѵ� ���� �������� ���ϴ� 
			//���� �迭���ٴ� �÷��� ��ü �� List�迭�� ��õ 
			//rs�� Ŀ���� �Ӵٰ��� ���� �ʾƵ� �ɰ��̴� ! 
			
			while (rs.next()) {
				topCategory.add(rs.getString("NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//����ī�װ��������� 
	public List getSubCategory(String name) {//top, down, accessary, shoes
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList subList=new ArrayList();
		
		String sql="select * from subcategory where topcategory_id=(select topcategory_id from topcategory where name=?)";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);//���ε� ���� ����
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				subList.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return subList;//ȣ���ϴ� �ڰ� ����ī�װ� ��� ������ �� �ֵ��� 
	}
	
	public void disConnect() {
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new ProductTree();
	}
}
