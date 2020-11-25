package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * BorderPane �� AWT������ BorderLayout�� ���� 
 * */
public class BorderPaneApp extends Application{

	
	public void start(Stage stage) throws Exception {
		//BorderPane ����
		BorderPane parent = new BorderPane();
		Button bt1 = new Button("Top");
		Button bt2 = new Button("Right");
		Button bt3 = new Button("Bottom");
		Button bt4 = new Button("Left");
		Button bt5 = new Button("Center");
		
		parent.setTop(bt1);
		parent.setRight(bt2);
		parent.setBottom(bt3);
		parent.setLeft(bt4);
		parent.setCenter(bt5);
		
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
