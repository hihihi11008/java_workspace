
/*���ݱ����� sun���� �����ڰ� �������� �״�� ������Ʈ���� ���ƿ����� 
 * �� ���������� �츮�� ������Ʈ�� �׷����� ����� �����Ͽ�, ���ϴ� �׸����� 
 * ������Ʈ�� ���������� ó���غ��� (�׷���ó���� �����غ���, �츮�ֵ��Ͽ� �׸��׸���)
 * */
package day1028.graphic;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import day1028.graphic.line.MyCanvas;


public class PaintTest extends JFrame{
	MyCanvas can;//��ȭ���� ǥ���� ������Ʈ
	
	public PaintTest() {
		can = new MyCanvas();
		
		can.setBackground(Color.yellow);
		//ĵ���� �׸��� �׸�����, �˹����� ������ �׸��� �޼����� .paint() �޼��带 ������ 
		
		add(can);//ĵ������ �����ӿ� ���� 
		
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//���� Ŭ������ PaintTest�� JFrame�� paint.�޼��带 �������̵��ϸ� 
	//����� �ڽ��� �������� �޼��带 �켱 ������ ȣ�����ش� (�������� �ڽ�Ŭ������ )
	//��ưx, JFrame, Choice ���Ǵٹ����������� .... 
	//�׷��� ������Ʈ�� �����ڰ� �����ڰ� �ֵ��ؼ� �׸��� �׸� �� �ִ� ������Ʈ 
	//Canvas(AWT), JPanel (�� ����ִ� ������Ʈ) 
	/*
	public void paint(Graphics g) {
		System.out.println("������ �����׷��� ");
	}
	*/
	public static void main(String[] args) {
		new PaintTest();
	}

}
