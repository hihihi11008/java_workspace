package day1028.graphic.line;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener{
	MyCanvas2 can2; //null
	
	//�˹����� �ּҰ��� �Ѱܹ��� �޼��尡�ʿ��ϴ� , �̹����� �����ڷ� ���� 
	public MyListener(MyCanvas2 can2) {
		this.can2=can2;
	}
	public void actionPerformed(ActionEvent e) {
		//�˹����� ���� �׸��� LineMaker Ŭ������ JTextField�� ���� �̿��Ͽ� 
		//paint() �޼���� �����ڰ� ����ȣ���� ���� ����, ȣ���ؼ��� �ȴ�! 
		//paint() �޼���� �׸��� �׷��� �غ� �Ǿ����� �ý���, �� .JVM�� ���� ȣ��ȴ� 
		//���� �����ڰ� ���ϴ� Ÿ�ӿ� �׸��� �����ϰ� �Ϸ��� paint()�޼��带 ���� ȣ���ؼ��� �ȵǰ�
		//������ ���� �ý��ۿ� ��û!! repaint() �ٽñ׷��ּ��� -> update()ȭ������� 
		//-> paint()
		//ĵ������������.repaint();
		can2.repaint();
	}
}
