package day1027.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*Action�� ������ �д� (��ư���� Ŭ��, �ؽ�Ʈ�ڽ�-���� ��) 
 * ��ư�� Ŭ���̺�Ʈ�� �����غ���!! */
public class MyActionListener implements ActionListener{
	JTextField t_input;
	JTextArea area;//null �ּҰ��� ���� ����
	JButton bt;
	
	public MyActionListener(JTextField t_input,JTextArea area, JButton bt) {
		this.t_input=t_input;
		this.area=area;	
		this.bt=bt;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object obj = e.getSource(); //�̺�Ʈ�� ����Ų ������Ʈ ��ȯ!!!
	      //��ư�̺�Ʈ��� ��ư�� �ּҰ��� obj�� �ް�,TextField��� TextField��ȯ
		 if(obj==bt) {
				String msg = t_input.getText();//�ؽ�Ʈ�ʵ尪�� ������ 
				area.append(msg+"\n");
				t_input.setText("");//���ؽ�Ʈ�� �ʱ�ȭ 
			}
	      System.out.println(e);
		//System.out.println("�� ������?");
		
	}

}
