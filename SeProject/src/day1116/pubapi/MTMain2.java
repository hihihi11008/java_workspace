package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MTMain2 extends JFrame{

	/*���ʿ��� */
	JPanel p_west; 
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
	//�� ���켼��, tablemodel���� �����ҰŴϱ��
	JTable table;
	/*JTable ���� �����ϴ� Vector����� 2�����迭���ٴ� ���������� 
	   ������ 2�����迭�� ������ �����ϹǷ�, TableModel�� �̿��� ���� �� VO�� �����ؼ� �����غ��ڽ� 
	 * */
	MountainModel model;
	JScrollPane scroll;
	
	//��������� �ļ� �����ϱ� 
	String apiKey="Wwz6NBYYF7uY53T7ctZyyrXgJkBteQ%2F7VIaVyH%2BbpxON8dt5oAiKyvRg5NcTOL8ichbKiHn34jvY7fq7usy70g%3D%3D";
	SAXParserFactory factory;
	SAXParser saxParser;
	Thread loadThread;//��Ʈ��ũ�󿡼� xml�ҷ��ö� ��� 
	InputStream is;//xml�����͸� ��� �ִ� ��Ʈ�� 
	MountainHandler mountainHandler;
	
	HttpURLConnection conn;
	BufferedReader rd;
	/*
	 * JTable���� ������ ������ ���ݱ����� ������ �迭�� ��Դµ�, ��� ������ �迭�� 
	 * ������ ũ�⸦ ���ؾ� �ϱ� ������ ������ ���� �����ϴ�.
	 * ( �����޴� ��: rs.last()  ��  rs.getRow()�� ������ �� �� ���ϰ�,�ٽ� Ŀ���� ���󺹱� ��Ŵ..������)
	 * �����Ͻ�? ���� ����
	 * ���� �÷��� �����ӿ��� Vector�� �����ϴ� �����ڸ� �̿��غ��ô�!!
	 * */
	
	public MTMain2() {
		//����
		p_west = new JPanel();
		t_name = new JTextField();
		t_op1 = new JTextField();
		t_op2 = new JTextField();
		t_op3 = new JTextField();
		bt = new JButton("�˻��ϱ�");

		//���̺���� �̿��� ���߹������ ��	
		table = new JTable(model = new MountainModel()); 
		scroll = new JScrollPane(table);
		
		//�����ڿ��� �����带 �����͸����� ó�� 
//		loadThread = new Thread() {
//			public void run() {//��ư�� ������ �̾����带 ȣ���� 
//				loadXML();
//			}
//		};
		
		//��Ÿ�� ���� 
		p_west.setPreferredSize(new Dimension(200, 600));
		p_west.setBackground(Color.WHITE);
		t_name.setPreferredSize(new Dimension(190, 30));
		t_op1.setPreferredSize(new Dimension(190, 30));
		t_op2.setPreferredSize(new Dimension(190, 30));
		t_op3.setPreferredSize(new Dimension(190, 30));
		
		//���� 
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		//��ư�� ������ ���� 
		bt.addActionListener((e)->{
			//��Ʈ��ũ�� Ÿ�� �����͸� �����ö� ���ξ����忡�� ���� �ϴ� 
			loadThread = new Thread() {
				public void run() {//��ư�� ������ �̾����带 ȣ���� 
					loadXML();
				}
			};
			loadThread.start();//xml�ε� ������ ȣ�� 
		});
		
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	//
	public void loadXML() {
		try {
			StringBuilder urlBuilder = new StringBuilder("http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+apiKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("mntnNm","UTF-8") + "=" + URLEncoder.encode(t_name.getText(), "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnHght","UTF-8") + "=" + URLEncoder.encode(t_op1.getText(), "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnAdd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoAraCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoSsnCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoThmCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			URL url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			    rd = new BufferedReader(new InputStreamReader(is=conn.getInputStream()));
			} else {
			    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			//�Ʒ��� �ڵ�� ȭ�鿡 ����ϱ� ���� �ڵ��̹Ƿ�, �׽�Ʈ�� ������ �����ؾ��Ѵ� 
			//����? read�� ���⼭ �ع����� ������ ���ο����� ��Ʈ���� ���� �����ϰ� �ǹǷ� �� ������� ��������Ƿ� 
//			StringBuilder sb = new StringBuilder();
//			String line;
//			while ((line = rd.readLine()) != null) {
//			    sb.append(line);
//			}
			
			//����� �ҷ��� ������ sb�� �ֿܼ� ����غ��ô� 
			//System.out.println(sb.toString());
			
			parseData();// �̽������� �Ľ̽��� 
		
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (rd!=null) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
			if (conn!=null) conn.disconnect();				
		}
	}
	//�������������� api�� �޸𸮻󿡼� �ҷ��ͼ� ó���ؾ��Ѵ� 
	//�׷��� parsing�Ҷ� �����ε� �� �޼��带 �� �����ؾ��Ѵ� 
	public void parseData() {
		factory=SAXParserFactory.newInstance();//���丮 ��ü���� (�̰�ü�� �־�� �ļ��� ������)
		try {
			saxParser=factory.newSAXParser();//�ļ�����
			saxParser.parse(is, mountainHandler=new MountainHandler());
			
			//�Ľ��� ������ TableModel�� ���Ͱ�ü�� �Ľ��� ����� ���� ���ͷ� ��ü�ع����� �ȴ� 
			model.data=mountainHandler.mtList;
			table.updateUI();//���̺� ���� 
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new MTMain2();
	}

}

