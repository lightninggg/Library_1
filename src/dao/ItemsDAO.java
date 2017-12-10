package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.Items;
import entity.Reader;
import entity.Borrow;
import util.DBhelper;

//��Ʒ��ҵ���߼���
public class ItemsDAO {

	// ����������ѯ
	public ArrayList<Items> getItemsById(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;// ��������
		ResultSet rs = null;// ���ݼ�
		 String sql="";
		ArrayList<Items> list = new ArrayList<Items>();// ��Ʒ���� ArrayList����
		try {
			conn = DBhelper.getConnection();// ������Ӷ���
			sql = "select * from tb_bookinfo where book_name like '%" + name + "%' ; ";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
			rs = stmt.executeQuery();// ִ��SQL��������ݼ�
			while (rs.next())// ������¼
			{
				Items item = new Items();// ��Ʒ��Ϣ
				// ��set����װ����
				item.setBook_id(rs.getInt("book_id"));
				item.setBook_name(rs.getString("book_name"));
				item.setBook_author(rs.getString("author"));
				item.setISBN(rs.getString("ISBN"));
				item.setPrice(rs.getFloat("price"));
				item.setBook_case(rs.getString("book_case"));
				item.setBook_intime(rs.getString("book_intime"));
				item.setPress(rs.getString("press"));
				item.setNumber(rs.getInt("Number"));
				item.setCategory(rs.getString("Category"));
				list.add(item);// ��һ����Ʒ��Ϣ���뼯��
			}
		} catch (Exception ex) {
			ex.printStackTrace();// �����쳣��ջ
			return null;
		} finally// �ͷ���Դ����С�����ͷ�
		{
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return list;
	}

	// �������߲�ѯ
		public ArrayList<Items> getItemsByauthor(String name) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			 String sql="";
			ArrayList<Items> list = new ArrayList<Items>();// ��Ʒ���� ArrayList����
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				sql = "select * from tb_bookinfo where author like '%" + name + "%' ; ";
				System.out.println(sql);
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				rs = stmt.executeQuery();// ִ��SQL��������ݼ�
				while (rs.next())// ������¼
				{
					Items item = new Items();// ��Ʒ��Ϣ
					// ��set����װ����
					item.setBook_id(rs.getInt("book_id"));
					item.setBook_name(rs.getString("book_name"));
					item.setBook_author(rs.getString("author"));
					item.setISBN(rs.getString("ISBN"));
					item.setPrice(rs.getFloat("price"));
					item.setBook_case(rs.getString("book_case"));
					item.setBook_intime(rs.getString("book_intime"));
					item.setPress(rs.getString("press"));
					item.setNumber(rs.getInt("Number"));
					list.add(item);// ��һ����Ʒ��Ϣ���뼯��
				}
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
				return null;
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			return list;
		}

