package day1030.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	//String ori="C:/workspace/java_workspace/SeProject/res/data/memo.txt";//������ ��ġ 
	String ori="C:/workspace/java_workspace/SeProject/res/travel2/aa.jpg";//������ ��ġ 	
	String dest="C:/workspace/java_workspace/SeProject/res/data/photo_copy.jpg";//����� ����� ��ġ 
	FileInputStream fis;//������ ������� �� �Է� ��Ʈ�� 
	FileOutputStream fos;//������ ������� �� ��½�Ʈ��
	public FileCopy() {
		//�Ʒ��� �ڵ�� ������ ������ ����, �� ����� ������ ���� ��� ������ ���鼭 ���α׷��� ����������� �� �ִ� ����� �ִ�. 
		//���� sun������ �̷��� ����� ���� ó���� ����ó���� �����ϰ� �ִ� 
	 try {
		fis= new FileInputStream(ori);//��Ʈ������
		System.out.println("��Ʈ�� ���� ����! ");
		fos = new FileOutputStream(dest); //���� ��½�Ʈ���� ,������ ��η� ����ִ�(empty) ������ �������� 
		//��Ʈ�� ������ �����Ǿ����Ƿ�, �����͸� �� ����Ʈ�� �о �ٸ� ��� �ִ� ���Ͽ� ����غ���
		int data;
		while(true) {
			data=fis.read();//1byte �б� (���� ���ñ�)
			System.out.println(data);
			if(data==-1)break;
			fos.write(data); //1byte ���� (�����)
		}
		System.out.println("����ó���� �Ϸ��Ͽ����ϴ�.");
	} catch (FileNotFoundException e) {
		System.out.println("������ ã�� �� �����ϴ�. ");//���ø��ɾ�� ����ڸ� ���� �޽���
		e.printStackTrace(); //�����ڰ� ���κм��� �ϱ� ���� ��³��� 
	}catch(IOException e){
		System.out.println("������ ���� �� ��� ");
		e.printStackTrace();
	}finally {
		if(fis !=null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(fos !=null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
	public static void main(String[] args) {
		new FileCopy();
	}
}
