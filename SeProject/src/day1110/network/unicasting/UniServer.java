package day1110.network.unicasting;

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



public class UniServer extends JFrame{
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
	

	public UniServer() {
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
			
			//������ �������� �����ڸ� �����ؾ��Ѵٸ�, �� �����ڸ��� �񵿱������� �� ���������� ���� ������� 
			//��ȭ�� �ְ� �޴� ��ü�� �������� �ν��Ͻ��� ó������ ! 
			while (true) {
				Socket socket=server.accept();
				area.append("�����ڹ߰�\n");
				
				 //��ȭ�� �����带 �����ϰ�, ������ �ѱ�� (������ ��ȭ �����ϰ� �ϱ�����)
	            MessageThread messageThread = new MessageThread(this, socket);
	            messageThread.start();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new UniServer();
	}
}
