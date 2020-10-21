class Doll{
	static String name="피카츄";
	int price;
	
	public void walk(){
		
	}
	/*
	개발자가 정의하지 않으면 sun에서 나선다 
	컴파일러에 의해 아주 기본적인 최소한의 관여를 통해 생성자를 정의한다 
	디폴트 생정자 
	public Doll(){
		//로직은 없다 . 최소한의 관여만하므로 (에러만안나게 )
	}
	*/

	//개발자가 생성자를 정의하면, 더 이상 컴파일러에 의핸 생정자 정의는 없다 
	//따라서 개발자가 정의한 생성자만 존재한다 
	//public Doll(){
	//	System.out.println("내가 정의한 생성자");
	//}
	public static void main(String[] args){
		Doll d=new Doll();//defalut 생정자 메서드 호출한 것임 
		d.name="가비";
		System.out.println(d.name);
	}	
}
