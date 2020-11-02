package day1030.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;



public class GalleryApp extends JFrame implements ActionListener{
	//1.
	JPanel p_center;
	JPanel p_west;
	//10.
	JScrollPane scroll;
	//17.
	JLabel la_name; //���񳪿ð� 
	XCanvas can;//���Ϳ� ũ�� ���� �̹����� �׸� ĵ���� 
	JPanel p_south;
	JButton bt_prev, bt_next;
	
	
	
	
	//8.����Ϲ迭���� 
	//Thumb[] list = new Thumb[10];//[][][][]..������ ����
	ArrayList<Thumb> list = new ArrayList<Thumb>(); //������� 0 
	//12 
	String dir="C:/workspace/java_workspace/SeProject/res/travel2/";
	String[] src= {
			"aa.jpg","ab.jpg","ax.jpg","bm.jpg","et.jpg","kg.jpg","mx.jpg","pk.jpg","ub.jpg","ya.jpg"};
	int n =0;//23. �迭�� index
	
	
	public GalleryApp() {
		//�ʱ�ȭ
		super("�ڹٰ�����");
		//2.����
		p_west = new JPanel();
		p_center = new JPanel();//2.
		scroll = new JScrollPane(p_west);//11.
		//17-2.
		la_name = new JLabel(src[n], SwingConstants.CENTER);//��α����ø����� dir �� �ֱ� 
		can = new XCanvas(dir+src[n]);
		p_south=new JPanel();
		bt_prev=new JButton("���� ����");
		bt_next=new JButton("���� ����");
		
		//9.����� ���� .
		for(int i=0; i<src.length;i++) {
			Thumb thumb=null; //15 .
			list.add(thumb=new Thumb(dir+src[i], this));
			p_west.add(thumb);
		}
		
		
		//3.��Ÿ��
		la_name.setPreferredSize(new Dimension(700,50));//17.4
		la_name.setFont(new Font("Verdana", Font.BOLD, 25));
		
		p_west.setPreferredSize(new Dimension(100,600));
		p_center.setPreferredSize(new Dimension(700,600));
		p_west.setBackground(Color.YELLOW);
		p_center.setBackground(Color.GRAY);
		
		//17-3
		p_south.add(bt_prev);
		p_south.add(bt_next);
		p_center.add(la_name);
		p_center.add(can);
		p_center.add(p_south);
		
		//4.���� //12 ��ũ���� �� ũ�⶧���� ��ũ���� �ִ´�
		add(scroll, BorderLayout.WEST);
		add(p_center);
		
		//25 
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		//1-1.
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);//�����츦 ȭ�� �߾ӿ� ���� �� 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		updateDate();//ù�̹������� ����ǥ�õǰ�
	}
	
	public static void main(String[] args) {
		new GalleryApp();
	}

	@Override//22 
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); //�̺�Ʈ ����Ų ������Ʈ
		
		if(obj==bt_prev) {
			prev();
		}else if(obj==bt_next) {
			next();
		}
		updateDate();// 28 ��� ��ư�� ������ ������Ʈ�� �Ͼ�⶧���� if�������� ����
	}
	public void updateDate() {
		//���񺯰� 
		la_name.setText(src[n]+"("+(n+1)+"/"+src.length+")");
		//27 ����Ǵ� �����͸� �޼����
		can.setSrc(dir+src[n]);//��������� ����
		can.repaint();//update() --> paint()
		
	}
	public void prev() {
		//next���� �����ؼ� n--; ���� ����
		if(n>0) {
			n--;			
		}else {
			JOptionPane.showMessageDialog(this, "ù �����̿���! ");			
		}
	}
	public void next() {
		//22�׸��� XCanvas�� ����ϹǷ�, �׷��� img�� ��������ְ� �ٽñ׸����ϸ�� (updateDate()�޼���� �Q��)
		//29 �迭�� �Ѿ�� �ʴ� ���������� ++���
		if(n<src.length-1) {
			n++;				
		}else {
			JOptionPane.showMessageDialog(this, "������ �����̿�����_��");
			//showMessageDialog(parentComponent, message) - parentComponent �θ�������Ʈ�� �ƴ϶� �ٱ���������Ʈ�� ����
		}
	}
}
