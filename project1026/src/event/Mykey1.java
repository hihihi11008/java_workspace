package event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Mykey1 implements KeyListener{
   //�������̵� �ϰ�, Ű���� ���������� ������? �޽��� ������ ó��
   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if(key==32) {
         System.out.println("�����̽���");
      }
   }
   public void keyReleased(KeyEvent e) {
      System.out.println("Ű�� ������ ����");
   }
   public void keyTyped(KeyEvent arg0) {
      // TODO Auto-generated method stub
      System.out.println("Ű�� ĥ��");
   }
}