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
	JLabel la_name; //제목나올곳 
	XCanvas can;//센터에 크게 나올 이미지를 그릴 캔버스 
	JPanel p_south;
	JButton bt_prev, bt_next;
	
	
	
	
	//8.썸네일배열선언 
	//Thumb[] list = new Thumb[10];//[][][][]..공간만 생성
	ArrayList<Thumb> list = new ArrayList<Thumb>(); //사이즈는 0 
	//12 
	String dir="C:/workspace/java_workspace/SeProject/res/travel2/";
	String[] src= {
			"aa.jpg","ab.jpg","ax.jpg","bm.jpg","et.jpg","kg.jpg","mx.jpg","pk.jpg","ub.jpg","ya.jpg"};
	int n =0;//23. 배열으 index
	
	
	public GalleryApp() {
		//초기화
		super("자바갤러리");
		//2.생성
		p_west = new JPanel();
		p_center = new JPanel();//2.
		scroll = new JScrollPane(p_west);//11.
		//17-2.
		la_name = new JLabel(src[n], SwingConstants.CENTER);//경로까지올리려면 dir 도 넣기 
		can = new XCanvas(dir+src[n]);
		p_south=new JPanel();
		bt_prev=new JButton("이전 사진");
		bt_next=new JButton("다음 사진");
		
		//9.썸네일 생성 .
		for(int i=0; i<src.length;i++) {
			Thumb thumb=null; //15 .
			list.add(thumb=new Thumb(dir+src[i], this));
			p_west.add(thumb);
		}
		
		
		//3.스타일
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
		
		//4.조립 //12 스크롤이 더 크기때문에 스크롤을 넣는다
		add(scroll, BorderLayout.WEST);
		add(p_center);
		
		//25 
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		//1-1.
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);//윈도우를 화면 중앙에 띄우는 법 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		updateDate();//첫이미지에도 제목표시되게
	}
	
	public static void main(String[] args) {
		new GalleryApp();
	}

	@Override//22 
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); //이벤트 일으킨 컴포넌트
		
		if(obj==bt_prev) {
			prev();
		}else if(obj==bt_next) {
			next();
		}
		updateDate();// 28 어떠한 버튼을 눌러도 업데이트가 일어나기때문에 if문밖으로 낸당
	}
	public void updateDate() {
		//제목변경 
		la_name.setText(src[n]+"("+(n+1)+"/"+src.length+")");
		//27 공통되는 데이터를 메서드로
		can.setSrc(dir+src[n]);//멤버변수로 뺴기
		can.repaint();//update() --> paint()
		
	}
	public void prev() {
		//next에서 복붗해서 n--; 으로 변경
		if(n>0) {
			n--;			
		}else {
			JOptionPane.showMessageDialog(this, "첫 사진이에여! ");			
		}
	}
	public void next() {
		//22그림은 XCanvas가 담당하므로, 그려질 img를 변경시켜주고 다시그리고하면된 (updateDate()메서드로 뻈움)
		//29 배열을 넘어서지 않는 범위내에서 ++허용
		if(n<src.length-1) {
			n++;				
		}else {
			JOptionPane.showMessageDialog(this, "마지막 사진이에여ㅠ_ㅠ");
			//showMessageDialog(parentComponent, message) - parentComponent 부모컴포넌트가 아니라 바깥쪽컴포넌트를 말함
		}
	}
}
