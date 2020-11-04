//초를 실시간 출력할 쓰레드
package day1103.thread;

import java.util.Calendar;
import java.util.Date;

public class TimeThread extends Thread{
	
	public void run() {
		while(true) {
			//현재 시간을 구해서 1초마다 갱신해서 출력 
			Calendar cal = Calendar.getInstance(); // 추상클래스이므로 자체 메서드로 인스턴스 얻자!(툴킷도 이런식으로 얻어옴)
			//System.out.println(cal);
			System.out.println(cal.get(Calendar.YEAR)+"년"+(cal.get(Calendar.MONTH)+1)+"월"+cal.get(Calendar.DATE)+"일"+
			cal.get(Calendar.HOUR)+"시"+cal.get(Calendar.MINUTE)+"분"+cal.get(Calendar.SECOND)+"초");
			Date time = cal.getTime();
			System.out.println(time);
			try {
				Thread.sleep(1000);// 1/1000초까지 표현가능  JS setinterval과 흡사
											//1초동안 non-runnable 로 상태로 있다가 다시 복귀하라는 명령 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
