package day1116.pubapi;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MountainModel extends AbstractTableModel{
	/*
	 * ���� �������迭�� �ƴ϶�, Vector�� �����ؼ� , �����Ϳ� �÷����� ó���غ��ڽ��ϴ�.
	 * ���ʹ� �÷��� �����ӿ��̴� �迭ó�� ������ ũ�⸦ ������� �ʾƵ� �˴ϴ�..�� ��ŭ �����մϴ�..
	 * */
	//�����ϼ���
	Vector<Mountain> data=new Vector<Mountain>();//�ٵ� ���ʸ�Ÿ���� �ƴ϶� ���� �����մϴ�..
											//���ʸ�Ÿ������ �˸´� �ڷ����� �����? �츮�� ���� ���� �����ͼ� 
											//���̺� ����� ��������!!!!! �׷� ���� ���;� �մϴ�
	//�÷� ���� ������ ��� ���� 
	Vector<String> columnName = new Vector<String>(); //n�� �����׿�
	
	//�÷������� ������ ���� ��Ҵ� �����ڿ��� ä��ô�!!!
	//�÷����� �ѱ����� ä��ô�!!
	public MountainModel() {
		//�÷� ���� 
		columnName.add("ID");//�� ���̵� 
		columnName.add("���̸�");//�� �̸� 
		columnName.add("������");//�� ������ 
		columnName.add("����");//�� ����
		
		//������ �������� �����غ���!!(�׽�Ʈ�� ���� )
		Mountain mt = new Mountain();
		mt.setMntnid(1);
		mt.setMntnnm("�Ӹ���");
		mt.setMntninfopoflc("������");
		mt.setMntninfohght(1000);
		data.add(mt); //�� 1���� ���Ϳ� �ֱ�!! , �����غ�����
	}
	
	//���� ���ڵ��� ��(���� ��)�� ������ ���̿��� �������� ��
	public int getRowCount() {
		return data.size();
	}
	
	//���� �÷��� ���� ������ ���̿��� �������� �� 
	public int getColumnCount() {
		return columnName.size();
	}
	//�÷� ������ ����ϱ� ����, �޼��� �������̵� 
	public String getColumnName(int col) { //col�� �ٿ��ּ���
		return columnName.get(col);//�迭�� �ƴϹǷ� get(�ε���) �� �����;� �մϴ�
	}
	
	//2�����迭�̳� ���ʹ� ��� �迭�����̹Ƿ� ���ݱ����� [row][col] ���·� �����͸� �����Ͽ���!!
	//������, ���� ���Ϳ� ����ִ� �����ʹ� VO�̹Ƿ� [row]�� ���� ������ ����������  [col]�� ����
	//������ �Ұ��ϴ�!! �̸� ���� �Ǽ���?? �ȵǽø� �׸� �׸����� , �ȵǴ� �� ��!!
	public Object getValueAt(int row, int col) {
		//�ذ�å!!!! ���ǹ��� ����մϴ�!!
		//��  col�� 0�϶��� ���� ���̵�, 1 �϶� �̸�, 2�϶� ��..������� �츮�� ������ �޾ƾ� �ؿ�!!
		System.out.println("row="+row+"col �� = "+col);// ȣ��� �÷��� Ȯ���ϱ�!! �����غ����� 
		
		//����� data�� ����� 0�̴ϱ� �� �޼��带 ȣ������ �ʰ� ������, 
		//�������� �����͸� �־����
		Mountain mt = data.get(row);//row��°���� ���� �ϳ� ������ ����!!
		
		String obj=null; //�� ���ǿ� ���� ��ȯ�� ������
		
		if(col==0) { //�̶��� �츮�� ���� ���̵� ��ȯ�Ҳ�����!!
			obj=Integer.toString(mt.getMntnid());//int
		}else if(col==1) {//�̶��� ���� �̸�
			obj = mt.getMntnnm();
		}else if(col==2) {//���� ��ġ
			obj = mt.getMntninfopoflc();
		}else if(col==3) {//���� ����
			obj = Integer.toString(mt.getMntninfohght());
		}
		//�� �޼����� ��ȯ���� ������Ʈ ���̹Ƿ�, �츮�� ��ü��(String, Integer��)���� ��ȯ�ؾ� �ǿ�
		//�ٵ�  JTable�� ���� ��� �����ʹ� String ����Ҽ� �����Ƿ�  String���� ��ȯ�Ҳ���
		return obj;
	}
	
	
}
