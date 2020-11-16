/*
 * java�� xml�� �Ľ��ϴ� ����� ũ�� 2������ �ִ� 
 * 
 * 1)DOM���-html�� ���� ���� 
 * 					��, ��� �±׸��� 1:1 �����ϴ� DOM��ü�� �޸𸮿� �����س��� 
 * 					���α׷��� ���� �ʿ��� ��ü�� �����ϴ� ���
 * 					��) javascript --- DOM 
 * 					���ſ� DOM��ü�� �޸𸮿� ���ϸ� ����ų���ִ�. Ư�� �޸�ũ�Ⱑ pc�� ���� ��������� ���� ����̽��� ���
 * 					DOM����� �����F �Ӹ��ϴ� 
 * 					
 * 2)SAX ���-xml������ �̷�� ������Ʈ, �ؽ�Ʈ ���� ��� ��忡 ���� �̺�Ʈ�� �߻������ִ� ���
 * 					���� �����ڴ� ������ �ڹ��� ��ü���� �޸𸮿� �÷� ,xml �� ����Ͽ� �����͸� ����ϸ� �ȴ� 
 * */

package day1113.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;



public class XMLParseApp {
	//�������� �ڹ����μ����� ���Ͽ� �����ϱ����ؼ��� �����Է½�Ʈ�� �迭�� �ʿ��ϴ� .
	FileInputStream fis;
	InputStreamReader reader;
	BufferedReader buffr;
	URL url; //������ �ִ� ��� 
	URI uri;
	File file;
	
	public XMLParseApp() {
		url= this.getClass().getClassLoader().getResource("res/pets.xml");
		try {
			uri = url.toURI();//File Ŭ������ �����ڿ����� URL�̾ƴ�URI�� ���ϹǷ�, ��ȯ����
			file=new File(uri);
			parseData();//�Ľ̽��� 
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//xml �Ľ��غ��� 
	public void parseData() {
		//SAX����� �ļ��� SAXParserFactory ��ü�κ��� ��´� 
		SAXParserFactory factory;
		factory=SAXParserFactory.newInstance();//static �޼��带 �̿��Ͽ� factory �ν��Ͻ� ����
		try {
			SAXParser saxParser=factory.newSAXParser();//Factory�κ��� �ļ��� �ν��Ͻ��� ���� �� �ִ�. 
			saxParser.parse(file, new MyHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readTest() {
		try {
			fis=new FileInputStream(file=new File(uri));
			//�������� Ȯ���Ҷ� �ѱ��� ���� �� �����Ƿ� Reader�� ���׷��̵�����
			reader=new InputStreamReader(fis);
			//�ѹ��ھ� �о���̸� �ʹ� �ð��� �����ɸ��Ƿ�, ���پ� �о���� �� �ִ� ����ó���� ��Ʈ������ ���׷��̵����� 
			buffr = new BufferedReader(reader);
			//�Ľ��� ���߿� �ϰ�, ���� �츮�� ������ xml�� ����� ��Ʈ������ �о� ���� �� �ִ��� üũ�غ��� 
			String data = null;
			while (true) {
				data = buffr.readLine();
				if (data==null) break;
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new XMLParseApp();
	}
}
