package gui;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.TextField;
import java.awt.GridLayout;

class LoginForm extends Frame{
	public static void main(String[] args){
		Frame frame = new Frame("�����ϱ�");

		//frame.setLayout(new BorderLayout());
		frame.setLayout(new GridLayout(2,2));
		
		Panel p_south = new Panel();
		Panel p_center= new Panel();

		frame.add(p_south, BorderLayout.SOUTH);
		frame.add(p_center, GridLayout);
		
		//p_center ä��� 
		TextField field1= new TextField("���̵�",15);
		TextField field2= new TextField("�н�����",15);

		p_center.add(field1);
		p_center.add(field2);
		frame.add(field1);
		frame.add(field2);

		//p_south ä��� 
		Button bt1 = new Button("��ư1");
		Button bt2 = new Button("��ư2");

		p_south.add(bt1);
		p_south.add(bt2);
		frame.add(p_south);

		frame.setSize(300,200);
		frame.setVisible(true);

		

	}
}

