/*
 * AWT�� SWing�� ������ �ڹ� �ڵ�θ�, ȭ���� �������� �����ؾ��ϹǷ� 
 * ���������ϱⰡ �ʹ��ʹ� ��ƴ� 
 * �̷��ѹ����� �ذ��ϱ� ���� ������ �ڵ�� ������ �и����� �����ϴ� ����� �̿��غ��� 
 *	Fx�� �������� �ڹٻӸ� �ƴ϶�, xml�ε� �����ϰ� ������ ��� �������� ������ �ڹ��ڵ忡���� ���� �������ƾ�...�Ѵ�? 
 *	Ư���Ѱ�� ���� 
 * */
package day1124.xml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class XMLDesignApp extends Application{
	public void start(Stage stage) throws Exception {
		//���� �������� �������� ����ϴ� xml�� �������� �����Ƿ� 
		//xml�� �о ���� �ڹ��ڵ�� �����;��Ѵ� 
		//DOM SAX parsing(������ �����͸� xml�� ǥ�������� ) �� ����ϴ� ���̾ƴ϶� 
		//FX���� �����ϴ� xml�ؼ���ü �̿��ϸ� �ȴ� (��ü����) 
		URL url =this.getClass().getClassLoader().getResource("day1124/xml/main.fxml");
		VBox parent = (VBox)FXMLLoader.load(url);
		
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
