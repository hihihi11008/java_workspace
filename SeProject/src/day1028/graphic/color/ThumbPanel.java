package day1028.graphic.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//나만의 패널 정의하기 - 기존의 패널의 커스터마이징 custom
import javax.swing.JPanel;

public class ThumbPanel extends JPanel implements MouseListener{
	JPanel p_center;//null
	Color color;
	//너비, 높이 색상을 가진 패널로 태어나게 
	public ThumbPanel(JPanel p_center,Color color) {
		this.p_center=p_center;
		this.color=color;
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(color);
		this.addMouseListener(this);//나와 리스너 연결 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("나눌럿옹?");
		//센터영역패널의 배경색을 나(현재패널)와 같은 색상으로 설정하자 
		p_center.setBackground(color);
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
