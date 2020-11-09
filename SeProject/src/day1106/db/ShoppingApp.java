/* ���θ� ��ǰ���� ���α׷��� �����ϱ� */
package day1106.db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import common.image.ImageUtil;








public class ShoppingApp extends JFrame{
	//1.
	JPanel p_west;//��ü�� ���� 
	JPanel p_center; //��ü�� ���
	JPanel c_north; //��� �� ���� //�˻� ���� �г�
	JPanel c_center; //����� ����//���̺� ���� ���� 
	JPanel p_east; //��ü�� ���� 
	
	//����� ����
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_brand;
	JTextField t_price;
	JButton bt_find; //�̹��� ã�ƺ��� 
	JButton bt_collect;//�̹��� �����ϱ� (�������� �̹����� ���� �ϵ� ��ũ��..)
	JPanel can;//�̹��� �̸����� �׷��� �� 
	JButton bt_regist; //�̹��� ã�ƺ��� 
	CollectorFrame collectorFrame;
	
	//���Ϳ��� -�˻�����
	Choice ch_category;//�˻�ī�װ�
	JTextField t_keyword;//�˻���
	JButton bt_search; //�˻���ư
	JTable table;
	JScrollPane scroll;
	
	//���ʿ���
	Choice ch_top2;
	Choice ch_sub2;
	JTextField t_name2;
	JTextField t_brand2;
	JTextField t_price2;
	JButton bt_find2; //�̹��� ã�ƺ��� 
	JPanel can2;//�̹��� �̸����� �׷��� �� 
	JButton bt_edit; //������ư
	JButton bt_del; //������ư
	
	String url="jdbc:oracl:thin:@localhost:1521:XE";
	String user="user1104";
	String password="user1104";
	
	Connection con;
	HashMap<String, Integer> map=new HashMap<String, Integer>();//�÷��� �����ӿ� ��, key-value �� ������ ��ü�� �������ִ� ��ü 
	HashMap<String, Integer> map2=new HashMap<String, Integer>();//�÷��� �����ӿ� ��, key-value �� ������ ��ü�� �������ִ� ��ü 

	JFileChooser chooser=new JFileChooser("C:/workspace/java_workspace/SeProject/src/res/gabi");
	Toolkit kit= Toolkit.getDefaultToolkit();//�޸𸮿ø��� 26. �÷����������� ��η� �����Ë��� ��Ŷ ���� 
	Image img;
	File file;
	ProductController productController;
	
	public ShoppingApp() {
		//2.�޸𸮿� �ø���(����)
		//���ʿ������� 
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub= new Choice();
		t_name= new JTextField();
		t_brand = new JTextField();
		t_price= new JTextField();
		bt_find = new JButton("�̹���ã��");
		bt_collect=new JButton("���ͳݼ���");
		can = new JPanel() {
			public void paint(Graphics g) {//26.
				g.drawImage(img, 0, 0, can);
			}
		};
		bt_regist=new JButton("���");
		
		ch_top.add("choose category");
		
		//3.���� ���� 
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_name);
		p_west.add(t_brand);
		p_west.add(t_price);
		p_west.add(bt_find);
		p_west.add(bt_collect);
		p_west.add(can);
		p_west.add(bt_regist);
		
		//5.��Ÿ������
		ch_top.setPreferredSize(new Dimension(135, 30));
		ch_sub.setPreferredSize(new Dimension(135, 30));
		t_name.setPreferredSize(new Dimension(135, 30));
		t_brand.setPreferredSize(new Dimension(135, 30));
		t_price.setPreferredSize(new Dimension(135, 30));
		bt_find.setPreferredSize(new Dimension(135, 30));
		bt_collect.setPreferredSize(new Dimension(135, 30));
		can.setPreferredSize(new Dimension(135, 115));
		
		p_west.setPreferredSize(new Dimension(150, 600));
		//p_west.setBackground(Color.yellow);
		
