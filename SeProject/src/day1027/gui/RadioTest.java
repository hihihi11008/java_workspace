/*
  1) �۾�ũ������ ctrl + (-,+Ű) 
  2) ����Ű ��� ���� ctrl + shift + L
  3) �ڵ�����Ʈ : �ش�Ŭ������ Ŀ�� �÷����� ctrl + shift + O 
  4) �ڵ� �ڵ� ���� :ctrl + shift + F
  5) �ش� ��ü�� api ���� �ٷΰ��� : �ش� Ŭ���� Ŀ�� �ø� �� shift + F2(���Ű) ���ͳ� ������ ������
  6) �ڵ�� �̵��ϱ� : ������ �� Alt + ��,�Ʒ�
  7) �ڵ庹�� : �������� ctrl +Alt+�Ʒ� 
 */
package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �ڹٿ����� üũ�ڽ��� ������ �����
	CheckboxGroup group= new CheckboxGroup();
	
	public RadioTest() {
		setLayout(new FlowLayout());
		this.add(new Checkbox("�", group, false));
		this.add(new Checkbox("����", group, false));
		this.add(new Checkbox("��ȭ", group, false));
		this.add(new Checkbox("������", group, false));
		this.add(new Checkbox("�丮", group, false));
		this.add(new Checkbox("���񺸱�", group, true));
		
		setSize(300, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		System.out.println("����");
		new RadioTest();
	}

}
