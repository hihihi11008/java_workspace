/*
 * �������� ���� �ٽ��ѹ� �����غ��� 
 * */
package day1029.poly;

import java.util.ArrayList;

public class Bird {
	String name = "����";
	String local = "�ѱ�";
	
	public void fly() {
		System.out.println("�������ƿ�");
	}
	public static void main(String[] args) {
		//������ ������� ������ �����ϱ� 
		Bird b1 = new Bird();
		Bird b3 = new Sparrow();//���������� 
		
//		b3.fly(); //������, �ൿ�� �پ��ϴ� 
		
		Bird b2 = new Duck(); //b2�� Bird Ŭ���� ����, �޼�������
										//�������� Ư¡���μ��� �ڽ� �޼��带 ���ٰ��� 
		//Duck d = new Duck(); // �θ� ����
		
		//�θ��ڷ������� ���� �θ�� �ڽ��� �������� ������ �ִ� �޼��常 ���ٰ��� 
		//�ڽĿ��ִ� �޼��带 ����Ϸ��� �ڽ��ڷ������� ������ 
	}
}
