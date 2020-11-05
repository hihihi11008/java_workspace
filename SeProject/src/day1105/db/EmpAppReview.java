package day1105.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpAppReview{
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			//1.����̹� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
			
			//2.DB������ url, id, password
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="user1104";
			String password="user1104";
			
			//3.���ӽõ� 
			con= DriverManager.getConnection(url, user, password);
			if (con==null) {
				System.out.println("���ӽ���");
			}else {
				System.out.println("���� ����");
				
				//4.����������
				String sql="insert into member(member_id, name, age, phone)";
				sql+=" values(seq_member.nextval, 'JJively', 30, '8875')";
				pstmt=con.prepareStatement(sql);
				int result=pstmt.executeUpdate();
				if (result!=1) {
					System.out.println("�Է½���");
				}else {
					System.out.println("�Է¼���");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
	}
}