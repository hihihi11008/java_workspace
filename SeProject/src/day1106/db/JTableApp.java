/*
 * JTable 더 자세히 알아보기 
 * */
package day1106.db;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
public class JTableApp extends JFrame{
   JTable table; //MVC에서 '뷰'
   JScrollPane scroll;
   MyModel model;
   
   public JTableApp() {
      //JTable과 컨트롤러인 MyModel 연결
      table = new JTable(model = new MyModel());
      scroll = new JScrollPane(table);
      add(scroll);
      
      setSize(400,200);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }
   
   public static void main(String[] args) {
      new JTableApp();
   }
}