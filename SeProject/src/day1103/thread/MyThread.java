/*
 	�����ڴ� ���������� �����ϰ� ���� �ڵ尡 ������, �����带 ��ӹ޾� run() �������ϸ�ȴ�, 
 	�� run() �� �����ڰ� �ۼ��ϰ��� �ϴ� ������ �ۼ��ϸ�ȴ� 
*/
package day1103.thread;

public class MyThread extends Thread{
	
	//jvm�� �Ʒ��� run() �޼��带 �������ָ�, �̶��� ������ running ���¶� �Ѵ� 
	@Override
	public void run() {
		while (true) {
			System.out.println("��");			
		}
	}
}
