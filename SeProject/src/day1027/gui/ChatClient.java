package day1027.gui;

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

public class ChatClient extends JFrame implements KeyListener, ActionListener{
							  /* is a                  is a */
	//1.�ʱ�ȭ
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	
	public ChatClient() {
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
		area.setBackground(Color.yellow);
		t_input.setBackground(Color.BLUE);
		t_input.setForeground(Color.white);
		bt.setBackground(Color.black);
		bt.setForeground(Color.white);
		
		t_input.setPreferredSize(new Dimension(265,30));
		
		//5.�����ֱ� ������ �̸� �����س��� (������Ʈ�� ������ ����)
		bt.addActionListener(this);
		t_input.addKeyListener(this);//�������� �� �����ʴ�!!! 
		
		//4.
		setSize(300,400);
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
			String msg = t_input.getText();//�ؽ�Ʈ�ʵ尪�� ������ 
			area.append(msg+"\n");
			t_input.setText("");//���ؽ�Ʈ�� �ʱ�ȭ 
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==bt) {
			String msg = t_input.getText();//�ؽ�Ʈ�ʵ尪�� ������ 
			area.append(msg+"\n");
			t_input.setText("");//���ؽ�Ʈ�� �ʱ�ȭ 
		}
		
	}
	public static void main(String[] args) {
		new ChatClient();
	}
}
