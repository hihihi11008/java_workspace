/*
 ���� ������Ʈ ��, ������ ������ ������(ǥ)�� ǥ���ϱ⿡ ����ȭ�� JTable�� ����غ��� 
 */
package day1105.db;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableApp extends JFrame{
	JTable table;
	String[] column= {"��ȣ","�̸�","����ó","�ּ�","����"};
	String[][] data= {
			{"1","Batman","011","����","��"},
			{"2","superman","017","ũ����","��"},
			{"3","wonder","019","�Ƹ���","��"}
	};
	JScrollPane scroll;

	public TableApp() {
		table = new JTable(data,column);// row 3, col 5
		scroll=new JScrollPane(table);
		
		setLayout(new FlowLayout());
		add(scroll);
		
		//���콺�̺�Ʈ ���� 
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				//System.out.println("���ռ�?");
				int col=table.getSelectedColumn();//������ ������ �÷� index(ȣ��)
				int row=table.getSelectedRow();
				//System.out.println("��ǥ("+row+","+col+")");
				
				String value=(String)table.getValueAt(row, col);
				System.out.println(value);
			}
		});
		
		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TableApp();
	}
}
