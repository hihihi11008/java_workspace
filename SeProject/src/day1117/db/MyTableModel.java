package day1117.db;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
   //�Ʒ� �� ���ʹ� ���� 0, ������ ���ϴ� ����Ŭ ���̺� ���ý� ���� �� ���� �Ҵ�
   Vector<Vector> record = new Vector<Vector>(); //���̺� ������ ���ڵ带 ó���ϴ� ���� ����
   Vector<String> column = new Vector<String>();//���̺� ������ �÷� ���� ���� ���� ����
   
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
