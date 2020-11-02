package day1030.album;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;



//5.썸네일 하나를 정의한다  // 6. 마우스리스너 정의
public class Thumb extends JPanel implements MouseListener{
	//13-1. 
	Toolkit kit; // 플랫폼에 의존적인 경로를 이용할때 툴킷이 필요 window d://
	Image img;
	//17. 상수로 
	public static final int WIDTH=75;
	public static final int HEIGHT=55;
	//29
	GalleryApp galleryApp; //필요하면 has a 로 참초한다, 지금은 null

	//5-1. //14-1 생성자에게 V
	public Thumb(String src,GalleryApp galleryApp) {
		this.galleryApp=galleryApp;// 29생성자 injection 주입받는다고 한다 
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
	
	//13. src를 받아와서 그림그리기 
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	@Override//7.
	public void mouseReleased(MouseEvent e) {
		//System.out.println("썸네일눌렀어? ");
		//29. n을 지금 나의 index값으로 
		//현재 패널이 ArrayList 내에서의 몇번째 인덱스에 들어있는지 역추적!!! 
		galleryApp.n=galleryApp.list.indexOf(this);
		galleryApp.updateDate();//프레임의 메서드를 접근해야해 
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