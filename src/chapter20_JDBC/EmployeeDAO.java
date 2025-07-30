package chapter20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbConn;

public class EmployeeDAO extends DbConn{
	//Field

	//다른데에서도 url 이라는 변수 쓸수 있으니 다른데에서 못쓰게 private 으로 막아둠
//	private String url = "jdbc:mysql://localhost:3306/hrdb2019";
//	private String user = "root";
//	private String password = "mysql1234";
//	
//	Connection connection;
//	Statement stmt;
//	ResultSet rs;
	
	//constructor	
	public EmployeeDAO() // 호출하고 1단계진행.
	{//1단계
		super(); // 부모(DBConn)의 생성자 호출
//		try
//		{
//		//Connection connection = DriverManager.getConnection(String url, String user, String password);
//		connection = DriverManager.getConnection(url, user, password);
//		System.out.println("1단계 성공");
//		
//		//2단계 : Statement 객체 생성
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}

	
	//method
	//2단계를 메소드로 정의 : Statement 생성
//	public void getStatement()// throws Exception
//	{
//		try
//		{
//			stmt = connection.createStatement();
//			System.out.println("2단계 성공");
//		}
//		catch(Exception e){e.printStackTrace();}
//	}
	
	//3단계 : ResultSet > CRUD 기능에 따라 메소드를 분할 및 변경하자. 해당 메소드 밑으로가 분할
//	public ResultSet getResultSet(String sql)
//	{
//		try
//		{
//			rs = stmt.executeQuery(sql); // 4단계 : 데이터 추출
//		}
//		catch(Exception e){e.printStackTrace();}
//		return rs;
//	}
	

	public List<EmployeeVo> getList()
	{
		
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		String sql = """
				select emp_id,
				emp_name,
				hire_date,
				salary
				from employee
				""";
		try
		{
			getStatement(); //부모꺼 호출 - stmt 생성
			rs = stmt.executeQuery(sql); // 4단계 : 데이터 추출
			while(rs.next())
			{//한번 돌때, rs 객체의 1개 row를 가져옴. 이걸 EmployeeVo에 담고, 그걸 list에 넣기
				EmployeeVo employee = new EmployeeVo();
				employee.setEmpID(rs.getString(1));
				employee.setEmpName(rs.getString(2));
				employee.setHireDate(rs.getString(3));
				employee.setSalary(rs.getInt(4));
				list.add(employee);
			}
		}
		catch(Exception e){e.printStackTrace();}
		close();
		return list;
	}
	
	
	
	//5단계 : Close
//	public void close()
//	{
//		try
//		{
//			if(rs!=null) rs.close();
//			if(stmt!=null) stmt.close();
//			if(connection!=null) connection.close();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
