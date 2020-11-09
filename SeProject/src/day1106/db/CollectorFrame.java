/*
 * 인터넷으로 제품 이미지 가져오기
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
   
   BufferedImage buffr; //url로 가져온 이미지 정보를 담을 객체
   ShoppingApp shoppingApp; // null;
   File file;
   
   public CollectorFrame(ShoppingApp shoppingApp) {
      this.shoppingApp = shoppingApp;
      setLayout(new FlowLayout());
      
      t_url = new JTextField();
      bt = new JButton("수집실행");
      bt_apply = new JButton("반영하기");
      
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
            //ShoppingApp 클래스의 img 변수의 값을 인터넷상 이미지로 교체 후,            //
            shoppingApp.getTargetImage(file.getAbsolutePath());//디렉토리포함한 파일의 풀경로
            shoppingApp.preview();
         }
      });
      
      setLocationRelativeTo(null);
      setVisible(true);
      setSize(600,250);
      
   }
   
   public void collect() {
      //가져올 데이터가 이미지인 경우엔 아래의 방법이 유용
      try {
         URL url = new URL(t_url.getText());
         buffr = ImageIO.read(url);                  
         
         //현재까진 메모리에 존재, 실제 파일로 저장하기         
         //저장할 파일명은 개발자가 지정 > 규칙 : (시 분 초 밀리초)설정
         long time = System.currentTimeMillis(); //현재 시간을 반환해주는 메서드
         String filename = FileManager.getFilename(t_url.getText());
         String extend = FileManager.getExtend(filename);
         
         //빈파일 생성
         file = new File("C:/workspace/java_workspace/SeProject/src/res/gabi/"+time+"."+extend);
         //빈 파일에 이미지 데이터를 쓰기(출력)
         ImageIO.write(buffr, extend , file);
         JOptionPane.showMessageDialog(this, "가져오기 완료");
      } catch (IOException e) {         
         e.printStackTrace();
      }
   }
}
