
/*
 	��� �������� ���������� �������� �Ӽ�, �޼��� ���� �����ϱ� ���� �ֻ��� ������ Ŭ����
 	���� Home, Product, Q&A, MyPage, Login���� ���������� 
 	�� Ŭ������ ��ӹ��� ��� �ڵ带 �ߺ��ؼ� �ۼ����� �ʾƵ� �ȴ� 
 */
package com.swingmall.admin;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel{
	private AdminMain adminMain;
	
	
	
	public AdminMain getAdminMain() {
		return adminMain;
	}



	public Page(AdminMain adminMain) {
		this.adminMain = adminMain;
		this.setPreferredSize(new Dimension(adminMain.WIDTH, adminMain.HEIGHT-50));
		
	}

}
