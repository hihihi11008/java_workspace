/*
  1) 글씨크기조절 ctrl + (-,+키) 
  2) 단축키 모두 보기 ctrl + shift + L
  3) 자동임포트 : 해당클래스에 커서 올려놓고 ctrl + shift + O 
  4) 자동 코드 정렬 :ctrl + shift + F
  5) 해당 객체의 api 문서 바로가기 : 해당 클래스 커서 올린 후 shift + F2(기능키) 인터넷 연결이 전제됨
  6) 코드블럭 이동하기 : 블럭지정 후 Alt + 위,아래
  7) 코드복사 : 블럭지정후 ctrl +Alt+아래 
 */
package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 자바에서는 체크박스를 라디오로 사용함
	CheckboxGroup group= new CheckboxGroup();
	
	public RadioTest() {
		setLayout(new FlowLayout());
		this.add(new Checkbox("운동", group, false));
		this.add(new Checkbox("독서", group, false));
		this.add(new Checkbox("영화", group, false));
		this.add(new Checkbox("자전거", group, false));
		this.add(new Checkbox("요리", group, false));
		this.add(new Checkbox("가비보기", group, true));
		
		setSize(300, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		System.out.println("오잉");
		new RadioTest();
	}

}
