/*
 * �ϳ��� ��ǰ������ ��� ���� �� ������, 
 * ����ڰ� �����ϱ⸦ ���ϴ� ������ ProductVO�� ���������⿡
 * ���� Ŭ������ ProductVO�� ��ӹ޴� �ڽ�Ŭ������ �����ϵ�
 * ea�� �߰��ϸ� �ڵ� ������ �����ϴ�!!
 * */
package com.swingmall.cart;

import com.swingmall.admin.product.ProductVO;

public class CartVO extends ProductVO{
	private int ea;
	private String color;
	private String size;
	
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	


	
}