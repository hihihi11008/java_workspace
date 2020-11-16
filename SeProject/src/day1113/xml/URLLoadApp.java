/*
 * ���ݱ����� URL���� �ڿ��� �����ö�, �� ����� �̹����� �Ͽ����� 
 * ex) ImageIO.read() �� �ǽ� 
 * 
 * ���� �� �ǽ������� �̹��� �Ӹ��ƴ϶� �������� ��� ������ �ڿ��� ������� �����Ͽ� 
 * ��Ʈ������ �����͸� �о�� �ǽ��� �����غ��� 
 * */
package day1113.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLLoadApp {
	//������ ��� �ڿ��� ������� ���� �� �����͸� �о�� �� �ִ� ��ü 
	URLConnection con; //�߻�Ŭ���� �̹Ƿ� URL ��ü�� ���� �ν��Ͻ��� ��´� 
	HttpURLConnection http;
	URL url;
	FileOutputStream fos;
	
	public URLLoadApp() {
		try {
			url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT1uF4Hqm5z8fi4ksqW-6HwQO9vDVSLluS1AA&usqp=CAU");
			
			//������ �������� �ڿ��� ������ �õ�! 
			con=url.openConnection();
			http=(HttpURLConnection)con;
			//http�� �ڿ��� GET ������� �ڿ��� ��û���� 
			http.setRequestMethod("GET");
			
			//���� ��ü�κ��� ��Ʈ���� ���ͼ� �����͸� �о��!! 
			InputStream is =http.getInputStream();
			
			//���Ϸ� �����غ���
			File file = new File("C:/workspace/java_workspace/SeProject/src/res/copy.jpg");
			fos = new FileOutputStream(file);
			
			//�ѹ���Ʈ�� �о�ͼ� ��½�Ʈ���� �̿��Ͽ� ���Ͽ� ��¥ 
			int data=1; //ó������ �о���� �����Ͱ� ���ٰ� ���� 
			
			while (true) {
				data=is.read();
				
				if (data==-1) break;
				fos.write(data);
			}
			System.out.println("���ͳݻ��� ������ ���÷� ����Ϸ��߾�� ");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new URLLoadApp();
	}
}
