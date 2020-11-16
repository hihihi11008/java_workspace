package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MTMain extends JFrame{
	JPanel p_west;
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
	Vector data = new Vector();//������ ���Ͱ� �� ���� 
	//�÷� ���� ������ ��� ����
	Vector<String> columnName= new Vector<String>();
	
	JTable table;
	MountainModel model;
	JScrollPane scroll;
	
	/*JTable���� ������ ������ ���ݱ����� ������ �迭�� ��Դµ�, ��� ������ �迭�� ������ ũ�⸦ ���ؾ� �ϱ� ������ ������ ���� �����ϴ�. 
	 * (�����ߴ� �� :  rs.last()  �� rs.getRow()�� ������ �� �� ���ϰ�, �ٽ� Ŀ���� ���󺹱� ��Ŵ ... )
	 * 
	 *���� �÷��� �����ӿ��� Vector�� �����ϴ� �����ڸ� �̿��غ��ô� 
	 * */
	
	public MTMain() {
		init(); //������ ä��� 
		
		p_west = new JPanel();
		t_name = new JTextField();
		t_op1 = new JTextField();
		t_op2 = new JTextField();
		t_op3 = new JTextField();
		bt = new JButton("�˻�");
		table=new JTable(data, columnName);
		scroll = new JScrollPane(table);
		
		//��Ÿ�� 
		p_west.setPreferredSize(new Dimension(200, 600));
		p_west.setBackground(Color.white);
		t_name.setPreferredSize(new Dimension(190, 30));
		t_op1.setPreferredSize(new Dimension(190, 30));
		t_op2.setPreferredSize(new Dimension(190, 30));
		t_op3.setPreferredSize(new Dimension(190, 30));
		
		//����
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west, BorderLayout.WEST);
		
		add(scroll);
		

		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo( null);
		
		
	}
	//���Ͱ��� �ʱ�ȭ ���� , �̸޼��餩 �����ڿ��� ȣ��
	public void init() {
		//������ 1�� �־�� 
		//JTable�� ���͸� �Ű������� �ִ� ����� ��ü�������� ���� ���߹�Ŀ� ��������
		//����) ���;ȿ� ���͸� �־���ϹǷ�, �������迭 ��İ� �ٸ��� ���� 
		//���� �Ʒ��� ���� ���;ȿ� ���ϳ��� ���͸� �߰��ؾ��Ѵ�
		Vector v = new Vector();
		v.add("1");
		v.add("���ǻ�");
		v.add("������");
		v.add("3000");
		
		data.add(new Vector());// ���;��� ���� �ᱹ ������ �迭 ����� �״�� ������ 
		
		//�÷����� ä��� 
		columnName.add("ID");
		columnName.add("���̸�");
		columnName.add("������");
		columnName.add("����");
	}
	
	public static void main(String[] args) {
		new MTMain();
	}
}
