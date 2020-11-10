package day1110.network.echocasting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class EchoServer extends JFrame{
	JTextField t_port;
	JButton bt;
	JPanel p_north;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server;
	int port = 7777;
	
	Thread thread;//���ξ����� ��� �����ڸ� �����ϰԵ� ������! ( accept() �޼��� ������ )
	BufferedReader buffr;//���
	BufferedWriter buffw;//���ϱ� 
	

	public EchoServer() {
		t_port = new JTextField(Integer.toString(port),10);
		bt = new JButton("��������");
		p_north = new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		//���� 
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		//������ư�� ������ ���� 
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread = new Thread() {
					public void run() {
						startServer();
					}
				};
				thread.start();//Runnable�� ���Խ�Ű��!
			}
		});
		
		
		setVisible(true);
		setBounds(600, 200, 300, 400);//x,y,width,height ����
	}
	
	public void startServer(){

		try {
			server = new ServerSocket(Integer.parseInt(t_port.getText())); //�������� ���� 
			area.append("�����غ�\n");
			//���� ���� 
			//�ڹٴ� ���������̹Ƿ� ���ݱ��� ���ν���ζ� �ҷȴ� ������ü�� ����� �ý��ۿ� ���� ������ �����忴�� 
			//������ ���ξ������ �����ڰ� �����ϴ� �Ϲݾ�����ʹ� �ϴ� ���ҿ� ���̰� �ִ�. 
			//���ξ������ ���α׷��� ����ִ� ���� Ư�� �׷���ó��, �̺�Ʈó������ ����ϹǷ� ����� �Ʒ��� ��������
			//1.���ѷ����� ��Ʈ���� ���� 
			//2. �����¿� ������ ���� ���� (accept(), ��Ʈ���� read()...�� )
			//		����� �ȵ���̵忡���� ���ξ����尡 1, 2 �� �õ���ü�� ������ ���� 
			//���) ������ �����带 �����Ͽ� ó������ 
			Socket socket=server.accept();//������ ������ ���ÿ� ��ȭ�� ���� ��ȯ! 
			area.append("�����ڹ߰�\n");
			
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			listen();//������
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//�޼��� �ޱ�(û��)
	public void listen() {
		String msg= null;
		try {
			while (true) {
				msg = buffr.readLine();//����μ��� �ѹ��� ����� while�� ���� ������ ��´� 			
				area.append(msg+"\n");
				send(msg);//Ŭ���̾�Ʈ���� �ٽú������Ѵ� ������ �ǹ� 
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
	public static void main(String[] args) {
		new EchoServer();
	}
}
