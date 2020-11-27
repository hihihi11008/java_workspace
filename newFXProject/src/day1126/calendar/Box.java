/*
 * �޷¿� ���Ǵ� ���� �����Ѵ�!!
 * */
package day1126.calendar;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Box extends Canvas{
	String title;
	int width;
	int height;
	GraphicsContext context;
	
	public Box(String title, int width, int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		this.setWidth(width);//�ʺ�
		this.setHeight(height);//����
		
		//��� ������Ʈ��  �׷��� ó���� ���Ǵ� ��ü�� ������ �ִ�..
		context=this.getGraphicsContext2D();
		
		erase();
		renderText(title);
	}
	
	//���� �ڽ��� �׷��� �۾� �����
	public void erase() {
		context.setFill(Color.YELLOW); //����Ʈ�� �������� ���������..
		context.fillRect(0, 0, 100, 100); //����� ä���� �簢��
		//���ж��� 
		context.setStroke(Color.valueOf("#ff0000")); //���� ����
		context.strokeRect(0, 0, width, height);//�簢�� ������ �׸���
		
	}
	
	//����ڽ��� �۾� �׸��� 
	public void renderText(String title) {
		//�۾� �׸��� 
		this.title = title;
		context.setFill(Color.BLACK);//����Ʈ�� �� ��ü
		context.setFont(new Font(17)); //��Ʈ ũ�⼳�� 
		context.fillText(title,2, 20);
	}
}