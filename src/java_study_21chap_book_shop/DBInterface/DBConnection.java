package java_study_21chap_book_shop.DBInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	//Field
	private String url = "jdbc:mysql://localhost:3306/hrdb2019?characterEncoding=UTF-8";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	protected Statement stmt; //상속받는 클래스는 어디서든 쓸수 있게끔 만들어준다.
	//넘겨주는 방식은 위에 이거처럼 하던지 아니면 그냥 메소드에 타입선언하고 리턴해서 줘버려도 된다.
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	protected DBConnection()
	{
		try
		{
			connection = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected void getStatement()
	{
		try
		{
			stmt = connection.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected void getPreparedStatement(String sql)
	{
		try
		{
			pstmt = connection.prepareStatement(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected void close()
	{
		if (rs!=null)
		{
			try
			{rs.close();}
			catch(Exception e)
			{e.printStackTrace();}
		}
		if (pstmt!=null)
		{
			try
			{pstmt.close();}
			catch(Exception e)
			{e.printStackTrace();}
		}
		if (stmt!=null)
		{
			try
			{stmt.close();}
			catch(Exception e)
			{e.printStackTrace();}
		}
		if (connection!=null)
		{
			try
			{connection.close();}
			catch(Exception e)
			{e.printStackTrace();}
		}
	}
	
}