		//4.�����ӿ� ���� ���� ���̱� 
		add(p_west, BorderLayout.WEST);
		
		//6.��� ���� ���� 
		c_north = new JPanel();
		c_center =new JPanel();
		ch_category=new Choice();
		t_keyword=new JTextField();
		bt_search = new JButton("�˻�");
		table = new JTable(productController = new ProductController());
		scroll = new JScrollPane(table);
		
		ch_category.add("product_name");
	    ch_category.add("brand");

		
		//7. ��Ÿ�� ���� 
		c_north.setBackground(Color.PINK);
		ch_category.setPreferredSize(new Dimension(130, 30));
		t_keyword.setPreferredSize(new Dimension(400, 30));
		bt_search.setPreferredSize(new Dimension(120, 30));
		
		//8.���-�˻��������� 
		c_north.add(ch_category);
		c_north.add(t_keyword);
		c_north.add(bt_search);
		
		//9.���-���̺��� ����
		c_center.setLayout(new BorderLayout());
		c_center.add(scroll);
		
		//10.��� ������ ��ü �гο� ���г� ���� 
		p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(c_north, BorderLayout.NORTH);
		p_center.add(c_center);
		
		//11.��� ��ü�г��� �����ӿ� ���� 
		add(p_center);
		
		//12.���U�������� 
		p_east= new JPanel();
		ch_top2 = new Choice();
		ch_sub2= new Choice();
		t_name2= new JTextField();
		t_brand2 = new JTextField();
		t_price2= new JTextField();
		bt_find2=new JButton("�̹��� ã��");
		can2 = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, can2);
			}
		};
		bt_edit=new JButton("����");
		bt_del=new JButton("����");
		
		//13.���� ���� 
		p_east.add(ch_top2);
		p_east.add(ch_sub2);
		p_east.add(t_name2);
		p_east.add(t_brand2);
		p_east.add(t_price2);
		p_east.add(bt_find2);
		p_east.add(can2);
		p_east.add(bt_edit);
		p_east.add(bt_del);
		
		//14.��Ÿ������
		ch_top2.setPreferredSize(new Dimension(135, 30));
		ch_sub2.setPreferredSize(new Dimension(135, 30));
		t_name2.setPreferredSize(new Dimension(135, 30));
		t_brand2.setPreferredSize(new Dimension(135, 30));
		t_price2.setPreferredSize(new Dimension(135, 30));
		bt_find2.setPreferredSize(new Dimension(135, 30));
		can2.setPreferredSize(new Dimension(135, 115));
		bt_edit.setPreferredSize(new Dimension(135, 30));
		bt_del.setPreferredSize(new Dimension(135, 30));
		
		p_east.setPreferredSize(new Dimension(150, 600));
		//p_east.setBackground(Color.CYAN);
		
		//15.�����ӿ� ���� ���� ���̱� 
		add(p_east, BorderLayout.EAST);
		//15.1 oracle�� �����ͳֱ� 
		
		//16.
		connect();
		//18.
		getTopList();
		//��ǰ �� �� ����ϱ� 
		getProductList();
		
		//17.������ â ������, ����Ŭ���� ���� ���� ���μ����� �����ؾ��� 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//�������� 
				disconnect();
				System.exit(0);
			}

		});
		
		//20.ch_top�� �����۸����� ���� 
		ch_top.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//System.out.println("���ùٲ��?");
				//�ٲ������� �̿��Ͽ� ���� ī�װ��� �������� 
				//21.�ؽø����� ���� key ���� �̿��Ͽ�, value�� �����Ѵ� 
				if(ch_top.getSelectedIndex()>0) {
				int topcategory_id=map.get(ch_top.getSelectedItem());
				//System.out.println(topcategory_id);
				getSubList(topcategory_id);
				}
			}
		});
		
		//23.����ã�� ��ư�� ������ ���� 
		bt_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findImage();//24.���θ��� ����� ��ǰ�̹������� 
				preview();
			}
		});
		
		//27
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
				getProductList();
				table.updateUI();
			}
		});
		
		  //�̹��� ���ͳ����� �����ϱ� ��ư�� ���� 
	      bt_collect.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            collectorFrame = new CollectorFrame(ShoppingApp.this); //�����͸��� �ܺ�Ŭ���� �ν��Ͻ� ���ٽ�
	         }
	      });

        
        bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category= ch_category.getSelectedItem();
				String keyword=t_keyword.getText();
				
				getSearchResult(category, keyword);
				table.updateUI();
			}
		});
        
       //���콺 ������ ���� 
        table.addMouseListener(new MouseAdapter() {
        	public void mouseReleased(MouseEvent e) {
        		int row = table.getSelectedRow();//�������� 
        		int col = table.getSelectedColumn();//������ ��
        		
        		String value=(String)table.getValueAt(row, col);
        		System.out.println(value);
        		
        		setCategory(row);
        		setSubCategory(row);
        		
        		getDetail(row);//�󼼺��� ��� 
        		
        		
        		String filename=(String)table.getValueAt(row, 5);
        		getTargetImage("C:/workspace/java_workspace/SeProject/src/res/gabi/"+filename);//�̹����׸���
        		can2.repaint();
        	}
        });

		setSize(1000,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	//16.����Ŭ ���� 
	public void connect() {
		//����̹� �ε�! jdbc:oracl:thin:@localhost:1521:XE
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			if(con==null) {
				JOptionPane.showMessageDialog(this, "�������� ���߾�� �Ф�");
				System.exit(0);
			}else {
				//������ â�� ���������� �����ߴٴ� �޽��� 
				this.setTitle(user+"�� ������");
			}
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "����̹��� ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//18.����ī�װ� �������� 
	public void getTopList() {
		String sql="select * from topcategory";
		//�������� �����ϴ� JDBC��ü��? PreparedStatement
		//��������� ��� JDBC ��ü��? ResultSet(select�� ���� �� �� ����� ��°�ü)
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();//�������� 
			
			while (rs.next()) {
				ch_top.add(rs.getString("name"));	//����ڵ��� ���Ե� ������ 
				ch_top2.add(rs.getString("name"));
				
				map.put(rs.getString("name"), rs.getInt("topcategory_id"));//20.�ؽøʿ� key_value�� ������ ���� �ֱ� ,,,,�ڽ̾˾ƺ���
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "�Է½��п���..");
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//22.���� ī�װ� �������� 
	public void getSubList(int topcategory_id) {
		String sql = "SELECT * FROM SUBCATEGORY WHERE TOPCATEGORY_ID ="+topcategory_id;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);//�������ఴü ����
			rs=pstmt.executeQuery();
			//ä������� ��� ����� !! (�ʱ�ȭ)
			ch_sub.removeAll();
			ch_sub2.removeAll();
			
			ch_sub.add("choose category");
			ch_sub2.add("choose category");
			//22-1.����ī�װ�ä��� 
			while (rs.next()) {
				ch_sub.add(rs.getNString("name"));
				ch_sub2.add(rs.getNString("name"));
				map2.put(rs.getString("name"), rs.getInt("subcategory_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//24. ��ǰ�̹��� ���� �� , �̸����� ��� ���� 
	public void findImage() {
		if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
			//���������� ���Ѵ� !! 
			file = chooser.getSelectedFile();
			System.out.println("����� ���� ������ ���� ���� : "+ file.getAbsolutePath());
			
			getTargetImage(file.getAbsolutePath());
		}
	}
	
	//�׷��� �̹��� ���ϱ� 
   public void getTargetImage(String path) {
	      img = kit.getImage(path); //�ɹ����� img ���� ���Ѵ�.
	      img = ImageUtil.getCustomSize(img, 135, 115);
	   }

	//25.�̸����� ���� 
	public void preview() {
		//paint ó�� 
		can.repaint();
	}
	
	
	//27.��� �����ϱ� 
	public void regist() {
	      //����ǥ �� �������� 
	      int subcategory_id=map2.get(ch_sub.getSelectedItem()); //??
	      String product_name = t_name.getText();
	      String brand = t_brand.getText();
	      int price = Integer.parseInt(t_price.getText());
	      String filename = file.getName();//Ǯ��θ��� �̹�����..
	      
	      System.out.println("subcategory_id: "+ subcategory_id );
	      System.out.println("product_name: "+ product_name);
	      System.out.println("brand: "+ brand );
	      System.out.println("price: "+ price );
	      System.out.println("filename: "+ filename);
	      
	      String sql="insert into product(product_id, subcategory_id, product_name, band,price,filename)";
	      sql+=" values(seq_product.nextval, ?,?,?,?,?)";
	      
	      PreparedStatement pstmt=null;
	      
	      try {
	         pstmt = con.prepareStatement(sql);
	         //���ε� ���� �����Ŀ� ���� �����ؾ� �Ѵ�!!
	         pstmt.setInt(1,subcategory_id);
	         pstmt.setString(2, product_name);
	         pstmt.setString(3, brand);
	         pstmt.setInt(4,price);
	         pstmt.setString(5,filename);
	         
	         //�Ʒ��� �޼����� ��ȯ��? �� �������� ���� ����޴� ���ڵ� ���� ��ȯ , ����  insert ��쿣 ������ ������1
	         //update, delete�� ������ ��� 0,,�����̸� 1�̻���..
	         int result = pstmt.executeUpdate(); //DML(insert , update ,delete �� ���)
	         
	         if(result ==0) {
	            JOptionPane.showMessageDialog(this, "��Ͻ��Ф̤�");  
	         }else {
	            JOptionPane.showMessageDialog(this, "��ϼ���^^");
	         }
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
	      

	}
	//product ���̺��� ���ڵ� �������� 
	   public void getProductList() {
	      String sql="select * from product";
	      
	      PreparedStatement pstmt=null;
	      ResultSet rs = null;
	      
	      try {
	         //PreparedStatement ������ �μ� 2���� �Ѱ�, ���Ĺ������� Ŀ���� �����Ӱ� �̵� �����ϰ��� �� �ִ�. 
	         pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//�����غ�
	         rs = pstmt.executeQuery(); //select�� ���� �� ���ǥ�� rs�� ����
	         
	         //rs�� �޼��� �� .getRow() �� ���� Ŀ���� ��ġ �� ���ڵ� ��� ����Ű�� �ִ�����
	         //�˼� �ִ�..
	         
	         rs.last();// Ŀ���� ���� ���������� ������ 
	         int currentRow = rs.getRow();
	         //System.out.println("���� Ŀ���� ����Ű�� ���ڵ� ��ȣ�� "+currentRow);
	         System.out.println("�������� ������ Ŀ���� rowNum "+currentRow);
	         
	         //rs�� ǥ �����͸� ProductController�� ������  data������ �迭�� ����!!
	         String[][] data = new String[currentRow][productController.column.length];
	         
	         //�������迭�� �����͸� ��������, Ŀ���� �ٽ� ���󺹱ͽ��Ѿ� �Ѵ�..
	         rs.beforeFirst(); //ù��° ���ڵ� ���ٵ� �������� �ǵ��� (�� ��ġ �ʱ�ȭ)
	         
	         int index=0;
	         while(rs.next()) {
	            String[] record = new String[productController.column.length];
	            
	            record[0] = rs.getString("product_id");
	            record[1] = rs.getString("subcategory_id");
	            record[2] = rs.getString("product_name");
	            record[3] = rs.getString("band");
	            record[4] = rs.getString("price");
	            record[5] = rs.getString("filename");
	            
	            //ä���� ������ �迭�� data �������迭�� ������� ����
	            data[index++]=record;
	            System.out.println(index);
	         }
	         //�ϼ��� �������迭�� productController�� ������ data �迭 �ּҷ� ���Խ��ѹ�����
	         productController.data = data;
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         if(rs!=null) {
	            try {
	               rs.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         if(pstmt!=null) {
	            try {
	               pstmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }         
	      }
	      
	   }
	   
   //�˻���� ����ϱ� 
   public void getSearchResult(String category, String keyword) {
	   String sql="select * from product where "+category+" like '%"+keyword+"%'";
	   PreparedStatement pstmt=null;
	   ResultSet rs = null;
      
	   try {
         //PreparedStatement ������ �μ� 2���� �Ѱ�, ���Ĺ������� Ŀ���� �����Ӱ� �̵� �����ϰ��� �� �ִ�. 
         pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//�����غ�
         rs = pstmt.executeQuery(); //select�� ���� �� ���ǥ�� rs�� ����
         
         //rs�� �޼��� �� .getRow() �� ���� Ŀ���� ��ġ �� ���ڵ� ��� ����Ű�� �ִ�����
         //�˼� �ִ�..
         
         rs.last();// Ŀ���� ���� ���������� ������ 
         int currentRow = rs.getRow();
         //System.out.println("���� Ŀ���� ����Ű�� ���ڵ� ��ȣ�� "+currentRow);
         System.out.println("�������� ������ Ŀ���� rowNum "+currentRow);
         
         //rs�� ǥ �����͸� ProductController�� ������  data������ �迭�� ����!!
         String[][] data = new String[currentRow][productController.column.length];
         
         //�������迭�� �����͸� ��������, Ŀ���� �ٽ� ���󺹱ͽ��Ѿ� �Ѵ�..
         rs.beforeFirst(); //ù��° ���ڵ� ���ٵ� �������� �ǵ��� (�� ��ġ �ʱ�ȭ)
         
         int index=0;
         while(rs.next()) {
            String[] record = new String[productController.column.length];
            
            record[0] = rs.getString("product_id");
            record[1] = rs.getString("subcategory_id");
            record[2] = rs.getString("product_name");
            record[3] = rs.getString("band");
            record[4] = rs.getString("price");
            record[5] = rs.getString("filename");
            
            //ä���� ������ �迭�� data �������迭�� ������� ����
            data[index++]=record;
            System.out.println(index);
         }
         //�ϼ��� �������迭�� productController�� ������ data �迭 �ּҷ� ���Խ��ѹ�����
         productController.data = data;
         
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         if(rs!=null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if(pstmt!=null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }         
      }
	}

   //��ǰ�󼼺��� 
   public void getDetail(int row) {
	   
	   t_name2.setText((String)table.getValueAt(row, 2));//��ǰ��
	   t_brand2.setText((String)table.getValueAt(row, 3));//�귣��
	   t_price2.setText((String)table.getValueAt(row, 4));//��ǰ����
	   //�̹���ó��
}
   public void setCategory(int row) {
	   PreparedStatement pstmt=null;
	   ResultSet rs = null;
	   
	   String subcategory_id=(String)table.getValueAt(row, 1);
	   
		String sql="select * from topcategory where topcategory_id =(";
		sql+=" select topcategory_id  from subcategory where subcategory_id =";
		sql+=")";
		
//		System.out.println(sql);
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();//���������� 
			if(rs.next()) {
				ch_top2.select(rs.getNString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
	         if(rs!=null) {
	             try {
	                rs.close();
	             } catch (SQLException e) {
	                e.printStackTrace();
	             }
	          }
	          if(pstmt!=null) {
	             try {
	                pstmt.close();
	             } catch (SQLException e) {
	                e.printStackTrace();
	             }
	          }         
	       }
   }

public void setSubCategory(int row) {
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	String subcategory_id=(String)table.getValueAt(row, 1);
	
	String sql="select * from subcategory where subcategory_id="+subcategory_id;

	
	System.out.println(sql);
	
	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();//���������� 
		if(rs.next()) {
			ch_top2.select(rs.getNString("name"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}         
	}
}
	//��������
	private void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ShoppingApp();
	}
}
