/*DBeaver 수준은 아니어도, 딕셔너리를 학습하기위해 데이터베이스 접속 클라이언트를 자바로 만들어본다 
 * 실무에서는 ,SQLPlus를 잘 사용하지 않음 이유) 업무효율성이 떨어지기 떄문임 
 * 				그럼언제쓰나? 실무 현장에서는 개발자의 pc에는 각종 개발툴들이 있지만, 실제적인 운영 서버에는  
 * 				보안상 아무것도 설치해서는 안된다. 따라서 서버에는 툴들이 없기때문에 만일 오라클을 유지보수하러 파견을 나간 경우 
 * 				콘솔창 기반으로 쿼리를 다뤄야할 경우가 종종 있다. 이때 SQLPlus를 써야함 
 * 				
 * 개발자들이 개발할때 데이터베이스 다루는 툴을 "데이터베이스 접속 클라이언트"라고 부른다.
 * 이러한 툴 들중 꽤 유명한 제품은 Toad, 등이 있다 (유료)
 * Toad는 DBeaver에 비해 기능이 막강하지만 유료이기에, 우린 DBeaver를 사용하고 있움  
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
	Choice ch_users;//유저명이 출력될 초이스 컴포넌트 
	JPasswordField t_pass;// 비밀번호 텍스트 필드 
	JButton bt_login;// 접속 버튼 
	
	JPanel p_center;//그리드가 적용될 센터패널 
	JTable t_tables;//유저의 테이블 정보를 출력할 JTable
	JTable t_seq; //유저의 시퀀스 정보를 출력한 JTable
	JScrollPane s1,s2;//스크롤 2개 준비 
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system"; //모든 유저를 보기위해 system으로 로그인 
	String password="1234";
	Connection con;
	
	//테이블을 출력할 백터, 및 컬럼
	Vector tableList=new Vector();//이 벡터안에는 추후 또다른 벡터가 들어갈 예정임, 즉 이차원 배열과 동일함 
												//단, 이차원배열보다는 크기가 자유로워서 유연함 코딩하기 편해 
	Vector<String> columnList= new Vector<String>();//컬럼명은 당연히 String 이므로 
	
	public DBMSClientApp() {
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("접속");
		
		//스타일 
		p_west.setPreferredSize(new Dimension(150, 350));
		ch_users.setPreferredSize(new Dimension(145, 30));
		t_pass.setPreferredSize(new Dimension(145, 30));
		bt_login.setPreferredSize(new Dimension(145, 30));
		
		p_center=new JPanel();
		p_center.setLayout(new GridLayout(2,1));
		t_tables = new JTable(tableList,columnList);//여기서 초기벡터값을 넣어준다, 이 시점엔 아직 db연동을 안한 상태이므로 
																		//사이즈가 0이지만, 추후 메서드호출시 벡터의 크기가 변경될 것이고 
																		//JTable을 새로고침하면 되겟죠? 
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
			login(); //선택한 유저로 로그인 시도하기 
		});
		
		setVisible(true);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);// ㅠㅡ로세스만 종료시켜버리고, 오라클, 스트림닫는 처리를 할 기회를 잃어버리게 된다 .
		//따라서 윈도우 어댑터 구현하여 닫을게 있다면 닫게 처리하자 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect();//시스템 종료전에 닫을 자원이 있을때 먼저 닫을려고 호출함 
				System.exit(0);
				
			}
		});
		setSize(700, 350);
		
		connect();
		getUserList();//유저목록구해오기 
		
		//컬럼정보 초기화하기 
		columnList.add("table_name");
		columnList.add("tablespace_name");
	}
	
	//오라클에 접속하기 
	public void connect() {
		try {
			Class.forName(driver); //드라이버로드 
			con=DriverManager.getConnection(url, user, password);//접속시도 
			if (con==null) {
				JOptionPane.showMessageDialog(this,user+"계정의 접속에 실패하였습니다.");
			}else {
				this.setTitle(user+"계정으로 접속중 ... ");//프레임 제목에 성공출력 
	
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//유저목록가져오기 
	public void getUserList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select username from dba_users order by username asc";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			//이제 rs 에 들어있는 유저정보를 Choice에 출력합시다
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
	
	//현재 접속 유저의 테이블목록 가져오기 
	public void getTableList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql = "select table_name, tablespace_name from user_tables";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();//쿼리실행 및 결과집합 받기 
			//평소같았으면 이차원 배열 선언한 후 last(). getRow() 스크롤 옵션 등등 아주 성가셧으나, 벡터를 이용하면 그런게 필요없음 
			while (rs.next()) {
				Vector vec=new Vector(); // tableList벡터에 담겨질 벡터 
				vec.add(rs.getNString("table_name"));
				vec.add(rs.getNString("tablespace_name"));
				
				tableList.add(vec);//멤버변수 벡터에 벡터를 담았으니, 이제 멤버변수 벡터는 이차원 벡터가 됨 
			}
			//완성된 이차원 벡터를 JTable에 반영해야함 
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
	
	//로그인 
	public void login() {
		//현재 유지되고 있는 접속 객체인 Connection을 끊고, 다른 유저로 접속을 시도한다 
		disConnect();//접속끊기 
		user = ch_users.getSelectedItem();//현재 초이스 컴포넌트에 선택된 아이템값
		password =new String( t_pass.getPassword());
		connect();//접속하기 (하지만 멤버변수가 현재 .system으로 되어 있으므로 멤버변수를 초이스 값으로 교체헤야한다)
		getTableList();// 바로 이시점에 로그인하자마자, 이사람의 테이블 정보를 보여주는게 좋을거같음 
	}
	
	//오라클에 접속끊기 
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
