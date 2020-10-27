package gui;
import java.awt.*;
class LoginForm extends Frame{
	/*3.has 관계는 멤버변수가 객체형일때를 의미한다 */
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center;//센터에 그리드를 적용할 패널 
	Panel p_south;//남쪽에 붙일 패널 (여기에 버튼2개붙일 예정)

	public LoginForm(){
		//3-1부품관계로 보유한 변수들은 모두 초기화시키자 
		//특히 부품은 이객체가 태어날때 같이 함께 태어나야하므로, 생성자의 타이밍을 놓치지말자 
		la_id = new Label("ID");
		la_pass = new Label("Password");
		t_id = new TextField(15);
		t_pass = new TextField(15);
		bt_login = new Button("Login");
		bt_regist= new Button("Join");
		p_center = new Panel();
		p_south = new Panel();
		//3-2. 생성만하였고, 스타일부여나 조립은 하지 않았음

		//4.Frame은 개발자가 레이아웃을 지정하지 않으면 디폴트가 BorderLayout이다. 
		//this.setLayout(new BorderLayou()); 필요없다! 디폴트가 이미 보더레이아웃이므로...
		//처음보는 객체에 대한 대응법 1.뭐하는 객체인지 파악 2.메모리에 올리는법(일반,추상,인터페이스)
		p_center.setBackground(new Color (102,153,102));

		//5.센터패널을 윈도우의 BorderLayout 센터에 넣다 
		this.add(p_center, BorderLayout.CENTER); //BorderLayout.CENTER 디폴트값이라 생략가능

		//6.south값 넣기 
		p_south.setBackground(Color.MAGENTA);//Color를 인간이 사용하기 쉬운데이터로 사용해보자
		//상수는 직관성을 부여한 데이터이다. final로 더이상 값을 변경할 수 없으며 static으로 인스턴스간 공유가 가능하며
		//public으로 선언하여 모든객체가 접근할 수 있도록 접근제한을 풀어놓은 데이터 
		this.add(p_south, BorderLayout.SOUTH); //BorderLayout.CENTER 디폴트값이라 생략가능

		//8.p_center에 그리드 적용 
		p_center.setLayout(new GridLayout(2,2));//2행 2열짜리 그리드 적용
		p_center.add(la_id);//id 라벨부착 1행 1열 
		p_center.add(t_id);//id 텍스트박스부착 1행 2열 
		p_center.add(la_pass);//pass 라벨부착 2행 1열 
		p_center.add(t_pass);//pass 텍스트박스부착 2행 2열 


		//7.p_south에 버튼붙이기/Panel은 아무런 배치관리자를 적용하지 않으면 디폴트가 FlowLayout이다. 
		p_south.add(bt_login);
		p_south.add(bt_regist);

		/*2. this의 정확한 의미 : 레퍼런스 변수이다. 단 나자신의 인스턴스의 주소값을 가진...
		해당 인스턴스가 자기자신을 가리킬때 사용*/
		setSize(400,150);
		setVisible(true);
	}

	public static void main(String[] args){
		//1.
		new LoginForm();	
	}
}

