package use;
//개념상만 가능 .. 아래처럼 명시하면 
//이 자바 코드는 윈도우, 리눅스, 맥에서 모두 실행되어야 하므로, 경로를 특정 OS에 의존적 경로 
//명시하면 안된다 

//OS환경변수 : path 실행하고픈 파일의 경로의 위치 
//			 classpath 실행하고픈 클래스파일의 경로의 위치
import fashion.down.Pants;//사용하고픈 클래스의 위치 등록! 

class UsePants{
	public static void main(String[] args){
		//현재 클래스와는 물리적으로 떨어져 있는 ,즉 다른 패키지에 들어있는 
		//클래스 사용해보기 ! 
		//js: <script src="경로/파일명"></script>
		Pants p = new Pants();
		System.out.println(p);
	}
}

