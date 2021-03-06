package day1110.network.multicasting;

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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MultiServer extends JFrame{
	JTextField t_port;
	JButton bt;
	JPanel p_north;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server;
	int port = 7777;
	
	Thread thread;//메인쓰레드 대신 접속자를 감지하게될 쓰레드! ( accept() 메서드 떄문에 )
	
	//
	Vector<MessageThread> clientList = new Vector<MessageThread>();
	

	public MultiServer() {
		t_port = new JTextField(Integer.toString(port),10);
		bt = new JButton("서버가동");
		p_north = new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		//조립 
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		//가동버튼과 리스너 연결 
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread = new Thread() {
					public void run() {
						startServer();
					}
				};
				thread.start();//Runnable로 진입시키자!
			}
		});
		
		setVisible(true);
		setBounds(600, 200, 300, 400);//x,y,width,height 순서
	}
	
	public void startServer(){
		try {
			server = new ServerSocket(Integer.parseInt(t_port.getText())); //서버소켓 생성 
			area.append("서버준비\n");
			
			//서버는 여려명의 접속자를 감지해야한다면, 각 접속자마다 비동기적으로 즉 독립적으로 서로 상관없이 
			//대화를 주고 받는 주체는 쓰레드의 인스턴스로 처리하자 ! 
			while (true) {
				Socket socket=server.accept();
				area.append("접속자발견\n");
				
				//다수의 접속자 수 정보를 어딘가에 저장해놓자 ! 

				 //대화용 쓰레드를 생성하고, 소켓을 넘기기 (여러명 대화 가능하게 하기위해)
	            MessageThread messageThread = new MessageThread(this, socket);
	            messageThread.start();
	            
	            clientList.add(messageThread);//지금접속한 클라이언트와 쌍을 이루는 서버측 대화쓰레드를 백터에 담아두면 
	            //총 몇명이 들어왔고 누가 들어왔는지에 대한 데이터를 누적할 수 있게 된다 
	            area.append("현재까지 접속자는 "+ clientList.size()+"명\n");
	            
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new MultiServer();
	}
}
