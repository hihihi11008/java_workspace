/*
 �Է½�Ʈ�� ó���� ���Ͽ� ���ѵ� ����� �ƴϴ�. 
 �� �������� ���α׷����� �����Ͱ� �귯�巷�´ٸ�, �̸����� �� �Է� ��Ʈ���̴�. 
 ���� �� ���������� ������ ������� �����͸� �д� ���� �ƴ϶� 
 Ű���带 ������� ����Ʈ�� �о�� ���� 
 ����) ���ϰ��� �޸�, Ű������ ��Ʈ���� �ڹٿ��� ������ �� �ִ� ���� �ƴ϶� ,�̹� OS �������� ��Ʈ���� 
 		�����ϹǷ�, �ڹٴ� ���� �̹� �����ϴ� ��Ʈ���� ���� �� �� ���� ���̴�. 
 */
package day1102.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardInputApp {
	public static void main(String[] args) {
		//Ű���� ��Ʈ���� �̹� �ý��������� �����ϹǷ�, �ڹ��� SystemŬ�����κ��� ���� 
		InputStream is =System.in; // ǥ�� �Է½�Ʈ��(Ű���� or ��Ÿ �Էµ���)
		InputStreamReader reader = new InputStreamReader(is); //ǥ�� �Է½�Ʈ��(Ű���� or ��Ÿ �Էµ���)
		int data;
		try { //shift+Alt+z 
			while (true) {
				data = reader.read();//1byte �б�  , read()�� Ư¡, �Է��� �Ϸ���� ������ ���Դ����·� �ӹ������� 
				//��, �Է��� �Ǿ�� read() �޼��� ������ ������ ����� �� �ִ�. 
				System.out.println((char)data);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//System.out.println(); // ǥ�� ��� ��Ʈ�� 
	}

}
