/*�ڹ��� ������Ʈ�� �̹����� �־��!(�̹��� ������)*/

package day1102.icon;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IconApp extends JFrame{
	JButton bt;
	ImageIcon icon;//ImageIcon is Icon
	
	public IconApp() {
		//os�� �������� ��θ� ������� ����, Ŭ�����н��� �������� �� ��η� �ڿ��� �̿��غ���
		URL url=this.getClass().getClassLoader().getResource("res/1.png");
		icon= new ImageIcon(url);
		bt=new JButton(icon);
		
		//Image Ŭ������ �̹����� ũ�⸦ ������ �� �ִ� ����� �ִ�. getScaledInstance
		Image img=icon.getImage();
		img=img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		icon.setImage(img);//�����ܿ� ����� �̹����� �ٽ�����
		bt.setPreferredSize(new Dimension(30,30));
		
		setLayout(new FlowLayout());
		add(bt);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 400);
		
	}
	public static void main(String[] args) {
		new IconApp();
	}
}
