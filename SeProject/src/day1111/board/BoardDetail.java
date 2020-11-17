package day1111.board;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class BoardDetail extends JPanel{
	   JTextField t_title;
	   JTextField t_writer;
	   JTextArea content;
	   JScrollPane scroll;
	   
	   JButton bt_edit;
	   JButton bt_del;
	   JButton bt_list;
	   
	   JTable table;
	   
	   BoardApp boardApp;
	   BoardModel boardModel;
	   Board board;
	   Connection con;
	   
	   public BoardDetail(BoardApp boardApp) {
		  this.boardApp = boardApp;
		  table= new JTable(boardModel = new BoardModel());
		  con=boardApp.getCon();
	      t_title = new JTextField();
	      t_writer = new JTextField();
	      content = new JTextArea();
	      scroll = new JScrollPane(content);
	      
	      bt_edit = new JButton("�����ϱ�");
	      bt_del = new JButton("�����ϱ�");
	      bt_list = new JButton("��Ϻ���");
	      
	      //��Ÿ��
	      t_title.setPreferredSize(new Dimension(780,35));
	      t_writer.setPreferredSize(new Dimension(780,35));
	      scroll.setPreferredSize(new Dimension(780,200));      
	      
	      //����
	      add(t_title);
	      add(t_writer);
	      add(scroll);
	      add(bt_edit);
	      add(bt_del);
	      add(bt_list);
	      
	      setPreferredSize(new Dimension(780, 490));
	      setVisible(true);
	      
	      bt_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardList boardList=(BoardList)boardApp.getPages(boardApp.BOARD_LIST);//����Ʈ����
				boardList.getList();//����Ʈ ����
				
				boardApp.setPage(BoardApp.BOARD_LIST);//��Ϻ��� 
			}
	      });
	      
	     bt_del.addActionListener((e)->{
	    	 int ans=JOptionPane.showConfirmDialog(this, "����?");
	    	 if(ans==JOptionPane.OK_OPTION) {
	    	 	int result=del();
	    	 	if (result==0) {
				JOptionPane.showMessageDialog(this, "��������");
			   }else {
				JOptionPane.showMessageDialog(this, "��������");	
				BoardList boardList=(BoardList)boardApp.getPages(boardApp.BOARD_LIST);//����Ʈ����
				boardList.getList();
				boardApp.setPage(BoardApp.BOARD_LIST);
			   }
			 }
	     }); 
	     bt_edit.addActionListener((e)->{
	    	 int result=edit(board);
	    	 if(result==0) {
	    		 JOptionPane.showMessageDialog(this, "��������");
	    	 }else {
	    		 JOptionPane.showMessageDialog(this, "��������");	
				 BoardList boardList=(BoardList)boardApp.getPages(boardApp.BOARD_LIST);//����Ʈ����
				 boardList.getList();
				 boardApp.setPage(BoardApp.BOARD_LIST);
	    	 }
	     });
	   }
	   //��ȸ�� ���� 
	   public void updateHit(int board_id) {
	         PreparedStatement pstmt = null;
	         String sql = "update board set hit=hit+1 where board_id="+board_id;
	         try {
	         pstmt = con.prepareStatement(sql);//������ �غ�
	         int result = pstmt.executeUpdate();//������ ����
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         if(pstmt!=null) {
	            try {
	               pstmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	         
	      }

	   
	   public  void getDetail(int board_id) {
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
//		   String sql="select * from board where board_id= ������ ������ board_id";
		   String sql="select * from board where board_id="+board_id;
		   
		   try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//Ŀ���� ��ĭ���� 
			if (rs.next()) {
				board = new Board();//create Empty object
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				
				//������ ä��� 
				t_title.setText(board.getTitle());
				t_writer.setText(board.getWriter());
				content.setText(board.getContent());
				
			}
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
	   //���� �����ϱ� 
	   public int del() {//�Ű������� board_id�־��ֱ�  �޼��尡 Ŭ�����̵��� ���� �� �ֱ⶧����!!@!!
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   int result=0;
		   
		   int board_id=board.getBoard_id();
		   String sql = "delete FROM board WHERE BOARD_ID ="+board_id;
		   System.out.println(sql);
		   
		   try {
			   pstmt= con.prepareStatement(sql);
			   result=pstmt.executeUpdate();
			
		   } catch (SQLException e) {
			e.printStackTrace();
		   }finally {
			   if(pstmt!=null) {
				   try {
					   pstmt.close();
				   } catch (SQLException e) {
					   e.printStackTrace();
				   }
			   }
		   }
		   return result;
	   }
	   
	   public int edit(Board board) { //������ �������� ���� 1���� �Խù��� ����ִ� �ν��Ͻ��� �������� 
		   PreparedStatement pstmt = null;
		   int result=0;
		   String sql="update board set title=?, content=? where board_id=?";
		   
		   try {
			   pstmt=con.prepareStatement(sql);
			   //����ڰ� �Է��� ������ ��ü 
			   pstmt.setString(1, t_title.getText());//����ڰ� �Է��� ��
			   pstmt.setString(2, content.getText());//����ڰ� �Է��� ��
			   pstmt.setInt(3, board.getBoard_id());//���� �󼼺��⿡���� board_id
			   result=pstmt.executeUpdate();//���������� 
			 
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }finally {
			   if(pstmt!=null) {
				   try {
					   pstmt.close();
				   } catch (SQLException e) {
					   e.printStackTrace();
				   }
			   }
		   }
		   return result;
	   }
	}
