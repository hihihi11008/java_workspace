package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* FX application�� Application Ŭ������ ��ӹ޾ƾ� �Ѵ�.*/
public class AppMain extends Application{
	/*FX Application �����ֱ� �޼��尡 ������ */
	
	public AppMain() {
		System.out.println("AppMain() ������ �޼��� ȣ�� by "+Thread.currentThread().getName());
	}
	//���ø����̼��� ������ �غ� �Ǹ� ȣ��Ǵ� �޼��� 
	public void start(Stage stage) throws Exception {
		System.out.println("start()  �޼��� ȣ�� by "+Thread.currentThread().getName());
		//�Ű������� ���� stage ������ ���ø����̼��� �������̴�!!
		
		//���븦 �����Ѵ�!!(FX������ �����쿡 �ݵ�� �ϳ��� Scene�� �����ؾ� ��)
		VBox parent = new VBox(); //�������� ������Ʈ�� ��ġ�ϴ� ���̾ƿ� ��ü
													//FlowLayout�� ����� ��ü
		
		Scene s = new Scene(parent); //Parent��? �θ�Ŭ������ �ǹ��ϴ� ���� �ƴ϶�, ��ü�� ���԰��迡�� 
													//�ٱ��� �����̳ʸ� �ǹ�
													//Swing�� �������ڸ�, ���̾ƿ� ��ü�� Parent �̴�!!
		Button bt = new Button("����ư");
		bt.setPrefWidth(200);
		bt.setPrefHeight(40);
		
		
		
		//��ư�� parent �� �����ϱ� 
		parent.getChildren().add(bt);
		javafx.scene.control.TextField t = new javafx.scene.control.TextField("test");
		parent.getChildren().add(t);
		
		stage.setScene(s);//���� �����쿡 ����
		
		bt.setOnAction((e)->{
			System.out.println("Ŭ���޾�?");
		});
		
		
		stage.setHeight(500);
		stage.setWidth(500);
		
		stage.show(); //������ ���̰�
	}

	/*���ø����̼� ���� ��, �ʱ�ȭ�� ����ϴ� �޼����̴�. ���� �ʱ�ȭ�� �� ���ٸ� 
 	�����Ǵ� �ʼ��� �ƴϴ�..
 	������ : �ν��Ͻ��� �¾�� ȣ��Ǵ¸޼��� (�� ���� ������)
 	vs 
 	init() : �¾ ���Ŀ�, �ʱ�ȭ �۾��� ���Ǵ� �޴��� 
 	*/
	public void init() throws Exception {
		//�ڹ��� �������� �޼��� �� ���� �������� ������ ������ ��� ���� �޼���  

		System.out.println("init()  �޼��� ȣ�� by "+Thread.currentThread().getName());
	}
	
	public void stop() throws Exception {
		System.out.println("stop()  �޼��� ȣ�� by "+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		System.out.println("launch()  �޼��� ȣ�� by "+Thread.currentThread().getName());
		launch(args); //�����ɾ�
	}


}
