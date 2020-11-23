package soomCoProject.main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



import common.image.ImageUtil;

public class MainFrame extends JFrame{
	//�������_������
	public static final int WIDTH= 600;
	public static final int HEIGHT= 800;
//	//�ֻ��� �������� 
	public static final int HOME= 0;
	public static final int LOGIN= 1;
	public static final int REGIST= 2;
	
	JPanel p_main;
	JPanel p_header,p_navi,p_content,p_theme,p_footer;
	
	ImageIcon icon;
	String [] dirName = {"Beauty", "Cooking", "Education", "Exercise", "Foreign_Language", "Interior", "Lesson", "Programming"};
	String [] iconName = {"BeautyIcon.png","CookingIcon.png","EducationIcon.png","ExerciseIcon.png","foreign_languageIcon.png","InteriorIcon.png","lessonIcon.png","ProgrammingIcon.png"};

	
	String[] navi_title= {"LogIn","Logout","1:1 Chat","Join"};
	JButton[] title= new JButton[navi_title.length];
	
	String[] navi_theme= {"Programming","Art","Interior","Beauty","Food","Education","Language","Exercise"};
	JButton[] theme= new JButton[navi_theme.length];
	
	//����������
	Page[] page = new Page[1];
	JLabel la_logo, la_info;
//	ButtonUI btUI;
	
	public MainFrame() {
		p_main = new JPanel();
		p_header = new JPanel();
		p_navi = new JPanel();
		p_content = new JPanel();
		p_theme = new JPanel();
		p_footer = new JPanel();
		
//		icon = ImageUtil.getIcon(this.getClass(), "res/Main_Interior_1.png", 30, 30);
		
		//��� ��ư 
		for (int i = 0; i < title.length; i++) {
			title[i] = new JButton(navi_title[i]);
			
			p_navi.add(title[i]);
		}
		
		//������ ���� 
				page[0]= new LogIn(this);
//				page[1]= new Product(this);
//				page[2]= new Member(this);
//				page[3]= new Order(this);
		
		//������ư 
		for (int i = 0; i < theme.length; i++) {
			theme[i]= new JButton(navi_theme[i]);
//			String path ="res/Cooking/CookingIcon.png";
			String path = "res/"+dirName[i]+"/"+iconName[i];
			icon = ImageUtil.getIcon(this.getClass(), path, 30, 30);
//			System.out.println(path);
			p_theme.setLayout(new GridLayout(4,2));
			p_theme.add(theme[i]);
			theme[i].setBackground(new Color(253, 116, 31));
			theme[i].setForeground(Color.white);
			theme[i].setIcon(icon);
		}
		
	
		
		//�ΰ�,ī�Ƕ���Ʈ
		la_logo = new JLabel("SooMCo");
		la_info = new JLabel("SwingMall All rights reserved", SwingConstants.CENTER);
		
		//���� 
		p_header.setLayout(new FlowLayout());
		p_header.add(la_logo);
		p_header.add(p_navi);
		
		p_content.add(p_theme);
		
		p_footer.add(la_info);
		
		//����
//		p_content.setLayout(new BorderLayout());
//			for (int i = 0; i < page.length; i++) {
//				p_content.add(page[i]);
//			}
		showPage(1);//ó���� ���;��ϴ� ������ ���� 
		
		add(p_header, BorderLayout.NORTH);
		add(p_footer, BorderLayout.SOUTH);
		add(p_content);
		
		//��Ÿ�� 
//		p_content.setBackground(Color.darkGray);
		p_content.setBackground(new Color(235, 70, 72));
		p_footer.setBackground(Color.gray);
		
		
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		
		
		//�α��ι�ư�� �����ʿ��� 
		for (int i = 0; i < theme.length; i++) {
			theme[i].addActionListener((e)->{
				Object obj=e.getSource();
				if (obj==theme[0]) {
					showPage(0);
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
	

	public static void main(String[] args) {
		new MainFrame();
	}
}

