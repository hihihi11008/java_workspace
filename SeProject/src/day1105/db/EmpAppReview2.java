package day1105.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpAppReview2{
	
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user="user1104";
			String password = "user1104";
			
			con = DriverManager.getConnection(url, user, password);
			if (con == null) {
				System.out.println("접속 실패");
			}else {
				System.out.println("접속성공");
				String sql = "select * from emp";				
				pstmt = con.prepareStatement(sql);				
				rs = pstmt.executeQuery(sql);		
				
				System.out.println("EMPNO\t ENAME\t JOB\t MGR\t\t HIREDATE\t\t SAL\t COMM\t DEPTNO\t \n");
				while (rs.next()) {
					int empno=rs.getInt("empno");
					String ename = rs.getNString("ename");
					String job = rs.getString("job");
					String mgr = rs.getString("mgr");
					String hiredate = rs.getString("hiredate");
					String sal = rs.getString("sal");
					String comm = rs.getString("comm");
					String deptno = rs.getString("deptno");
					
					System.out.println(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno+"\t"+"\n");					
				}
			}			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
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
			System.exit(0);
		}
	}
}