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
	//�����͸�Ŭ������ Ŭ������ 
	JPanel can;
	JButton bt;
	int x,y;
	Thread thread;
	
	public CircleMove() {
		can = new JPanel() { //�����͸�Ŭ������ Ŭ�����̹Ƿ�, .class�� �����ϵ� ��Ī�� �����Ƿ� 
										//���������� $���� ������ ���ϸ��� ���Եȴ�
			//�����͸�Ŭ���� ���� ����? .java�� ���� ������ �ʾƵ� �ȴ�, ���߽ð� ����
			//�ܺ� Ŭ������ ����� ��ġ �ڱⲨó�� ����� �� �ִ�.
			public void paint(Graphics g) {
				g.setColor(Color.YELLOW);//����Ʈ ��������
				g.fillRect(0, 0, 750, 650);//ä���� �簢��
				
				//���׸��� 
				g.setColor(Color.red);
				g.fillOval(x, y, 50, 50);//ä���� ��
			}
		};
		
		bt = new JButton("�������");
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
		
		//��Ÿ�� 
		can.setPreferredSize(new Dimension(700, 600));
		
		//��ư�� ������ ���� 
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//move();
				//can.repaint();
				//�����带 runnable�� ���Խ�Ű�� 
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
	//���� ����ǥ�� ���� 
	public void move() {
		x+=2;
		y+=2;
	}
	public static void main(String[] args) {
		new CircleMove();
	}
}
