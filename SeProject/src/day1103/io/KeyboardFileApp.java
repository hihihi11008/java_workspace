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
		//디렉토리+파일명
		try {
			URL url2= new URL(url, "empty.txt");//디렉토리와 파일명 조합 
			
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
		//키보드로부터 입력받은 데이터를 파일로 저장해본다 
		//1.키보드 스트림은 System으로부터 얻어온다 
		InputStream is = System.in; // 바이트(영어)
		
		//2.문자기반스트림으로 업그레이드! 
		InputStreamReader reader = new InputStreamReader(is);
		
		//3.버퍼기반의 문자입력스트림으로 업그레이드!
		BufferedReader buffr = new BufferedReader(reader);
		
		//5.파일출력스트림 계열은 (empty)빈 파일을 생성해준다 
		//FileWriter writer = new FileWriter();
		
		//4.리드라인으로 읽은 후 trycatch문으로 감싼다 
		String msg =null;
		
		try {
			msg=buffr.readLine();
			System.out.println(msg);
			writer.write(msg);//마무리
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
