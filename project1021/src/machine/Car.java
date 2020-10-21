class Car{
	String color = "red";
	String name ="Benz";
	int price= 500;
	Wheel wheel=null; //이 코드가 낯설지 않은 이유? 
	//클래스안에는 자료형을 둘 수 있는데, 자바의 자료형은 총 4개이다 
	//따라서 이 클래스 안에는 문자, 숫자, 논리값 이외에도 객체형도 올 수 있다. 
	//객체자료형도 자료형이닌깐 ! 
	//클래스명과 동일한 이름의 메서드를 가리켜 생성자라하고 
	//생성자는 이름에서도 알 수 있듯이 객체생성타임에 무언가 초기화작업이 있을때 
	//작업을 수행하는 용도의 메서드이다.
	public Car(){
		wheel =new Wheel(); //this.wheel 로도 지칭가능 
	}
	public static void main(String[] args){
		//자동차를 생성 
		Car c=new Car();
		String a=c.name;
		String b=c.wheel.brand;
		String d=c.wheel.color;
		int e=c.wheel.price;
		System.out.println("자동차의 이름 : " +a);
		System.out.println("바퀴의 브랜드 : " +b);
		System.out.println("바퀴의 색상 : " +d);
		System.out.println("바퀴의 가격 : " +e);
	}
}

