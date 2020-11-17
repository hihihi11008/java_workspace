package day1117.db;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
   //아래 두 백터는 현재 0, 유저가 원하는 오라클 테이블 선택시 조사 후 동적 할당
   Vector<Vector> record = new Vector<Vector>(); //테이블에 보여질 레코드를 처리하는 벡터 선언
   Vector<String> column = new Vector<String>();//테이블에 보여질 컬럼 정보 갖는 벡터 선언
   
   public MyTableModel(Vector record, Vector column) {
	   this.record = record;
	   this.column=column;
   }

   public int getRowCount() {
      return record.size();
   }

   public int getColumnCount() {
      return column.size();
   }
   public String getColumnName(int col) {
	   return null;
   }

   public Object getValueAt(int row, int col) {
      return record.get(row).get(col);      
   }
}
