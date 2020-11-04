/*
 	�������? Thread
 	-�ϳ��� ���μ��������� �񵿱������� ������ �� �ִ� ���ϳ��� ���ν��� ������ ���Ѵ� 
 */
package day1103.thread;

public class ThreadTest1 {
	public static void main(String[] args) {
		//�ð������� �����ϰ� , ���۽��Ѻ��� 
		TimeThread tt = new TimeThread();
		tt.start();//runnable ���·� ���� ! 
		
		//0.5�ʸ��� ���� ����ϴ� �����带 �����ϵ�, ���� Ŭ���������� �������� ! ( �����͸� Ŭ���� )
		Thread startThread = new Thread() {
			public void run() {
				while(true) {
					System.out.println("��");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		startThread.start();//Runnable���·� ����
		
		//�����ڰ� ������ �����带 �̿��ؼ� ���ѷ��� ����! 
		MyThread t1 = new MyThread(); // �нŻ��� 
		//�������� ������ �ý��ۿ� �ðܾ��Ѵ� 
		//t1.start();
		//�����尡 ������ run() �޼���� jvm�� ���� ȣ��ȴ� ! 
//		
//		while(true) {
//			System.out.println("hi");
//		}
		
	}
}
