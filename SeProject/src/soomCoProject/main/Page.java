
/*
 	��� �������� ���������� �������� �Ӽ�, �޼��� ���� �����ϱ� ���� �ֻ��� ������ Ŭ����
 	���� Home, Product, Q&A, MyPage, Login���� ���������� 
 	�� Ŭ������ ��ӹ��� ��� �ڵ带 �ߺ��ؼ� �ۼ����� �ʾƵ� �ȴ� 
 */
package soomCoProject.main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel{
	MainFrame mainFrame;
	public Page(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setPreferredSize(new Dimension(600,800));
		
	}

}
