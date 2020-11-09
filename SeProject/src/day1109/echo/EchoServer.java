/*
 *������ǥ�� ä��(��Ƽĳ���� ����) ������ �ϴ� ������ Echo System�� ���� �н� 
 */
package day1109.echo;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	ServerSocket server; // ��ȭ�� ������ �ƴ� , ������ ������ ������ ����! 
	int port =9999; // port 1~1024�������� �̹� �ý����� �����ϹǷ�, ���Ұ�

	public EchoServer() {
		//���������� �̿��Ͽ�, ������ �޾ƺ��� 
		try {
			server = new ServerSocket(port);
			System.out.println("�������� �����Ϸ�");
			
			Socket socket=server.accept(); //�����ڰ� �߰ߵɶ����� ������·� ��ٸ� 
			System.out.println("������ �߰�");
			
			//��ȯ���� ������ �̿��ϸ�, ���� �����ڿ� ���� ������ ���� �� ������, Ư�� ip�� �����غ��� 
			InetAddress inet=socket.getInetAddress();//���ͳ� �ּ������� ���� ��ü 
			String ip=inet.getHostAddress();//ip���� 
			System.out.print(ip);
			
			//Ŭ���̾�Ʈ�� ���� �޽��� �ޱ� (�޽����� �޴� ���� �������� ���α׷����� �����Ͱ� ������ ���̹Ƿ� 
			//�Է½�Ʈ������ ó���ؾ� �Ѵ� )
			//�������κ��� ��Ʈ���� �̾Ƴ� �� �ִ� .
			InputStream is=socket.getInputStream();//����Ʈ ����� �Է½�Ʈ��(�ѱ۱���, ���� �������� �� )
			int data;
			while (true) {
				data=is.read();//1byte�о����
				System.out.println((char)data);				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}//�������ϻ���
	}
	public static void main(String[] args) {
		new EchoServer();
	}
}
