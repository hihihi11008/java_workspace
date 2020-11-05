package day1027.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*Action은 범위가 넓다 (버튼에는 클릭, 텍스트박스-엔터 등) 
 * 버튼에 클릭이벤트를 감지해보자!! */
public class MyActionListener implements ActionListener{
	JTextField t_input;
	JTextArea area;//null 주소값이 없는 상태
	JButton bt;
	
	public MyActionListener(JTextField t_input,JTextArea area, JButton bt) {
		this.t_input=t_input;
		this.area=area;	
		this.bt=bt;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object obj = e.getSource(); //이벤트를 일으킨 컴포넌트 반환!!!
	      //버튼이벤트라면 버튼의 주소값을 obj가 받고,TextField라면 TextField반환
		 if(obj==bt) {
				String msg = t_input.getText();//텍스트필드값을 구하자 
				area.append(msg+"\n");
				t_input.setText("");//빈텍스트로 초기화 
			}
	      System.out.println(e);
		//System.out.println("나 눌렀어?");
		
	}

}
