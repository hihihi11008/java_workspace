package day1027.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//GUI �� �������� ��ü���� ���� �Ϲ� Ŭ���� 
public class MemoApp extends JFrame{
	JMenuBar bar;  //1.�޴����� �÷����� ����(import���ֱ�)
	JMenu m_file,m_edit,m_style,m_view,m_help;//2.�������ְ� �޴��̸� �ʱ�ȭ 
	//��ü�ڷ����� �ڷ����̹Ƿ�, �迭�� ���� 
	JMenuItem[] items;//1)m_file �޴��� ���� �޴��� �� 8���� �������� �߰��غ��� 
	String[] item_title= {"���� �����","�� â","����","����","�ٸ� �̸����� ����","������ ����","����Ʈ","������"};//1-2)
	JTextArea area;//3.
	JScrollPane scroll;//4. area�� �ٿ��� ��ũ�� 
	
	//5.
	public MemoApp() {
		//6.�ٻ���
		bar = new JMenuBar();
		
		//7.�޴��� ���� 
		m_file = new JMenu("����");
		m_edit = new JMenu("����");
		m_style = new JMenu("����");
		m_view = new JMenu("����");
		m_help = new JMenu("����");
		
		//2)��ü�迭 ���� (������ ����) : ����! �޴��������� �����Ȱ� �ƴ϶�, �������� �� �ڸ��� 8ĭ Ȯ���� ������
		//js�ʹ� �޸�, �ڹٿ����� �迭�� �ڷ����� �̹� �����Ǹ�, �ش� �ڷ����� ���� �� ���� 
		items = new JMenuItem[item_title.length];
		//3)�޴� ���� 
		for(int i=0;i<items.length;i++) {
			items[i]=new JMenuItem(item_title[i]);//�����ۻ���
			//3-1)5��° �����ϸ� ���м� �߰� 
			if(i==5 || i==7) {
				m_file.addSeparator();//���м��߱�
			}
			m_file.add(items[i]);//���Ͽ� ������ ���� 
		}
		
		//8.
		area = new JTextArea();
		scroll = new JScrollPane(area); //8-1. ��ũ�� �ް� ���� ������Ʈ�� ������ �Ű������� �ִ´� 
		
		//9.�ٿ� �޴��� ����
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_style);
		bar.add(m_view);
		bar.add(m_help);
		
		//10.�ٴ� ���� Ư������ �ֱ� ������ ��ġ�����ڿ� ������� ������ �������� ��ܿ����� �ٿ��� 
		this.setJMenuBar(bar);//JFrame�� �� ���� 
		
		
		//11.�����ӿ� scroll���� (���ͺ��⿣ area�� �����ؾ� �� �� ó�� ��������, scroll �� area�� �����ϰ� �����Ƿ� 
		//scroll�� �ٿ����Ѵ� )
		add(scroll);
		//11-1.bar ��Ÿ������
		bar.setBackground(Color.black);
		m_file.setForeground(Color.white);
		m_edit.setForeground(Color.white);
		m_style.setForeground(Color.white);
		m_view.setForeground(Color.white);
		m_help.setForeground(Color.white);
		
		//11-1.�޴�ũ������
		m_file.setPreferredSize(new Dimension(100,50));
		m_edit.setPreferredSize(new Dimension(100,50));
		m_style.setPreferredSize(new Dimension(100,50));
		m_view.setPreferredSize(new Dimension(100,50));
		m_help.setPreferredSize(new Dimension(100,50));
		
		//11-1.area ��Ÿ�� ���� 
		area.setBackground(Color.pink);//area���� �ٲٱ� 
		area.setFont(new Font("����", Font.BOLD|Font.ITALIC, 15));//area �۾�Ű���
		area.setForeground(Color.MAGENTA);//area �۾�������
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//12.
	public static void main(String[] args) {
		new MemoApp();
	}
}
