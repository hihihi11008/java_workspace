package day1111.member;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import day1111.board.BoardApp;

public class Login extends JPanel{
	JPanel p_container;
	JTextField t_id;
	JPasswordField t_pass;
	JButton bt_regist, bt_login;
	BoardApp boardApp;
	
	public Login(BoardApp boardApp) {
		this.boardApp=boardApp;
		p_container= new JPanel();
		t_id = new JTextField(30);
		t_pass = new JPasswordField(30);
		bt_regist= new JButton("����");
		bt_login= new JButton("�α���");
		
		p_container.setPreferredSize(new Dimension(350, 150));
		p_container.add(t_id);
		p_container.add(t_pass);
		p_container.add(bt_regist);
		p_container.add(bt_login);
		
		add(p_container);
		
		setVisible(true);
		
		
		bt_regist.addActionListener((e)->{
			boardApp.setPage(boardApp.MEMBER_REGIST);
		});
		
//		bt_login.addActionListener((e)->{
//			boardApp.setPage(boardApp.);
//		});
	}
}
