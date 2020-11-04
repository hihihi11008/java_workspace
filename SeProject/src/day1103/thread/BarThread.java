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
				Thread.sleep(time);//non-runnable에 빠졌다가 1초뒤 복귀하라는 명령 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//바의 값제어 
		public void setBarValue() {
			bar.setValue(n);//20퍼센트가 채워짐 
		}
}
