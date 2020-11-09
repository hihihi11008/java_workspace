/*
 * ���ͳ����� ��ǰ �̹��� ��������
 * */
package day1106.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JTextField;




public class CollectorFrame extends JFrame{
   JTextField t_url;
   JButton bt;
   JButton bt_apply;
   
   BufferedImage buffr; //url�� ������ �̹��� ������ ���� ��ü
   ShoppingApp shoppingApp; // null;
   File file;
   
   public CollectorFrame(ShoppingApp shoppingApp) {
      this.shoppingApp = shoppingApp;
      setLayout(new FlowLayout());
      
      t_url = new JTextField();
      bt = new JButton("��������");
      bt_apply = new JButton("�ݿ��ϱ�");
      
      t_url.setPreferredSize(new Dimension(580,40));
      
      add(t_url);
      add(bt);
      add(bt_apply);
      
      bt.addActionListener(new ActionListener() {               
         public void actionPerformed(ActionEvent e) {
            collect();            
         }
      });
      
      bt_apply.addActionListener(new ActionListener() {               
         public void actionPerformed(ActionEvent e) {
            //ShoppingApp Ŭ������ img ������ ���� ���ͳݻ� �̹����� ��ü ��,            //
            shoppingApp.getTargetImage(file.getAbsolutePath());//���丮������ ������ Ǯ���
            shoppingApp.preview();
         }
      });
      
      setLocationRelativeTo(null);
      setVisible(true);
      setSize(600,250);
      
   }
   
   public void collect() {
      //������ �����Ͱ� �̹����� ��쿣 �Ʒ��� ����� ����
      try {
         URL url = new URL(t_url.getText());
         buffr = ImageIO.read(url);                  
         
         //������� �޸𸮿� ����, ���� ���Ϸ� �����ϱ�         
         //������ ���ϸ��� �����ڰ� ���� > ��Ģ : (�� �� �� �и���)����
         long time = System.currentTimeMillis(); //���� �ð��� ��ȯ���ִ� �޼���
         String filename = FileManager.getFilename(t_url.getText());
         String extend = FileManager.getExtend(filename);
         
         //������ ����
         file = new File("C:/workspace/java_workspace/SeProject/src/res/gabi/"+time+"."+extend);
         //�� ���Ͽ� �̹��� �����͸� ����(���)
         ImageIO.write(buffr, extend , file);
         JOptionPane.showMessageDialog(this, "�������� �Ϸ�");
      } catch (IOException e) {         
         e.printStackTrace();
      }
   }
}
