package event;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MyMouse1 implements MouseListener{
	public void mouseClicked(MouseEvent e){
		System.out.println("클릭하면 mouseClicked called...");
	}
	public void mousePressed(MouseEvent e){
		//System.out.println("mousePressed called...");
	}
	public void mouseReleased(MouseEvent e){
		//System.out.println("mouseReleased called...");
	}
	public void mouseEntered(MouseEvent e){
		//System.out.println("mouseEntered called...");
	}
	public void mouseExited(MouseEvent e){
		//System.out.println("mouseExited called...");
	}
}