		// ��������ѯ
				public ArrayList<Items> getItemsBycategory(String name) {
					Connection conn = null;
					PreparedStatement stmt = null;// ��������
					ResultSet rs = null;// ���ݼ�
					 String sql="";
					ArrayList<Items> list = new ArrayList<Items>();// ��Ʒ���� ArrayList����
					try {
						conn = DBhelper.getConnection();// ������Ӷ���
						sql = "select * from tb_bookinfo where Category like '%" + name + "%' ; ";
						System.out.println(sql);
						stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
						rs = stmt.executeQuery();// ִ��SQL��������ݼ�
						while (rs.next())// ������¼
						{
							Items item = new Items();// ��Ʒ��Ϣ
							// ��set����װ����
							item.setBook_id(rs.getInt("book_id"));
							item.setBook_name(rs.getString("book_name"));
							item.setBook_author(rs.getString("author"));
							item.setISBN(rs.getString("ISBN"));
							item.setPrice(rs.getFloat("price"));
							item.setBook_case(rs.getString("book_case"));
							item.setBook_intime(rs.getString("book_intime"));
							item.setPress(rs.getString("press"));
							item.setNumber(rs.getInt("Number"));
							list.add(item);// ��һ����Ʒ��Ϣ���뼯��
						}
					} catch (Exception ex) {
						ex.printStackTrace();// �����쳣��ջ
						return null;
					} finally// �ͷ���Դ����С�����ͷ�
					{
						// �ͷ����ݼ�����
						if (rs != null) {
							try {
								rs.close();
								rs = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						// �ͷ�������
						if (stmt != null) {
							try {
								stmt.close();
								stmt = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
					return list;
				}

		
		
	
	// ���
	public void getBookIn(float price, String name, String author, String ISBN, String bookcase, String press,
			String intime,String category,int number) {
		Connection conn = null;
		PreparedStatement stmt = null;// ��������
		ResultSet rs = null;// ���ݼ�
		try {
			conn = DBhelper.getConnection();// ������Ӷ���
			String sql = "INSERT tb_bookinfo (book_name,author,ISBN,price,book_case,book_intime,press,Category,Number) VALUES('" + name
					+ "','" + author + "','" + ISBN + "'," + price + ",'" + bookcase + "','" + intime + "','" + press
					+ "','"+category+"',number);";

			stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
			stmt.execute();
			// stmt.setFloat(5, price);
			// stmt.setString(2, name);
			// stmt.setString(3, author);
			// stmt.setString(4, ISBN);
			// stmt.setString(6, bookcase);
			// stmt.setString(7, intime);
			// stmt.setString(8, press);
			// rs = stmt.executeQuery();// ִ��SQL��������ݼ�
			/*
			 * while (rs.next())// ������¼ { Items item = new Items();// ��Ʒ��Ϣ //
			 * ��set����װ���� item.setBook_id(rs.getInt("book_id"));
			 * item.setBook_name(rs.getString("book_name"));
			 * item.setBook_author(rs.getString("author"));
			 * item.setISBN(rs.getString("ISBN"));
			 * item.setPrice(rs.getFloat("price"));
			 * item.setBook_case(rs.getString("book_case"));
			 * item.setBook_intime(rs.getString("book_intime"));
			 * item.setPress(rs.getString("press")); list.add(item);//
			 * ��һ����Ʒ��Ϣ���뼯�� }
			 */
		} catch (Exception ex) {
			ex.printStackTrace();// �����쳣��ջ
		} finally// �ͷ���Դ����С�����ͷ�
		{
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	// ����ͼ��
	public ArrayList<Items> getAllBooks() {
		Connection conn = null;
		PreparedStatement stmt = null;// ��������
		ResultSet rs = null;// ���ݼ�
		ArrayList<Items> list = new ArrayList<Items>();// ��Ʒ���� ArrayList����
		try {
			conn = DBhelper.getConnection();// ������Ӷ���
			String sql = "select * from tb_bookinfo;";// SQL���
			stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
			rs = stmt.executeQuery();// ִ��SQL��������ݼ�
			while (rs.next())// ������¼
			{
				Items item = new Items();// ��Ʒ��Ϣ
				// ��set����װ����
				item.setBook_id(rs.getInt("book_id"));
				item.setBook_name(rs.getString("book_name"));
				item.setNumber(rs.getInt("Number"));
				item.setBook_case(rs.getString("book_case"));
				list.add(item);// ��һ����Ʒ��Ϣ���뼯��
			}
			return list;// ���ؼ���
		} catch (Exception ex) {
			ex.printStackTrace();// �����쳣��ջ
			return null;
		} finally// �ͷ���Դ����С�����ͷ�
		{
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	// ����
	public void DeleteBooks(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;// ��������
		ResultSet rs = null;// ���ݼ�
		try {
			conn = DBhelper.getConnection();// ������Ӷ���
			String sql = "DELETE FROM tb_bookinfo WHERE book_id=?;";// SQL���
			stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
			stmt.setInt(1, id);// ����һ����������Ŵ�1��ʼ
			stmt.execute();// ִ��SQL��������ݼ�
		} catch (Exception ex) {
			ex.printStackTrace();// �����쳣��ջ
		} finally// �ͷ���Դ����С�����ͷ�
		{
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	//�ж�ʣ���鼮�����Ƿ�Ϊ0
	public int getremain(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;// ��������
		ResultSet rs = null;// ���ݼ�
		int number = 0;
		//ArrayList<Reader> list = new ArrayList<Reader>();
		try {
			conn = DBhelper.getConnection();// ������Ӷ���
			String sql = "Select Number From tb_bookinfo   WHERE book_id="+id+";";// SQL���
			stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
			//stmt.setString(1, name);// ����һ����������Ŵ�1��ʼ
			rs=stmt.executeQuery();// ִ��SQL��������ݼ�
			//psd=String.valueOf(rs.getString("password"));
			System.out.println("number");
			if(rs.next()){//ûnext��ָ�����ûָ���Ӧ��¼
				number = rs.getInt("Number");
			}
			//Reader Readers = new Reader();// ��Ʒ��Ϣ
			//Readers.setPassword(rs.getString("password"));
			//list.add(Readers);
			
		} catch (Exception ex) {
			ex.printStackTrace();// �����쳣��ջ
		} finally// �ͷ���Դ����С�����ͷ�
		{
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return number;
	}
	
	
	
	
	
	// ���ģ��������ݿ⣩
		public void BorrowBooks(int id) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				String sql = "UPDATE tb_bookinfo set Number=Number-1 WHERE book_id=?;";// SQL���
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				stmt.setInt(1, id);// ����һ����������Ŵ�1��ʼ
				stmt.execute();// ִ��SQL��������ݼ�
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		//�����¼
		public void InsertBorrow(int book_id, String toUser, String borrow_time, String return_time) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				String sql = "INSERT tb_borrowinfo (reader_ID,book_ID,borrowTime,backTime) VALUES('" + toUser
						+ "',(SELECT book_name FROM tb_bookinfo WHERE book_id=?),'" + borrow_time + "','" + return_time + "');";

				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				stmt.setInt(1, book_id);
				stmt.execute();
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		//���������¼
		public ArrayList<Borrow> BorrowAllBooks(String toUser) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�,�˴�rs��ResultSet���ʵ�����������ڴ洢�������
			ArrayList<Borrow> list = new ArrayList<Borrow>();// �� ArrayList����
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				String sql = "select * from tb_borrowinfo where reader_ID='"+toUser+"';";// SQL���
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				//stmt.setString(1,toUser);
				rs = stmt.executeQuery();// ִ��SQL��������ݼ�
				while (rs.next())// ������¼
				{
					Borrow borrowing = new Borrow();// ��Ʒ��Ϣ
					// ��set����װ����
					borrowing.setID(rs.getInt("ID"));
					borrowing.setBook_ID(rs.getString("book_ID"));
					borrowing.setBorrowTime(rs.getString("borrowTime"));
					borrowing.setBackTime(rs.getString("backTime"));
					list.add(borrowing);// ��һ����Ʒ��Ϣ���뼯��
				}
				return list;// ���ؼ���
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
				return null;
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		//����
		public void UpdateBorrow(int id,String time1, String time2) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				String sql = "UPDATE tb_borrowinfo SET borrowTime='"+time1+"',backTime='"+time2+"' WHERE ID=?;";// SQL���
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				stmt.setInt(1, id);// ����һ����������Ŵ�1��ʼ
				stmt.execute();// ִ��SQL��������ݼ�
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		

		//�黹
		public void DeleteBorrow(int id) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				String sql = "DELETE FROM tb_borrowinfo WHERE ID=?;";
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				stmt.setInt(1, id);// ����һ����������Ŵ�1��ʼ
				stmt.execute();// ִ��SQL��������ݼ�
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		//�黹ʱ����bookinfo
		public void DeleteUpdateBorrow(String num) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				//String sql = "UPDATE tb_bookinfo SET if_borrow = 0 WHERE book_name=(SELECT book_ID FROM tb_borrowinfo WHERE ID=?);";
				//System.out.println(num);
				String sql = "UPDATE tb_bookinfo SET Number = Number+1 WHERE book_name='"+num+"';";
				//String sql = "UPDATE tb_bookinfo SET if_borrow = 0 WHERE book_id=1;";
				System.out.println(sql);
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				stmt.execute();// ִ��SQL��������ݼ�
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		//��Ӷ�����Ϣ
		public void management_reader(String name,int password, String type,int IDnumber,String phone,int allow) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				String sql = "Insert tb_readerManage SET readerID='"+name+"',password='"+password+"',readerType='"+type+"',idNumber='"+IDnumber+"',readerPhone='"+phone+"',allowBookNum='"+allow+"';";// SQL���
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				stmt.execute();// ִ��SQL��������ݼ�
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		//����������Ϣ
		public ArrayList<Reader> getreaderinfo() {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			ArrayList<Reader> list = new ArrayList<Reader>();// ��Ʒ���� ArrayList����
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				String sql = "select * from tb_readerManage ;";// SQL���
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				//stmt.setString(1,toUser);
				rs = stmt.executeQuery();// ִ��SQL��������ݼ�
				while (rs.next())// ������¼
				{
					Reader Readers = new Reader();// ��Ʒ��Ϣ
					// ��set����װ����
					Readers.setPassword(rs.getString("password"));
					Readers.setReaderPhone(rs.getInt("readerPhone"));
					Readers.setIdNumber(rs.getInt("idNumber"));
					Readers.setAllowBookNum(rs.getInt("allowBookNum"));
					Readers.setReaderID(rs.getString("readerID"));
					Readers.setReaderType(rs.getString("readerType"));
					list.add(Readers);// ��һ����Ʒ��Ϣ���뼯��
				}
				return list;// ���ؼ���
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
				return null;
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		//��ȡ����
		public String getpassword(String name) {
			Connection conn = null;
			PreparedStatement stmt = null;// ��������
			ResultSet rs = null;// ���ݼ�
			String psd="";
			//ArrayList<Reader> list = new ArrayList<Reader>();
			try {
				conn = DBhelper.getConnection();// ������Ӷ���
				String sql = "Select password From tb_readermanage   WHERE readerID='"+name+"';";// SQL���
				stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
				//stmt.setString(1, name);// ����һ����������Ŵ�1��ʼ
				rs=stmt.executeQuery();// ִ��SQL��������ݼ�
				//psd=String.valueOf(rs.getString("password"));
				System.out.println("psd");
				if(rs.next()){//ûnext��ָ�����ûָ���Ӧ��¼
					   psd = rs.getString("password");
				}
				//Reader Readers = new Reader();// ��Ʒ��Ϣ
				//Readers.setPassword(rs.getString("password"));
				//list.add(Readers);
				
			} catch (Exception ex) {
				ex.printStackTrace();// �����쳣��ջ
			} finally// �ͷ���Դ����С�����ͷ�
			{
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			return psd;
		}
		
		//����ע��
				public void register(String name,int password, String type,int IDnumber,String phone) {
					Connection conn = null;
					PreparedStatement stmt = null;// ��������
					ResultSet rs = null;// ���ݼ�
					try {
						conn = DBhelper.getConnection();// ������Ӷ���
						String sql = "Insert tb_readerManage SET readerID='"+name+"',password='"+password+"',readerType='"+type+"',idNumber='"+IDnumber+"',readerPhone='"+phone+"';";// SQL���
						stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
						stmt.execute();// ִ��SQL��������ݼ�
					} catch (Exception ex) {
						ex.printStackTrace();// �����쳣��ջ
					} finally// �ͷ���Դ����С�����ͷ�
					{
						// �ͷ����ݼ�����
						if (rs != null) {
							try {
								rs.close();
								rs = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						// �ͷ�������
						if (stmt != null) {
							try {
								stmt.close();
								stmt = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
				
				//��ȡ��ǰ������Ŀ
				public int getcurrentnumber(String name) {
					Connection conn = null;
					PreparedStatement stmt = null;// ��������
					ResultSet rs = null;// ���ݼ�
					int number = 0;
					//ArrayList<Reader> list = new ArrayList<Reader>();
					try {
						conn = DBhelper.getConnection();// ������Ӷ���
						String sql = "Select currentnumber From tb_readermanage   WHERE readerID='"+name+"';";// SQL���
						stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
						//stmt.setString(1, name);// ����һ����������Ŵ�1��ʼ
						rs=stmt.executeQuery();// ִ��SQL��������ݼ�
						//psd=String.valueOf(rs.getString("password"));
						System.out.println("psd");
						if(rs.next()){//ûnext��ָ�����ûָ���Ӧ��¼
							number = rs.getInt("currentnumber");
						}
						//Reader Readers = new Reader();// ��Ʒ��Ϣ
						//Readers.setPassword(rs.getString("password"));
						//list.add(Readers);
						
					} catch (Exception ex) {
						ex.printStackTrace();// �����쳣��ջ
					} finally// �ͷ���Դ����С�����ͷ�
					{
						// �ͷ����ݼ�����
						if (rs != null) {
							try {
								rs.close();
								rs = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						// �ͷ�������
						if (stmt != null) {
							try {
								stmt.close();
								stmt = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
					return number;
				}
				
				//���µ�ǰ������Ŀ
				public void updateCurrentumber(String name,int code) {
					Connection conn = null;
					PreparedStatement stmt = null;// ��������
					ResultSet rs = null;// ���ݼ�
					String sql="";
					//ArrayList<Reader> list = new ArrayList<Reader>();
					try {
						conn = DBhelper.getConnection();// ������Ӷ���
						if(code==1) {
						 sql = "update tb_readermanage SET currentnumber=currentnumber+1 WHERE readerID='"+name+"';";// SQL���
						}
						else if(code==0)
						{
						 sql = "update tb_readermanage SET currentnumber=currentnumber-1 WHERE readerID='"+name+"';";// SQL���
						}
						stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
						stmt.execute();// ִ��SQL��������ݼ�
					} catch (Exception ex) {
						ex.printStackTrace();// �����쳣��ջ
					} finally// �ͷ���Դ����С�����ͷ�
					{
						// �ͷ����ݼ�����
						if (rs != null) {
							try {
								rs.close();
								rs = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						// �ͷ�������
						if (stmt != null) {
							try {
								stmt.close();
								stmt = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
		
				//��ȡ�Ķ�����Ϣ
				public Reader getreaderinfoByid(int id) {
					Connection conn = null;
					PreparedStatement stmt = null;// ��������
					ResultSet rs = null;// ���ݼ�
					Reader list = new Reader();// ��Ʒ���� ArrayList����
					try {
						conn = DBhelper.getConnection();// ������Ӷ���
						String sql = "select * from tb_readerManage WHERE IdNumber= "+id+";";// SQL���
						stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
						//stmt.setString(1,toUser);
						rs = stmt.executeQuery();// ִ��SQL��������ݼ�
						while (rs.next())// ������¼
						{
							Reader Readers = new Reader();// ��Ʒ��Ϣ
							// ��set����װ����
							Readers.setPassword(rs.getString("password"));
							Readers.setReaderPhone(rs.getInt("readerPhone"));
							Readers.setIdNumber(rs.getInt("idNumber"));
							Readers.setAllowBookNum(rs.getInt("allowBookNum"));
							Readers.setReaderID(rs.getString("readerID"));
							Readers.setReaderType(rs.getString("readerType"));
							Readers.setCurrentnumber(rs.getInt("currentnumber"));
							//list.add(Readers);// ��һ����Ʒ��Ϣ���뼯��
						
						return Readers;// ���ؼ���
						}
					} catch (Exception ex) {
						ex.printStackTrace();// �����쳣��ջ
						return null;
					} finally// �ͷ���Դ����С�����ͷ�
					{
						// �ͷ����ݼ�����
						if (rs != null) {
							try {
								rs.close();
								rs = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						// �ͷ�������
						if (stmt != null) {
							try {
								stmt.close();
								stmt = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
					return list;
					
				}
				
				
				//��ȡ�Ķ�����Ϣ
				public Reader getreaderinfoByname(String name) {
					Connection conn = null;
					PreparedStatement stmt = null;// ��������
					ResultSet rs = null;// ���ݼ�
					Reader list = new Reader();// ��Ʒ���� ArrayList����
					try {
						conn = DBhelper.getConnection();// ������Ӷ���
						String sql = "select * from tb_readerManage WHERE readerID= '"+name+"';";// SQL���
						stmt = conn.prepareStatement(sql);// ����һ�����Ӷ���
						//stmt.setString(1,toUser);
						rs = stmt.executeQuery();// ִ��SQL��������ݼ�
						while (rs.next())// ������¼
						{
							Reader Readers = new Reader();// ��Ʒ��Ϣ
							// ��set����װ����
							//Readers.setPassword(rs.getString("password"));
							Readers.setReaderPhone(rs.getInt("readerPhone"));
							Readers.setIdNumber(rs.getInt("idNumber"));
							Readers.setAllowBookNum(rs.getInt("allowBookNum"));
							Readers.setReaderID(rs.getString("readerID"));
							Readers.setReaderType(rs.getString("readerType"));
							Readers.setCurrentnumber(rs.getInt("currentnumber"));
							//list.add(Readers);// ��һ����Ʒ��Ϣ���뼯��
						
						return Readers;// ���ؼ���
						}
					} catch (Exception ex) {
						ex.printStackTrace();// �����쳣��ջ
						return null;
					} finally// �ͷ���Դ����С�����ͷ�
					{
						// �ͷ����ݼ�����
						if (rs != null) {
							try {
								rs.close();
								rs = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						// �ͷ�������
						if (stmt != null) {
							try {
								stmt.close();
								stmt = null;
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
					return list;
					
				}
				
		
}
