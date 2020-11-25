package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageViewApp extends Application{
	String url;
	ImageView imageView;
	
	public void start(Stage stage) throws Exception {
		//1)String �� url�� �����ϴ� ��
		/*
		url="https://image.genie.co.kr/Y/IMAGE/IMG_MUZICAT/IV2/Genie_Magazine/7762/Mgz_Main_List_20191209151924.jpg";
		imageView = new ImageView(url);
		*/
		
		//2)Image��ü�� �̿��ϴ� ��
		url="https://image.genie.co.kr/Y/IMAGE/IMG_MUZICAT/IV2/Genie_Magazine/7762/Mgz_Main_List_20191209151924.jpg";
		Image img = new Image(url);
		imageView = new ImageView(img);
		
		
		//�̹����� ������ ��ü������ ����Ͽ� �����ϴ� ��� 
		imageView.setPreserveRatio(true);
		imageView.setFitWidth(300);
		imageView.setFitHeight(300);
		
		FlowPane parent = new FlowPane(imageView); //add�޼��� ��ſ� �̷� ��ĵ� ���� 
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
