
/*
 * �� Ŭ������ ������ ������ �ƴϰ�, ���� ��ٱ��� ���������� ���뼺�� ���� 
 * ��ǰ �������� �����ϱ� ���� Ŭ������!!
 * */
package com.swingmall.cart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.swingmall.main.ShopMain;

import common.image.ImageUtil;

public class CartItem extends JPanel{
	JPanel p_can; //��ǰ �̹��� 
	JPanel p_info; //�󺧵��� ��ġ�� �׸��� �г� (3,1)
	JLabel la_brand,la_product_name, la_price;
	JLabel la_ea;//���� 
	JTextField t_ea;
	JButton bt_update;//�������� ���� ��ư
	JButton bt_del;//��ٱ��Ͽ��� ����
	Image image;
	
	public CartItem(CartVO cartVO) {
		image=ImageUtil.getCustomSize(ImageUtil.getImageFromURL(cartVO.getFilename()) , 100,85);
		
		p_can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, p_can);
			}
		};
		
		p_info = new JPanel();
		la_brand = new JLabel(cartVO.getBrand());
		la_product_name = new JLabel(cartVO.getProduct_name());
		la_price = new JLabel(Integer.toString(cartVO.getPrice()));
		la_ea = new JLabel("����");
		t_ea = new JTextField(Integer.toString(cartVO.getEa()) ,4);
		bt_update = new JButton("���� ����"); 
		bt_del = new JButton("  X  "); 
		
		//��Ÿ��
		this.setPreferredSize(new Dimension(ShopMain.WIDTH-350, 115));
		this.setBackground(Color.YELLOW);
		p_can.setPreferredSize(new Dimension(100, 85));
		p_info.setPreferredSize(new Dimension(400, 100));
		p_info.setBackground(Color.WHITE);
		
		la_ea.setPreferredSize(new Dimension(40, 25));
		t_ea.setPreferredSize(new Dimension(100, 25));
		bt_update.setBackground(Color.BLUE);
		bt_update.setForeground(Color.YELLOW);
		bt_del.setBackground(Color.BLUE);
		bt_del.setForeground(Color.YELLOW);
		
		//���� 
		p_info.setLayout(new GridLayout(3,1));
		this.add(p_can);
		p_info.add(la_brand);
		p_info.add(la_product_name);
		p_info.add(la_price);
		this.add(p_info);
		this.add(la_ea);
		this.add(t_ea);
		this.add(bt_update);		
		this.add(bt_del);		
		
		p_can.repaint();
		
		
	}
	
}