package com.swingmall.admin;

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

import com.swingmall.admin.board.Board;
import com.swingmall.admin.member.Member;
import com.swingmall.admin.order.Order;
import com.swingmall.admin.product.Product;
import com.swingmall.util.db.DBManager;






public class AdminMain extends JFrame{
	//�������
	public static final int WIDTH=1000;
	public static final int HEIGHT=700;
	public static final int HOME=0;
	public static final int PRODUCT=1;//��ǰ����
	public static final int MEMBER=2;//ȸ������
	public static final int ORDER=3;//�ֹ�����
	public static final int BOARD=4;//�Խ��ǰ���

	JPanel admintype_container;//������, ����� ȭ���� �������� �� �ִ� �����̳� 
	JPanel p_content; //���⿡ ��� �������� �̸� �پ��� �������� ���� showPage �޼���� ������ ���� ����
	
	JPanel p_navi;// ������Ʈ �� �޴��� ������ �����̳� �г�
	String[] navi_title= {"Home","��ǰ����","ȸ������","�ֹ�����","�Խ��ǰ���"};
	JButton[] navi = new JButton[navi_title.length];//[][][][][] �迭 ����
	
	//������ ���� 
	Page[] page = new Page[5];
	
	
	JLabel la_footer;//������ �ϴ��� ī�Ƕ���Ʈ ����
	private DBManager dbManager;
	

	private Connection con;
	
	public AdminMain() {
		dbManager = new DBManager();
		
		admintype_container = new JPanel();
		p_content = new JPanel();
		p_navi = new JPanel();
		la_footer = new JLabel("SwingMall All rights reserved", SwingConstants.CENTER);

		con = dbManager.connect();
		
		if (con==null) {
			JOptionPane.showMessageDialog(this, "�����ͺ��̽��� ������ �� �����ϴ�.");
			System.exit(0);
		}else {
			this.setTitle("SwingMall �����ڷ� �̿����Դϴ�.");
		}
		
		//���γ׺���̼� ����
		for (int i = 0; i < navi.length; i++) {
			navi[i]= new JButton(navi_title[i]);
			navi[i].setBackground(Color.black);
			navi[i].setForeground(Color.white);
			p_navi.add(navi[i]);//�гο� �׺���̼� ���� 
		}
		
		//������ ���� 
		page[0]= new Home(this);
		page[1]= new Product(this);
		page[2]= new Member(this);
		page[3]= new Order(this);
		page[4]= new Board(this);
		
		
		//��Ÿ�� ���� 
		admintype_container.setPreferredSize(new Dimension(WIDTH, HEIGHT-100));
		admintype_container.setBackground(Color.WHITE);
		la_footer.setPreferredSize(new Dimension(WIDTH, 50));
		la_footer.setFont(new Font("Arial Black", Font.BOLD, 19));
		
		
		//����
		admintype_container.setLayout(new BorderLayout());
		for (int i = 0; i < page.length; i++) {
			p_content.add(page[i]);
		}
		showPage(HOME);//ó���� ���;��ϴ� ������ ���� 

		admintype_container.add(p_navi, BorderLayout.NORTH);
		admintype_container.add(p_content);//���Ϳ� ������ ���� 
		
		this.add(admintype_container);
		this.add(la_footer, BorderLayout.SOUTH);
		
		
		
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		//�����Ӱ� ������ ���� 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dbManager.disConnect(con);
				System.exit(0);//���μ����� ����
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
	
	//�ٸ�Ŭ�������� ������ �� �ֵ��� getter ���� 
	public Connection getCon() {
		return con;
	}
	
	public DBManager getDbManager() {
		return dbManager;
	}
	
	public static void main(String[] args) {
		new AdminMain();
	}
}
