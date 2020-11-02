package day1029.collection.album;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DetailPanel extends JPanel{
	private Image img2;
	
	public void setImg(Image img2) {
		this.img2 = img2;
		this.img2= this.img2.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
	}
	public void paint(Graphics g) {
		g.drawImage(img2, 0, 0, this);
	}

}
