/*
 	진행상황을 직관적으로 알 수 있는 프로그래스바를 활용해보자 
 */
package day1103.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class ProgressApp extends JFrame{
	JLabel la;
	JProgressBar b1, b2, b3;
	Thread t1,t2,t3; //바를 증가시킬 쓰레드
	Thread laThread;//라벨을 증가시킬 쓰레드 
	int n = 0 ; 
	
	
	public ProgressApp() {
		la = new JLabel("0", SwingConstants.CENTER);
		b1 = new JProgressBar();
		b2 = new JProgressBar();
		b3 = new JProgressBar();
		
		laThread = new Thread() {
			public void run() {
				while (true) {
					la.setText(""+n);					
					n++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		la.setPreferredSize(new Dimension(500,150));
		la.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC,90));
		b1.setPreferredSize(new Dimension(500,70));
		b2.setPreferredSize(new Dimension(500,70));
		b3.setPreferredSize(new Dimension(500,70));
		
		setLayout(new FlowLayout());
		add(la);
		add(b1);
		add(b2);
		add(b3);
		
		//쓰레드 3개 생성하여 runnable로 진입시키자 
		t1 = new BarThread(b1,50);
		t2 = new BarThread(b2,150);
		t3 = new BarThread(b3,500);
		
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		t1.start();//thread 동작!
		t2.start();//thread 동작!
		t3.start();//thread 동작!
		laThread.start(); 
	}
	
//	//바의 값제어 
//	public void setBarValue() {
//		bar.setValue(n);//20퍼센트가 채워짐 
//	}
	
	public static void main(String[] args) {
		new ProgressApp();
		
	}
}
