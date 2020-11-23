package soomCoProject.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LogIn extends Page{
	JPanel p_container;
	JLabel la_id, la_password;
	JTextField t_id;
	JPasswordField t_password;
	JButton bt_login,bt_regist;
	
	public LogIn(MainFrame mainFrame) {
		super(mainFrame);
		
		
		
		p_container = new JPanel();
		la_id= new JLabel("ID");
		t_id = new JTextField(20);
		la_password= new JLabel("PassWord");
		t_password = new JPasswordField(20);
		bt_login = new JButton("로그인");
		bt_regist = new JButton("회원가입");
		
		p_container.setLayout(null);
		
		la_id.setBounds(10, 10, 80, 25);
		la_password.setBounds(10, 40, 80, 25);
		t_id.setBounds(100, 10, 160, 25);
		t_password.setBounds(100, 40, 160, 25);
		bt_login.setBounds(30, 80, 100, 25);
		bt_regist.setBounds(150, 80, 100, 25);

		
		p_container.setPreferredSize(new Dimension(280, 150));
		p_container.setBackground(new Color(235, 70, 72));
		p_container.add(la_id);
		p_container.add(t_id);
		p_container.add(la_password);
		p_container.add(t_password);
		p_container.add(bt_login);
		p_container.add(bt_regist);
		
		
		//스타일 
		
		add(p_container);
		
		setSize(280, 150);
		setVisible(true);
		
	}


}
