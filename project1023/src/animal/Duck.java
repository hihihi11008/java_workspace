package animal;
public class Duck extends Bird{
	/*Duck is Bird*/
	/*Duck형은 Bird형이다*/
	/*오리는 새다*/
	String name="난오리";

	public void quack(){
		System.out.println("꽥꽥");
	}
	public static void main(String[] args){
		Duck d1 = new Duck();
		Duck d2 = new Duck();

		Bird b = new Bird();

		//b=d1; //가능
		//b = new Duck(); //가능

		//객체자료형도 자료형이다 
		Duck a = new Duck();
		Bird r =new Bird();
		r = a;
		a = (Duck)r; // 작<--큰 down casting
		r = (Bird)a; // 작은 자료형에서 큰 자료형으로 올라감 up casting

		//객체 자료형도 자료형이므로, 기본자료형의 원칙이 상당부분 그대로 적용되고 있다 .
	}
}

