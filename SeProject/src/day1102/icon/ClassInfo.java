/*
 	java.lang�� �ִ� Ŭ���� �� Ŭ������ ���� ������ ���� Ŭ������ �����ȴ� 
 	Class Ŭ���� 
 */

package day1102.icon;

import java.lang.reflect.Method;
import java.net.URL;

public class ClassInfo {
	Class myClass;
	
	public void test() {
	}
	public ClassInfo() {
		//���� ������� ClassInfo��� Ŭ������ ���� ������ ����غ��� ! 
		//���α׷��������� ���� Ŭ������ ���� �ä����� ���غ��� !!! 
		myClass=this.getClass();//���� �ν��Ͻ��� ������ ���� ! 
		Method[] methods=myClass.getMethods();//���� �ν��Ͻ��� ������ �޼������ ��ȯ 
		
		for (int i = 0; i < methods.length; i++) {
			System.out.println("���簴ü�� ������ �޼����"+methods[i]);
			
		}
		//����� �޼������ �����Ϸ��� �׷���..�ƴ϶�... 
		//ClassŬ������ �̿��ϸ�, �ش� Ŭ������ ȯ������� ������ �� �ִ�. ���� �츮�� 
		//Ŭ���� �н��� �����ؼ� �츮�� ������� res��� ��Ű���� ��θ� ������ �ž� 
		//�Ʒ��� �޼��带 �̿��ϸ�, Ŭ�����н��� �������� �ڿ��� ������ �� �ִ� 
		//��Ű���� ���� �ڿ��� Ŭ������ �ƴ� �Ϲ������� ��� .�� �ƴ� /�����÷� �����ؾ���!!! 
		URL url=myClass.getClassLoader().getResource("res/1.png");
		System.out.println(url);
		//URL�� �ڿ��� ��ġ�� ����
	}
	public static void main(String[] args) {
		new ClassInfo();
	}
}
