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
	//상수선언_사이즈
	public static final int WIDTH= 600;
	public static final int HEIGHT= 800;
//	//최상위 페이지들 
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
	
	//페이지구성
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
		
		//헤더 버튼 
		for (int i = 0; i < title.length; i++) {
			title[i] = new JButton(navi_title[i]);
			
			p_navi.add(title[i]);
		}
		
		//페이지 구성 
				page[0]= new LogIn(this);
//				page[1]= new Product(this);
//				page[2]= new Member(this);
//				page[3]= new Order(this);
		
		//주제버튼 
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
		
	
		
		//로고,카피라이트
		la_logo = new JLabel("SooMCo");
		la_info = new JLabel("SwingMall All rights reserved", SwingConstants.CENTER);
		
		//조립 
		p_header.setLayout(new FlowLayout());
		p_header.add(la_logo);
		p_header.add(p_navi);
		
		p_content.add(p_theme);
		
		p_footer.add(la_info);
		
		//조립
//		p_content.setLayout(new BorderLayout());
//			for (int i = 0; i < page.length; i++) {
//				p_content.add(page[i]);
//			}
		showPage(1);//처음에 나와야하는 페이지 설정 
		
		add(p_header, BorderLayout.NORTH);
		add(p_footer, BorderLayout.SOUTH);
		add(p_content);
		
		//스타일 
//		p_content.setBackground(Color.darkGray);
		p_content.setBackground(new Color(235, 70, 72));
		p_footer.setBackground(Color.gray);
		
		
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		
		
		//로그인버튼과 리스너연결 
		for (int i = 0; i < theme.length; i++) {
			theme[i].addActionListener((e)->{
				Object obj=e.getSource();
				if (obj==theme[0]) {
					showPage(0);
				}
			});
		}
	}
	
	//보여질 페이지와 안보여질 페이지를 설정하는 메서드 
		public void showPage(int showIndex) { // 매개변수로는 보여주고 싶은 페이지 넘버
			for (int i = 0; i < page.length; i++) {
				if (i==showIndex) {
					page[i].setVisible(true); // 보이게할 페이지 	
				}else {
					page[i].setVisible(false); // 안보이게 할 페이지 				
				}
				
			}	
		}
	

	public static void main(String[] args) {
		new MainFrame();
	}
}

