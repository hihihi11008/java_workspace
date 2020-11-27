package com.swingmall.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.swingmall.admin.product.RegistForm;
import com.swingmall.home.Home;
import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Login extends Page{
	JPanel p_content;
	JTextField t_id;
	JPasswordField t_pass;
	JButton bt_login;
	JButton bt_regist;
	   
	public Login(ShopMain shopMain) {
		super(shopMain);
		p_content = new JPanel();
		t_id = new JTextField();
		t_pass = new JPasswordField();
		bt_login = new JButton("Login");
		bt_regist = new JButton("ȸ������");
		  
		//��Ÿ��
		p_content.setPreferredSize(new Dimension(300,125));
		p_content.setBackground(Color.white);
		t_id.setPreferredSize(new Dimension(280,25));
		t_pass.setPreferredSize(new Dimension(280,25));
		  
		//����
		p_content.add(t_id);
		p_content.add(t_pass);
		p_content.add(bt_login);
		p_content.add(bt_regist);
		  
		add(p_content);
		
		//���̵� ������Ʈ�� ��Ŀ���ø��� 
//		t_id.requestFocus();
		  
		//ȸ������ ��ư�� ������ ���� 
		bt_regist.addActionListener((e)->{
			getShopMain().showPage(ShopMain.MEMBER_REGIST);
		});
		  
		//�α��� ��ư�� ������ ���� 
		bt_login.addActionListener((e)->{
			ShopMember vo = new ShopMember();
			vo.setMid(t_id.getText());
			vo.setPass(new String(t_pass.getPassword()));
			validCheck(vo);
			
		});
		 //Ű���� ������ ����
	      t_id.addKeyListener((KeyListener) new KeyAdapter() {
	         public void keyReleased(KeyEvent e) {
	            if(e.getKeyCode()==KeyEvent.VK_ENTER) {//����ġ��..
	               ShopMember vo = new ShopMember();
	               vo.setMid(t_id.getText());
	               vo.setPass(new String(t_pass.getPassword()));
	               
	               validCheck(vo);               
	            }
	         }
	      });
	      t_pass.addKeyListener(new KeyAdapter() {
	         public void keyReleased(KeyEvent e) {
	            if(e.getKeyCode()==KeyEvent.VK_ENTER) {//����ġ��..
	               ShopMember vo = new ShopMember();
	               vo.setMid(t_id.getText());
	               vo.setPass(new String(t_pass.getPassword()));
	               
	               validCheck(vo);               
	            }
	         }
	      });
	}
	
	//��ȿ�� üũ (�Է����� ���� �ʵ尡 �ִ��� ���ο� ���� �ǵ�� 
	public void validCheck(ShopMember shopMember) {
		if (shopMember.getMid().length()<1) {//���ڿ��� ���̰� 0�̶��
			JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���");
			//return;//������� �޼��� ������ ���´� 
		}else if (shopMember.getPass().length()<1) {
			JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
			//return;//������� �޼��� ������ ���´� 			
		}else {
			if (login(shopMember)==null) {
				JOptionPane.showMessageDialog(this, "�α��������� �ùٸ��� �ʽ��ϴ�");
			}else {
				JOptionPane.showMessageDialog(this, "�α��� ����");
				getShopMain().showPage(ShopMain.HOME);
				getShopMain().navi[4].setText("logout");
				getShopMain().navi[4].setBackground(Color.DARK_GRAY);
				getShopMain().navi[4].setForeground(Color.white);
				
			}			
		}
	}
	//ȸ�� �α��� ó�� �޼��� ����:�α��� ���� �� Home�� ������ ������
	//�Ʒ��� �޼��尡 ShopMember�� ��ȯ�ϹǷ� ���� �α��� �����ϰ�� 
	//null����ȯ
	public ShopMember login(ShopMember shopMember) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		ShopMember vo=null;//�α��� ���� �� ȸ���� ��� ������ ��Ե� VO

		String sql = "select * from shop_member";
		sql+=" where mid=? and pass=?";
		try {
			pstmt = getShopMain().getCon().prepareStatement(sql);
			pstmt.setString(1, shopMember.getMid());
			pstmt.setString(2, shopMember.getPass());
			rs=pstmt.executeQuery();
			
			//rs.next() �� ���̸� ȸ���� �����ϴ� ���̹Ƿ� �α������� ���� 
			if (rs.next()) {
				vo = new ShopMember();
				vo.setMember_id(rs.getInt("member_id"));
				vo.setMid(rs.getString("mid"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getShopMain().getDbManager().close(pstmt, rs);	
		}
		return vo;
	}
	
	//�α׾ƿ� ó�� 
	//1.hasSession�� ���� false 2.��ư�� ���� ���� 3.��ư�� �ؽ�Ʈ login���� 
	public void logout() {
		getShopMain().setHasSession(false);
		getShopMain().navi[4].setText("login");
		getShopMain().navi[4].setBackground(null);
		getShopMain().navi[4].setForeground(null);
		getShopMain().showPage(ShopMain.HOME);
	}
}