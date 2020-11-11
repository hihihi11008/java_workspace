package day1111.json;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class Movie extends JPanel implements Runnable{
	Image big;//������ ū�̹���
	Image img;//����Ϸ� �׷��� �̹��� 
	BufferedImage buffImg;
	int width;
	int height;
	Thread thread;
	JsonGallery jsonGallery;
	
	//�� ��ü�� ������ ��ȭ�� ǥ���ϴ� Ŭ�����̴�. 
	String url;
	String title;
	String phase;
	String category_name;
	String release_year;
	
	
	public Movie(JsonGallery jsonGallery,int width, int height, String url, String title, String phase, String category_name, String release_year) {
		this.jsonGallery = jsonGallery;
		this.width=width;
		this.height = height;
		this.url = url;
		this.title=title;
		this.phase = phase;
		this.category_name = category_name;
		this.release_year=release_year;
		
		this.setPreferredSize(new Dimension(width, height));
		
		thread = new Thread(this);//Runnable�� ������ ��ü�� �μ��� �־��ش� 
		thread.start();//������ ���ÿ� ������ ���� 
		
		//�����ʿ� ���� �гΰ� ���� 
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("Ŭ���� ���� ��ȭ ������?" + title);
				jsonGallery.getDetail(big, title, phase, category_name, release_year);
			}
		});
		
	}
	
	public void getErrorImage() {
		URL url = this.getClass().getClassLoader().getResource("res/error.png");
		try {
			BufferedImage buffImg =ImageIO.read(url);
			img = buffImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

	public void run() {
		//1.�̹����� ���� �ϵ忡 ���� ��� Toolkit�� ��� 
		//2.�̹����� Ŭ�����н��� �� ��Ű���� ���� ��� ClassLoader()�� �̿� 
		//3.BufferedImage > ImageIO
		try {
			URL path = new URL(url);
			buffImg = ImageIO.read(path);
			big=buffImg.getScaledInstance(400, 600, Image.SCALE_SMOOTH);
			img=buffImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			
			jsonGallery.p_south.updateUI();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�̹����� ã�� �� ���׿� ");
			getErrorImage();
		}
	}
}
