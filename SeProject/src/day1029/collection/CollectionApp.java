/*
 Collection Framework(���������� ��ü���� ������� �Ѵ�. )
 -�ڹپ����� ��ü�� ��Ƽ� ó���Ҷ� ������ api�� �����ϴµ� 
 	�� api�� ������ �÷��� �����ӿ��̶� �Ѵ�, �׸��� java.util���� �����Ѵ� 
   - �÷��� �����ӿ����� �����ϴ� ��ü���� ����� ����� ������ ũ�Դ� ���� ����� ���� 
   1) �����ִ� ���� List�� : �迭�� ���ǰ��� !! 
   								�ڹ��� �迭�� ���̰� �ִٸ� 
   								�迭 : 1.�ݵ�� �����Ҷ� ũ�⸦ ������ �Ѵ�. ���� �������� �þ �� ���� (������ )
   								 		2.�ڷ����� ���� ����� �� ���� 
   								 		ex) int[] arr = new int[5];//���� int���� ���� �� �ִ�. 
   								 ����Ʈ : ũ�Ⱑ �����Ӵ�, ��ü �ڷ����� ��� ���� �� �ִ�. 
   2) �������� ���� Set�� :
   3) key-value �� ���� Map�� :
 
 */
package day1029.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.swing.JButton;


public class CollectionApp {
	//List���� �׽�Ʈ�غ��� 
	private void showList() {
		//List ���� �ֻ�����ü�� List�� �������̽��̸�, List�� �⺻������ �������� �߻�޼��尡 ��õǾ� �ִ�.  
		//Generic Type ���� �����ϸ� �÷��� �����ӿ��� ���� �� �ִ� �ڷ����� ������ �� �ִ�. 
		ArrayList<JButton> list= new ArrayList<JButton>(); //����Ʈ �������� �迭�� ���� ���� ! 
		//js�� �迭�� ���� :���۹���� 
		list.add(new JButton("ù��ư"));
//		list.add("���");
//		list.add("������");
//		list.add("���");
		list.add(new JButton("������ ��ư"));
		System.out.println("����Ʈ�� ������ ����"+list.size());//�迭�� length���� ,�÷��� �����ӿ��� ��� size()�̿� 
		
		for(int i=0;i<list.size(); i++) {
			JButton bt1 = list.get(i);//��� ���Ƿ�, ��ȯ���� ������ �� ���⶧���� Object���� ��ȯ�ȴ� 
			System.out.println(bt1.getText());
		}
		//����Ʈ�� �ߺ��� �����͸� ����ұ�?
		//��� : �ߺ����δ� ������ �ʰ� ����Ѵ� .
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("apple");
		list2.add("apple");
		list2.add("apple");
		System.out.println("list2�� ������ ���� "+list2.size());
	}
	
	private void showSet() {
		HashSet<String> set = new HashSet<String>();
		set.add("banan");
		set.add("banan");
		set.add("banan");
		set.add("banan");
		System.out.println("HashSet�� ũ��� "+set.size());
		//��� : �ȶ�! �ߺ��� �����ʹ� �޾Ƶ����� ����
		HashSet<String> set2 = new HashSet<String>();
		set2.add("�ٳ���");
		set2.add("����");
		set2.add("��纣��");
		//�ݺ������� set2�� ��� �����͸� ���! 
		Iterator<String> it=set2.iterator();
		while(it.hasNext()) { //��Ұ� �����ϴ��� �Ǵ�, true�ε��� while �� ���� 
			String e=it.next(); //������ҹ�ȯ 
			System.out.println(e);
		};
	}
	private void showMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("k1", "���");
		map.put("k2", "ƫ��");
		map.put("k3", "�Ȱ���");
		//map.put("k3", "�ҹ̲�");
		System.out.println("map�� ���̴� " +map.size());
		//��� : key���� �ߺ��� ������� �ʴ´� ���� ��ü�Ǿ� ������ 
		
		//�ݺ����� �̿��� map�� ��� �����͸� ��� 
		Set<String> keySet = map.keySet();// key�� ���� �����Ѵ� 
		//�׸��� set�� Iterator�� �����ϹǷ�, key�� �Ϸķ� �þ�߸��� 
		Iterator<String> keyIter = keySet.iterator();
		while(keyIter.hasNext()) {
			String key=keyIter.next();
			String value= map.get(key); 
			System.out.println(value);
		}
		
	}
	public static void main(String[] args) {
		CollectionApp app = new CollectionApp();
		app.showList();
		app.showSet();
		app.showMap();
		
	}
}
