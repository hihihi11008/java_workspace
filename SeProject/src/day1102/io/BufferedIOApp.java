/*
  
  
  �ǽ�)Ű����� �Էµ� �����͸� ���پ� �����ͼ� ȭ�鿡 ����غ��� 
 */

package day1102.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedIOApp {
	public static void main(String[] args) {
		//keyboard�� ���� �� ��Ʈ���� �����ڰ� ���ϴ� Ÿ�ӿ� new �� �� ���� 
		//��? OS�� �̹̾��� �������Ƿ� ���� �ڹٿ����� ���ý������κ��� ���� �� �ִ�. 
		
		//�Է½�Ʈ���� �ֻ��� �߻� Ŭ�����̴�!! (Ű����,��ĳ�� ����� �� ��Ʈ������ ���� �� �ִ�. 
		InputStream is =System.in;
		
		//�ѱ��� ������ �ʵ��� ���ڱ������ ���׷��̵� 
		InputStreamReader reader = new InputStreamReader(is);//����Ʈ ����� ���ڱ�ݽ�Ʈ������ ����
		BufferedReader buffr = new BufferedReader(reader);//����ó���� ���ڱ���� �Է½�Ʈ�� , ���پ� �Է�ó�� 
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
