package day1029.graphic.image;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




//이미지 썸네일에 사용할캔버스 
public class ThumbCanvas extends Canvas implements MouseListener{
	//1.
	Toolkit kit;
	Image img;
	//11
	DetailPanel p_center;//null
	
	//2.
	public ThumbCanvas(String path, DetailPanel p_center) {
		//3.
		kit = java.awt.Toolkit.getDefaultToolkit();//static 메서드 호출 
		img = kit.getImage(path);
		this.setPreferredSize(new Dimension(100,100));
		this.p_center = p_center;
		
		this.addMouseListener(this);
	}

	//4.도화지에 그림을 그리자 ! 모든 컴포넌트 는 스스로 그림의 주체이자 그려질대상이기도 하다 
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//11-1. p_center에게  나의 img를 전달해야한다 
		p_center.setImg(img);
		//10.p_center 패널에 이미지를 그리되 현재 나의 이미지를 가지고 
		p_center.repaint(); // 다시그려라고 호출 --> update()화면지우기 -> paint() 다시그림 
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
