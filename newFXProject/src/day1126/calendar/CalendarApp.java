package day1126.calendar;

import java.util.Calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class CalendarApp extends Application{
	ChoiceBox ch_yy; //����
	ChoiceBox ch_mm;//��
	Button bt;
	TilePane tilePane;
	int startDayOfWeek; //�ش� ���� ���� ���� (1���� ������) 
	int lastDate; // �� ���� ��������
	Box[] box=new Box[7*6];

	public void start(Stage stage) throws Exception {
		BorderPane borderPane = (BorderPane)FXMLLoader.load(this.getClass().getClassLoader().getResource("day1126/calendar/layout.fxml"));
		
		//��Ʈ ������ ��ϵ� ��ü ã�Ƴ�����~~!
		//js�� document.getElemnetById("ch_yy"); �� ������ ����!!
		ch_yy=(ChoiceBox)borderPane.lookup("#ch_yy");
		ch_mm=(ChoiceBox)borderPane.lookup("#ch_mm");
		tilePane=(TilePane)borderPane.lookup("#tilePane");
		bt=(Button)borderPane.lookup("#bt");
		
		initDate(); //���̽��ڽ� �ʱ�ȭ!!
		createTitle(); //���� �����ϱ�
		createDateBox();//��¥�ڽ� �����ϱ�
		
		getStartDayOfWeek();//���ۿ��� ���ϱ� 
		getLastDate();//�������� ���ϱ�
		
		bt.setOnAction((e)->{
			getStartDayOfWeek();//���ۿ��� ���ϱ� 
			getLastDate();//�������� ���ϱ�
			printData();//�ʱ�ȭ �� �۾� ��ֱ�
		});
		
		showWindow(stage, borderPane);
	}
	
	public void initDate() {
		for(int i=2020;i>=1990;i--) {
			ch_yy.getItems().add(i);
		}
		//ch_yy.getSelectionModel().select(0);//n��° ��Ұ� ���õǾ� �ְ�... 
		ch_yy.getSelectionModel().selectFirst();//������ ó����Ұ� ���õǾ� �ְ�..
		
		for(int i=1;i<=12;i++) {
			ch_mm.getItems().add(i);
		}
		ch_mm.getSelectionModel().selectFirst();
	}
	
	//����7 �ڽ� �����ϱ� 
	public void createTitle() {
		for(int i=0;i<Days.values().length;i++) {
			Box box=new Box(Days.values()[i].toString() ,100,100);
			tilePane.getChildren().add(box);
		}		
	}
	
	//��:6,  ��:7 
	public void createDateBox() {
		for(int i=0;i<7*6;i++) {
			box[i]= new Box(Integer.toString(i),100,100);
			tilePane.getChildren().add(box[i]);
		}
	}
	
	//�ش� ���� ���� ���ϱ��ϱ�(�׷��� �ش� ���Ϻ��� 1�Ͼ� ����� �����ϴϱ�!!)
	//����!! ������ 1���ͽ�����, ���� 0���� ������
	public void getStartDayOfWeek() {
		//��¥ ��ü�� �ϳ� �����!!(��? �����ҷ���)
		Calendar cal=Calendar.getInstance();
		//System.out.println(cal); //���糯¥�� ��´� 
		
		//�� ��¥�� �ְ��Ű��! ���� ���ϴ� ��¥��..
		int yy=(Integer)ch_yy.getValue();
		int mm=(Integer)ch_mm.getValue();
		
		cal.set(yy, mm-1, 1); //������ ����
		
		startDayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("���۵� ���� ���������: "+startDayOfWeek);//���۵� ������ ��¥ ��ü���� ���� ������ �����
	}
	
	//�ش� ���� ���ϱ��� �ִ� �� ���ϱ� 
	public void getLastDate() {
		Calendar cal = Calendar.getInstance();
		
		int yy=(Integer)ch_yy.getValue();
		int mm=(Integer)ch_mm.getValue();
		
		//����!! �ش���� 0�� �� ��¥�� �����ص�, ���� �ڵ����� ��ȯ�ȴ�..
		cal.set(yy, mm, 0);
		
		//���۵� �����̹Ƿ�, ���� ��ü�� ���Ͽ� ���ִ��� �������� 
		lastDate=cal.get(Calendar.DATE);
		System.out.println(lastDate);
	}
	
	//������ �ڽ����� �������, ������ �ؽ�Ʈ ����ϱ�!!!
	public void printData() {
		//��� �ڽ��� �ٽ� �ʱ�ȭ!!!
		for(int i=0;i<box.length;i++){
			box[i].erase();
		}
		
		getStartDayOfWeek();
		getLastDate();
		
		//������ �˸´� ������ 
		int count = 1;//1�Ϻ��� 1�� �����ϸ� ��µ� ���� 
		for (int i = (startDayOfWeek-1); i < (startDayOfWeek-1)+lastDate; i++) {
			box[i].renderText(Integer.toString(count));
			count++;
		}
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s=new Scene(parent);//�� ����
		stage.setScene(s);//������ ���� �����쿡 ���� 
		stage.setWidth(720);//�ʺ�
		stage.setHeight(800);//����
		stage.show();//������ �����ֱ�
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}