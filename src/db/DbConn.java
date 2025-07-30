package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConn {
	//Field
	private String url = "jdbc:mysql://localhost:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	protected Statement stmt; //상속받는 클래스는 어디서든 쓸수 있게끔 만들어준다.
	//넘겨주는 방식은 위에 이거처럼 하던지 아니면 그냥 메소드에 타입선언하고 리턴해서 줘버려도 된다.
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	//Constructor
	
	protected DbConn() // - 상속자만 쓰게 하겠다.
	{
		try
		{
			//1단계 : 연결
			//Connection connection = DriverManager.getConnection(String url, String user, String password);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("1단계 성공");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Statement 생성
	//2단계를 메소드로 정의 : Statement 생성
	public void getStatement()// throws Exception
	{
		try
		{
			stmt = connection.createStatement();
			System.out.println("2단계 성공");
		}
		catch(Exception e){e.printStackTrace();}
		//return stmt;
	}
	
	// PreparedStatement
	public void getPreparedStatement(String sql)
	{
		try
		{
			pstmt = connection.prepareStatement(sql);
			System.out.println("2단계 성공");
		}
		catch(Exception e){e.printStackTrace();}
	}
	// 5단계 : 닫기.
	public void close()
	{
		try
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(connection!=null) connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
