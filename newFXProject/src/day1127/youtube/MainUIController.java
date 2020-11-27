/*
 * javaFX�� �̺�Ʈ ó���� ������ �� �ִ� ��ü�� ���c�Ѵ� (�̸� ��Ʈ�ѷ��� �Ѵ� ) 
 * Initailizable �������̽��� �����ؾ��Ѵ� 
 * */
package day1127.youtube;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.web.WebView;

public class MainUIController implements Initializable{
	 //�����ڰ� ���� lookup()�ϴ� ���� �ƴ϶�, �ý��ۿ� ���� �ڵ������� ��ü�� ���Թ��� 
	//@�� ������̼�(annotation)�̶� �θ��� ������ �ּ��ε� ���ּ��� �츮�� �˰��ִ� �Ϲ��ּ����� �޸� ���α׷����� ���ȴ� 
	//jdk5�������� �����ϱ� ���� 
	@FXML
	TextField t_url;

	@FXML
	TextField t_title;

	@FXML
	Button bt;
	
	@FXML
	TilePane tilePane;
	
	//�̸޼���� ���� Ŭ������ �����ɶ�, �ڵ��� ȣ��Ǵ� �ʱ�ȭ �޼����̴� 
	//URL�� �� �������α׷��� ������� layout.xml�� ��ΰ� �Ѿ�´� 
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("location���� "+location);
		System.out.println("resources���� "+resources);
		
		System.out.println("bt"+bt);
		
		bt.setOnAction((e)->{
			createThumb();
//			System.out.println("������ .. ");
		});
	}
	
	//���� ����� �����ϱ� 
	public void createThumb() {
		try {
			BorderPane borderPane = (BorderPane)FXMLLoader.load(this.getClass().getClassLoader().getResource("day1127/youtube/thumb.fxml"));
			WebView webView = (WebView)borderPane.lookup("#webView");
			Label la_title= (Label)borderPane.lookup("#la_title");
			
//			webView.getEngine().load(t_url.getText());
			 
			
			webView.getEngine().loadContent(t_url.getText(), "text/html");
			la_title.setText(t_title.getText());
			
			//�ε�� ������ ������� Ÿ�������̳ʿ� ���� 
			tilePane.getChildren().add(borderPane);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
