/*
 	MVC패턴이 적용된 JTable에서 사용되는 TableModel은 명칭으로는 마치 모델인 것처럼 보이지만 
 	그 역할로 본다면 컨트롤러이다 ! 
 	
 	JTable(View) ----------컨트롤러(JTableModel)--------- 보여질데이터(Model)
 	
 	MyModel이 보유한 모든 메서드의 호출자는? JTable 이다! 
 */
package day1106.db;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	//데이터 준비 
	String [][] flower= {
			{"장미","50000","RED","Korea"},
			{"튤립","70000","PURPLE","France"},
			{"안개꽃","80000","White","Korea"},
	};
	
	String [][] car= {
			{"BMW","5000","Black"},
			{"Benz","9500","Navy"},
			{"Audi","8000","White"},
	};
	//행갯수 반환하는 메서드
	public int getRowCount() {
		return car.length;
	}
	//열의 갯수 반환하는 메서드
	public int getColumnCount() {
		return car[0].length; //1번째든 2번째든 상관없 
	}
	//지정한 좌표의 값을 반환
	public Object getValueAt(int row, int col) {
		System.out.println("row : "+row+", col : "+col);
		return car[row][col];
	}

}
