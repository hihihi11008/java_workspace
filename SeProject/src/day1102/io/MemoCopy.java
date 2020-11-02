/*
 �����ֿ��� ��������(����)�� ���̳ʸ� ����(����)���� �����غ��Ҵ�. 
 ������, ���������� ��� �ѱ��� ���� ������ � ����� �������� �׽�Ʈ�غ��� 
 
 [��Ʈ���� ����]
 ��Ʈ���� �⺻�� 1byte�� ó���ϴ� ����Ʈ ����� ��Ʈ���̴�. 
 ������, ��Ʈ�������� �帣�� �����͸� ���ڷ� �ؼ��� �� �ִ� ��Ʈ���� ���ڱ�� ��Ʈ���̶� �Ѵ�. 
 ���ڱ�� ��Ʈ���� ���̾ ~Reader, ~Writer�� ������. 
 */

package day1102.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemoCopy {
	FileInputStream fis;
	FileOutputStream fos;
	
	FileReader reader; //������ ������� �� ���ڱ���� �Է½�Ʈ�� 
	FileWriter writer; // ������ ������� �� ���ڱ���� ��½�Ʈ�� 
	
	String path="C:/workspace/java_workspace/SeProject/res/data/text.txt";
	String path2="C:/workspace/java_workspace/SeProject/res/data/text2.txt";
	public MemoCopy() {
		try {
			//fis =new FileInputStream(path);
			//fos =new FileOutputStream(path2); //���� ��½�Ʈ���� �������� �����ϴ� Ư¡�� �ִ�. 
			reader = new FileReader(path);
			writer = new FileWriter(path2);
			//�ѹ���Ʈ�� �о���̸鼭 ������ �ѱ��� ��� �Ǵ��� ����
			//���: FileInputStream�� ����Ʈ����� ��Ʈ���̹Ƿ� 1byte�� �� �ؼ��� �� �ִ�. 
			//���� �ѱ��� ��� 2byte�� �����Ǿ� �����Ƿ�, ����� �����ϰ�����, ��Ʈ���󿡼� �帣�� �����͸� 
			//�ѱ۷� ������ �Ҷ��� ������ ���� �� �ۿ� ���� .
			int data; // �� ��
			while(true) {
			data = reader.read(); //fis�� �ƴ϶� reader�� �޼��� ȣ���ؾ���
			if(data==-1)break;
			System.out.println((char)data);
			writer.write(data);// <--fos�� �ƴ϶� writer�� �޼��� ȣ���ؾ���
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new MemoCopy();
	}
}
