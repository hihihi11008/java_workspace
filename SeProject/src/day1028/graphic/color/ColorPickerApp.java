package day1028.graphic.color;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ColorPickerApp extends JFrame{
	JPanel p_north;
	JPanel p_center;
	ThumbPanel[] thumb=new ThumbPanel[7];
	//7가지 색상을 배열로 보유하자 (반복문마다 틀린 색을 사용해야 하기 때문ㅇ)
	Color[] colorArrayColors= {
			Color.red,Color.orange,Color.yellow,Color.green,Color.cyan,Color.blue,Color.pink
	};
	
	
	//생성자
	public ColorPickerApp() {
		p_north = new JPanel();
		p_center = new JPanel();
		for(int i=0; i<thumb.length;i++) {
			thumb[i]= new ThumbPanel(p_center, colorArrayColors[i]); 
			p_north.add(thumb[i]);
		}
	
		p_center.setBackground(Color.white);
		
		add(p_center);
		add(p_north, BorderLayout.NORTH);
	

		setVisible(true);
		setSize(750, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ColorPickerApp();
	}
}
