package day1029.collection.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.ChangedCharSetException;

public class AlbumBook extends JFrame implements ActionListener{
	
	
	String dir="C:/workspace/java_workspace/SeProject/res/travel2/";
	String[] src= {
			"aa.jpg",
			"ab.jpg",
			"ax.jpg",
			"bm.jpg",
			"et.jpg",
			"kg.jpg",
			"mx.jpg",
			"pk.jpg",
			"ub.jpg",
			"ya.jpg"			
	};
	JPanel p_south;
	JPanel p_west;
	BookPanel b;
	DetailPanel p_center;
	JLabel label;
	JButton bt_prev, bt_next; 
	//������ �̹��� 10���� �迭�� �غ��ϸ� ȿ������ ���� ����
	ThumbCanvas[] thumb = new ThumbCanvas[src.length];
	
	
	public AlbumBook() {
		b = new BookPanel();
		p_south = new JPanel();
		p_west = new JPanel();
		p_center = new DetailPanel();
		label = new JLabel("������γֱ� ");
		label.setHorizontalAlignment(JLabel.CENTER);
		bt_next = new JButton("���� ����");
		bt_prev = new JButton("���� ����");
		for(int i=0;i<thumb.length;i++) {
			thumb[i]=new ThumbCanvas(dir+src[i], p_center);
			p_west.setLayout(new GridLayout(i+1, 1));
			p_west.add(thumb[i]);
		}
		add(b);
		add(p_center);

		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_south, BorderLayout.SOUTH);
		add(p_west, BorderLayout.WEST);
		add(label, BorderLayout.NORTH);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		setVisible(true);
		setSize(770,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new AlbumBook();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt_prev) {
			b.n--;
		}else if(obj==bt_next) {
			b.n++;
		}
		b.repaint();
	}

}
