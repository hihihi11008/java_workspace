/*SAX Parsing 시 모든 node(요소, 텍스트 등 xml을 이루는 요소들을 일컬음) 마다 
 * 이벤트를 발생시켜주는 객체 
 * */
package day1116.pubapi;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	//발견되는 산이 있을떄 VO로 생성후, 그 vo를 담게될 벡터 
	Vector<Mountain> mtList;
	Mountain mt;// 산의 정보1건을 임시적으로 담을 수 있는 변수 
	
	//현재실행부가 어느위치 지났는지를 알기 위한 변수 
	boolean isMntnid;
	boolean isMntnnm;
	boolean isMntninfopoflc;
	boolean isMntninfohght;
	
	//xml문서가 시작될때 호출되는 메서드 
	public void startDocument() throws SAXException {
	}
	
	//시작태그를 만날때 호출되는 메서드 
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.println("<"+tag+">");//시작태그
		 
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
	
	//태그사이의 텍스트를 만날때 호출되는 메서드 

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
	
	//닫는 태그를 만날때 호출되는 메서드 
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
			System.out.println("산고유번호 : "+obj.getMntnid());
			System.out.println("산이름 : "+obj.getMntnnm());
			System.out.println("산주소 : "+obj.getMntninfopoflc());
			System.out.println("산높이 : "+obj.getMntninfohght());
			System.out.println("--------------------------------------------------------------");
		}
	}
	
}
