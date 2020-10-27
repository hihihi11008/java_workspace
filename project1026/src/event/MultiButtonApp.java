/*
동일한 종류의 컴포넌트가 2개이상일때, 리스너 연결방법 
*/
package event;
import java.awt.*;
import java.awt.event.*;

class MultiButtonApp extends Frame{
	Button bt1, bt2;

	public MultiButtonApp(){
		bt1 = new Button("버튼1");
		bt2 = new Button("버튼2");
		this.setLayout(new FlowLayout());//버튼의 크기 제것으로 제대로 나오게하기위해 
		
		this.add(bt1);
		this.add(bt2);

		//버튼마다 리스너 연결 
		bt1.addActionListener(new MultiActionListener());
		bt2.addActionListener(new MultiActionListener());

		this.setSize(300,400);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new MultiButtonApp();
	}
}

