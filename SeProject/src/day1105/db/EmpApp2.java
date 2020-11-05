package day1105.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class EmpApp2 extends JFrame{
	JButton bt_connect, bt_load;
	JTextArea area;
	JScrollPane scroll;
	
	//JDBC ����� DBMS������ ������� �߸����� �ڵ带 �ۼ��� �� �ֵ��� �����Ѵ� 
	//�ش� DB�������� �˸´� Dirver�� ����ؾ� �Ѵ�. 
	String url="jdbc:mariadb://localhost/db1105";
	String user="root";
	String password="1234";
	Connection con; // ���� �� , �� ������ ���� ��ü 
	PreparedStatement pstmt;//������ ���� ��ü, �������̽��̹Ƿ� new�� �����ϴ� ���� �ƴ϶� ���Ӱ�ü�� Connection��ü�� ���� �ν��Ͻ��� ���ü��ִ�. 
											//why? ������ �����Ǿ�� �������� ������ �� �����Ƿ�, ���Ӱ�ü�� �������ΰ��� �翬�ϴ� 
	ResultSet rs;//select ������ �������� ���� ǥ�� ��ȯ�Ǵµ�, �̶� �� ǥ����� ��ü
	
	public EmpApp2() {
		bt_connect = new JButton("Connect");
		bt_load = new JButton("Load");
		
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		//��Ÿ������
		area.setPreferredSize(new Dimension(780,550));
		
		
		setLayout(new FlowLayout());
		
		add(bt_connect);
		add(bt_load);
		add(scroll);
		
		//��ư�� ������ ���� 
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();//����Ŭ����
			}
		});
		bt_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();//select 
			}
		});
		
		setSize(800, 600);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE); //DB�� �����ʰ�, ���μ����� �����ع����ѱ�!

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//�����ִ� �����ͺ��̽� ���� ��ü�� ��� �ݤ��� 
				//System.out.println("�̰ǰ�!!! ");
				if (rs!=null) {
					try {
						rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				//���μ��� ���� 
				System.exit(0);
			}
		});
	}
	
	public void connect() {
		//����Ŭ ���ӽõ��ϱ�! (1.����̹� �ε� 2.����)
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			area.append("����̹� �ε� ����\n");
			
			//���ӽõ� 
			con = DriverManager.getConnection(url,user,password);
			if(con==null) {
				area.append("���ӽ���\n");
			}else {
				area.append("���Ӽ���\n");				
			}
		} catch (ClassNotFoundException e) {
			area.append("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void load() {
		//select���� �����غ���! 
		String sql = "select * from emp";
		
		try {
			pstmt = con.prepareStatement(sql);
			//pstmt.executeUpdate();//DML�� ��츸
			
			//select ���� ��쿣 executeQuery() �̿��ؾ��� 
			rs = pstmt.executeQuery(sql);
			//rs���� ǥ�� ����ִ�! ���� ���ϴ� ���ڵ�� Ŀ���� �ű��� 
			//rs.next();//�����Ͱ� �����ϸ�, ��ĭ ���� ��  true���� ��ȯ 
			area.append("EMPNO\t ENAME\t JOB\t MGR\t HIREDATE\t\t SAL\t COMM\t DEPTNO\t \n");
			while (rs.next()) {
				int empno=rs.getInt("empno");
				String ename= rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
			
				area.append(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno+"\t"+"\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EmpApp2();
	}
}
