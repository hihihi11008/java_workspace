/*DBeaver ������ �ƴϾ, ��ųʸ��� �н��ϱ����� �����ͺ��̽� ���� Ŭ���̾�Ʈ�� �ڹٷ� ������ 
 * �ǹ������� ,SQLPlus�� �� ������� ���� ����) ����ȿ������ �������� ������ 
 * 				�׷���������? �ǹ� ���忡���� �������� pc���� ���� ���������� ������, �������� � ��������  
 * 				���Ȼ� �ƹ��͵� ��ġ�ؼ��� �ȵȴ�. ���� �������� ������ ���⶧���� ���� ����Ŭ�� ���������Ϸ� �İ��� ���� ��� 
 * 				�ܼ�â ������� ������ �ٷ���� ��찡 ���� �ִ�. �̶� SQLPlus�� ����� 
 * 				
 * �����ڵ��� �����Ҷ� �����ͺ��̽� �ٷ�� ���� "�����ͺ��̽� ���� Ŭ���̾�Ʈ"��� �θ���.
 * �̷��� �� ���� �� ������ ��ǰ�� Toad, ���� �ִ� (����)
 * Toad�� DBeaver�� ���� ����� ���������� �����̱⿡, �츰 DBeaver�� ����ϰ� �ֿ�  
 * */
package day1116.dbclient;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class DBMSClientApp extends JFrame{
	JPanel p_west;
	Choice ch_users;//�������� ��µ� ���̽� ������Ʈ 
	JPasswordField t_pass;// ��й�ȣ �ؽ�Ʈ �ʵ� 
	JButton bt_login;// ���� ��ư 
	
	JPanel p_center;//�׸��尡 ����� �����г� 
	JTable t_tables;//������ ���̺� ������ ����� JTable
	JTable t_seq; //������ ������ ������ ����� JTable
	JScrollPane s1,s2;//��ũ�� 2�� �غ� 
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system"; //��� ������ �������� system���� �α��� 
	String password="1234";
	Connection con;
	
	//���̺��� ����� ����, �� �÷�
	Vector tableList=new Vector();//�� ���;ȿ��� ���� �Ǵٸ� ���Ͱ� �� ������, �� ������ �迭�� ������ 
												//��, �������迭���ٴ� ũ�Ⱑ �����ο��� ������ �ڵ��ϱ� ���� 
	Vector<String> columnList= new Vector<String>();//�÷����� �翬�� String �̹Ƿ� 
	
	public DBMSClientApp() {
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("����");
		
		//��Ÿ�� 
		p_west.setPreferredSize(new Dimension(150, 350));
		ch_users.setPreferredSize(new Dimension(145, 30));
		t_pass.setPreferredSize(new Dimension(145, 30));
		bt_login.setPreferredSize(new Dimension(145, 30));
		
		p_center=new JPanel();
		p_center.setLayout(new GridLayout(2,1));
		t_tables = new JTable(tableList,columnList);//���⼭ �ʱ⺤�Ͱ��� �־��ش�, �� ������ ���� db������ ���� �����̹Ƿ� 
																		//����� 0������, ���� �޼���ȣ��� ������ ũ�Ⱑ ����� ���̰� 
																		//JTable�� ���ΰ�ħ�ϸ� �ǰ���? 
		t_seq = new JTable();
		s1 = new JScrollPane(t_tables);
		s2 = new JScrollPane(t_seq);
		
		p_center.add(s1);
		p_center.add(s2);
		
		p_west.add(ch_users);
		p_west.add(t_pass);
		p_west.add(bt_login);
		
		add(p_center);
		add(p_west, BorderLayout.WEST);
		
		bt_login.addActionListener((e)->{
			login(); //������ ������ �α��� �õ��ϱ� 
		});
		
		setVisible(true);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);// �Фѷμ����� ������ѹ�����, ����Ŭ, ��Ʈ���ݴ� ó���� �� ��ȸ�� �Ҿ������ �ȴ� .
		//���� ������ ����� �����Ͽ� ������ �ִٸ� �ݰ� ó������ 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect();//�ý��� �������� ���� �ڿ��� ������ ���� �������� ȣ���� 
				System.exit(0);
				
			}
		});
		setSize(700, 350);
		
		connect();
		getUserList();//������ϱ��ؿ��� 
		
		//�÷����� �ʱ�ȭ�ϱ� 
		columnList.add("table_name");
		columnList.add("tablespace_name");
	}
	
	//����Ŭ�� �����ϱ� 
	public void connect() {
		try {
			Class.forName(driver); //����̹��ε� 
			con=DriverManager.getConnection(url, user, password);//���ӽõ� 
			if (con==null) {
				JOptionPane.showMessageDialog(this,user+"������ ���ӿ� �����Ͽ����ϴ�.");
			}else {
				this.setTitle(user+"�������� ������ ... ");//������ ���� ������� 
	
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//������ϰ������� 
	public void getUserList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select username from dba_users order by username asc";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			//���� rs �� ����ִ� ���������� Choice�� ����սô�
			while (rs.next()) {
				ch_users.add(rs.getString("username"));
				
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
	
	//���� ���� ������ ���̺��� �������� 
	public void getTableList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql = "select table_name, tablespace_name from user_tables";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();//�������� �� ������� �ޱ� 
			//��Ұ������� ������ �迭 ������ �� last(). getRow() ��ũ�� �ɼ� ��� ���� ����������, ���͸� �̿��ϸ� �׷��� �ʿ���� 
			while (rs.next()) {
				Vector vec=new Vector(); // tableList���Ϳ� ����� ���� 
				vec.add(rs.getNString("table_name"));
				vec.add(rs.getNString("tablespace_name"));
				
				tableList.add(vec);//������� ���Ϳ� ���͸� �������, ���� ������� ���ʹ� ������ ���Ͱ� �� 
			}
			//�ϼ��� ������ ���͸� JTable�� �ݿ��ؾ��� 
			t_tables.updateUI();
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
	
	//�α��� 
	public void login() {
		//���� �����ǰ� �ִ� ���� ��ü�� Connection�� ����, �ٸ� ������ ������ �õ��Ѵ� 
		disConnect();//���Ӳ��� 
		user = ch_users.getSelectedItem();//���� ���̽� ������Ʈ�� ���õ� �����۰�
		password =new String( t_pass.getPassword());
		connect();//�����ϱ� (������ ��������� ���� .system���� �Ǿ� �����Ƿ� ��������� ���̽� ������ ��ü����Ѵ�)
		getTableList();// �ٷ� �̽����� �α������ڸ���, �̻���� ���̺� ������ �����ִ°� �����Ű��� 
	}
	
	//����Ŭ�� ���Ӳ��� 
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
		new DBMSClientApp();
	}
}
