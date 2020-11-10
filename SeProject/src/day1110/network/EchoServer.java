package day1110.network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	ServerSocket server;//��ȭ�� �����̾ƴ϶�, �����ڸ� �����ϰ� �����ڸ� �߰ߵǸ� ��ȭ�� ������ ��ȯ���ִ� ��ü
	//(��ġ��ȭ���� ���� �︮�� �����ĺ��� ��ȭ�� �ް� ��ȭ�ϴ°Ͱ� ���)
	//��ȭ �޴¿� ���� 
	int port=8989; //Ŭ���̾�Ʈ�� �޾Ƶ��� ��Ʈ��ȣ, �� ��Ʈ��ȣ�� ���� �ٸ� ��Ʈ��ũ ���μ����� ���е� �� �ִ� ��)����Ŭ 1521, mysql 3306
	
	
	public EchoServer() {
		try {
			server=new ServerSocket(port);//�������� ����(���� ������ �ƴ�)
			System.out.println("�������� �����Ϸ�");
			Socket socket=server.accept();//��������  �� Ŭ���̾�Ʈ���� ��ٸ�.. (������ ���Ë����� ���Ѵ�� �ϴ� �����߻�)
			//�����ڴ� ��ȯ���� �������κ��� ��ſ� �ʿ��� ����� ��Ʈ���� ���� �� �ִ� 
			//�̶� �����ڴ� ��Ʈ��ũ �Ϻο� ���� �ƹ��� �����̾��� �׳� ��Ʈ��ó���� �ϸ� �˾Ƽ� �������� ��ȭ���� ����� �����ϸ� 
			//�� ��� �͵��� ������ �˾Ƽ� ���ִ� �Ŵ� 
			InputStream is=socket.getInputStream();//����Ʈ����� �Է½�Ʈ���̹Ƿ� ������ �ؼ������� ���� 
			InputStreamReader reader=new InputStreamReader(is);
			BufferedReader buffr= new BufferedReader(reader);
			String data;
			while (true) {
				data =buffr.readLine();//1byte�б� (���ϰ� ����� ��Ʈ�����κ��� ) 
				System.out.print(data);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public static void main(String[] args) {
		new EchoServer();
	}
}
