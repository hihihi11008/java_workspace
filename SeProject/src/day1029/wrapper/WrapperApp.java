package day1029.wrapper;

/*
 	var x="5" --> ����5�� �ٲٷ���? js : parseInt(x)
 	
 	�ڹٿ����� ��� �⺻ �ڷ������� 1:1 �����ϴ� ����Ŭ������ �������ش� 
 	���� : byte : Byte, short : Short, int:Integer, long:Long
 	�Ǽ� : float : Float, double : Double
 	
 	Wrapper Ŭ������ �⺻�ڷ����� ��üȭ ��Ŵ���ν� �ξ� �پ��� ������ ó���� �������ش� 
 	ex)���������ڸ� ���� ���ڷ� ��ȯ 
 		�⺻�ڷ����� ��ü�ڷ������� ����ȯ 
 		��Ÿ ���� �޼��带 �����ϹǷν�, �⺻�ڷ����� ���� �پ��ϰ� ������ �� �ִ�
*/

public class WrapperApp {
	public static void main(String[] args) {
		String x= "6";
		int y=4;
		System.out.println(x+y); //��� string�� �ǹ��� ���� �̶� +��ȣ�� �����ڰ� �ȴ� 
		
		int z=Integer.parseInt(x); //static�޼����̹Ƿ� Integer.��� �����Ѵ� 
		System.out.println(z+y);
		
		Integer i=5; //�ڹ��� Ŭ���� ��Ģ���� ���ٸ� ���� ���� ���� �Ұ����ϴ� ������ Integer Ŭ������ �⺻�ڷ����� 
							//���õ� ��ü�̹Ƿ�, ��ġ �⺻�ڷ���ó�� �����͸� ������ �� �ִ� 
							//��ǻ� ���������� 5��� �⺻�ڷ����� ��üȭ �Ȱ��̴�. (Boxing:�⺻�����͸� �ڽ��� ���մ�)
							//Wrapper Ŭ������ box�� ���δ�(wrapper)���� �ٰ��� ����
		int k = i; //��Ģ�� ��ü�ڷ����� �⺻�ڷ����� �������� ������, �Ұ����� �������� ���� ���������� ����Ŭ������ 
						//�⺻�ڷ����� ���õ� ��ü�̹Ƿ�, ���������� unBoxing�� ���� �⺻�ڷ������� ��ȯ�� �Ȱ��̴� 
		//��� : �⺻�ڷ����� -->��üȭ(Boxing), ��ü�ڷ����� --> �⺻�ڷ������� (unBoxing) 
		//box�� ���ΰ�, �ٽ� ������ ��ü�� ������ Wrapper Ŭ������ �θ��� 
	}
}