package day1028.graphic.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame implements ActionListener{
	AlbumPanel p;//paint�޼��带 �������Ϸ��� Ŭ������ �����ؾ��Ѵ� 
	
	JPanel p_south; //��ư 2���� ���� �г� 
	JButton bt_prev, bt_nextButton;// ����, ���� ��ư 

	public PhotoAlbum() {
		//����
		p = new AlbumPanel();
		p.setBackground(Color.yellow);
		p_south = new JPanel();
		bt_prev = new JButton("���� ����");
		bt_nextButton = new JButton("���� ����");
		
		//���� 
		add(p);//�߾ӿ� �ٹ��г� �ֱ� 
		p_south.add(bt_prev);
		p_south.add(bt_nextButton);
		add(p_south, BorderLayout.SOUTH);
		
		bt_prev.addActionListener(this);
		bt_nextButton.addActionListener(this);
		
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource(); //�̺�Ʈ�� ����Ų �̺�Ʈ�ҽ� ���ϱ� 
		//�̺�Ʈ�ҽ���? �̺�Ʈ�� ����Ų ������Ʈ�� �ǹ� 
		
		//������ư�̸� AlbumPanel.n�� ����
		if(object==bt_prev) {
			p.n--;
		}
		//������ư�̸� AlbumPanel.n�� ���� 
		if(object==bt_nextButton) {
			p.n++;
		}
		//ȭ�� ���� (���� AlbumPanel�� paint()ȣ�� �Ұ� )
		//�����ϵ��� ��û!! 
		p.repaint(); //�ٽñ׷��ּ��� update() -> paint()
		
	}
	
	public static void main(String[] args) {
		new PhotoAlbum();
	}
}
