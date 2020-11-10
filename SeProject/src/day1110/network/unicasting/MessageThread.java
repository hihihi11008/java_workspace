package day1110.network.unicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

//�̾������ ��ȭ�� ������ �̹Ƿ� ����� ��Ʈ���� ������ �ν��Ͻ��� �����ؾ��Ѵ� 
//�Ʒ��� Ŭ������ ������� �����ϴ� ��������, �� �ν��Ͻ����� ���� �񵿱�(Asynchronous)������ ������ �� �ִ� 
public class MessageThread extends Thread{
	Socket socket;//������ ������� ��ȭ�� ������ �����ؾ� ��Ʈ���� ���� �� �����Ƿ�, �����ڰ� �����Ǹ� �ش� ������ �μ��� �Ѱ� ���� 
	BufferedReader buffr;//���
	BufferedWriter buffw;//���ϱ� 
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
	//�޼��� �ޱ�(û��)
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
		
		//Ŭ���̾�Ʈ���� �޽��� ������ 
		public void send(String msg) {
			try {
				buffw.write(msg+"\n");
				buffw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
