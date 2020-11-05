/*
���� ������Ʈ�� �÷����� ����, � ������� �÷��������� �����ϴ� ���� ��ġ�� �ϸ� 
AWT���� �����ϴ� ��ġ�� ������ ���� 5���� ������ �ִ�
1)FlowLayout: ��������� �þ�� ��ġ���, ���� ������ �����ϸ� ���������� ��������
			  �����̳��� ũ�⿡ ���� �帣�� ��ġ�� �ǹǷ� flow ��� ���� �ο��Ǿ���.
2)BorderLayout: ��,��,��,��,�߾� �̶�� ������ ���� ��ġ���
3)GridLayout: ���� �� �ٵ��� ����� ��ġ���
4)CardLayout: ī��ó�� �ϳ��� ī�尡 ���϶��� �ٸ�ī�尡 �Ⱥ��̴� ����� ��ġ
5)GridBagLayout: GridLayout�� �ȼ������� ���ϰ� ������ �� �ִ� ��ġ���
��ǻ� 1,2,3�������ε� ����� ���߰����� 
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.BorderLayout;

class BorderTest{ 
	public static void main(String[] args){
		//Frame����
		Frame frame = new Frame();
		//BorderLayout �н�
		Button bt_north=new Button("North");
		Button bt_south=new Button("South");
		Button bt_west=new Button("West");
		Button bt_east=new Button("East");
		Button bt_center=new Button("Center");

		//��ġ����� �������� 

		//1.BorderLayout ���� 
		frame.setLayout(new BorderLayout());
		
		//2.��ư�� �����ӿ� ���̱� 
		//frame.add(bt_north, BorderLayout.NORTH); //���ʿ� ��ư ���� (����� �빮�ڷ� ǥ��)
		frame.add(bt_south, BorderLayout.SOUTH); //���ʿ� ��ư ���� (����� �빮�ڷ� ǥ��)
		//frame.add(bt_west, BorderLayout.WEST); //���ʿ� ��ư ���� (����� �빮�ڷ� ǥ��)
		frame.add(bt_east, BorderLayout.EAST); //���ʿ� ��ư ���� (����� �빮�ڷ� ǥ��)
		//���ʹ� ��������ʾƵ� ����Ʈ�̱� ������ �����ص� ����ȴ�. 
		frame.add(bt_center); //��� ��ư ���� (����� �빮�ڷ� ǥ��)

		//3.�����Ӽ���
		frame.setSize(250,200);
		frame.setVisible(true);


	}
}

