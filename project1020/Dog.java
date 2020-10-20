class Dog{
	String name="도그";
	int age=5;
	static String color="white"; //이변수는, 클래스로부터 생성된 인스턴스에 딸려올라가지 말고
	//클래스원본에 딱 달라붙어 있어라. 즉 인스턴스 소속이 아니라, 클래스 원본소속으로 선언!! 

	public void bark(){
		System.out.println("왁왁");
	}

	public static void main(String[] args){ //java.exe 매개변수 
		//Dog.color="black"; //FM적인 표현방식
		color="yellow";

		int a=8;
		Dog d = new Dog();

		d1.age=8;
		d2.age=7;
		boolean k=true;
	}
}

