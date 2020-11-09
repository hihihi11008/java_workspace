/*
 	MVC������ ����� JTable���� ���Ǵ� TableModel�� ��Ī���δ� ��ġ ���� ��ó�� �������� 
 	�� ���ҷ� ���ٸ� ��Ʈ�ѷ��̴� ! 
 	
 	JTable(View) ----------��Ʈ�ѷ�(JTableModel)--------- ������������(Model)
 	
 	MyModel�� ������ ��� �޼����� ȣ���ڴ�? JTable �̴�! 
 */
package day1106.db;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	//������ �غ� 
	String [][] flower= {
			{"���","50000","RED","Korea"},
			{"ƫ��","70000","PURPLE","France"},
			{"�Ȱ���","80000","White","Korea"},
	};
	
	String [][] car= {
			{"BMW","5000","Black"},
			{"Benz","9500","Navy"},
			{"Audi","8000","White"},
	};
	//�హ�� ��ȯ�ϴ� �޼���
	public int getRowCount() {
		return car.length;
	}
	//���� ���� ��ȯ�ϴ� �޼���
	public int getColumnCount() {
		return car[0].length; //1��°�� 2��°�� ����� 
	}
	//������ ��ǥ�� ���� ��ȯ
	public Object getValueAt(int row, int col) {
		System.out.println("row : "+row+", col : "+col);
		return car[row][col];
	}

}
