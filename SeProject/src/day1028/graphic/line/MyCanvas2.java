package day1028.graphic.line;

import java.awt.Canvas;
import java.awt.Graphics;

public class MyCanvas2 extends Canvas{
	//�˹����� �����ڰ� ���� �׸��� �׸� �� �ִ� �� ��ȭ�� �̴�. 
	//���� paint() �޼��带 �������ϸ� �ȴ� 
	
	//default ���������ڴ� ���� ��Ű���� �����ϴ� Ŭ�����������ٰ�����
	LineMaker lm;//null
	int x1;
	int y1;
	int x2;
	int y2;
	
	//	public MyCanvas2(LineMaker lm) {
	//		this.lm=lm;
	//	}
	
	// �̸޼��带 ȣ���ϴ� �ڴ� LineMaker�� �ּҰ��� �ѱ�� �ȴ� 
	public void setLineMaker(LineMaker lm) {
		this.lm=lm;		
	}
	@Override
	public void paint(Graphics g) {
		x1=Integer.parseInt(lm.t_x1.getText());
		y1=Integer.parseInt(lm.t_y1.getText());
		x2=Integer.parseInt(lm.t_x2.getText());
		y2=Integer.parseInt(lm.t_y2.getText());
		
		g.drawLine(x1,y1,x2,y2);
		
	}
}
