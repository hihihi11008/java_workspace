/*�ܺ��� �����͸� �������� ��� ��κ� XML, JSON ������ �������̴�. 
 * ���� �ڹٰ����ڴ� �ڹ� ���� xml, json���� �����͸� �ؼ�, �м�(�Ľ�:parsing)�� �� �ִ� �ɷ��� �ʿ��ϴ� 
 * */
package day1111.json;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONControl {
	public static void main(String[] args) {
		//�ڹ� ��� ���������δ� json ǥ����� ������ �� ����. �߸��� �������� �����Ѵ� 
		//���ڿ��� ó���ؾ��Ѵ� 
		
		//StringBuffer�� �������� ? String�� �Ҹ��� Ư¡�� �����Ƿ�, �ʹ� ���� ���ڿ� ����� ������ �ʱ�����
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"name\":\"GABI\"");
		sb.append("}");
		
		//sb�� ����� ǥ��� ���� json��ü�¾ƴϹǷ�, �Ľ̴ܰ踦 ���� json��ü�� ��ȯ�ؾ��Ѵ� 
		//JSON. �ļ��� �ڹ� ��ü������ �������� �����Ƿ� �ܺ� ���̺귯���� �̿��Ͽ� �Ľ̾����� �õ����� 
		//�ڹٰ��ߺоߴ� �ַ� ������(���¼ҽ� ����)�� �ܺ� ���̺귯���� ����ġ��ܿ��� ��Ǵ� maven ����Ʈ�� �̿��Ѵ�
		JSONParser jsonParser = new JSONParser(); //������ �м��ϴ� �ļ���ü ���� 
		try {
			JSONObject obj=(JSONObject)jsonParser.parse(sb.toString());//�Ľ̽���! 
			//�Ľ��� �Ϸ�� ���ĺ��ʹ� ���̻� ���ڿ��� �ƴ� json��ü�� ����ϸ� �ȴ� 
			System.out.println(obj.get("name"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
