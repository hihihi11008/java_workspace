class UseCat{
	public static void main(String[] args){
		Cat c=new Cat();
		System.out.println("����ź��!!!");
		System.out.println("���� �̸� :"+c.name);
		System.out.println("���� ���� :"+c.age);
		System.out.println("���� ��ȥ���� :"+c.isMarried);

		c.work();
		c.cry();
	}
}

