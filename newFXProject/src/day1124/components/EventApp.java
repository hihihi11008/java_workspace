package day1124.components;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EventApp extends Application{
	Button bt;
	TextField t;
	ImageView imageView;
	
	public void start(Stage stage) throws Exception {
		bt = new Button("버튼");
		t = new TextField();
		imageView = new ImageView("https://image.genie.co.kr/Y/IMAGE/IMG_MUZICAT/IV2/Genie_Magazine/7762/Mgz_Main_List_20191209151924.jpg");
		
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);
		imageView.setPreserveRatio(true);
		
		//이벤트소스와 이벤트핸들러 연결 
		bt.setOnAction((e)->{
				System.out.println("눌럿냐궁");
		});
		
		t.setOnKeyReleased((e)-> {
			//엔터를 치면 
			if (e.getCode()==KeyCode.ENTER) {
				System.out.println("키 눌렀냐궁!");
			}
		});
		
		imageView.setOnMouseClicked((e)->{
			System.out.println("아하핳");
		});
		
		FlowPane flow = new FlowPane(bt, t, imageView); //가변형 인자로 선언된 생성자이므로 
																					//매개변수의 갯수를 실행타임에 결정 지을 수 있다. 
//		test(3,5,6,7);
		showWindow(stage, flow);
	}
	
	public void test(int...x) {//갯수를 호출자가 결정하는것 
		System.out.println(x.length);
		
		for(int v :x) {
			System.out.println("값은"+v);
		}
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s= new Scene(parent);//씬생성 
		stage.setScene(s);//생성된 씬을 윈도우에 적용 
		stage.setWidth(500);
		stage.setHeight(500);
		stage.show();//윈도우 봉주기	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
