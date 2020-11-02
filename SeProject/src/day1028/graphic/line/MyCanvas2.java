package day1028.graphic.line;

import java.awt.Canvas;
import java.awt.Graphics;

public class MyCanvas2 extends Canvas{
	//켄버스는 개발자가 직접 그림을 그릴 수 있는 빈 도화지 이다. 
	//따라서 paint() 메서드를 재정의하면 된다 
	
	//default 접근제한자는 같은 패키지에 존재하는 클래스만이접근가능함
	LineMaker lm;//null
	int x1;
	int y1;
	int x2;
	int y2;
	
	//	public MyCanvas2(LineMaker lm) {
	//		this.lm=lm;
	//	}
	
	// 이메서드를 호출하는 자는 LineMaker의 주소값을 넘기면 된다 
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
