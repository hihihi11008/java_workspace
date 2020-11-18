package com.swingmall.main;

import java.awt.BorderLayout;
import java.awt.Color;
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
import com.swingmall.product.Product;
import com.swingmall.util.db.DBManager;

public class ShopMain extends JFrame{
	//�������
	public static final int WIDTH=1200;
	public static final int HEIGHT=900;
	public static final int HOME=0;
	public static final int PRODUCT=1;
	public static final int QNA=2;
	public static final int MYPAGE=3;
	public static final int LOGIN=4;

	JPanel usetype_container;//������, ����� ȭ���� �������� �� �ִ� �����̳� 
	
	JPanel p_navi;// ������Ʈ �� �޴��� ������ �����̳� �г�
	String[] navi_title= {"Home","Product","QnA","MyPage","Login"};
	JButton[] navi = new JButton[navi_title.length];//[][][][][] �迭 ����
	
	//������ ���� 
	Page[] page = new Page[5];
	
	
	JLabel la_footer;//������ �ϴ��� ī�Ƕ���Ʈ ����
	DBManager dbManager;
	Connection con;
	
	public ShopMain() {
		dbManager = new DBManager();
		
		usetype_container = new JPanel();
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
		
		
		//��Ÿ�� ���� 
		usetype_container.setPreferredSize(new Dimension(WIDTH, HEIGHT-100));
		usetype_container.setBackground(Color.WHITE);
		la_footer.setPreferredSize(new Dimension(WIDTH, 50));
		la_footer.setFont(new Font("Arial Black", Font.BOLD, 19));
		
		
		//����
		usetype_container.setLayout(new BorderLayout());
		usetype_container.add(p_navi, BorderLayout.NORTH);
		
		usetype_container.add(page[ShopMain.HOME]);//���Ϳ� ������ ���� 
		
		this.add(usetype_container);
		this.add(la_footer, BorderLayout.SOUTH);
		
		
		
		setSize(1200, 900);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		//�����Ӱ� ������ ���� 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dbManager.disConnect(con);
			}
		});
	}
	
	

	
	public static void main(String[] args) {
		new ShopMain();
	}
}
