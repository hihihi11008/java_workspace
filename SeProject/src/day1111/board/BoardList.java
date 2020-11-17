/*�Խù� ��� ������ */
package day1111.board;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;




public class BoardList extends JPanel{
	JTable table;
	JScrollPane scroll;
	JButton bt;
	
	Connection con;
	
	BoardApp boardApp;
	BoardModel boardModel;
	
	public BoardList(BoardApp boardApp) {
		this.boardApp = boardApp;
		con = boardApp.getCon();
		table= new JTable(boardModel = new BoardModel());
		scroll = new JScrollPane(table);
		bt = new JButton("�� ����");
		
		getList();
		
		setLayout(new BorderLayout());
		
		add(scroll);
		add(bt, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(780, 500));
		setVisible(true);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				//�󼼺��Ⱑ ������ getDetail() �޼���ȣ���ϱ� 
				BoardDetail boardDetail=(BoardDetail)boardApp.getPages(boardApp.BOARD_DETAIL);
				String board_id=(String)table.getValueAt(table.getSelectedRow(), 0);//board_id
				boardDetail.getDetail(Integer.parseInt(board_id));
				boardDetail.updateHit(Integer.parseInt(board_id));
				
				boardApp.setPage(boardApp.BOARD_DETAIL);
				
			}
		});
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�۾��� ���� �ۼ��ڿ�, ���̵� �־�α�!!
				BoardWrite page=(BoardWrite)boardApp.getPages(BoardApp.BOARD_WRITE);
				page.t_writer.setText(boardApp.getBoardMember().getM_id());
				
				boardApp.setPage(BoardApp.BOARD_WRITE);//�۾��� �� �����ֱ�
			}
		});
	}
	
	//�Խù� �������� 
	//rs�� ����� �����͸� TableModel�� ������ ������ �迭 data �� ���� 
	public void getList() {
		  PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String sql = "select * from board order by board_id desc";
	      try {
	         pstmt = con.prepareStatement(sql, 
	               ResultSet.TYPE_SCROLL_INSENSITIVE
	               , ResultSet.CONCUR_READ_ONLY);

			//��ũ���� �����ϰ� (next()�ɷ�+ ��������� �̵��ɷ�), �б������� rs �� ����� ���� �ɼ�
			rs=pstmt.executeQuery();
			
			rs.last();
			int total = rs.getRow();//�� ���ڵ�� ��ȯ 
			//rs�� ����ִ� �����͸� �������迭�� �Űܽɾ�� 
			//�׷��� ���ؼ��� ���� ������ �迭�� �غ��س��� 
			String[][] records = new String[total][5];
			rs.beforeFirst();
			
			int index=0;
			while (rs.next()) {
				String[] arr=new String[5];
				arr[0]=rs.getString("board_id");
				arr[1]=rs.getString("title");
				arr[2]=rs.getString("writer");
				arr[3]=rs.getString("regdate");
				arr[4]=rs.getString("hit");
				
				records[index++]=arr;//�������迭�� �������迭�� �濡 ����
			}	
			//�������迭�� ��� �ϼ��Ǿ����Ƿ�, TableModel�� ������ data ������ �迭�� ����! 
			boardModel.data=records;
			table.updateUI();//JTable UI����
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
