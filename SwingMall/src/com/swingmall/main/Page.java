
/*
 	��� �������� ���������� �������� �Ӽ�, �޼��� ���� �����ϱ� ���� �ֻ��� ������ Ŭ����
 	���� Home, Product, Q&A, MyPage, Login���� ���������� 
 	�� Ŭ������ ��ӹ��� ��� �ڵ带 �ߺ��ؼ� �ۼ����� �ʾƵ� �ȴ� 
 */
package com.swingmall.main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel{
	ShopMain shopMain;
	public Page(ShopMain shopMain) {
		this.shopMain = shopMain;
		this.setPreferredSize(new Dimension(shopMain.WIDTH, shopMain.HEIGHT-50));
		
	}

}
