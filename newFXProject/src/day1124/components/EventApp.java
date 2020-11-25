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
		bt = new Button("��ư");
		t = new TextField();
		imageView = new ImageView("https://image.genie.co.kr/Y/IMAGE/IMG_MUZICAT/IV2/Genie_Magazine/7762/Mgz_Main_List_20191209151924.jpg");
		
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);
		imageView.setPreserveRatio(true);
		
		//�̺�Ʈ�ҽ��� �̺�Ʈ�ڵ鷯 ���� 
		bt.setOnAction((e)->{
				System.out.println("�����ı�");
		});
		
		t.setOnKeyReleased((e)-> {
			//���͸� ġ�� 
			if (e.getCode()==KeyCode.ENTER) {
				System.out.println("Ű �����ı�!");
			}
		});
		
		imageView.setOnMouseClicked((e)->{
			System.out.println("�����K");
		});
		
		FlowPane flow = new FlowPane(bt, t, imageView); //������ ���ڷ� ����� �������̹Ƿ� 
																					//�Ű������� ������ ����Ÿ�ӿ� ���� ���� �� �ִ�. 
//		test(3,5,6,7);
		showWindow(stage, flow);
	}
	
	public void test(int...x) {//������ ȣ���ڰ� �����ϴ°� 
		System.out.println(x.length);
		
		for(int v :x) {
			System.out.println("����"+v);
		}
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s= new Scene(parent);//������ 
		stage.setScene(s);//������ ���� �����쿡 ���� 
		stage.setWidth(500);
		stage.setHeight(500);
		stage.show();//������ ���ֱ�	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
