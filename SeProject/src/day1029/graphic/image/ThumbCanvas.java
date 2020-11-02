package day1029.graphic.image;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




//�̹��� ����Ͽ� �����ĵ���� 
public class ThumbCanvas extends Canvas implements MouseListener{
	//1.
	Toolkit kit;
	Image img;
	//11
	DetailPanel p_center;//null
	
	//2.
	public ThumbCanvas(String path, DetailPanel p_center) {
		//3.
		kit = java.awt.Toolkit.getDefaultToolkit();//static �޼��� ȣ�� 
		img = kit.getImage(path);
		this.setPreferredSize(new Dimension(100,100));
		this.p_center = p_center;
		
		this.addMouseListener(this);
	}

	//4.��ȭ���� �׸��� �׸��� ! ��� ������Ʈ �� ������ �׸��� ��ü���� �׷�������̱⵵ �ϴ� 
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
		//11-1. p_center����  ���� img�� �����ؾ��Ѵ� 
		p_center.setImg(img);
		//10.p_center �гο� �̹����� �׸��� ���� ���� �̹����� ������ 
		p_center.repaint(); // �ٽñ׷���� ȣ�� --> update()ȭ������� -> paint() �ٽñ׸� 
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
