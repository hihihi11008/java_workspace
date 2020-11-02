package day1102.review;

import java.awt.geom.Path2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class TextBox{
	
	public TextBox() {
//		FileWriter writer;
		BufferedWriter buffw = null;
		BufferedReader buffr = new BufferedReader(new InputStreamReader(System.in));
		URL url=this.getClass().getClassLoader().getResource("res/TextBox.txt");
		String [] pathArr= url.toString().split("file:/");
		String path = pathArr[1];
		File fe= new File(path);
		String str=null;

//		System.out.println(path);
			try {
				buffw=new BufferedWriter(new FileWriter(fe));
				while (true) {
					str=buffr.readLine();
					if(str==null)break;
					buffw.write(str);
					buffw.close();
				}
			}catch (NullPointerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(buffw!=null) {
					try {
						buffw.close();
					} catch (IOException e) {
						e.printStackTrace();
				}
			}		
		}
	}
	
	public static void main(String[] args) {
		new TextBox();
	}
}
