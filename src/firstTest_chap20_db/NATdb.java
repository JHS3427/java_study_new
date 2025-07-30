package firstTest_chap20_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
public class NATdb {

	//Field
	
	String url= "jdbc:mysql://localhost:3306/hrdb2019";
	String user = "root";
	String password = "mysql1234";
	
	Connection connection;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	
	//Constructor
	protected NATdb()
	{
		try
		{
			connection= DriverManager.getConnection(url,user,password);
			System.out.println("접속 성공");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//method
	public void getStatement()
	{
		try
		{
			stmt = connection.createStatement();
			System.out.println("stmt 생성 성공");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void getpreparedStatement(String sql)
	{
		try
		{
			pstmt = connection.prepareStatement(sql);
			System.out.println("pstmt 생성 성공");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getResultSet(String sql)
	{
		try
		{
			rs = stmt.executeQuery(sql);
			System.out.println("SQL 수행");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public void natClose()
	{
		try
		{
			if(rs != null) {rs.close();}
			if(stmt != null) {stmt.close();}
			if(pstmt != null) {pstmt.close();}
			if(connection != null) {connection.close();}
			System.out.println("끝");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
