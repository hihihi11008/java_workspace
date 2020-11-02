package day1029.collection.album;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ThumbCanvas extends JPanel implements MouseListener{
	Toolkit kit;
	Image img2;
	DetailPanel p_center;
	
	public ThumbCanvas(String src, DetailPanel p_center) {
		kit = Toolkit.getDefaultToolkit();
		img2 = kit.getImage(src);
		this.setPreferredSize(new Dimension(80,100));
		this.p_center=p_center;
		
		this.addMouseListener(this);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img2, 0, 0, this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		p_center.setImg(img2);
		
		p_center.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
