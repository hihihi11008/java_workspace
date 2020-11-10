/*���ڼ����� �����Ͽ� �޽����� �ְ���� Ŭ���̾�Ʈ �ۼ�*/
package day1110.network;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	Socket socket;//��ȭ�� ���� 
	String ip="localhost";
	int port=8989;
	Thread thread;
	
	public EchoClient() {
		try {
			//������ ������ ������ �õ��Ѵ�
			//���� ������ �ν��Ͻ��� ������ٴ� ���� �̹̼������� ������ �� �����̴� 
			socket = new Socket(ip, port); //new ��ü�� ���� 
			System.out.println("���Ӽ���");
			
			//�޴¿�, �� ��¿� 
			InputStream is = socket.getInputStream();
			InputStreamReader reader=new InputStreamReader(is);
			BufferedReader buffr= new BufferedReader(reader);
			
			//�����¿�, �� ���ϴ¿� 
			OutputStream out= socket.getOutputStream();
			OutputStreamWriter writer= new OutputStreamWriter(out);
			BufferedWriter buffw= new BufferedWriter(writer);
			
			thread = new Thread() {
				public void run() {
					//����� ��Ʈ���� �̿��Ͽ� ������ �޽��� ������ 
					while (true) {
						try {
							buffw.write("��ȣ\n"); //������ �޽��� ���
							buffw.flush();//����ó���� ��½�Ʈ���� ���, ��Ʈ������ �����͸� ��� ��������°� 
							Thread.sleep(1000);
						} catch (IOException e) {
							e.printStackTrace();
						}catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			
			
			thread.start();//Runnable�� �о�ֱ� thread����
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EchoClient();
	}
}
