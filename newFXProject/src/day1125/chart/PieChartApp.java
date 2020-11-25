/*
 	[FX���� chart]
 	piechart
 	linechart
 	
 * */
package day1125.chart;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartApp extends Application{
	PieChart pie;

	public void start(Stage stage) throws Exception {
		pie = new PieChart();
		
		//������Ʈ�� ������ �����ϱ� 
		PieChart.Data s1 = new PieChart.Data("�ȵ���̵�", 6);//�ȵ���̵尡 60�� ����
		PieChart.Data s2 = new PieChart.Data("������", 3);
		PieChart.Data s3 = new PieChart.Data("��������", 1);
		
		//������Ʈ�� ���� 
		pie.getData().add(s1);
		pie.getData().add(s2);
		pie.getData().add(s3);
		
		pie.setLegendSide(Side.LEFT);
		
		showWindow(stage, pie);
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
