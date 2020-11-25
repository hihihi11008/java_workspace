package day1124.layout;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/*FlowPane�� AWT�� FlowLayout�� ����� ���� 
 * �� ������ ������ ���, ���� ������ ������Ʈ���� �귯 ������ 
 * */
public class FlowPaneApp extends Application{

	public void start(Stage stage) throws Exception {
		//TilePane�� ���������, TilePane�� �ڽĿ�ҵ��� ũ�Ⱑ ��� �����ϴ� 
		FlowPane parent = new FlowPane(Orientation.VERTICAL, 10,10);
		
		Button bt1 = new Button("bt1");
		Button bt2 = new Button("bt2");
		Button bt3 = new Button("bt3");
		
		parent.getChildren().add(bt1);
		parent.getChildren().add(bt2);
		parent.getChildren().add(bt3);
		
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
