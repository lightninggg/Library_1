package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBhelper {
	private static final String driver="com.mysql.jdbc.Driver";//���������� 
	//URLָ��Ҫ���ʵ����ݿ���shopping
	private static final String url="jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";
	private static final String username="root";
	private static final String password="785210";
	private static Connection conn=null;//Connection��Ҫ�����������ݿ�
	
	//��̬����鸺���������
	static
	{
		try
		{
			Class.forName(driver);//������������ 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();//�׳��쳣ʱ���쳣��ջ
		}
	}
	
	//����ģʽ�������ݿ����Ӷ���
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn=DriverManager.getConnection(url, username, password);//�������ݿ� 
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args)
	{
		try
		{
			Connection conn=DBhelper.getConnection();
			if(conn!=null)
			{
				System.out.println("���ݿ���������");
			}
			else
			{
				System.out.println("���ݿ������쳣");			
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
