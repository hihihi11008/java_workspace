/*
 * ��ٱ��� �������� �����Ѵ�
 * */
package com.swingmall.cart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Cart extends Page{
	JPanel bt_container; //��ư�� ������ �����̳�
	JButton bt_pay;//�����ܰ�� ����
	JButton bt_del; //��ٱ��� ����
	
	//��ٱ��� ������ �÷��� �����ӿ� ��ü�� ����
	HashMap<Integer,CartVO> cartList; 
	JPanel p_content;//Cart�� ���� ��Ƽ������, �����۵��� ���� �����̳� �غ��Ѵ� 
	
	
	public Cart(ShopMain shopMain) {
		super(shopMain);
		
		cartList = new HashMap<Integer, CartVO>();
		
		//this.setBackground(Color.BLACK);
		bt_container = new JPanel();
		bt_pay = new JButton("�����ϱ�");
		bt_del = new JButton("��ٱ��� ����");
		
		//��Ÿ��
		bt_container.setPreferredSize(new Dimension(ShopMain.WIDTH, 100));
		bt_container.setBackground(Color.CYAN);
		
		getCartList();
		
		bt_container.add(bt_pay);
		bt_container.add(bt_del);
		add(bt_container, BorderLayout.SOUTH);
		
		bt_del.addActionListener((e)->{
			//�ؽøʿ� ��ϵ� ��ǰ ���� �� ����Ʈ ȣ��
			removeAll();
		});
	}
	
	
	//��ٱ��Ͽ� �ֱ� 
	public void addCart(CartVO vo) { //��ǰ1���� ��ٱ��Ͽ� �߰��ϱ�!!!
		cartList.put(vo.getProduct_id(), vo);  //key�� ���� ����
	}
	//��ٱ��� �����ϱ�
	public void removeCart(int product_id) { //��ǰ1���� ��ٱ��Ͽ��� �����ϱ�
		cartList.remove(product_id);
	}
	
	//��ٱ��� ����
	public void removeAll() { //��� ��ǰ�� ��ٱ��Ͽ���  �����ϱ�
		
	}
	
	//��ٱ��� ���� 
	public void updateCart(CartVO vo) {
		
		CartVO obj = cartList.get(vo.getProduct_id());
		obj=vo;//���� �ؽø��� ������ �ִ� vo�� ã�Ƴ��� �ּҺ��� ����
		//cartList.replace(vo.getEa(), vo);
	}
	
	//��ٱ��� ��� �������� (����: ���� ������ ���� �����̹Ƿ� ���� �Ϸķ� �þ�߷��� �Ѵ�..�� �� ����..)
	public void getCartList() {
		Set<Integer> set = cartList.keySet(); //Ű���� set���� ��ȯ�޴´�..�� ���� �ѹ��� �Ϸķ� �þ�� ���� �ƴ϶�,  set���� ����
																	//key�� �����;� ��
		
		Iterator<Integer> it = set.iterator();
		
		int count=0;
		if (p_content!=null) {
			this.remove(p_content);
		}
		p_content = new JPanel();
		p_content.setPreferredSize(new Dimension(ShopMain.WIDTH-350, 600));
		
		while(it.hasNext()) {//��Ұ� �ִ� ����..
			int key=it.next();//��Ҹ� ����
			CartVO vo=cartList.get(key);
			//�������� ǥ���ϴ� CartItem�� CartVO�� ������ ä������!!
			CartItem item = new CartItem(vo);
			item.bt_del.addActionListener((e)->{
				if (JOptionPane.showConfirmDialog(Cart.this, "��ٱ��Ͽ��� �����Ұž�?")==JOptionPane.OK_OPTION) {
					removeCart(key);
					getCartList();
				}
			});
			item.bt_update.addActionListener((e)->{
				int ea = Integer.parseInt(item.t_ea.getText());//��������
				vo.setEa(ea);//����� ������ vo�� �ݿ��� �Ŀ� ����
				updateCart(vo);
				getCartList();
			});
			p_content.add(item);
			count++;
		}
		add(p_content);
		this.updateUI();
	}
}
