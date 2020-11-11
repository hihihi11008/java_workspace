package day1111.board;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.image.ImageUtil;
import day1111.member.Login;
import day1111.member.RegistForm;



public class BoardApp extends JFrame{
	JPanel p_north;
	JButton bt_board, bt_regist, bt_login;
	JPanel p_center;
	
	JPanel [] pages = new JPanel[5]; //ȭ�� ��ȯ�� ���� �гε��� ��Ե� �迭
	
	//�����? ������ �ʴ� �����Ϳ� �ǹ̸� �ο��Ͽ� �������� ���̱� ���� ����Ѵ� 
	public static final int BOARD_LIST=0;
	public static final int BOARD_WRITE=1;
	public static final int BOARD_DETAIL=2;
	public static final int MEMBER_REGIST=3;
	public static final int MEMBER_LOGIN=4;
	
	public BoardApp() {
		p_north = new JPanel();
		bt_board = new JButton(ImageUtil.getIcon(this.getClass(), "res/board.png", 90, 35));
		bt_regist = new JButton(ImageUtil.getIcon(this.getClass(), "res/registPic.png", 90, 35));
		bt_login = new JButton(ImageUtil.getIcon(this.getClass(), "res/login.png", 90, 35));
		p_center = new JPanel();
		pages[0] = new BoardList(this); //�Խ��Ǹ�������� 
		pages[1] = new BoardWrite(this); //�Խ��Ǳ۾��������� 
		pages[2] = new BoardDetail(this); //�Խ��� �󼼺��� ������ 
		pages[3] = new RegistForm(this); //�Խ��� �󼼺��� ������ 
		pages[4] = new Login(this); //�Խ��� �󼼺��� ������ 
		
	
		
		//��Ÿ�� 
		bt_board.setPreferredSize(new Dimension(90, 35));
		bt_regist.setPreferredSize(new Dimension(90, 35));
		bt_login.setPreferredSize(new Dimension(90, 35));
		
		//���� 
		p_north.add(bt_board);
		p_north.add(bt_regist);
		p_north.add(bt_login);
		
		p_center.add(pages[0]);
		p_center.add(pages[1]);
		p_center.add(pages[2]);
		p_center.add(pages[3]);
		p_center.add(pages[4]);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�Խ��ǹ�ư�� ������ ���� 
		bt_board.addActionListener((e)->{
			setPage(BOARD_LIST);
		});
		
		//���Թ�ư�� ������ ���� 
		//Lambdaǥ���� : �Լ��� ���α׷� ǥ�����̴�  ����)javascript������ ���ٸ� ������� �Ѵ�.
		//�̺�Ʈ ������, �������� �޼��尡 �޶� 1���� ��� ���� , �����͸�Ŭ������� ǥ�⸦ ��â�ϰ� ����� �ʿ䰡 �ִ°�? 
		//����� ������ ǥ����̰������� 
		bt_regist.addActionListener((e)->{
			setPage(MEMBER_REGIST);
		});
		
		//�α��� ��ư�� ������ ���� 
		bt_login.addActionListener((e)->{
			setPage(MEMBER_LOGIN);
		});
		
	}
	
	//�� ���α׷����� ���Ǵ� ��� �������� �����ϴ� �޼��� 
	public void setPage(int showIndex) {//�����ְ� ���� ������ index �Ѱܹ���
		for (int i = 0; i < pages.length; i++) {
			if (i==showIndex) {
				pages[i].setVisible(true);
			}else {
				pages[i].setVisible(false);
			}
		}
	}
	
	public static void main(String[] args) {
		new BoardApp();
	}
}
