/*
awt/swing/fx -->�ȵ���̵� 

*/
package gui;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;

class GridTest{
	public static void main(String[] args){
		//1.�����ӻ���
		Frame frame = new Frame("�׸��� ���̾ƿ�");
		
		//2.���̾ƿ� �Ŵ��� ���� �� ��� 
		GridLayout layout =new GridLayout(1,3);
		//2-1.�÷ο��ġ������ ������Ʈ�� �ڽ��� ����ũ�⸦ ���� �� �ִ�.
		//FlowLayout layout =new FlowLayout();
		
		//�׸��带 �����ϸ鼭 ������Ʈ�� ������ ũ�⸦ �����ϴ� �����? 
		//�ΰ��� ������������ �����������Ѵ� 
		//�ذ�å) ������Ʈ �� ��ġ������ ������ ������ �г��� �̿��ϸ�ȴ� 
		//�� �κ������� �ٸ� ��ġ�����ڸ� �����Ҷ� ���� ���� 

		
		//3.�����ӿ� ���̾ƿ� ���� 
		frame.setLayout(layout);
		
		Panel p = new Panel(); //���������� ���� div�� ��� 
		
		Button bt1=new Button("��ư1");
		Button bt2=new Button("��ư2");
		Button bt3=new Button("��ư3");
		
		p.add(bt1);//�гο� ��ư�ֱ� 
		frame.add(p);//�����ӿ� �гγֱ�
		frame.add(bt2);
		frame.add(bt3);

		//4.�����ӿ� ��ư�Է� 
		/*for(int i=0;i<6;i++){
			frame.add(new Button("��ư"+i));
		}*/
		//5.������ ������ 
		frame.setSize(300,200);
		//6.�������� ȭ�鿡 �������ϴ� �޼���
		frame.setVisible(true); 
	}
}

