/*데이터간 구조화된 */
package day1117.db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;





public class TreeApp extends JFrame{
	JTree tree;
	JTree brench;
	JScrollPane scroll;
	
	public TreeApp() {
		//트리에 보여질 노드를 구성해보자 
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("엑세서리");
		DefaultMutableTreeNode brenchs = new DefaultMutableTreeNode("상품정보 ");
		createNode(top); //반지 목걸이 귀걸이 팔찌를 부착할 예정임
		tree = new JTree(top);// 여기에 노드를 생성자 인수로 넣어줄 예정임
		scroll = new JScrollPane(tree);

		createBrench(brenchs,top);
		brench = new JTree(brenchs);
		
		
		add(scroll);
		add(brench);
		
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
	
	}
	//
	public void createBrench(DefaultMutableTreeNode brenchs,DefaultMutableTreeNode top) {
		DefaultMutableTreeNode[] node2 = new DefaultMutableTreeNode[2];
		node2[0] = new DefaultMutableTreeNode();
		node2[1] = new DefaultMutableTreeNode("뭐냐고 ");
		
		for(DefaultMutableTreeNode obj : node2) {
			brenchs.add(obj);
		}
	}
	
	public void createNode(DefaultMutableTreeNode top) {
		//넘겨받은 탑 노드에 원하는 하위 노드를 생성하여 자식노드로 붙이자 
		DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[4];
		node[0]=new DefaultMutableTreeNode("반지");
		node[1]=new DefaultMutableTreeNode("목걸이");
		node[2]=new DefaultMutableTreeNode("귀걸이");
		node[3]=new DefaultMutableTreeNode("팔찌");
		
		//생성된 노드를 top노드의 하위노드로 부착 
		for (DefaultMutableTreeNode obj : node) {
			top.add(obj);
		}
	}
	
	public static void main(String[] args) {
		new TreeApp();
	}
}
