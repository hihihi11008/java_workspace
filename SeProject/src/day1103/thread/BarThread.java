package day1103.thread;

import javax.swing.JProgressBar;

public class BarThread extends Thread {
	int n=0;
	int time=0;
	JProgressBar bar;
	
	public BarThread(JProgressBar bar,int time) {
		this.bar = bar;
		this.time=time;
	}
	
	public void run() {
		while (n<=100) {
			n++;
			setBarValue();		
			try {
				Thread.sleep(time);//non-runnable�� �����ٰ� 1�ʵ� �����϶�� ��� 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//���� ������ 
		public void setBarValue() {
			bar.setValue(n);//20�ۼ�Ʈ�� ä���� 
		}
}
