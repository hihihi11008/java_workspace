
/*
 * �����ͺ��̽��� ���õ� ������ ó���ϰ� �Ǵ� �ߺ��Ǵ� ������ ����ȭ���� ���뼺�� ���̱� ���� Ŭ����
 * */
package com.swingmall.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBManager {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String user="user1104";
	private String password="user1104";
	
	
	
	
	public Connection connect() {
		Connection con=null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//������ ����� ���õ� �ڿ��� �ݾ��ִ� �޼���(DML:insert, update,delete)
	public void close(PreparedStatement pstmt) {
		if (pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//select���� ���õ� ������������ 
	public void close(PreparedStatement pstmt, ResultSet rs) {
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
	
	//�ݰ���� Connection�� �޾ƿͼ� ó�� 
	public void disConnect(Connection con) {
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
