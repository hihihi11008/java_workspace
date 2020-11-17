package day1111.member;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import day1111.board.BoardApp;

public class Login extends JPanel{
   JPanel p_container;
   JTextField t_id;
   JPasswordField t_pass;
   JButton bt_regist;
   JButton bt_login;
   BoardApp boardApp;
   
   
   Connection con; //boardApp의 con
   
   public Login(BoardApp boardApp) {
      this.boardApp=boardApp;
      con = boardApp.getCon(); //getter con메서드
      
      p_container = new JPanel();
      t_id = new JTextField(30);
      t_pass = new JPasswordField(30);
      bt_regist = new JButton("회원가입");
      bt_login = new JButton("로그인");
      
      p_container.setPreferredSize(new Dimension(350, 150));
      
      p_container.add(t_id);
      p_container.add(t_pass);
      p_container.add(bt_regist);
      p_container.add(bt_login);
      
      add(p_container);
      
      setVisible(true);
      
      bt_regist.addActionListener((e)->{
         boardApp.setPage(BoardApp.MEMBER_REGIST);
      });
      
      //로그인 버튼과 리스너 연결
      bt_login.addActionListener((e)-> {
         login();
      });
   }
   
   
/*데이터베이스 연결을 모든 메서드마다 접속~끊기하면 문제발생,
 * 효율성도 없기 때문에 프로그램 가동과 동시에 한번 접속해놓고 프로그램 종료할때 접속해제
 * */
   public void login() {      
      //회원입니다 or 회원이 아닙니다.      
      PreparedStatement pstmt=null;
      ResultSet rs =null;
      
      String sql = "select * from board_member where m_id=? and m_pass=?";
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, t_id.getText());
         pstmt.setString(2, new String(t_pass.getPassword()));
         
         rs = pstmt.executeQuery();//쿼리 실행, select 문이므로 레코드를 담은 ResultSet이 반환된다.
         //로그인의 경우, 제대로 된 인증이 될 경우 레코드는 몇 건이 나올까? 1건
         //rs가 반환된 시점에서부턴 rs커서 내렸을때 레코드 존재한다면? 인증 성공
         //없다면 로그인 실패
         if(rs.next()) { //레코드가 존재한다면 회원인증 성공
            JOptionPane.showMessageDialog(this, "인증 성공");
            
            //로그인 성공했을때 회원정보를 보관 + 인증변수도 true로 
            boardApp.setHasSession(true);
            
            //회원정보 채워넣기 
            BoardMember boardMember = new BoardMember();//empty
            boardMember.setMember_id(rs.getInt("member_id"));
            boardMember.setM_id(rs.getString("m_id"));
            boardMember.setM_pass(rs.getString("m_pass"));
            boardMember.setM_name(rs.getString("m_name"));
            boardMember.setRegdate(rs.getString("regdate"));
            
            //boardApp가 보유한 회원정보 객체 주소값전달 
            boardApp.setBoardMember(boardMember);
            
            boardApp.setPage(BoardApp.BOARD_LIST);
         }else {
            JOptionPane.showMessageDialog(this, "로그인 정보가 올바르지 않습니다.");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(rs!=null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if(pstmt!=null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
   }
}