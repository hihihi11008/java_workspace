package soomCoProject.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import day1027.gui.Test;

public class Test11 extends JFrame{
	JPanel p;
	JLabel la,la1,la2;
	
	public Test11() {
	p=new JPanel();
	la=new JLabel("SoomCo 가나다라마",SwingConstants.CENTER);
	la1=new JLabel("SoomCo 가나다라마",SwingConstants.CENTER);
	la2=new JLabel("SoomCo 가나다라마",SwingConstants.CENTER);
		
	
//	Font font1 = new Font("메이플스토리 OTF",Font.PLAIN,13);
	Font font2=new Font("배달의민족 을지로체 TTF",Font.BOLD,13);
	Font font3=new Font("Arial Narrow",Font.PLAIN,13);
	
	la1.setForeground(Color.magenta);
	la2.setForeground(Color.BLACK);
	
//	la.setFont(font1);
	la1.setFont(font2);
	p.add(la);
	p.add(la1);
	p.add(la2);
	add(p);
	
	
	
	
	setSize(300,300);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		new Test11();
	}
}
