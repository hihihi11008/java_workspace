package event;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Choice;

class MyWin extends Frame{
			/*MyWin is a Frame*/
	Button bt; //1.MyWin has a bt
	TextField t;
	Choice ch; //html에서의 select 박스와 동일 

	public MyWin(){
		bt = new Button("click");//2.
		t = new TextField(15);
		ch = new Choice();

		//3.ch의 아이템 채우기 
		ch.add("Java Programming");
		ch.add("JSP Programming");
		ch.add("Android Programming");
		ch.add("Spring Programming");

		//3.레이아웃 설정 
		this.setLayout(new FlowLayout());
		
		//4.버튼을 윈도우에 부착 
		this.add(bt);//프레임은 디폴트가 BoderLayout이므로 센터영역에 크게 붙을 것임 
		this.add(t);
		this.add(ch);
		
		//5.버튼과 리스너연결! (전에 리스너클래스만들고옴)
		//bt.addActionListener(new MyListener());
		//t 넣기 ! 
		//this.addMouseListener(new MyMouse1());//프레임과 리스너 연결 
		//ch.addItemListener(new MyItem());
		this.addWindowListener(new MyWindowListener());

		this.setSize(300,400);
		this.setVisible(true);
	}

	public static void main(String[] args){
		new MyWin();
	}
}

