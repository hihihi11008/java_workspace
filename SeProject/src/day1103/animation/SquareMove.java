package day1103.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SquareMove  extends JFrame{
	JPanel canvas;
	JButton bt;
	Thread thread;
	Image img;
	int x,y;

	public SquareMove() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		bt = new JButton("움직여볼래..?");
		img =toolkit.getImage("C:/workspace/java_workspace/SeProject/src/res/gabi/1.jpg");
		img=img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		
		canvas = new JPanel() {
			public void paint(Graphics g) {
//				g.setColor(Color.WHITE);
//				g.fillRect(0, 0, 700, 500);
				
//				g.setColor(Color.red);
//				g.fillOval(x, y, 50, 50);
				g.drawImage(img, 50, 200, this);
				
			}
		};
		
		thread= new Thread() {
			public void run() {
				while (true) {
					move();
					canvas.repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		canvas.setPreferredSize(new Dimension(700, 500));
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});

		setLayout(new FlowLayout());
		add(canvas);
		add(bt);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		
		
	}
	public void move() {
		x+=2;
		y+=2;
	}
	public static void main(String[] args) {
		new SquareMove();
	}
}
