package day1028.graphic.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//������ �г� �����ϱ� - ������ �г��� Ŀ���͸���¡ custom
import javax.swing.JPanel;

public class ThumbPanel extends JPanel implements MouseListener{
	JPanel p_center;//null
	Color color;
	//�ʺ�, ���� ������ ���� �гη� �¾�� 
	public ThumbPanel(JPanel p_center,Color color) {
		this.p_center=p_center;
		this.color=color;
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(color);
		this.addMouseListener(this);//���� ������ ���� 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("��������?");
		//���Ϳ����г��� ������ ��(�����г�)�� ���� �������� �������� 
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
