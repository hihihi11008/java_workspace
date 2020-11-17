/*�����Ͱ� ����ȭ�� */
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
		//Ʈ���� ������ ��带 �����غ��� 
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("��������");
		DefaultMutableTreeNode brenchs = new DefaultMutableTreeNode("��ǰ���� ");
		createNode(top); //���� ����� �Ͱ��� ��� ������ ������
		tree = new JTree(top);// ���⿡ ��带 ������ �μ��� �־��� ������
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
		node2[1] = new DefaultMutableTreeNode("���İ� ");
		
		for(DefaultMutableTreeNode obj : node2) {
			brenchs.add(obj);
		}
	}
	
	public void createNode(DefaultMutableTreeNode top) {
		//�Ѱܹ��� ž ��忡 ���ϴ� ���� ��带 �����Ͽ� �ڽĳ��� ������ 
		DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[4];
		node[0]=new DefaultMutableTreeNode("����");
		node[1]=new DefaultMutableTreeNode("�����");
		node[2]=new DefaultMutableTreeNode("�Ͱ���");
		node[3]=new DefaultMutableTreeNode("����");
		
		//������ ��带 top����� �������� ���� 
		for (DefaultMutableTreeNode obj : node) {
			top.add(obj);
		}
	}
	
	public static void main(String[] args) {
		new TreeApp();
	}
}
