package com.swingmall.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingmall.board.QnA;
import com.swingmall.home.Home;
import com.swingmall.member.Login;
import com.swingmall.member.MyPage;
import com.swingmall.member.RegistForm;
import com.swingmall.product.Product;
import com.swingmall.product.ProductDetail;
import com.swingmall.util.db.DBManager;

public class ShopMain extends JFrame{
	//�������
	public static final int WIDTH=1200;
	public static final int HEIGHT=700;
	//�ֻ��� �������� 
	public static final int HOME=0;
	public static final int PRODUCT=1;
	public static final int QNA=2;
	public static final int MYPAGE=3;
	public static final int LOGIN=4;

	//����������
	public static final int PRODUCT_DETAIL=5;
	public static final int MEMBER_REGIST=6;
	
	JPanel usetype_container;//������, ����� ȭ���� �������� �� �ִ� �����̳� 
	JPanel p_content; //���⿡ ��� �������� �̸� �پ��� �������� ���� showPage �޼���� ������ ���� ����
								//��������ȯ������ ����Ʈ�� ������ xxxx
	
	JPanel p_navi;// ������Ʈ �� �޴��� ������ �����̳� �г�
	String[] navi_title= {"Home","Product","QnA","MyPage","Login"};
	JButton[] navi = new JButton[navi_title.length];//[][][][][] �迭 ����
	
	//������ ���� 
	Page[] page = new Page[7];//�ֻ�����������
	
	
	



	JLabel la_footer;//������ �ϴ��� ī�Ƕ���Ʈ ����
	private DBManager dbManager;
	private Connection con;
	

	public ShopMain() {
		dbManager = new DBManager();
		
		usetype_container = new JPanel();
		p_content = new JPanel();
		p_navi = new JPanel();
		la_footer = new JLabel("SwingMall All rights reserved", SwingConstants.CENTER);

		con = dbManager.connect();
		
		if (con==null) {
			JOptionPane.showMessageDialog(this, "�����ͺ��̽��� ������ �� �����ϴ�.");
			System.exit(0);
		}else {
			this.setTitle("SwingShop�� ���Ű� ȯ���մϴ�.");
		}
		
		//���γ׺���̼� ����
		for (int i = 0; i < navi.length; i++) {
			navi[i]= new JButton(navi_title[i]);
			p_navi.add(navi[i]);//�гο� �׺���̼� ���� 
		}
		
		//������ ���� 
		page[0]= new Home(this);
		page[1]= new Product(this);
		page[2]= new QnA(this);
		page[3]= new MyPage(this);
		page[4]= new Login(this);
		page[5]= new ProductDetail(this);//���������� ����
		page[6]= new RegistForm(this);//���������� ����
		
		
		//��Ÿ�� ���� 
		usetype_container.setPreferredSize(new Dimension(WIDTH, HEIGHT-100));
		usetype_container.setBackground(Color.WHITE);
		la_footer.setPreferredSize(new Dimension(WIDTH, 50));
		la_footer.setFont(new Font("Arial Black", Font.BOLD, 19));
		
		
		//����
		usetype_container.setLayout(new BorderLayout());
		usetype_container.add(p_navi, BorderLayout.NORTH);
		
		
		//��� �������� �̸� �ٿ�����
		for (int i = 0; i < page.length; i++) {
			p_content.add(page[i]);
		}
		usetype_container.add(p_content);
		
		this.add(usetype_container);
		this.add(la_footer, BorderLayout.SOUTH);
		
//		showPage(6);
		
		
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		//�����Ӱ� ������ ���� 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dbManager.disConnect(con);
			}
		});
		
		//�׺���̼� ��ư�� ������ ���� 
		for (int i = 0; i < navi.length; i++) {
			navi[i].addActionListener((e)->{
				Object obj=e.getSource();
				if (obj==navi[0]) {
					showPage(0);
				} else if (obj == navi[1]) {
					showPage(1);
				}else if (obj == navi[2]) {
					showPage(2);
				}else if (obj == navi[3]) {
					showPage(3);
				}else if (obj == navi[4]) {
					showPage(4);
				}
			});			
		}
	}
	
	//������ ����Ʈ�� ������ ����Ʈ�� �����ϴ� �޼���
   public void addRemoveContent(Component removeObj, Component addObj) {
      this.remove(removeObj); //���� ���
      this.add(addObj);//���� ���
      ((JPanel)addObj).updateUI();
   }
	
	//������ �������� �Ⱥ����� �������� �����ϴ� �޼��� 
	public void showPage(int showIndex) { // �Ű������δ� �����ְ� ���� ������ �ѹ�
		for (int i = 0; i < page.length; i++) {
			if (i==showIndex) {
				page[i].setVisible(true); // ���̰��� ������ 			
			}else {
				page[i].setVisible(false); // �Ⱥ��̰� �� ������ 				
			}
		}	
	}
	
	public Connection getCon() {
		return con;
	}
	
	public DBManager getDbManager() {
		return dbManager;
	}
	
	public Page[] getPage() {
		return page;
	}
	

	
	public static void main(String[] args) {
		new ShopMain();
	}
}
