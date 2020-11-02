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




public class ChatC extends JFrame implements KeyListener, ActionListener{
							  /* is a                  is a */
	//1.초기화
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	JButton bt_open; //대화상대방을 띄우는 버튼 
	private ChatA chatA;
	private ChatB chatB;
	
	ArrayList<JFrame> frn = new ArrayList<JFrame>();
	
	public ChatC() {
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
		
		//5.
		bt.addActionListener(this);
		bt_open.addActionListener(this);
		t_input.addKeyListener(this);

		
		//4.
		setBounds(500, 550, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
	@Override 
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();//키코드값 반환 
		if(key ==10) { //엔터치면
			//System.out.println("area에 추가");
			send();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//가장 광범위한 object로 받음 .
		if(obj==bt) {		
			send();
			 }else if(obj.equals(bt_open)) { //누르는버튼과 열기버튼이 같은버튼이라면 
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
		chatB.area.append(msg+"\n");
		
	}
	//대화할 상대방 윈도우 띄우기 
	public void open() {

	}
	//세터 추가 
	public void setChatB(ChatB chatB) {
		new ChatB();
	}
	public void setChatA(ChatA chatA) {
		new ChatA();
	}
}
