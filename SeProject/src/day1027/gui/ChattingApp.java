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
		bt_send=new JButton("����");
		
		//1.ū ���̾ƿ� �����
//		setLayout(new BorderLayout());
		
		//2.south, center�г� ����� 
		add(p_center, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
		
		//2-1.�гο� ��Ÿ�ϳֱ� 
		p_center.setBackground(Color.yellow);
		p_south.setBackground(new Color (0,103,163));
		
		//3.center�� textarea���̱�
		p_center.add(t_content);
		
		//4.south�� textfield, button �ֱ�
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
