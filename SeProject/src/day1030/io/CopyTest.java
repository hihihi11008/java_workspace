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
		//생성
		la_ip = new JLabel("원본");
		la_op = new JLabel("복사본");
		f_ip = new JTextField(50);
		f_op = new JTextField(50);
		bt = new JButton("COPY");
		
		
		//스타일 
		la_ip.setPreferredSize(new Dimension(150,30));
		la_op.setPreferredSize(new Dimension(150,30));
		f_ip.setPreferredSize(new Dimension(500,30));
		f_op.setPreferredSize(new Dimension(500,30));
		
		//조립
		setLayout(new FlowLayout()); //프레임 레이아웃 변경
		add(la_ip);
		add(f_ip);
		add(la_op);
		add(f_op);
		add(bt);
		
		//버튼과 리스너 연결 
		bt.addActionListener(this);
		
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
	
		setVisible(true);
		setSize(750, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 하면안된다! 왜 ? 스트림을 닫을 기회가 없기때문에!! 
		//해결책) 윈도우 창을 닫을때, 이벤트를 구현해야한다. 즉, WindowListener 구현
		
	}

	public void copy() {
		//두개의 클래스가 메모리에 올라와야하는 시점은?
		//메서드의 내의 지역변수는 반드시 개발자가 초기화해야한다. 멤버변수가 아니다 
		FileInputStream fis=null;
		FileOutputStream fos=null;

		String ori = f_ip.getText();//원본경로
		String dest = f_op.getText();//복사본 경로 
		
		try {
			fis = new FileInputStream(ori);//입력스트림 생성
			fos = new FileOutputStream(dest);//출력스트림 생성
			
			//읽고 내뱉자 ! 
			int data;//읽혀진 데이터를 받을 변수 
			while(true) {
				data = fis.read();
				if(data==-1)break;
				fos.write(data);
			}
			JOptionPane.showConfirmDialog(this, "복사완료");
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
