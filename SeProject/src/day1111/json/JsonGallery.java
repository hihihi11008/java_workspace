package day1111.json;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonGallery extends JFrame{
	JPanel p_center; //�׸��带 ������ ��� �г� 
	JPanel p_south;//������� ������ �����г� 
	JPanel p_can;//ū �׸��� �׷��� �г� 
	JPanel p_detail;//�󼼳����� ��µ� �г� 
	JLabel []la = new JLabel[4];
	String [] la_title= {"Title","Phase","Category","Release"};

	Image big;//���̹���

//	Thread thread; //�������� URL �̹����� �ε��ϴ� ����, �׷��� ó���� ������ �ǹ�����. �� ������ �ذ��ϱ� ���� 

	public JsonGallery() {
		p_south = new JPanel();
		p_center = new JPanel();
		p_can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(big, 0, 0, p_can);
			}
		};
		p_detail= new JPanel();
		
		for (int i = 0; i < la.length; i++) {
			la[i]=new JLabel(la_title[i]);
			//��Ÿ��
			la[i].setPreferredSize(new Dimension(380, 50));
			la[i].setFont(new Font("Verdana",Font.BOLD,28));
			p_detail.add(la[i]);
		}
		p_center.setLayout(new GridLayout(1,2));//1�� 2ȣ�� �׸��� ���� 
		
		//��Ÿ������ 
		p_center.setBackground(Color.BLUE);
		p_can.setBackground(Color.ORANGE);
		p_detail.setBackground(Color.PINK);
		p_south.setPreferredSize(new Dimension(800, 100));
		p_south.setBackground(Color.green);
		
		//����
		p_center.add(p_can);
		p_center.add(p_detail);
		
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		
		
		setSize(800,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		createThumb();
	}
	
	//��ȭ ����� �����ϱ� 
	public void createThumb() {
		BufferedReader buffr=null;
		try {
			//Ŭ�����н��� �ִ� �ؽ�Ʈ ���� �б� 
			URL url = this.getClass().getClassLoader().getResource("res/data.json");
			URI uri = url.toURI();//URL�� URI�� ���� 
			FileReader reader=new FileReader(new File(uri));
			buffr = new BufferedReader(reader);
			
			StringBuffer sb = new StringBuffer();
			String data = null;
			while (true) {
				data = buffr.readLine();
				if(data==null)break;
				sb.append(data);
			}
			System.out.println(sb.toString());//����� ��Ʈ�� ����غ��� 
			
			//�Ľ� 
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject= (JSONObject)jsonParser.parse(sb.toString());//���ڿ��� �Ұ��ߴ� json ǥ������ڿ��� ���� json��ü�� ��ȯ 
			JSONArray jsonArray = (JSONArray) jsonObject.get("marvel");
			//���� �� �������� ��ġ ��üó�� �����Ͽ� ����� �����ϴ� 
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject obj = (JSONObject) jsonArray.get(i);//��ȭ �����ȯ! 
				
				System.out.println(obj.get("title"));
				System.out.println(obj.get("phase"));
				
				String u= (String)obj.get("url"); 
				String title = (String)obj.get("title"); 
				String phase = (String)obj.get("phase"); 
				String category_name= (String)obj.get("category_name"); 
				String release_year = ((Long)obj.get("release_year")).toString(); 
				
				Movie thumbnail = new Movie(this,90, 90, u, title, phase, category_name, release_year);
				p_south.add(thumbnail);//������ ������� p_south �гο� ���� 				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//�󼼳��� ����ϱ� 
	public void getDetail(Image big,String title, String phase, String category, String release) {
		//�̹���ó��
		this.big = big;
		p_can.repaint();

		//���� ���� ��ȭ���� ���
		la[0].setText(la[0].getText()+" : "+title);
		la[1].setText(la[1].getText()+" : "+phase);
		la[2].setText(la[2].getText()+" : "+category);
		la[3].setText(la[3].getText()+" : "+release);
	}
	public static void main(String[] args) {
		new JsonGallery();
	}
}
