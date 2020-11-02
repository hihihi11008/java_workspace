package day1029.graphic.image;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePickerApp extends JFrame{
	//1.
	String dir="C:/workspace/java_workspace/SeProject/res/travel2/";
	String[] path= {
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
	JPanel p_north;
	DetailPanel p_center;
	//7.
	ThumbCanvas[] thumb = new ThumbCanvas[path.length];
	
	//2.
	public ImagePickerApp() {
		//3.
		p_north = new JPanel();
		//6.
		p_center = new DetailPanel();
		
		//9. 켄버스 생성 및 조립 
		for(int i=0; i<thumb.length;i++) {
			thumb[i]= new ThumbCanvas(dir+path[i], p_center); 
			p_north.add(thumb[i]);//켄버스를 패널에 부착 
		}
		
		//8.조립 
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		//4.
		setSize(770, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ImagePickerApp();
	}
}
