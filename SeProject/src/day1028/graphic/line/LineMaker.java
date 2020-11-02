package day1028.graphic.line;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class LineMaker  extends JFrame{
	MyCanvas2 can2;
	JLabel la_x1;
	JLabel la_y1;
	JLabel la_x2;
	JLabel la_y2;
	JTextField t_x1;
	JTextField t_y1;
	JTextField t_x2;
	JTextField t_y2;
	JPanel p_north;
	JButton bt;
	int x1;
	int y1;
	int x2;
	int y2;
	
	public LineMaker() {
		super("선그리기 어플리케이션");
		//객체생성
		can2 = new MyCanvas2();
		can2.setLineMaker(this);//켄버스에게 나의 주소값넘기기
		la_x1= new JLabel("x1");
		la_y1= new JLabel("y1");
		la_x2= new JLabel("x2");
		la_y2= new JLabel("y2");
		t_x1=new JTextField("0", 10);
		t_y1=new JTextField("0", 10);
		t_x2=new JTextField("100", 10);
		t_y2=new JTextField("100", 10);
		bt = new JButton("OK");
		p_north = new JPanel();
		
		can2.setBackground(new Color(81,146,163));
		p_north.setBackground(new Color(255,186,83));
		
		p_north.add(la_x1);
		p_north.add(t_x1);
		p_north.add(la_y1);
		p_north.add(t_y1);
		p_north.add(la_x2);
		p_north.add(t_x2);
		p_north.add(la_y2);
		p_north.add(t_y2);
		p_north.add(bt);
		
		add(can2);
		add(p_north,BorderLayout.NORTH);
		
		bt.addActionListener(new MyListener(can2));
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new LineMaker();
	}	
}
