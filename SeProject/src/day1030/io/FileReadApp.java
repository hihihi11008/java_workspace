package day1030.io;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 Stream �̶�? ���ǿ����� �帣�� ���ٱ⸦ �ǹ� 
 					���꿡���� �帧�� ����� ���� �ƴ� �������̴�. 
 					but ���꿡���� �帧�� ���⿡ ���� ������ ���� �з�(������ �������� ���α׷�) 
 					1) �Է�(Input) : �������� ���α׷����� �����Ͱ� �귯���� �� 
 					2) ���(Output) : �������� ���α׷����� �����Ͱ� �귯������ ��
 �ڹٿ����� ����°� ���õ� ��Ű������ java.io�̴�! ���⿡�� ����� ó���� ���� ������ api ������ 


 ���ܶ�? ���α׷��� ������� �Ǿ��� �� ���� �������� ��Ȳ�� �ǹ� (����)
 		�������߻��ϸ�? ���α׷��� ������ ���ᰡ �ǹ�����. 
*/
public class FileReadApp {
	//1. ������ ������� �����͸� �о���̴� FileInputStream�� �н��غ��� 
	FileInputStream fis;

	public FileReadApp(){
		File file=new File("C:/workspace/java_workspace/SeProject/res/data/meo.txt");
		//���û��� ������ ������� ��Ʈ��(��)�� �������� !
		try{//�� ������ ������ �߻��� ���ɼ��� �ִ� �ڵ����� ��� 
			fis=new FileInputStream(file);
			System.out.println("��Ʈ�� ���� �����Դϴ�.");	
			//sun�翡�� �̸�, ���ɼ� �ִ� ������ ��üȭ ���� ���� �� �� �ϳ� 
			//���� ����ߴ� ������ �߻��ϸ�, jvm�� �� FileNotFoundException �ν��Ͻ��� �޸𸮿� �ö���� 
			//catch���� �μ��� �����Ͽ�, �����ڷ� �Ͽ��� ������ ���� ������ �м��� �� �ִ� ��ȸ�� �ִ� ���̴�. 
			//����ó���� ������?? ������ ������ ����!!!!!!!!!!!!!!
			int data;
			while(true){
				data=fis.read();
				if(data==-1)break;
				System.out.print((char)data);
			}
		}catch(FileNotFoundException e){//Ȥ���� ����ߴ� ������ �߻��Ѵٸ� ,������ �������� ����
				//����δ� �� catch�� ���� �����ض�! 
			System.out.println("������ ������ ã�� �� �����ϴ�....");
			e.printStackTrace();//stack ������, ������ ������ ����϶�! 
		}catch(IOException e){
			System.out.println("������ ���� �� ��� ");
			e.printStackTrace();
		}finally {
			//�� ������ try���� �����ϴ�, catch���� �����ϴ� ������ ���ļ� �����ϴ� �����̹Ƿ� 
			//�� ������ �ڿ��� �ݴ� �ڵ带 �ۼ��ؾ��Ѵ� 
			//�ַ� �����ͺ��̽����� �������, ��Ʈ�� ������� 
			if(fis !=null) {//�޸𸮰� �����Ҷ��� 
				//db, stream ������ �ݵ�� null ���θ� �������� ������ ����
				try {
					//null�� ���ƴҶ��� �ݾƶ� 
					fis.close();//��Ʈ���� ���� ������� �� shift+alt+z ����Ű �Ʒ� try/catch block Ŭ�� 
				} catch (IOException e) {
					e.printStackTrace();
				}			
			}
		}
	}
	public static void main(String[] args){
		new FileReadApp();
	}
}
