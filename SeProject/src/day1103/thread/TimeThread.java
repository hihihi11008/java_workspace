//�ʸ� �ǽð� ����� ������
package day1103.thread;

import java.util.Calendar;
import java.util.Date;

public class TimeThread extends Thread{
	
	public void run() {
		while(true) {
			//���� �ð��� ���ؼ� 1�ʸ��� �����ؼ� ��� 
			Calendar cal = Calendar.getInstance(); // �߻�Ŭ�����̹Ƿ� ��ü �޼���� �ν��Ͻ� ����!(��Ŷ�� �̷������� ����)
			//System.out.println(cal);
			System.out.println(cal.get(Calendar.YEAR)+"��"+(cal.get(Calendar.MONTH)+1)+"��"+cal.get(Calendar.DATE)+"��"+
			cal.get(Calendar.HOUR)+"��"+cal.get(Calendar.MINUTE)+"��"+cal.get(Calendar.SECOND)+"��");
			Date time = cal.getTime();
			System.out.println(time);
			try {
				Thread.sleep(1000);// 1/1000�ʱ��� ǥ������  JS setinterval�� ���
											//1�ʵ��� non-runnable �� ���·� �ִٰ� �ٽ� �����϶�� ��� 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
