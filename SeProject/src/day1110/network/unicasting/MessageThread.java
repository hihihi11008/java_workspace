package day1110.network.unicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

//이쓰레드는 대화용 쓰레드 이므로 입출력 스트림을 각각의 인스턴스가 보유해야한다 
//아래의 클래스를 쓰레드로 선언하는 순간부터, 이 인스턴스들은 서로 비동기(Asynchronous)적으로 동작할 수 있다 
public class MessageThread extends Thread{
	Socket socket;//각각의 쓰레드는 대화용 소켓을 보유해야 스트림을 뽑을 수 있으므로, 접속자가 감지되면 해당 소켓을 인수로 넘겨 받자 
	BufferedReader buffr;//듣기
	BufferedWriter buffw;//말하기 
	UniServer uniServer;
	
	public MessageThread(UniServer uniServer,Socket socket) {
		this.socket = socket;
		this.uniServer = uniServer;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			String msg=null;
			msg = buffr.readLine();	
			uniServer.area.append(msg+"\n");
			send(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		listen();
	}
	//메세지 받기(청취)
		public void listen() {
			String msg= null;
			try {
				while (true) {
					msg = buffr.readLine();	
					uniServer.area.append(msg+"\n");
					send(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//클라이언트에게 메시지 보내기 
		public void send(String msg) {
			try {
				buffw.write(msg+"\n");
				buffw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
