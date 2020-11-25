package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ChatClient extends Application{

	public void start(Stage stage) throws Exception {
		FlowPane flow = new FlowPane();
		
		TextField t =new TextField();
		Button bt = new Button("��ư��");
		TextArea area = new TextArea();
		
		//��Ÿ�� 
		t.setPrefSize(400, 25);
		
		flow.getChildren().add(t);
		flow.getChildren().add(bt);
		
		
		//��ü ���̾ƿ� 
		BorderPane parent = new BorderPane();
		parent.setTop(flow);
		parent.setCenter(area);
		
		showWindow(stage, parent);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s= new Scene(parent);//������ 
		stage.setScene(s);//������ ���� �����쿡 ���� 
		stage.setWidth(500);
		stage.setHeight(500);
		stage.show();//������ ���ֱ�	
	}

}
