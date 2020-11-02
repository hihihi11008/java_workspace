package day1028.graphic.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame implements ActionListener{
	AlbumPanel p;//paint메서드를 재정의하려면 클래스로 정의해야한다 
	
	JPanel p_south; //버튼 2개를 얹힐 패널 
	JButton bt_prev, bt_nextButton;// 이전, 다음 버튼 

	public PhotoAlbum() {
		//생성
		p = new AlbumPanel();
		p.setBackground(Color.yellow);
		p_south = new JPanel();
		bt_prev = new JButton("이전 사진");
		bt_nextButton = new JButton("다음 사진");
		
		//조립 
		add(p);//중앙에 앨범패널 넣기 
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
		Object object = e.getSource(); //이벤트를 일으킨 이벤트소스 구하기 
		//이벤트소스란? 이벤트를 일으킨 컴포넌트를 의미 
		
		//이전버튼이면 AlbumPanel.n을 감소
		if(object==bt_prev) {
			p.n--;
		}
		//다음버튼이면 AlbumPanel.n을 증가 
		if(object==bt_nextButton) {
			p.n++;
		}
		//화면 갱신 (직접 AlbumPanel의 paint()호출 불가 )
		//갱신하도록 요청!! 
		p.repaint(); //다시그려주세요 update() -> paint()
		
	}
	
	public static void main(String[] args) {
		new PhotoAlbum();
	}
}
