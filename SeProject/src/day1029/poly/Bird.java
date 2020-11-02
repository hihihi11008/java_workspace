/*
 * 다형성에 대해 다시한번 공부해보자 
 * */
package day1029.poly;

import java.util.ArrayList;

public class Bird {
	String name = "난새";
	String local = "한국";
	
	public void fly() {
		System.out.println("새가날아영");
	}
	public static void main(String[] args) {
		//새들을 대상으로 다형성 공부하기 
		Bird b1 = new Bird();
		Bird b3 = new Sparrow();//유연해진다 
		
//		b3.fly(); //새지만, 행동이 다양하다 
		
		Bird b2 = new Duck(); //b2는 Bird 클래스 변수, 메서드접근
										//다형성의 특징으로서는 자식 메서드를 접근가능 
		//Duck d = new Duck(); // 부모꺼 내꺼
		
		//부모자료형으로 가면 부모와 자식이 공통으로 가지고 있는 메서드만 접근가능 
		//자식에있는 메서드를 사용하려면 자식자료형으로 가야함 
	}
}
