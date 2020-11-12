package day1111.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import day1111.board.BoardApp;

public class RegistForm extends JPanel{
	JPanel p_container;
	JTextField t_id;
	JPasswordField t_pass;
	JTextField t_name;
	JButton bt;
	BoardApp boardApp;
	
	public RegistForm(BoardApp boardApp) {
		this.boardApp = boardApp;
		p_container = new JPanel();
		t_id = new JTextField(30);
		t_pass = new JPasswordField(30);
		t_name = new JTextField(30);
		bt = new JButton("����");
		
		p_container.setBackground(Color.pink);
		p_container.setPreferredSize(new Dimension(350, 200));
		
		p_container.add(t_id);
		p_container.add(t_pass);
		p_container.add(t_name);
		p_container.add(bt);
		
		add(p_container);
		
		setVisible(true);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}