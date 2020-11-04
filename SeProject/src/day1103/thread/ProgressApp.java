/*
 	�����Ȳ�� ���������� �� �� �ִ� ���α׷����ٸ� Ȱ���غ��� 
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
	Thread t1,t2,t3; //�ٸ� ������ų ������
	Thread laThread;//���� ������ų ������ 
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
		
		//������ 3�� �����Ͽ� runnable�� ���Խ�Ű�� 
		t1 = new BarThread(b1,50);
		t2 = new BarThread(b2,150);
		t3 = new BarThread(b3,500);
		
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		t1.start();//thread ����!
		t2.start();//thread ����!
		t3.start();//thread ����!
		laThread.start(); 
	}
	
//	//���� ������ 
//	public void setBarValue() {
//		bar.setValue(n);//20�ۼ�Ʈ�� ä���� 
//	}
	
	public static void main(String[] args) {
		new ProgressApp();
		
	}
}
