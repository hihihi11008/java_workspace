class UseCat{
	public static void main(String[] args){
		Cat c=new Cat();
		System.out.println("냥이탄생!!!");
		System.out.println("냥이 이름 :"+c.name);
		System.out.println("냥이 나이 :"+c.age);
		System.out.println("냥이 결혼여부 :"+c.isMarried);

		c.work();
		c.cry();
	}
}

