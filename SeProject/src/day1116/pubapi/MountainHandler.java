/*SAX Parsing �� ��� node(���, �ؽ�Ʈ �� xml�� �̷�� ��ҵ��� ������) ���� 
 * �̺�Ʈ�� �߻������ִ� ��ü 
 * */
package day1116.pubapi;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	//�߰ߵǴ� ���� ������ VO�� ������, �� vo�� ��Ե� ���� 
	Vector<Mountain> mtList;
	Mountain mt;// ���� ����1���� �ӽ������� ���� �� �ִ� ���� 
	
	//�������ΰ� �����ġ ���������� �˱� ���� ���� 
	boolean isMntnid;
	boolean isMntnnm;
	boolean isMntninfopoflc;
	boolean isMntninfohght;
	
	//xml������ ���۵ɶ� ȣ��Ǵ� �޼��� 
	public void startDocument() throws SAXException {
	}
	
	//�����±׸� ������ ȣ��Ǵ� �޼��� 
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.println("<"+tag+">");//�����±�
		 
		if (tag.equals("items")) {
			mtList = new Vector<Mountain>();			
		}else if (tag.equals("item")) {
			mt = new Mountain();  
		}else if (tag.equals("mntnid")) {
			isMntnid=true;
		}else if (tag.equals("mntnnm")) {
			isMntnnm = true;
		}else if (tag.equals("mntninfopoflc")) {
			isMntninfopoflc = true;
		}else if (tag.equals("mntninfohght")) {
			isMntninfohght=true;
		}
	}
	
	//�±׻����� �ؽ�Ʈ�� ������ ȣ��Ǵ� �޼��� 

	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);
//		System.out.print(data);
		if (isMntnid) {
			mt.setMntnid(Integer.parseInt(data));
		}else if (isMntnnm) {
			mt.setMntnnm(data);
		}else if (isMntninfopoflc) {
			mt.setMntninfopoflc(data);
		}else if (isMntninfohght) {
			mt.setMntninfohght(Integer.parseInt(data));
		}
	}
	
	//�ݴ� �±׸� ������ ȣ��Ǵ� �޼��� 
	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.println("</"+tag+">");
		if (tag.equals("item")) {
			mtList.add(mt);
		}else if (tag.equals("mntnid")) {
			isMntnid=false;
		}else if (tag.equals("mntnnm")) {
			isMntnnm = false;
		}else if (tag.equals("mntninfopoflc")) {
			isMntninfopoflc =false;
		}else if (tag.equals("mntninfohght")) {
			isMntninfohght=false;
		}
	}
	public void endDocument() throws SAXException {
		for(Mountain obj : mtList) {
			System.out.println("�������ȣ : "+obj.getMntnid());
			System.out.println("���̸� : "+obj.getMntnnm());
			System.out.println("���ּ� : "+obj.getMntninfopoflc());
			System.out.println("����� : "+obj.getMntninfohght());
			System.out.println("--------------------------------------------------------------");
		}
	}
	
}
