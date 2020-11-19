
/*
 	모든 페이지가 공통적으로 가져야할 속성, 메서드 등을 정의하기 위한 최상위 페이지 클래스
 	따라서 Home, Product, Q&A, MyPage, Login등의 페이지들이 
 	이 클래스를 상속받을 경우 코드를 중복해서 작성하지 않아도 된다 
 */
package soomCoProject.main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel{
	MainFrame mainFrame;
	public Page(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setPreferredSize(new Dimension(600,800));
		
	}

}
