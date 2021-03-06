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

	//배열은 크기를 정해야하기 떄문에 크기를 알 수 없는 프로그램에선 사용에 제한이 있다. 
	//JButton[] btn= new JButton[]; //배열의 가장 큰 특징, 배열은 생성시 반드시 크기를 명시해야한다.
	ArrayList<JButton> btn= new ArrayList<JButton>(); //크기가 0이다
	
	public ButtonCollection() {
		bt_s = new JButton("생성");
		bt_bg = new JButton("배경색");
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
		Object obj = e.getSource();//이벤트를 일으킨 컴포넌트를 반환 
		
		if(obj==bt_s) {
			create();
		}else if(obj==bt_bg) {
			setBG();
		}
	}
	public void create() {
		
		//버튼 생성하여, p_center에 부착 
		JButton bt = new CustomButton();
		p_center.add(bt);

		btn.add(bt);//리스트에 추가하기!! js의 push() 메서드와 같다
		System.out.println("현재까지 누적된 리스트의 수는 "+btn.size());
		bt.setText("버튼"+Integer.toString(btn.size()));
		
		
		//p_center에 버튼을 그린게 아니라, 버튼을 추가한 것이다 
		//따라서 이때는 p_center를 갱신하면 된다 update(UI)이다 ! 
		p_center.updateUI();
	}
	public void setBG() {
		//btn 리스트에 들어있는 모든 요소를 대상으로 배경색바꾸기! 
		//ArrayList는 순서있는 집합이므로 for문 사용이 가능하다 
		for(int i =0; i<btn.size();i++) {
			JButton bt = btn.get(i);// 리스트에서 끄집어내기 
			bt.setBackground(Color.yellow);
			
		}
	}
	
}
