/*
awt/swing/fx -->안드로이드 

*/
package gui;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;

class GridTest{
	public static void main(String[] args){
		//1.프레임생성
		Frame frame = new Frame("그리드 레이아웃");
		
		//2.레이아웃 매니져 생성 및 등록 
		GridLayout layout =new GridLayout(1,3);
		//2-1.플로우배치에서는 컴포넌트가 자신의 본래크기를 가질 수 있다.
		//FlowLayout layout =new FlowLayout();
		
		//그리드를 유지하면서 컴포넌트가 본래의 크기를 유지하는 방법은? 
		//두개는 양자택일이지 공존하지못한다 
		//해결책) 컴포넌트 중 배치관리자 적용이 가능한 패널을 이용하면된다 
		//즉 부분적으로 다른 배치관리자를 적용할때 많이 사용됨 

		
		//3.프레임에 레이아웃 적용 
		frame.setLayout(layout);
		
		Panel p = new Panel(); //눈에보이진 않음 div랑 흡사 
		
		Button bt1=new Button("버튼1");
		Button bt2=new Button("버튼2");
		Button bt3=new Button("버튼3");
		
		p.add(bt1);//패널에 버튼넣기 
		frame.add(p);//프레임에 패널넣기
		frame.add(bt2);
		frame.add(bt3);

		//4.프레임에 버튼입력 
		/*for(int i=0;i<6;i++){
			frame.add(new Button("버튼"+i));
		}*/
		//5.프레임 사이즈 
		frame.setSize(300,200);
		//6.프레임을 화면에 나오게하는 메서드
		frame.setVisible(true); 
	}
}

