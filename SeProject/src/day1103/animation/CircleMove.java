package day1103.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleMove extends JFrame{
	//내부익명클래스도 클래스다 
	JPanel can;
	JButton bt;
	int x,y;
	Thread thread;
	
	public CircleMove() {
		can = new JPanel() { //내부익명클래스도 클래스이므로, .class로 존재하되 명칭이 없으므로 
										//내부적으로 $순번 형태의 파일명을 갖게된다
			//내부익명클래스 사용시 장점? .java를 굳이 만들지 않아도 된다, 개발시간 단축
			//외부 클래스의 멤버를 마치 자기꺼처럼 사용할 수 있다.
			public void paint(Graphics g) {
				g.setColor(Color.YELLOW);//페인트 색상적용
				g.fillRect(0, 0, 750, 650);//채워진 사각형
				
				//원그리기 
				g.setColor(Color.red);
				g.fillOval(x, y, 50, 50);//채워진 원
			}
		};
		
		bt = new JButton("움지기기");
		thread = new Thread() {
			public void run() {
				while (true) {
					move();
					can.repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		//스타일 
		can.setPreferredSize(new Dimension(700, 600));
		
		//버튼과 리스너 연결 
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//move();
				//can.repaint();
				//쓰레드를 runnable로 진입시키다 
				thread.start();
			}			
		});
		
		setLayout(new FlowLayout());
		add(bt);
		add(can);
		
		setVisible(true);
		setSize(900, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	//원의 조ㅏ표를 변경 
	public void move() {
		x+=2;
		y+=2;
	}
	public static void main(String[] args) {
		new CircleMove();
	}
}
