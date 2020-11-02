package day1030.io;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CopyTest extends JFrame implements ActionListener{
	JLabel la_ip;
	JLabel la_op;
	JTextField f_ip;
	JTextField f_op;
	JButton bt;
	
	
	
	String ori;
	String dest;
	
	public CopyTest() {
		//����
		la_ip = new JLabel("����");
		la_op = new JLabel("���纻");
		f_ip = new JTextField(50);
		f_op = new JTextField(50);
		bt = new JButton("COPY");
		
		
		//��Ÿ�� 
		la_ip.setPreferredSize(new Dimension(150,30));
		la_op.setPreferredSize(new Dimension(150,30));
		f_ip.setPreferredSize(new Dimension(500,30));
		f_op.setPreferredSize(new Dimension(500,30));
		
		//����
		setLayout(new FlowLayout()); //������ ���̾ƿ� ����
		add(la_ip);
		add(f_ip);
		add(la_op);
		add(f_op);
		add(bt);
		
		//��ư�� ������ ���� 
		bt.addActionListener(this);
		
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
	
		setVisible(true);
		setSize(750, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// �ϸ�ȵȴ�! �� ? ��Ʈ���� ���� ��ȸ�� ���⶧����!! 
		//�ذ�å) ������ â�� ������, �̺�Ʈ�� �����ؾ��Ѵ�. ��, WindowListener ����
		
	}

	public void copy() {
		//�ΰ��� Ŭ������ �޸𸮿� �ö�;��ϴ� ������?
		//�޼����� ���� ���������� �ݵ�� �����ڰ� �ʱ�ȭ�ؾ��Ѵ�. ��������� �ƴϴ� 
		FileInputStream fis=null;
		FileOutputStream fos=null;

		String ori = f_ip.getText();//�������
		String dest = f_op.getText();//���纻 ��� 
		
		try {
			fis = new FileInputStream(ori);//�Է½�Ʈ�� ����
			fos = new FileOutputStream(dest);//��½�Ʈ�� ����
			
			//�а� ������ ! 
			int data;//������ �����͸� ���� ���� 
			while(true) {
				data = fis.read();
				if(data==-1)break;
				fos.write(data);
			}
			JOptionPane.showConfirmDialog(this, "����Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fis !=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		copy();
	}
	
	public static void main(String[] args) {
		new CopyTest();
	}
}
