package gui;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.TextField;
import java.awt.GridLayout;

class LoginForm extends Frame{
	public static void main(String[] args){
		Frame frame = new Frame("연습하기");

		//frame.setLayout(new BorderLayout());
		frame.setLayout(new GridLayout(2,2));
		
		Panel p_south = new Panel();
		Panel p_center= new Panel();

		frame.add(p_south, BorderLayout.SOUTH);
		frame.add(p_center, GridLayout);
		
		//p_center 채우기 
		TextField field1= new TextField("아이디",15);
		TextField field2= new TextField("패스워드",15);

		p_center.add(field1);
		p_center.add(field2);
		frame.add(field1);
		frame.add(field2);

		//p_south 채우기 
		Button bt1 = new Button("버튼1");
		Button bt2 = new Button("버튼2");

		p_south.add(bt1);
		p_south.add(bt2);
		frame.add(p_south);

		frame.setSize(300,200);
		frame.setVisible(true);

		

	}
}

