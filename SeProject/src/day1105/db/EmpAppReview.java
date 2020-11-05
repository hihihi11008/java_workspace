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
			//1.드라이버 연결 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			//2.DB서버의 url, id, password
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="user1104";
			String password="user1104";
			
			//3.접속시도 
			con= DriverManager.getConnection(url, user, password);
			if (con==null) {
				System.out.println("접속실패");
			}else {
				System.out.println("접속 성공");
				
				//4.쿼리문수행
				String sql="insert into member(member_id, name, age, phone)";
				sql+=" values(seq_member.nextval, 'JJively', 30, '8875')";
				pstmt=con.prepareStatement(sql);
				int result=pstmt.executeUpdate();
				if (result!=1) {
					System.out.println("입력실패");
				}else {
					System.out.println("입력성공");
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