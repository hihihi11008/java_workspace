package soomCoProject.main;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.image.ImageUtil;

public class test extends JFrame{
	JPanel p_navi;// ������Ʈ �� �޴��� ������ �����̳� �г�
	String[] navi_title= {"Home","Product","QnA","MyPage","Login"};
	JButton[] navi = new JButton[navi_title.length];//[][][][][] �迭 ����
	ImageIcon icon;
	
	public test() {
		p_navi = new JPanel();
		icon = ImageUtil.getIcon(this.getClass(), "res/Main_Interior_1.png", 30, 30);
		
		for (int i = 0; i < navi.length; i++) {
			navi[i]= new JButton(navi_title[i]);
			p_navi.add(navi[i]);//�гο� �׺���̼� ���� 
			navi[i].setIcon(icon);
		}
		
		add(p_navi);
		
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new test();
	}
}
