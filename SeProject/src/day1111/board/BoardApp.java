package day1111.board;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import common.image.ImageUtil;
import day1111.member.BoardMember;
import day1111.member.Login;
import day1111.member.RegistForm;


/*
 * BoardApp�� ��� 
 * */
public class BoardApp extends JFrame{
   JPanel p_north;
   JButton bt_board, bt_regist, bt_login;
   JPanel p_center;
   
   private JPanel[] pages=new JPanel[5]; //ȭ����ȯ�� ���� �гε��� ��Ե� �迭
   
   //�����? ������ �ʴ� �����Ϳ� �ǹ̸� �ο��Ͽ� �������� ���̱� ���� ����Ѵ�
   public static final int BOARD_LIST=0;
   public static final int BOARD_WRITE=1;
   public static final int BOARD_DETAIL=2;
   public static final int MEMBER_REGIST=3;
   public static final int MEMBER_LOGIN=4;
   
   //��� ���������� ����� �������� ��ü�� ���� ����
   //�� ���ؼ� ��ü�� ���α׷� ������ ���� �������
   private String driver="oracle.jdbc.driver.OracleDriver";
   private String url="jdbc:oracle:thin:@localhost:1521:XE";
   private String user="user1104";
   private String pass="user1104";
   
   private Connection con;
   
   //�α��� ���� ���θ� ������ ����
   private boolean hasSession=false; //������ �����ϰ� �ִ���
   
   //ȸ�������� ������ �ڷ���? 
   //�� ������ �����Ͱ� ä������ ����? �α��� ������ 
   private BoardMember boardMember; //�� ������ �����Ͱ� ä������ ���� 
   
   
   public BoardApp() {
      this.getConnection(); //�������� �����ֱ� ������ �����ͺ��̽� ���� �����س���
      //����
      p_north = new JPanel();
//   bt_board = new JButton(ImageUtil.getIcon(this.getClass(), "res/board.png", 90, 35));
      bt_board = new JButton("�Խ���");
      bt_regist = new JButton("ȸ������");
      bt_login = new JButton("�α���\n",ImageUtil.getIcon(this.getClass(), "res/login.png", 20, 20));
      //bt_login = new JButton("�α���");
      p_center = new JPanel();
      
      pages[0] = new BoardList(this); //�Խ��� ��� ������ 
      pages[1] = new BoardWrite(this); //�Խ��� �۾��� ������ 
      pages[2] = new BoardDetail(this); //�Խ��� �󼼺��� ������ 
      pages[3] = new RegistForm(this); //�Խ��� �󼼺��� ������ 
      pages[4] = new Login(this); //�Խ��� �󼼺��� ������ 
      
      //��Ÿ�� 
      bt_board.setPreferredSize(new Dimension(100, 35));
      bt_regist.setPreferredSize(new Dimension(100, 35));
      bt_login.setPreferredSize(new Dimension(100, 50));
      
      //���� 
      p_north.add(bt_board);
      p_north.add(bt_regist);
      p_north.add(bt_login);
      
      p_center.add(pages[0]);//�߾� �гο� �Խ��� ��� �ٿ��ֱ�
      p_center.add(pages[1]);//�߾� �гο� �Խ��� �۾��� �ٿ��ֱ�
      p_center.add(pages[2]);//�߾� �гο� �Խ��� �󼼺��� �ٿ��ֱ�
      p_center.add(pages[3]);//�߾� �гο� ȸ������ �ٿ��ֱ�
      p_center.add(pages[4]);//�߾� �гο� �α��� �ٿ��ֱ�
      
      add(p_north, BorderLayout.NORTH);
      add(p_center);            
      
      //����Ʈ�� ������ �������� �Ⱥ��̰� �� �������� ���� ó��
      loginCheck(BoardApp.BOARD_LIST);
      
      setVisible(true);
      setSize(800,600);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            disConnection();//��������
         }
      });
      
      //�Խ��ǹ�ư�� �����ʿ���
      bt_board.addActionListener((e)->{
         setPage(BOARD_LIST);
      });
      
      //���Թ�ư�� ������ ���� 
      //Lambdaǥ���� : �Լ��� ���α׷� ǥ�����̴� java 8���� ����
      //����) javascript������ ���ٸ� Ŭ������ �Ѵ�..
      //�̺�Ʈ ������ , �������� �޼��尡 �޶� 1���� ��� ����, �����͸�Ŭ������� ǥ�⸦
      //��â�ϰ� ����� �ʿ䰡 �ִ°�? ����� ������ ǥ����� ��������
      //����ǥ������ ��ü�� ��ġ �Լ�ó�� �����ϰ� ����� �� �ֵ��� �����ϴ� ǥ����̴�
      bt_regist.addActionListener((e)->{
         setPage(BoardApp.MEMBER_REGIST);
      });
      
      //�α��� ��ư�� �����ʿ���
      bt_login.addActionListener((e)->{
         setPage(MEMBER_LOGIN);
      });
      
   }
   
   //�� ���α׷����� ���Ǵ� ��� �������� �����ϴ� �޼��� 
   public void setPage(int showIndex) {//�����ְ� ���� ������ index  �Ѱܹ���
      for(int i=0;i<pages.length;i++) {
         if(i==showIndex) {
            pages[i].setVisible(true);
         }else {
            pages[i].setVisible(false);
         }
      }
   }
   
   //������ �õ��ϴ� �޼���
   public void getConnection() {
      try {
         Class.forName(driver); //����̹� �ε�
         con = DriverManager.getConnection(url,user,pass); //���ӽõ���, ��ü��ȯ
         if(con==null) { //���ӽ����ΰ�� �޽��� ȣ��
            JOptionPane.showMessageDialog(this, "�����ͺ��̽� �������� ���߽��ϴ�");
         }else {
            this.setTitle(user+"������");
         }
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   //������ �����ϴ� �޼��� ����
   //�� �޼���� ������â ������ ȣ�⿹��
   public void disConnection() {
      if(con!=null) {
         try {
            con.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   //�α��� ���θ� �Ǵ��ؼ� ���� �α������� �ʾҴٸ�, �α��� ������ �����ֱ�
   public void loginCheck(int page) {
      if(hasSession==false) { //�α��� ���� ���� ����
         JOptionPane.showMessageDialog(this, "�α��� �ʿ���");
         setPage(BoardApp.MEMBER_LOGIN);
      }else {
         setPage(page);
      }
   }
   
   
   //�ٸ� ��ü���� ������ �� �ֵ��� getter ����
   public Connection getCon() {
      return con;
   }
   
   //getter, setter
   public boolean isHasSession() {
	   return hasSession;
   }
   
   public void setHasSession(boolean hasSession) {
	   this.hasSession = hasSession;
   }
   
   public BoardMember getBoardMember() {
	   return boardMember;
   }
   
   public void setBoardMember(BoardMember boardMember) {
	   this.boardMember = boardMember;
   }
   
   //���������� ������ �� �ִ� getter
   public JPanel getPages(int pageName) {//BoardApp.BOARD_LIST
	   return pages[pageName];
   }
   
   public static void main(String[] args) {
      new BoardApp();
   }


}