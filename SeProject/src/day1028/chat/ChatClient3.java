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
	//1.�ʱ�ȭ
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
		//super("�ڽ� â");
		//1-1.����
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(20);
		bt = new JButton("send");
		
		//2.�г�����(�г��� ����Ʈ�� FlowLayout)
		p_south.add(t_input);
		p_south.add(bt);
		
		add(scroll);//���Ϳ� ��ũ�� ����
		add(p_south, BorderLayout.SOUTH); //���ʿ� �гκ���
		
		//3.��Ÿ������
		area.setBackground(new Color(81,146,163));
		t_input.setBackground(new Color(255,186,83));
		//t_input.setForeground(Color.white);
		bt.setBackground(new Color(255,167,166));
		bt.setForeground(Color.white);
		
		t_input.setPreferredSize(new Dimension(265,30));
		
		//5.�����ֱ� ������ �̸� �����س��� (������Ʈ�� ������ ����)
		bt.addActionListener(this);
		t_input.addKeyListener(this);//�������� �� �����ʴ�!!! 
		
		//4.
		//setSize(300,400);
		setBounds(500, 150, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
	@Override //������̼��̴� java 5���� �����Ǵ� ������ �ּ�, �Ϲ����� �ּ��� ���α׷��� �������� ������ 
					//������̼� ���α׷��ֿ��� � ǥ�ø� �ϱ� �����̹Ƿ� ���� ���� 
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//����Ű�� ������, area�� �Է� �����͸� �ݿ�����(������Ű��)
		//System.out.println(e.getKeyCode());
		int key = e.getKeyCode();//Ű�ڵ尪 ��ȯ 
		
		if(key ==10) { //����ġ��
			//System.out.println("area�� �߰�");
			send();
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==bt) {
			String msg = t_input.getText();//�ؽ�Ʈ�ʵ尪�� ������ 
			 area.append(msg+"\n");
			 t_input.setText("");
		}
		
	}
	public void send() {
		//�������� ó�� 
		String msg= t_input.getText();
		area.append(msg+"\n");
		t_input.setText("");
		
		//�ʿ����� ó�� 
		ch.area.append(msg+"\n");
		ch.t_input.setText("");

		ch2.area.append(msg+"\n");
		ch2.t_input.setText("");

	}
}
