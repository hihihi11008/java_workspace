/*
 * xml�� ��� ��忡�� �̺�Ʈ�� �߻��Ҵ븶�� �Ʒ��� �ڵ鷯 ��ü�� �޼��带 
 * �˸°� �������̵��ϸ� �� 
 * */
package day1113.xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class MyHandler  extends DefaultHandler{
	ArrayList<Pet> petList=new ArrayList<Pet>(); 
	Pet pet;
	
	boolean isType;
	boolean isName;
	boolean isAge;
	boolean isGender;
	
	//������ ���۵Ǹ�ȣ��� 
	public void startDocument() throws SAXException {
		System.out.println("�����ؿ� ");
	}
	//�����±� �������� ȣ��� <�±�>
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.print("<"+tag+">");
		
		//�����±� �� pets�� ������ ArrayList�� �������� 
		if (tag.equals("pets")) {
			petList = new ArrayList<Pet>();
		}else if (tag.equals("pet")) {//�ϳ��� pet �ν��Ͻ� ������ Ÿ���̴� 
			pet=new Pet();
		}else if (tag.equals("type")) {//
			isType=true;//���� �±׸� ���� �������� ������ �˷����� 
		}else if (tag.equals("name")) {// 
			isName=true;
		}else if (tag.equals("age")) {// 
			isAge=true;
		}else if (tag.equals("gender")) {// 
			isGender=true;
		}
	}
	
	
	//�±׿� �±׻����� �����͸� �������� ȣ�� 
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data=new String(ch,start,length);
		System.out.print(data);
		
		if (isType) {//���� �����±� �� �ֱ��� �����±װ� �������~~~ ,�ݷ������� ������ �����ϸ� 
			pet.setType(data);			
		}else if (isName) { //�ݷ������� �̸��� �����ϸ�
			pet.setName(data);			
		}else if (isAge) {
			pet.setAge(Integer.parseInt(data));
		}else if (isGender) {
			pet.setGender(data);
		}
		
	}
	//�ݴ� �±׸� �������� ȣ�� </�±�>
	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.println("</"+tag+">");
		
		if (tag.equals("pet")) {//�� ������ �ϳ��� pet�� �ϼ��Ǵ� �����̹Ƿ�, ����Ʈ�� ��Ƶ��� 
			petList.add(pet);
			//����ΰ� �������� �ִ� ��ġ�� �˷��ִ� ��� �������� �ʱ�ȭ
		}else if (tag.equals("type")) {//���� �����±� �� �ֱ��� �����±װ� �������~~~ ,�ݷ������� ������ �����ϸ� 
				isType=false;		
		}else if (tag.equals("name")) { //�ݷ������� �̸��� �����ϸ�
			isName=false;
		}else if (tag.equals("age")) {
			isAge=false;
		}else if (tag.equals("gender")) {
			isGender=false;
		}

	}
	//������ ������ȣ�� 
	public void endDocument() throws SAXException {
		System.out.println("������ �����մϴ�");
		System.out.println("������� : �� "+petList.size()+"�� �����մϴ�.");
		
		for(Pet pet : petList) {
			System.out.println("type : " + pet.getType());
			System.out.println("name : " + pet.getName());
			System.out.println("age : " + pet.getAge());
			System.out.println("gender: " + pet.getGender());
		}
	}
}
