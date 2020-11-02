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

/*ä��â�������
  1.�ʱ�ȭ -����300,���� 450 / frame, textarea, scroll, textfield, panel, button, key, actionlistener
  2. border.center - textarea 
  3. border.south- textfield, ����button 
  4. area,field ����,���ڻ� �ֱ� 
  5. ��ưŬ����, �����Է½� �׼��ֱ� 
  */
public class Review extends JFrame implements KeyListener, ActionListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JPanel p_south;
	JButton bt;
	
	public Review() {
		area = new JTextArea();
		scroll = new JScrollPane(area);// java������ area�� scrollpane�� ���̰� scrollpane�� frame�� ���δ� 
		t_input = new JTextField(20);
		p_south = new JPanel();
		bt = new JButton("����");
		
		//add(area, BorderLayout.CENTER);
		add(scroll, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
		
		p_south.add(t_input);
		p_south.add(bt);
		
		area.setBackground(new Color(81,146,163));
		t_input.setBackground(new Color(255,186,83));
		//t_input.setForeground(Color.white);
		bt.setBackground(new Color(255,167,166));
		bt.setForeground(Color.white);
		
		t_input.setPreferredSize(new Dimension(0,30));
		
		t_input.addKeyListener(this);
		bt.addActionListener(this);
		
		
		setVisible(true);
		setSize(300,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Review();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==bt) {
			String msg = t_input.getText();
			area.append(msg+"\n");
			t_input.setText(""); 
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {		
		//System.out.println(e.getKeyCode());
		int key = e.getKeyCode();
		
		if(key == 10) {
			String msg = t_input.getText();
			area.append(msg+"\n");
			t_input.setText("");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {		
	}
}
