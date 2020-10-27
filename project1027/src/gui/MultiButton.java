package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiButton extends Frame{
   Button b1,b2;
   TextField t;
   
   public MultiButton() {      
      b1= new Button("Button");
      b2= new Button("Button");
      t= new TextField(20);
      this.setLayout(new FlowLayout());
      
      this.add(b1);
      this.add(b2);
      this.add(t);
      
      MyActionListener listener = new MyActionListener(b1,b2,t);
      b1.addActionListener(listener);//버튼과 리스너 연결
      b2.addActionListener(listener);//버튼과 리스너 연결
      t.addActionListener(listener);//텍스트박스에도 클릭이벤트 가능
      
      this.setSize(400,300);
      this.setVisible(true);
      
   }
   public static void main(String[] args) {
      new MultiButton();
   }
}