/*ä�� �޽����� ������ �ʴ���, ä�ÿ� �����ϴ� ��� ����� ���� �޽����� �����Ϸ��� 
 * ���Ϸ����� ����Ǹ鼭 ��Ʈ���� ���� �����尡 �ʿ��ϴ� 
 * */
package day1110.network.multicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientThread extends Thread{
	MultiClient multiClient;
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	boolean flag = true;
	
	
	public ClientThread(MultiClient multiClient,Socket socket) {
		this.multiClient = multiClient;
		this.socket = socket;
		//������ �����Ǿ����Ƿ�, ��Ʈ���� ���� �� �ִ�. 
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
	//������ ���� �޽��� ��� 
	public void listen() {
		String msg= null;
		try {
			while (flag) {
				msg=buffr.readLine();
				multiClient.area.append(msg+"\n");//��ȭ ����ϱ� 				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//������ �޽��� ������(���)
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();//�����ִ� �����;���, ���ۺ���				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
