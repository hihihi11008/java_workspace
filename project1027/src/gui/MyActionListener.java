package gui;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;

public class MyActionListener implements ActionListener{
   Button b1;
   Button b2;
   TextField t;
   
   public MyActionListener(Button b1, Button b2, TextField t) {
      this.b1=b1;
      this.b2=b2;
      this.t=t;
   }
//�������̽��� �޼��� �������̵�(overriding):�޼��� ������
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource(); //�̺�Ʈ�� ����Ų ������Ʈ ��ȯ!!!
      //��ư�̺�Ʈ��� ��ư�� �ּҰ��� obj�� �ް�,TextField��� TextField��ȯ
      if(obj==b1) {
         System.out.println("b1 click");
      }else if(obj==b2) {
         System.out.println("b2 click");
      }else if(obj==t) {
         System.out.println("t click");
      }
      System.out.println(e);
   }
}
