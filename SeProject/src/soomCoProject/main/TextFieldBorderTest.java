package soomCoProject.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldBorderTest extends JFrame{
	JTextField textField;
	JPanel panel;
	JButton bt;
	
	public TextFieldBorderTest() {
		
		setTitle("SoomCo");
		textField = new JTextField(15);
		panel = new JPanel();
		bt = new JButton("Å¬¸¯");

		textField.setBorder(BorderFactory.createTitledBorder("SoomCo"));
//		textField.setBackground(null);
		
		setLayout(new FlowLayout());
		
		panel.add(textField);
		panel.add(bt);
		add(panel);
	
		setVisible(true);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TextFieldBorderTest();
	}
}
