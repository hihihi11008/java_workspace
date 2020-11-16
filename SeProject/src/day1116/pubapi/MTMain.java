package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MTMain extends JFrame{
	JPanel p_west;
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
	Vector data = new Vector();//이차원 백터가 될 예정 
	//컬럼 제목 정보를 담는 백터
	Vector<String> columnName= new Vector<String>();
	
	JTable table;
	MountainModel model;
	JScrollPane scroll;
	
	/*JTable에서 데이터 연동시 지금까지는 이차원 배열만 써왔는데, 사실 이차원 배열은 생성시 크기를 정해야 하기 떄문에 불편한 점이 많습니다. 
	 * (불편했던 예 :  rs.last()  후 rs.getRow()로 데이터 총 수 구하고, 다시 커서를 원상복귀 시킴 ... )
	 * 
	 *따라서 컬렉션 프레임웍중 Vector를 지원하는 생성자를 이용해봅시다 
	 * */
	
	public MTMain() {
		init(); //데이터 채우기 
		
		p_west = new JPanel();
		t_name = new JTextField();
		t_op1 = new JTextField();
		t_op2 = new JTextField();
		t_op3 = new JTextField();
		bt = new JButton("검색");
		table=new JTable(data, columnName);
		scroll = new JScrollPane(table);
		
		//스타일 
		p_west.setPreferredSize(new Dimension(200, 600));
		p_west.setBackground(Color.white);
		t_name.setPreferredSize(new Dimension(190, 30));
		t_op1.setPreferredSize(new Dimension(190, 30));
		t_op2.setPreferredSize(new Dimension(190, 30));
		t_op3.setPreferredSize(new Dimension(190, 30));
		
		//부착
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west, BorderLayout.WEST);
		
		add(scroll);
		

		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo( null);
		
		
	}
	//벡터값을 초기화 하자 , 이메서들ㄹ 생성자에서 호출
	public void init() {
		//데이터 1건 넣어보기 
		//JTable에 벡터를 매개변수로 넣는 방식은 객체지향적인 요즘 개발방식에 맞지않음
		//이유) 벡터안에 백터를 넣어야하므로, 이차원배열 방식과 다를바 없음 
		//따라서 아래와 같이 백터안에 또하나의 백터를 추가해야한다
		Vector v = new Vector();
		v.add("1");
		v.add("설악산");
		v.add("강원도");
		v.add("3000");
		
		data.add(new Vector());// 백터안의 백터 결국 이차원 배열 모습을 그대로 유지함 
		
		//컬럼정보 채우고 
		columnName.add("ID");
		columnName.add("산이름");
		columnName.add("소재지");
		columnName.add("높이");
	}
	
	public static void main(String[] args) {
		new MTMain();
	}
}
