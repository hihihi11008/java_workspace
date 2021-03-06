/*
 	쓰레드란? Thread
 	-하나의 프로세스내에서 비동기적으로 동작할 수 있는 또하나의 세부실행 단위를 말한다 
 */
package day1103.thread;

public class ThreadTest1 {
	public static void main(String[] args) {
		//시간쓰레드 생성하고 , 동작시켜보자 
		TimeThread tt = new TimeThread();
		tt.start();//runnable 상태로 진입 ! 
		
		//0.5초마다 별을 출력하는 쓰레드를 구현하되, 현재 클래스내에서 구현하자 ! ( 내부익명 클래스 )
		Thread startThread = new Thread() {
			public void run() {
				while(true) {
					System.out.println("★");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		startThread.start();//Runnable상태로 진입
		
		//개발자가 정의한 쓰레드를 이용해서 무한루프 수행! 
		MyThread t1 = new MyThread(); // 분신생성 
		//쓰레드의 수행은 시스템에 맡겨야한다 
		//t1.start();
		//쓰레드가 보유한 run() 메서드는 jvm에 의해 호출된다 ! 
//		
//		while(true) {
//			System.out.println("hi");
//		}
		
	}
}
