package day1125.web;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewApp extends Application{
	WebView webView;
	public void start(Stage stage) throws Exception {
		webView = new WebView();
		webView.getEngine().load("file:///C:/workspace/js_workspace/project1008/%EB%B9%84%ED%96%89%EA%B8%B0%EA%B2%8C%EC%9E%84.html");
		webView.setPrefSize(500, 500);
		
		showWindow(stage, webView);
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
