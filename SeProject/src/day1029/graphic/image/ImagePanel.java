package day1029.graphic.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;



public class ImagePanel extends JPanel{
	Toolkit kit = java.awt.Toolkit.getDefaultToolkit(); 
	//������ �̹��� 10���� �迭�� �غ� 
	String dir="C:/workspace/java_workspace/SeProject/res/travel2/";
	String[] src= {
			"aa.jpg",
			"ab.jpg",
			"ax.jpg",
			"bm.jpg",
			"et.jpg",
			"kg.jpg",
			"mx.jpg",
			"pk.jpg",
			"ub.jpg",
			"ya.jpg"			
	};
	Image[] img = new Image[src.length];
	int n = 0;
	
	public ImagePanel() {
		for(int i=0;i<img.length;i++) {
			img[i]=kit.getImage(dir+src[i]);
			img[i]=img[i].getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		}
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img[n], 0, 0, this);
	}
}
