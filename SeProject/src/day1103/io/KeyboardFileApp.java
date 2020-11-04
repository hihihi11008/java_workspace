package day1103.io;

import java.awt.geom.Path2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class KeyboardFileApp {
	//6.
	String dir;
	FileWriter writer;
	
	//2.
	public KeyboardFileApp() {
		URL url=this.getClass().getClassLoader().getResource("res/");//5.
		//���丮+���ϸ�
		try {
			URL url2= new URL(url, "empty.txt");//���丮�� ���ϸ� ���� 
			
			URI uri=url2.toURI();
			System.out.println(uri);
			writer = new FileWriter(new File(uri));
		}catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	//1.
	private void saveFile() {
		//Ű����κ��� �Է¹��� �����͸� ���Ϸ� �����غ��� 
		//1.Ű���� ��Ʈ���� System���κ��� ���´� 
		InputStream is = System.in; // ����Ʈ(����)
		
		//2.���ڱ�ݽ�Ʈ������ ���׷��̵�! 
		InputStreamReader reader = new InputStreamReader(is);
		
		//3.���۱���� �����Է½�Ʈ������ ���׷��̵�!
		BufferedReader buffr = new BufferedReader(reader);
		
		//5.������½�Ʈ�� �迭�� (empty)�� ������ �������ش� 
		//FileWriter writer = new FileWriter();
		
		//4.����������� ���� �� trycatch������ ���Ѵ� 
		String msg =null;
		
		try {
			msg=buffr.readLine();
			System.out.println(msg);
			writer.write(msg);//������
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new KeyboardFileApp().saveFile();
		
	}
}
