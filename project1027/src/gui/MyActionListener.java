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
//인터페이스의 메서드 오버라이딩(overriding):메서드 재정의
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource(); //이벤트를 일으킨 컴포넌트 반환!!!
      //버튼이벤트라면 버튼의 주소값을 obj가 받고,TextField라면 TextField반환
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
