package day1029.graphic.image;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.ImageGraphicAttribute;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePicker extends JFrame implements MouseListener{
	JPanel p_north;
	JPanel p_center;
	ImagePanel img;
	
	
	//생성자
	public ImagePicker() {
		//초기화
		p_north = new JPanel();
		p_center = new JPanel();
		img = new ImagePanel();
		img.setBackground(Color.white);
		
		//조립
		add(p_center);
		add(p_north);
		p_north.add(img);
	
		p_north.addMouseListener(this);
		
		
		setVisible(true);
		setSize(750, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ImagePicker();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("나눌럿옹?");

	}
	@Override
	public void mousePressed(MouseEvent e) {	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
