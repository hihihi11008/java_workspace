package day1030.album;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;



//5.����� �ϳ��� �����Ѵ�  // 6. ���콺������ ����
public class Thumb extends JPanel implements MouseListener{
	//13-1. 
	Toolkit kit; // �÷����� �������� ��θ� �̿��Ҷ� ��Ŷ�� �ʿ� window d://
	Image img;
	//17. ����� 
	public static final int WIDTH=75;
	public static final int HEIGHT=55;
	//29
	GalleryApp galleryApp; //�ʿ��ϸ� has a �� �����Ѵ�, ������ null

	//5-1. //14-1 �����ڿ��� V
	public Thumb(String src,GalleryApp galleryApp) {
		this.galleryApp=galleryApp;// 29������ injection ���Թ޴´ٰ� �Ѵ� 
		//14. 
		kit =Toolkit.getDefaultToolkit();
		img=kit.getImage(src);
		//16. 
		img=img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		//5-2.
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		
		//6-1. 
		this.addMouseListener(this);

	}
	
	//13. src�� �޾ƿͼ� �׸��׸��� 
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	@Override//7.
	public void mouseReleased(MouseEvent e) {
		//System.out.println("����ϴ�����? ");
		//29. n�� ���� ���� index������ 
		//���� �г��� ArrayList �������� ���° �ε����� ����ִ��� ������!!! 
		galleryApp.n=galleryApp.list.indexOf(this);
		galleryApp.updateDate();//�������� �޼��带 �����ؾ��� 
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {		
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}