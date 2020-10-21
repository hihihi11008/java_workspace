public class Hero {
	int hp=10;
	boolean fly=false;
	String name="메가맨"; //has a 맞지만, 워낙 빈도수가 높으니 그냥 일반자료형처럼 사용됨
	Bullet bullet; //객체형이므로, has a 관계 

	
	public void setHp(int hp) { //hp 값을 변경하고 싶다 
		this.hp=hp;
	}
	public void setFly(boolean fly) {//fly 값을 변경하고 싶다
		this.fly=fly;
	}
	public void setName(String n) {//name 값을 변경하고 싶다		
		name=n;
	}
	public void fire(Bullet bullet){//bullet 을 다른 무기로 변경하고 싶다
		bullet=bullet;
	}
	public static void main(String[] args) {
		Hero hero = new Hero();
		hero.setHp(500);//call by value
		hero.setFly(true);//call by value
		hero.setName("지언");// call by reference 스트링은 객체이므로 
		Bullet b = new Bullet();
		hero.fire(b);	//메서드 호출시, 넘겨지는 값은 실제 객체 자체가 아닌 그 객체의 주소값이라고하여 
						//call(호출한다) by(에 의해) reference(참조)
	}	
}
