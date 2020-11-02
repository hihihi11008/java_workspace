package day1102.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowApp extends JFrame{
	public WindowApp() {
		this.addWindowListener(new WindowAdapter() {//<--이름없는 클래스 코드 (내부익명클래스):재사용성없이 이벤트 구현할때 사용! 
			
			public void windowClosing(WindowEvent e) {//창에 의해 프로그램 종료될때 
				System.out.println("창 닫힘");
				System.exit(0);//프로세스 종료 
			}
		});
		
		setSize(300, 400);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new WindowApp();
	}

}
