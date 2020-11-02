package day1028.graphic.line;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class MyCanvas extends Canvas{
	Toolkit kit; //�÷���(os���� win, mac, linus)�� ���� �˸°� �ڿ��� ������ �� �ֵ��� ���ִ� ��ü
	Image img;//�굵 �߻��� �ٵ���Ŷ������ �ν��Ͻ��� ���� �� ���� 
	
	public MyCanvas() {
		kit = Toolkit.getDefaultToolkit();//��ü Ŭ���� �޼���(static)�� ���� �ν��Ͻ��� ��� ��� 
		img = kit.getImage("C:/workspace/java_workspace/SeProject/res/travel2/aa.jpg");
	}
	//�θ��� �˹����� ������ paint�޼��带 �����ع�����, �츮 ��Ȳ�� �°� ���������� 
	@Override
	public void paint(Graphics g) {
		//�Ű������� Graphics ��ü�� ���ǿ����� �ȷ�Ʈ�� ������ �� ������ ,���� ���� �����ϴ� ���� �ƴ϶� 
		//����, �ؽ�Ʈ, �̹���, ��, �� �� �پ��� �׷��� ó���� ���� ����� �����ϴ� ������ �׷��� ó�� ������̴� 
		g.drawLine(50, 50, 300, 350); //ĵ������ �� �׸��� 
		g.drawOval(0, 50, 200, 200);
		g.drawRect(50, 100, 100, 200);
		
		//���� ����Ʈ ���� ���� 
		g.setColor(Color.green);
		g.fill3DRect(200, 100, 50, 50, true);
		
		g.setColor(Color.BLUE);
		g.drawString("�̰� �׸��۾��� ", 50, 200);
		
		//Image : �̹����� ǥ���� ��ü 
		//�����غ��� �߻�Ŭ������ 
		//�Ǹ�X : �߻�Ŭ������ ���, �����ڰ� �ڽ�Ŭ������ ������ �ڽ��� new �ؼ� ����ؾ����� ��Ģ������ 
		//			sun�簡 �������ִ� ��κ��� �߻�Ŭ������ ��� �̹��ν��Ͻ��� �����س��� ���������� ���� ���
		//			�޼��带 �������ְų�, �ν��Ͻ��� ���� �� �ִ� ��ü �޼��带 �������ִ� ��찡 �� ���� 
		//�ý��ۿ� �ϵ��ũ ��θ� �̿��Ͽ� �̹����� ������ ��쿣, �÷����� ���� �̹��� ��ü�� ������ �� �ִ� 
		//Toolkit ��ü�� �̿��ؾ� �ϹǷ�, �̹����� ������� �켱 ��Ŷ��ü�� �ν��Ͻ����� ����
		g.drawImage(img, 50, 50, this);// �̹��� �����ڴ� ĵ������ ���� 
	}
}
