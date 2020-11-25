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
		//1)String 의 url로 생성하는 법
		/*
		url="https://image.genie.co.kr/Y/IMAGE/IMG_MUZICAT/IV2/Genie_Magazine/7762/Mgz_Main_List_20191209151924.jpg";
		imageView = new ImageView(url);
		*/
		
		//2)Image객체를 이용하는 법
		url="https://image.genie.co.kr/Y/IMAGE/IMG_MUZICAT/IV2/Genie_Magazine/7762/Mgz_Main_List_20191209151924.jpg";
		Image img = new Image(url);
		imageView = new ImageView(img);
		
		
		//이미지의 비율을 자체적으로 계싼하여 유지하는 방법 
		imageView.setPreserveRatio(true);
		imageView.setFitWidth(300);
		imageView.setFitHeight(300);
		
		FlowPane parent = new FlowPane(imageView); //add메서드 대신에 이런 방식도 가능 
		showWindow(stage, parent);
		
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
