package animal;
public class Duck extends Bird{
	/*Duck is Bird*/
	/*Duck���� Bird���̴�*/
	/*������ ����*/
	String name="������";

	public void quack(){
		System.out.println("�в�");
	}
	public static void main(String[] args){
		Duck d1 = new Duck();
		Duck d2 = new Duck();

		Bird b = new Bird();

		//b=d1; //����
		//b = new Duck(); //����

		//��ü�ڷ����� �ڷ����̴� 
		Duck a = new Duck();
		Bird r =new Bird();
		r = a;
		a = (Duck)r; // ��<--ū down casting
		r = (Bird)a; // ���� �ڷ������� ū �ڷ������� �ö� up casting

		//��ü �ڷ����� �ڷ����̹Ƿ�, �⺻�ڷ����� ��Ģ�� ���κ� �״�� ����ǰ� �ִ� .
	}
}

