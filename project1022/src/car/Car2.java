
현실의 자동차, 택시, 버스, 트럭을 자바 언어로 반영하되 재사용성을 고려해서 설계해 보세요
public class Car2{
	Wheel wheel;
	Body body;
	Engine engine;
	
	public car(){
		wheel = new Wheel();
		body = new Body();
		engine = new Engine();
	}
}

public static void main(String[] args){
	Car cr=new Car();

}