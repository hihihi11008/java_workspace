package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//GridPane�� AWT�� GridLayout�� ����� ���� ( �� ��� ���� ��ġ�ϴ� ���̾ƿ�)
public class GridPaneApp extends Application{
	
	public void start(Stage stage) throws Exception {
		GridPane parent = new GridPane();
		
		//AWT�� Ʋ���� �����̳ʿ� ������ ��,�� ���°� ������ 
		Button[] btn = new Button[6];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button("��ư"+i);
			btn[i].setPrefWidth(100);
			btn[i].setPrefHeight(100);
		}
		parent.add(btn[0], 0, 0);
		parent.add(btn[1], 1, 0);
		parent.add(btn[2], 2, 0);

		parent.add(btn[3], 0, 1);
		parent.add(btn[4], 1, 1);
		parent.add(btn[5], 2, 1);
		
		showWindow(stage, parent);
		
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
