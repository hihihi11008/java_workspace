class Shoes{
	String color; //String은 객체이므로 컴파일러에 의해 null
 	int price; //정수는 컴파일러에 의해 최소한의 관여 수인 0 으로 초기화 
	//아래의 두메서드로 속성을 변경하는 것과 
	//생정자에 의해 초기화하는 것에 차이점 
	//
	public Shoes(String color, int price){
		this.color=color;
		this.price=price;
	}
	public void setColor(String color){
		this.color=color;
	}
	public void setPrice(int price){
		this.price=price;
	}
	public static void main(String[] args){
		Shoes s = new Shoes();	
		s.setColor("red");
		s.setPrice(20000);

		System.out.println("신발의 색상은 "+s.color+", 가격은 "+s.price);
	}
}

아래의 클래스를 생산 시점부터 빨간색인 하이힐을 만들수 있는 클래스로 완성하시오
아래의 클래스를 생산 시점부터 검정색으로 만들 수 있는 기능 및 생산한 이후에 언제든 색상을
 빨간색으로 변경 할 수 있는 클래스로 완성하시오

class  HighHeel{
   String color="None Color"; 
   public void setColor(String color){
	this.color=color;
   }

	public HighHeel(String color){
		this.color = color;
	}

	public static void main(String[] args){
		HighHeel hHeel= new HighHeel("red");
		hHeel.color="black";
	}
}


