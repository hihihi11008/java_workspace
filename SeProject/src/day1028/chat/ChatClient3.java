package day1028.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient3 extends ChatClient implements KeyListener, ActionListener{
							  /* is a                  is a */
	//1.초기화
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	ChatClient ch;
	ChatClient2 ch2;
	
	public ChatClient3(ChatClient ch,ChatClient2 ch2) {
		this.ch =ch;
		this.ch2 =ch2;
		//super("자식 창");
		//1-1.생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(20);
		bt = new JButton("send");
		
		//2.패널조림(패널은 디폴트가 FlowLayout)
		p_south.add(t_input);
		p_south.add(bt);
		
		add(scroll);//센터에 스크롤 부착
		add(p_south, BorderLayout.SOUTH); //남쪽에 패널부착
		
		//3.스타일적용
		area.setBackground(new Color(81,146,163));
		t_input.setBackground(new Color(255,186,83));
		//t_input.setForeground(Color.white);
		bt.setBackground(new Color(255,167,166));
		bt.setForeground(Color.white);
		
		t_input.setPreferredSize(new Dimension(265,30));
		
		//5.보여주기 직전에 미리 연결해놓자 (컴포넌트와 리스너 연결)
		bt.addActionListener(this);
		t_input.addKeyListener(this);//프레임이 곧 리스너다!!! 
		
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
		Object obj = e.getSource();
		
		if(obj==bt) {
			String msg = t_input.getText();//텍스트필드값을 구하자 
			 area.append(msg+"\n");
			 t_input.setText("");
		}
		
	}
	public void send() {
		//나에대한 처리 
		String msg= t_input.getText();
		area.append(msg+"\n");
		t_input.setText("");
		
		//너에대한 처리 
		ch.area.append(msg+"\n");
		ch.t_input.setText("");

		ch2.area.append(msg+"\n");
		ch2.t_input.setText("");

	}
}
