package day1027.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChattingApp extends JFrame{
	Panel p_center;
	Panel p_south;
	JTextArea t_content;
	JTextField t_text;
	JButton bt_send;
	
	public ChattingApp() {
		p_center= new Panel();
		p_south= new Panel();
		t_content= new JTextArea();
		t_text = new JTextField(20);
		bt_send=new JButton("전송");
		
		//1.큰 레이아웃 만들기
//		setLayout(new BorderLayout());
		
		//2.south, center패널 만들기 
		add(p_center, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
		
		//2-1.패널에 스타일넣기 
		p_center.setBackground(Color.yellow);
		p_south.setBackground(new Color (0,103,163));
		
		//3.center에 textarea붙이기
		p_center.add(t_content);
		
		//4.south에 textfield, button 넣기
		p_south.add(t_text);
		p_south.add(bt_send);
		
		
		setVisible(true);
		setSize(300, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ChattingApp();
	}
}
