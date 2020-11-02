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
	//1.�ʱ�ȭ
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	JButton bt_open; //��ȭ������ ���� ��ư 
	private ChatA chatA;
	private ChatC chatC;

	
	ArrayList<JFrame> frn = new ArrayList<JFrame>();
	
	public ChatB() {
		//������ �θ� ���� �¾���� super() , JFrame("�θ�â")
		super("���� �θ�â");
		//1-1.����
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(13);
		bt = new JButton("send");
		bt_open = new JButton("open");
		
		//2.�г�����(�г��� ����Ʈ�� FlowLayout)
		p_south.add(t_input);
		p_south.add(bt);
		p_south.add(bt_open);
		
		add(scroll);//���Ϳ� ��ũ�� ����
		add(p_south, BorderLayout.SOUTH); //���ʿ� �гκ���
		
		//3.��Ÿ������
		area.setBackground(Color.yellow);
		t_input.setBackground(Color.BLUE);
		t_input.setForeground(Color.white);
		bt.setBackground(Color.black);
		bt.setForeground(Color.white);
		
		t_input.setPreferredSize(new Dimension(240,30));
		
		//5.�����ֱ� ������ �̸� �����س��� (������Ʈ�� ������ ����)
		bt.addActionListener(this);
		bt_open.addActionListener(this);
		t_input.addKeyListener(this);//�������� �� �����ʴ�!!! 
		
		//open��ư�� ������ ���� 
		
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
		Object obj = e.getSource();//���� �������� object�� ���� .
		//JButton btn=(JButton)obj; //���� �ڷ������� ��ȯ down casting  �ʼ��¾ƴ� , 
		
		if(obj==bt) {
			
			send();
			 }else if(obj.equals(bt_open)) { //�����¹�ư�� �����ư�� ������ư�̶�� 
//			System.out.println("open ����?");
			open();
		}
	}
	//�޼���â�� ��ȭ���� �����ϱ�
	public void send() {
		//�������� ä��ó��
		String msg= t_input.getText();
		area.append(msg+"\n");
		t_input.setText("");

		//�ʿ����� ä��ó��.
		chatA.area.append(msg+"\n");
		chatC.area.append(msg+"\n");
	}
	//��ȭ�� ���� ������ ���� 
	public void open() {

	}
	//���� �߰� 
	public void setChatC(ChatC chatC) {
		new ChatC();
	}
	public void setChatA(ChatA chatA) {
		new ChatA();
	}
}
