package event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Mykey1 implements KeyListener{
   //오버라이딩 하고, 키보드 누를때마다 눌렀어? 메시지 나오게 처리
   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if(key==32) {
         System.out.println("스페이스바");
      }
   }
   public void keyReleased(KeyEvent e) {
      System.out.println("키를 눌렀다 땔때");
   }
   public void keyTyped(KeyEvent arg0) {
      // TODO Auto-generated method stub
      System.out.println("키를 칠때");
   }
}