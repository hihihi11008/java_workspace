package day1030.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class ChatB extends JFrame implements KeyListener, ActionListener{
							  /* is a                  is a */
	//1.초기화
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	JButton bt_open; //대화상대방을 띄우는 버튼 
	private ChatA chatA;
	private ChatC chatC;

	
	ArrayList<JFrame> frn = new ArrayList<JFrame>();
	
	public ChatB() {
		//나보다 부모가 먼저 태어나야한 super() , JFrame("부모창")
		super("나는 부모창");
		//1-1.생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(13);
		bt = new JButton("send");
		bt_open = new JButton("open");
		
		//2.패널조림(패널은 디폴트가 FlowLayout)
		p_south.add(t_input);
		p_south.add(bt);
		p_south.add(bt_open);
		
		add(scroll);//센터에 스크롤 부착
		add(p_south, BorderLayout.SOUTH); //남쪽에 패널부착
		
		//3.스타일적용
		area.setBackground(Color.yellow);
		t_input.setBackground(Color.BLUE);
		t_input.setForeground(Color.white);
		bt.setBackground(Color.black);
		bt.setForeground(Color.white);
		
		t_input.setPreferredSize(new Dimension(240,30));
		
		//5.보여주기 직전에 미리 연결해놓자 (컴포넌트와 리스너 연결)
		bt.addActionListener(this);
		bt_open.addActionListener(this);
		t_input.addKeyListener(this);//프레임이 곧 리스너다!!! 
		
		//open버튼에 리스너 연결 
		
		//4.
		//setSize(300,400);
		setBounds(500, 150, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
	@Override //어노테이션이다 java 5부터 지원되는 일종의 주석, 일반적인 주석은 프로그램에 관여하지 않지만 
					//어노테이션 프로그래밍에서 어떤 표시를 하기 위함이므로 자주 사용됨 
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//엔터키를 누르면, area에 입력 데이터를 반영하자(누적시키자)
		//System.out.println(e.getKeyCode());
		int key = e.getKeyCode();//키코드값 반환 
		
		if(key ==10) { //엔터치면
			//System.out.println("area에 추가");
			send();
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//가장 광범위한 object로 받음 .
		//JButton btn=(JButton)obj; //하위 자료형으로 변환 down casting  필수는아님 , 
		
		if(obj==bt) {
			
			send();
			 }else if(obj.equals(bt_open)) { //누르는버튼과 열기버튼이 같은버튼이라면 
//			System.out.println("open 누름?");
			open();
		}
	}
	//메세지창에 대화내용 누적하기
	public void send() {
		//나에대한 채팅처리
		String msg= t_input.getText();
		area.append(msg+"\n");
		t_input.setText("");

		//너에대한 채팅처리.
		chatA.area.append(msg+"\n");
		chatC.area.append(msg+"\n");
	}
	//대화할 상대방 윈도우 띄우기 
	public void open() {

	}
	//세터 추가 
	public void setChatC(ChatC chatC) {
		new ChatC();
	}
	public void setChatA(ChatA chatA) {
		new ChatA();
	}
}
