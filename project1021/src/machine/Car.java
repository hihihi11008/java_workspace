class Car{
	String color = "red";
	String name ="Benz";
	int price= 500;
	Wheel wheel=null; //�� �ڵ尡 ������ ���� ����? 
	//Ŭ�����ȿ��� �ڷ����� �� �� �ִµ�, �ڹ��� �ڷ����� �� 4���̴� 
	//���� �� Ŭ���� �ȿ��� ����, ����, ���� �̿ܿ��� ��ü���� �� �� �ִ�. 
	//��ü�ڷ����� �ڷ����̴ѱ� ! 
	//Ŭ������� ������ �̸��� �޼��带 ������ �����ڶ��ϰ� 
	//�����ڴ� �̸������� �� �� �ֵ��� ��ü����Ÿ�ӿ� ���� �ʱ�ȭ�۾��� ������ 
	//�۾��� �����ϴ� �뵵�� �޼����̴�.
	public Car(){
		wheel =new Wheel(); //this.wheel �ε� ��Ī���� 
	}
	public static void main(String[] args){
		//�ڵ����� ���� 
		Car c=new Car();
		String a=c.name;
		String b=c.wheel.brand;
		String d=c.wheel.color;
		int e=c.wheel.price;
		System.out.println("�ڵ����� �̸� : " +a);
		System.out.println("������ �귣�� : " +b);
		System.out.println("������ ���� : " +d);
		System.out.println("������ ���� : " +e);
	}
}

