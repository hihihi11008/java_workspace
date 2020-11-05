package day1105.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class EmpApp extends JFrame{
	JButton bt_connect, bt_load;
	JTextArea area;
	JScrollPane scroll;
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="user1104";
	String password="user1104";
	Connection con; // ���� �� , �� ������ ���� ��ü 
	PreparedStatement pstmt;//������ ���� ��ü, �������̽��̹Ƿ� new�� �����ϴ� ���� �ƴ϶� ���Ӱ�ü�� Connection��ü�� ���� �ν��Ͻ��� ���ü��ִ�. 
											//why? ������ �����Ǿ�� �������� ������ �� �����Ƿ�, ���Ӱ�ü�� �������ΰ��� �翬�ϴ� 
	ResultSet rs;//select ������ �������� ���� ǥ�� ��ȯ�Ǵµ�, �̶� �� ǥ����� ��ü
	
	public EmpApp() {
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void connect() {
		//����Ŭ ���ӽõ��ϱ�! (1.����̹� �ε� 2.����)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EmpApp();
	}
}
