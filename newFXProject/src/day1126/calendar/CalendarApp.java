package day1126.calendar;

import java.util.Calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class CalendarApp extends Application{
	ChoiceBox ch_yy; //연도
	ChoiceBox ch_mm;//월
	Button bt;
	TilePane tilePane;
	int startDayOfWeek; //해당 월의 시작 요일 (1부터 시작함) 
	int lastDate; // 각 월의 마지막날
	Box[] box=new Box[7*6];

	public void start(Stage stage) throws Exception {
		BorderPane borderPane = (BorderPane)FXMLLoader.load(this.getClass().getClassLoader().getResource("day1126/calendar/layout.fxml"));
		
		//루트 하위에 등록된 객체 찾아나서기~~!
		//js의 document.getElemnetById("ch_yy"); 와 원리가 같다!!
		ch_yy=(ChoiceBox)borderPane.lookup("#ch_yy");
		ch_mm=(ChoiceBox)borderPane.lookup("#ch_mm");
		tilePane=(TilePane)borderPane.lookup("#tilePane");
		bt=(Button)borderPane.lookup("#bt");
		
		initDate(); //초이스박스 초기화!!
		createTitle(); //요일 구성하기
		createDateBox();//날짜박스 생성하기
		
		getStartDayOfWeek();//시작요일 구하기 
		getLastDate();//마지막일 구하기
		
		bt.setOnAction((e)->{
			getStartDayOfWeek();//시작요일 구하기 
			getLastDate();//마지막일 구하기
			printData();//초기화 후 글씨 써넣기
		});
		
		showWindow(stage, borderPane);
	}
	
	public void initDate() {
		for(int i=2020;i>=1990;i--) {
			ch_yy.getItems().add(i);
		}
		//ch_yy.getSelectionModel().select(0);//n번째 요소가 선택되어 있게... 
		ch_yy.getSelectionModel().selectFirst();//무조건 처음요소가 선택되어 있게..
		
		for(int i=1;i<=12;i++) {
			ch_mm.getItems().add(i);
		}
		ch_mm.getSelectionModel().selectFirst();
	}
	
	//요일7 박스 생성하기 
	public void createTitle() {
		for(int i=0;i<Days.values().length;i++) {
			Box box=new Box(Days.values()[i].toString() ,100,100);
			tilePane.getChildren().add(box);
		}		
	}
	
	//행:6,  열:7 
	public void createDateBox() {
		for(int i=0;i<7*6;i++) {
			box[i]= new Box(Integer.toString(i),100,100);
			tilePane.getChildren().add(box[i]);
		}
	}
	
	//해당 월의 시작 요일구하기(그래야 해당 요일부터 1일씩 출력을 시작하니깐!!)
	//주의!! 요일은 1부터시작함, 월은 0부터 시작함
	public void getStartDayOfWeek() {
		//날짜 객체를 하나 만든다!!(왜? 조작할려고)
		Calendar cal=Calendar.getInstance();
		//System.out.println(cal); //현재날짜를 찍는다 
		
		//이 날짜를 왜곡시키자! 내가 원하는 날짜로..
		int yy=(Integer)ch_yy.getValue();
		int mm=(Integer)ch_mm.getValue();
		
		cal.set(yy, mm-1, 1); //조작을 가함
		
		startDayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("조작된 월의 현재요일은: "+startDayOfWeek);//조작된 상태의 날짜 객체에게 현재 요일을 물어보자
	}
	
	//해당 월이 몇일까지 있는 지 구하기 
	public void getLastDate() {
		Calendar cal = Calendar.getInstance();
		
		int yy=(Integer)ch_yy.getValue();
		int mm=(Integer)ch_mm.getValue();
		
		//주의!! 해당월을 0일 즉 날짜만 조작해도, 월이 자동으로 변환된다..
		cal.set(yy, mm, 0);
		
		//조작된 상태이므로, 현재 객체가 몇일에 와있는지 조사하자 
		lastDate=cal.get(Calendar.DATE);
		System.out.println(lastDate);
	}
	
	//생성된 박스들을 대상으로, 내부의 텍스트 출력하기!!!
	public void printData() {
		//모든 박스를 다시 초기화!!!
		for(int i=0;i<box.length;i++){
			box[i].erase();
		}
		
		getStartDayOfWeek();
		getLastDate();
		
		//각월에 알맞는 데이터 
		int count = 1;//1일부터 1씩 증가하며 출력될 변수 
		for (int i = (startDayOfWeek-1); i < (startDayOfWeek-1)+lastDate; i++) {
			box[i].renderText(Integer.toString(count));
			count++;
		}
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s=new Scene(parent);//씬 생성
		stage.setScene(s);//생성된 씬을 윈도우에 적용 
		stage.setWidth(720);//너비
		stage.setHeight(800);//높이
		stage.show();//윈도우 보여주기
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}