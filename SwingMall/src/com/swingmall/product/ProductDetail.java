package com.swingmall.product;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.swingmall.admin.product.ProductVO;
import com.swingmall.cart.Cart;
import com.swingmall.cart.CartVO;
import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class ProductDetail extends Page{
	public JPanel p_content;//�󼼳����� ��Ե� �г� 
	public JPanel p_can;//ū ��ǰ �̹��� �׷��� �г� 
	JPanel p_option; // �ɼ� ���� ����
	JLabel la_brand;
	JLabel la_product_name;
	JLabel la_price;
	
	Choice ch_color;
	Choice ch_size;
	
	JButton bt_buy;
	JButton bt_cart;
	
	private ProductVO vo;
	private Image img;
	
	//�������� ȣ��� ��ǰ 1���� ������ vo�� �׷��� �̹����� img�� ���޹��� 
	public ProductDetail(ShopMain shopMain) {
		super(shopMain);
		
		p_content = new JPanel();
		p_can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, p_can);
			}
		};
		p_option = new JPanel();
		la_brand = new JLabel();
		la_product_name = new JLabel();
		la_price = new JLabel();
		
		ch_color = new Choice();
		ch_size = new Choice();
		
		//����ä��� ,������   (������ db���� ������..�� ����)
		ch_color.add("red");
		ch_color.add("black");
		ch_color.add("white");
		
		ch_size.add("s");
		ch_size.add("m");
		ch_size.add("l");
		
		bt_buy = new JButton("�����ϱ�");
		bt_cart = new JButton("��ٱ���");
		
		//��Ÿ�� 
		p_content.setPreferredSize(new Dimension(ShopMain.WIDTH-100, ShopMain.HEIGHT-200));
//		p_content.setBackground(new Color(204, 133, 154));
		
		Dimension d = new Dimension(shopMain.WIDTH/3,40);
		
		la_brand.setPreferredSize(d);
		la_product_name.setPreferredSize(d);
		la_price.setPreferredSize(d);
		bt_buy.setPreferredSize(new Dimension(200, 30));
		bt_cart.setPreferredSize(new Dimension(200, 30));
		
		ch_color.setPreferredSize(d);
		ch_size.setPreferredSize(d);
		
		
		la_brand.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		la_product_name.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		la_price.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		bt_buy.setBackground(new Color(192, 228, 241));
		bt_cart.setBackground(new Color(172, 208, 192));
		//����
		p_option.add(la_brand);
		p_option.add(la_product_name);
		p_option.add(la_price);
		p_option.add(ch_color);
		p_option.add(ch_size);
		p_option.add(bt_buy);
		p_option.add(bt_cart);
		
		
		p_content.setLayout(new GridLayout(1, 2));
		p_content.add(p_can);
		p_content.add(p_option);
		
		add(p_content);
		
		//��ٱ��� ������ ���� 
		bt_cart.addActionListener((e)->{
			registCart(); //��ٱ��Ͽ� ��ǰ �߰��ϱ�!!!
			
			//��ٱ��Ͽ� ������ ���ٰ� �˷��ְ�, ��ٱ��� �̵� ���θ� Ȯ���ؾ� ��
			int ans=JOptionPane.showConfirmDialog(ProductDetail.this, "��ٱ��Ͽ� ��ǰ�� �����ϴ�.\n��ٱ��Ϸ� �̵��Ͻðھ��?");
			
			if(ans == JOptionPane.OK_OPTION) {
				getShopMain().showPage(ShopMain.CART);
			}
			
		});
	}
	
	//���������� �������� �����͸� ä���ִ� �޼��� ( �����ڿ��� �ϸ� ������ ó���� Ÿ�̹����� ������ ���� )
	public void init(ProductVO vo, Image img) {
		this.vo =vo;//��������� ���� �����ִ� ��ǰ vo�� ���� 
		la_brand.setText(vo.getBrand());
		la_product_name.setText(vo.getProduct_name());
		la_price.setText(Integer.toString(vo.getPrice()));
		this.img = img;
		this.img =this.img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
		
	}
	
	//��ٱ��Ͽ� ��� (DB�� �������� �ʰ�, ���� �޸𸮻����� ������ ���� )
	public void registCart() {
		Cart cartPage =(Cart) getShopMain().getPage()[ShopMain.CART];//��ٱ��� �������� ���� 
		CartVO cartVO = new CartVO();
		
		cartVO.setProduct_id(vo.getProduct_id());//���� ���� �ִ� ��ǰ�� �̿��Ͽ� CartVO�� ä��� 
		cartVO.setBrand(vo.getBrand());
		cartVO.setProduct_name(vo.getProduct_name());
		cartVO.setPrice(vo.getPrice());
		cartVO.setFilename(vo.getFilename());
		cartVO.setDetail(vo.getDetail());
		cartVO.setColor(ch_color.getSelectedItem());//������ ���� 
		cartVO.setSize(ch_size.getSelectedItem());//������ ������
		cartVO.setEa(1);//��ٱ��Ͽ� �������� �⺻�� 1����
		
		cartPage.addCart(cartVO);//��ٱ��Ͽ� ��ǰ 1�� �߰��ϱ� 
		cartPage.getCartList();
	}
	
	public ProductVO getVo() {
		return vo;
	}

	public void setVo(ProductVO vo) {
		this.vo = vo;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
}
