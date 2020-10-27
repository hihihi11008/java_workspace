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
	Choice ch; //html������ select �ڽ��� ���� 

	public MyWin(){
		bt = new Button("click");//2.
		t = new TextField(15);
		ch = new Choice();

		//3.ch�� ������ ä��� 
		ch.add("Java Programming");
		ch.add("JSP Programming");
		ch.add("Android Programming");
		ch.add("Spring Programming");

		//3.���̾ƿ� ���� 
		this.setLayout(new FlowLayout());
		
		//4.��ư�� �����쿡 ���� 
		this.add(bt);//�������� ����Ʈ�� BoderLayout�̹Ƿ� ���Ϳ����� ũ�� ���� ���� 
		this.add(t);
		this.add(ch);
		
		//5.��ư�� �����ʿ���! (���� ������Ŭ����������)
		//bt.addActionListener(new MyListener());
		//t �ֱ� ! 
		//this.addMouseListener(new MyMouse1());//�����Ӱ� ������ ���� 
		//ch.addItemListener(new MyItem());
		this.addWindowListener(new MyWindowListener());

		this.setSize(300,400);
		this.setVisible(true);
	}

	public static void main(String[] args){
		new MyWin();
	}
}

