package gui;
import java.awt.*;
class LoginForm extends Frame{
	/*3.has ����� ��������� ��ü���϶��� �ǹ��Ѵ� */
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center;//���Ϳ� �׸��带 ������ �г� 
	Panel p_south;//���ʿ� ���� �г� (���⿡ ��ư2������ ����)

	public LoginForm(){
		//3-1��ǰ����� ������ �������� ��� �ʱ�ȭ��Ű�� 
		//Ư�� ��ǰ�� �̰�ü�� �¾�� ���� �Բ� �¾���ϹǷ�, �������� Ÿ�̹��� ��ġ������ 
		la_id = new Label("ID");
		la_pass = new Label("Password");
		t_id = new TextField(15);
		t_pass = new TextField(15);
		bt_login = new Button("Login");
		bt_regist= new Button("Join");
		p_center = new Panel();
		p_south = new Panel();
		//3-2. �������Ͽ���, ��Ÿ�Ϻο��� ������ ���� �ʾ���

		//4.Frame�� �����ڰ� ���̾ƿ��� �������� ������ ����Ʈ�� BorderLayout�̴�. 
		//this.setLayout(new BorderLayou()); �ʿ����! ����Ʈ�� �̹� �������̾ƿ��̹Ƿ�...
		//ó������ ��ü�� ���� ������ 1.���ϴ� ��ü���� �ľ� 2.�޸𸮿� �ø��¹�(�Ϲ�,�߻�,�������̽�)
		p_center.setBackground(new Color (102,153,102));

		//5.�����г��� �������� BorderLayout ���Ϳ� �ִ� 
		this.add(p_center, BorderLayout.CENTER); //BorderLayout.CENTER ����Ʈ���̶� ��������

		//6.south�� �ֱ� 
		p_south.setBackground(Color.MAGENTA);//Color�� �ΰ��� ����ϱ� ������ͷ� ����غ���
		//����� �������� �ο��� �������̴�. final�� ���̻� ���� ������ �� ������ static���� �ν��Ͻ��� ������ �����ϸ�
		//public���� �����Ͽ� ��簴ü�� ������ �� �ֵ��� ���������� Ǯ����� ������ 
		this.add(p_south, BorderLayout.SOUTH); //BorderLayout.CENTER ����Ʈ���̶� ��������

		//8.p_center�� �׸��� ���� 
		p_center.setLayout(new GridLayout(2,2));//2�� 2��¥�� �׸��� ����
		p_center.add(la_id);//id �󺧺��� 1�� 1�� 
		p_center.add(t_id);//id �ؽ�Ʈ�ڽ����� 1�� 2�� 
		p_center.add(la_pass);//pass �󺧺��� 2�� 1�� 
		p_center.add(t_pass);//pass �ؽ�Ʈ�ڽ����� 2�� 2�� 


		//7.p_south�� ��ư���̱�/Panel�� �ƹ��� ��ġ�����ڸ� �������� ������ ����Ʈ�� FlowLayout�̴�. 
		p_south.add(bt_login);
		p_south.add(bt_regist);

		/*2. this�� ��Ȯ�� �ǹ� : ���۷��� �����̴�. �� ���ڽ��� �ν��Ͻ��� �ּҰ��� ����...
		�ش� �ν��Ͻ��� �ڱ��ڽ��� ����ų�� ���*/
		setSize(400,150);
		setVisible(true);
	}

	public static void main(String[] args){
		//1.
		new LoginForm();	
	}
}

