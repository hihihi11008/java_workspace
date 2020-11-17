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
   
   
   Connection con; //boardApp�� con
   
   public Login(BoardApp boardApp) {
      this.boardApp=boardApp;
      con = boardApp.getCon(); //getter con�޼���
      
      p_container = new JPanel();
      t_id = new JTextField(30);
      t_pass = new JPasswordField(30);
      bt_regist = new JButton("ȸ������");
      bt_login = new JButton("�α���");
      
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
      
      //�α��� ��ư�� ������ ����
      bt_login.addActionListener((e)-> {
         login();
      });
   }
   
   
/*�����ͺ��̽� ������ ��� �޼��帶�� ����~�����ϸ� �����߻�,
 * ȿ������ ���� ������ ���α׷� ������ ���ÿ� �ѹ� �����س��� ���α׷� �����Ҷ� ��������
 * */
   public void login() {      
      //ȸ���Դϴ� or ȸ���� �ƴմϴ�.      
      PreparedStatement pstmt=null;
      ResultSet rs =null;
      
      String sql = "select * from board_member where m_id=? and m_pass=?";
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, t_id.getText());
         pstmt.setString(2, new String(t_pass.getPassword()));
         
         rs = pstmt.executeQuery();//���� ����, select ���̹Ƿ� ���ڵ带 ���� ResultSet�� ��ȯ�ȴ�.
         //�α����� ���, ����� �� ������ �� ��� ���ڵ�� �� ���� ���ñ�? 1��
         //rs�� ��ȯ�� ������������ rsĿ�� �������� ���ڵ� �����Ѵٸ�? ���� ����
         //���ٸ� �α��� ����
         if(rs.next()) { //���ڵ尡 �����Ѵٸ� ȸ������ ����
            JOptionPane.showMessageDialog(this, "���� ����");
            
            //�α��� ���������� ȸ�������� ���� + ���������� true�� 
            boardApp.setHasSession(true);
            
            //ȸ������ ä���ֱ� 
            BoardMember boardMember = new BoardMember();//empty
            boardMember.setMember_id(rs.getInt("member_id"));
            boardMember.setM_id(rs.getString("m_id"));
            boardMember.setM_pass(rs.getString("m_pass"));
            boardMember.setM_name(rs.getString("m_name"));
            boardMember.setRegdate(rs.getString("regdate"));
            
            //boardApp�� ������ ȸ������ ��ü �ּҰ����� 
            boardApp.setBoardMember(boardMember);
            
            boardApp.setPage(BoardApp.BOARD_LIST);
         }else {
            JOptionPane.showMessageDialog(this, "�α��� ������ �ùٸ��� �ʽ��ϴ�.");
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