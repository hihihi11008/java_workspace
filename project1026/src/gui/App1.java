/*�����쿡 �� �� �ִ� ���� ������Ʈ �˾ƺ��� 
ex) ��ư, �ؽ�Ʈ�ʵ�, �����ڽ�, üũ�ڽ�, ���̽�, �̹���, textarea.. */
package gui;
import java.awt.Frame;//����Ϸ��� Ŭ������ ��ġ��� // ��򰡿� .class�� �����ϱ� ������ ��밡���� ���̴�.
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;
class App1{
	public static void main(String[] args){
		/*������ ����*/

		/*����ó�� ���� Ŭ������ �������� ��ó��
		  ����,��ó�ڼ�0) "����Ϸ��� Ŭ������ ���� � �������� �����Ǵ°����� �� �뵵�ľ�"
		  ����,��ó�ڼ�1) "�ڹ��� ��� ��ü�� �ᱹ 3���� �����ۿ� ����" ���� �̿��ϸ�ȴ�
		  ����,��ó�ڼ�2) "Ŭ������ ����� ���� ���̴�, ���� �޸𸮿� �ø��� ���� �˸�ȴ�"

		  1) �Ϲ�Ŭ���� : new �ϸ�ȴ�! new ���� ����������(api������ ����)
		  2) �߻�Ŭ���� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ� new�ϰų� �̹� ������ �ν��Ͻ��� �̿��ϸ� �ȴ�(api������ ����)
		  3) �������̽� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ� new�ϰų� �̹� ������ �ν��Ͻ��� �̿��ϸ� �ȴ�(api������ ����) 
		*/

		//ó��������, �Ϲ��̱� ������ new ������ ���� �����ڸ� �����ؼ� ����ϸ��! 
		Frame frame=new Frame(); //�ڹ� ���������α׷��ֿ����� ������ 
		//�������� ����Ʈ�� ���� ������ �ʴ� ������, ���� ���̵��� �޼��� ȣ��! 
		frame.setVisible(true);//Window ��ü�κ��� ��ӹ��� �޼��� 
		//�Ű������δ� ������ ����� �� �ִ�.
		//�������� �ʺ�, ���̸� ������ �� �ִ� �޼��� ã�� 
		frame.setSize(400,400); 

		//�����찡 �����Ǿ����Ƿ�, ������ �ȿ� ��ġ�� ���� ������Ʈ �÷����ƺ��� ! 
		Button bt = new Button("����ư");
		//��ư�� �����ϱ�����, ���̾ƿ� ��Ÿ���� �����ؾ� �ϴµ�, ���̾ƿ��� ���� ���Ŵ� 
		//�ϴ� FlowLayout�� ����غ��� 
		FlowLayout flow = new FlowLayout();
		frame.setLayout(flow);//�����쿡 �÷ο� ����� ��ġ���� 
		//��ư�� ������ �����̳ʿ� �������� 
		frame.add(bt); //add�޼����� �Ű������� Component ���̹Ƿ� 
		//Button�� Component�� �ڽ��̱� ������ ���� �ڷ����� �ش��Ͽ�, add()�� �μ��� �� �� �ִ� .

		//html ������ input type="text"�� �ڹٿ����� TextField �� �Ѵ� 
		TextField tf = new TextField("ȸ������", 10);
		frame.add(tf);
		//Checkbox
		Checkbox cb1 = new Checkbox("����");
		Checkbox cb2 = new Checkbox("���");
		Checkbox cb3 = new Checkbox("ȣ��");
		frame.add(cb1);
		frame.add(cb2);
		frame.add(cb3);

		//TextArea
		TextArea ta = new TextArea(5,20); //5�� 20�� 
		frame.add(ta);
		
		//�׳��ؽ�Ʈ 
		Label la = new Label("ȸ������ ����Դϴ�.��");
		frame.add(la);
		
		//�̹��� �ֱ� 
		//Image�� �߻�Ŭ�����̸�, �÷���(window,mac,linux...)�� ������ ������� ���� �� �ִ�.
		//�÷����� �°� ����������, Toolkit Ŭ�����κ��� �ڿ��� ���� �Ѵ� 
		Toolkit kit=Toolkit.getDefaultToolkit(); //static �޼���! ���� Ŭ���������� ������ �� �ִ�.
		//��Ŷ�� �̹����� ���û��� ��ηκ��� ���� �� �ִ�
		//��λ��� �������� : �������ô� ������OS������ ����ϴ� ǥ���̹Ƿ�, 
		//���� �� �ڹ��ڵ尡 ��� OS����Ƿ���, ��� �߸����� ��η� �����Ѵ� 
		Image img =kit.getImage("C:/workspace/java_workspace/project1026/res/9.jpg");
		System.out.println("�̹��� �ּҰ��� " +img); //null ������ �������°���

		//ȭ�鿡 ����ϴ� ������ ���� �Ұ� .. ���ݱ��� html������ �̹����� html������ ���ٿ��� ����������, 
		//�ڹٿ� ���� �Ϲ����� ������ ����� ���α׷��־����� ������(�����׸��� �۾�)�� �ؾ� �ϱ� �����̴�. 



	}
}

