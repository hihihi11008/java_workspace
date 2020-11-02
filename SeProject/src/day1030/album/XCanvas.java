package day1030.album;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//17-1
public class XCanvas extends Canvas{
	//20. //23����ȭ ���ͼ��� 
	private Toolkit kit=Toolkit.getDefaultToolkit();
	private Image img;
	private String src;//generic ���콺 �����ʹ�ư Source -> generic getter & setter Ŭ�� src Ŭ��


	//18
	public XCanvas(String src) {
		img=kit.getImage(src);//21.  string ��ε� ���� �ѱ�� 
		img=img.getScaledInstance(660, 450, Image.SCALE_SMOOTH);//21�̹���ũ������
		setPreferredSize(new Dimension(660, 450));// �ߺ��Ǵ°� ����� 
		setBackground(Color.green);
	}
	//23-1
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		//24.�ߺ��� �ڵ�� �޼���� ���������� �������� �� ...����
		img=kit.getImage(src);
		img=img.getScaledInstance(660, 450, Image.SCALE_SMOOTH);
		this.src = src;
	}
	
	//19
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0,this);
	}
}
