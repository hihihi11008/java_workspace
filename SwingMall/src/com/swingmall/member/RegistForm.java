package com.swingmall.member;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class RegistForm extends Page{
	JPanel p_content;
	JTextField t_mid;
	JPasswordField t_pass;
	JTextField t_name;
	JTextField t_phone;
	JTextField t_email;
	JButton bt_regist;

	public RegistForm(ShopMain shopMain) {
		super(shopMain);
		
		p_content =new JPanel();
		
		t_mid = new JTextField();
		t_pass = new JPasswordField();
		t_name = new JTextField();
		t_phone = new JTextField();
		t_email = new JTextField();
		
		bt_regist = new JButton("회원가입");
		
		p_content.setPreferredSize(new Dimension(400,350));
		p_content.setBackground(Color.white);
		Dimension d = new Dimension(380, 25);
		t_mid.setPreferredSize(d);
		t_pass.setPreferredSize(d);
		t_name.setPreferredSize(d);
		t_phone.setPreferredSize(d);
		t_email.setPreferredSize(d);
		
		p_content.add(t_mid);
		p_content.add(t_pass);
		p_content.add(t_name);
		p_content.add(t_phone);
		p_content.add(t_email);
		
		p_content.add(bt_regist);
		
		add(p_content);
		
		bt_regist.addActionListener((e)->{
			if(checkId(t_mid.getText())) {
				JOptionPane.showMessageDialog(RegistForm.this, "중복된 아이디입니다\n다른 아이디를 사용하세요");
			}else{
				ShopMember vo= new ShopMember();//empty 상태임 
				vo.setMid(t_mid.getText());
				vo.setPass(new String(t_pass.getPassword()));
				vo.setName(t_name.getText());
				vo.setName(t_phone.getText());
				vo.setName(t_email.getText());
				int result = regist(vo);
				if (result==0) {
					JOptionPane.showMessageDialog(RegistForm.this, "등록실패");
				}else {
					JOptionPane.showMessageDialog(RegistForm.this, "등록성공");
				}
			};
		});
	}
	
	//회원존재 여부 체크
	//반환값이 true이면 회원가입진행 xxxx!!!
	public boolean checkId(String mid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag=false;
		
		String sql="select * from shop_member where mid=?";
		
		try {
			pstmt = getShopMain().getCon().prepareStatement(sql);
			pstmt.setString(1, mid);
			
			rs = pstmt.executeQuery();
			flag=rs.next(); //레코드가 존재하면 true, 아니면 false
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getShopMain().getDbManager().close(pstmt, rs);
		}
		return flag;
	}
	
	//회원등록
	public int regist(ShopMember shopMember) {
		PreparedStatement pstmt=null;
		int result=0;//메서드의 지역변수는 컴파일러가 초기화하지않으므로, 반드시 개발자가 초기화해야한다 
		
		String sql = "insert into shop_member(member_id,mid,pass,name,phone,email)";
		sql+=" values(seq_shop_member.nextval,?,?,?,?,?)";
		
		try {
			pstmt = getShopMain().getCon().prepareStatement(sql);
			pstmt.setString(1, shopMember.getMid());
			pstmt.setString(2, shopMember.getPass());
			pstmt.setString(3, shopMember.getName());
			pstmt.setString(4, shopMember.getPhone());
			pstmt.setString(5, shopMember.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getShopMain().getDbManager().close(pstmt);
		}
		return result;
	}
}
