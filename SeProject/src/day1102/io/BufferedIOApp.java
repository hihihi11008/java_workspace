/*
  
  
  실습)키보드로 입력된 데이터를 한줄씩 가져와서 화면에 출력해보자 
 */

package day1102.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedIOApp {
	public static void main(String[] args) {
		//keyboard에 연결 된 스트림은 개발자가 원하는 타임에 new 할 수 없다 
		//왜? OS가 이미얻어다 놓았으므로 따라서 자바에서느 ㄴ시스템으로부터 얻어올 수 있다. 
		
		//입력스트림의 최상위 추상 클래스이다!! (키보드,스캐너 등등은 이 스트림으로 받을 수 있다. 
		InputStream is =System.in;
		
		//한글이 꺠지지 않도록 문자기반으로 업그레이드 
		InputStreamReader reader = new InputStreamReader(is);//바이트 기반을 문자기반스트림으로 변경
		BufferedReader buffr = new BufferedReader(reader);//버퍼처리된 문자기반의 입력스트림 , 한줄씩 입력처리 
		int data;
		String str=null;
		
		try {
			while(true){
			str=buffr.readLine();
			System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
