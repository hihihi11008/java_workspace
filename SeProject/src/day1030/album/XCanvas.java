package day1030.album;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//17-1
public class XCanvas extends Canvas{
	//20. //23은닉화 게터세터 
	private Toolkit kit=Toolkit.getDefaultToolkit();
	private Image img;
	private String src;//generic 마우스 오른쪽버튼 Source -> generic getter & setter 클릭 src 클릭


	//18
	public XCanvas(String src) {
		img=kit.getImage(src);//21.  string 경로도 같이 넘기기 
		img=img.getScaledInstance(660, 450, Image.SCALE_SMOOTH);//21이미지크기조정
		setPreferredSize(new Dimension(660, 450));// 중복되는건 상수로 
		setBackground(Color.green);
	}
	//23-1
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		//24.중복된 코드는 메서드로 뺴야하지만 귀찮으니 걍 ...복붙
		img=kit.getImage(src);
		img=img.getScaledInstance(660, 450, Image.SCALE_SMOOTH);
		this.src = src;
	}
	
	//19
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0,this);
	}
}
