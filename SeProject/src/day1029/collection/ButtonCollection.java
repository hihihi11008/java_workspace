package day1029.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCollection extends JFrame implements ActionListener{
	JButton bt_s;
	JButton bt_bg;
	JPanel p_north;
	JPanel p_center;

	//�迭�� ũ�⸦ ���ؾ��ϱ� ������ ũ�⸦ �� �� ���� ���α׷����� ��뿡 ������ �ִ�. 
	//JButton[] btn= new JButton[]; //�迭�� ���� ū Ư¡, �迭�� ������ �ݵ�� ũ�⸦ ����ؾ��Ѵ�.
	ArrayList<JButton> btn= new ArrayList<JButton>(); //ũ�Ⱑ 0�̴�
	
	public ButtonCollection() {
		bt_s = new JButton("����");
		bt_bg = new JButton("����");
		p_north = new JPanel();
		p_center = new JPanel();
		
		
		p_north.add(bt_s);
		p_north.add(bt_bg);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		p_north.setBackground(Color.DARK_GRAY);
		p_center.setBackground(Color.LIGHT_GRAY);
		
		bt_s.addActionListener(this);
		bt_bg.addActionListener(this);
		
		
		setVisible(true);
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ButtonCollection();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//�̺�Ʈ�� ����Ų ������Ʈ�� ��ȯ 
		
		if(obj==bt_s) {
			create();
		}else if(obj==bt_bg) {
			setBG();
		}
	}
	public void create() {
		
		//��ư �����Ͽ�, p_center�� ���� 
		JButton bt = new CustomButton();
		p_center.add(bt);

		btn.add(bt);//����Ʈ�� �߰��ϱ�!! js�� push() �޼���� ����
		System.out.println("������� ������ ����Ʈ�� ���� "+btn.size());
		bt.setText("��ư"+Integer.toString(btn.size()));
		
		
		//p_center�� ��ư�� �׸��� �ƴ϶�, ��ư�� �߰��� ���̴� 
		//���� �̶��� p_center�� �����ϸ� �ȴ� update(UI)�̴� ! 
		p_center.updateUI();
	}
	public void setBG() {
		//btn ����Ʈ�� ����ִ� ��� ��Ҹ� ������� �����ٲٱ�! 
		//ArrayList�� �����ִ� �����̹Ƿ� for�� ����� �����ϴ� 
		for(int i =0; i<btn.size();i++) {
			JButton bt = btn.get(i);// ����Ʈ���� ������� 
			bt.setBackground(Color.yellow);
			
		}
	}
	
}
