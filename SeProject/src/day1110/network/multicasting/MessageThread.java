package day1110.network.multicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.text.StyledEditorKit.BoldAction;



//이쓰레드는 대화용 쓰레드 이므로 입출력 스트림을 각각의 인스턴스가 보유해야한다 
//아래의 클래스를 쓰레드로 선언하는 순간부터, 이 인스턴스들은 서로 비동기(Asynchronous)적으로 동작할 수 있다 
public class MessageThread extends Thread{
	Socket socket;//각각의 쓰레드는 대화용 소켓을 보유해야 스트림을 뽑을 수 있으므로, 접속자가 감지되면 해당 소켓을 인수로 넘겨 받자 
	BufferedReader buffr;//듣기
	BufferedWriter buffw;//말하기 
	MultiServer multiServer;
	boolean flag = true;
	
	public MessageThread(MultiServer multiServer,Socket socket) {
		this.multiServer = multiServer;
		this.socket = socket;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
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
				while (flag) {
					msg = buffr.readLine();	
					//코드명령어 중 나간다는 뜻이면 ... 나가는 ㅓ리 
					if(msg.equals("exit")) {
						//1)벡터명단에서 제거하고 2)flag도 flase : 쓰레드 Dead
						multiServer.clientList.remove(this); // 나를 명단에서 제거 
						flag=false;
						multiServer.area.append("현재까지 접속자 수 "+multiServer.clientList.size()+"명\n");
					}else {
						multiServer.area.append(msg+"\n");
						send(msg);						
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//클라이언트에게 메시지 보내기 
		public void send(String msg) {
			try {
				//벡터에 들어있는 메시지쓰레드만큼 반복문 수행하면서 .write,flush 수행하면됨 (멀티캐스팅)
				for (int i = 0; i < multiServer.clientList.size(); i++) {
					MessageThread messageThread= multiServer.clientList.get(i);//벡터에 들어있는 메시지 쓰레드를 하나씩 꺼낸다 
					messageThread.buffw.write(msg+"\n");
					messageThread.buffw.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
