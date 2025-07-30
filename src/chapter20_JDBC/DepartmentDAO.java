package chapter20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbConn;

public class DepartmentDAO extends DbConn{
	
	//Field

		//다른데에서도 url 이라는 변수 쓸수 있으니 다른데에서 못쓰게 private 으로 막아둠
//		private String url = "jdbc:mysql://localhost:3306/hrdb2019";
//		private String user = "root";
//		private String password = "mysql1234";
//		
//		Connection connection;
//		Statement stmt;
//		ResultSet rs;
		
		//constructor	
		public DepartmentDAO() // 호출하고 1단계진행.
		{//1단계
			super();
//			try
//			{
//			//Connection connection = DriverManager.getConnection(String url, String user, String password);
//			connection = DriverManager.getConnection(url, user, password);
//			System.out.println("1단계 성공");
//			
//			//2단계 : Statement 객체 생성
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
		}

		
		//method
		//2단계를 메소드로 정의 : Statement 생성
//		public void getStatement()// throws Exception
//		{
//			try
//			{
//				stmt = connection.createStatement();
//				System.out.println("2단계 성공");
//			}
//			catch(Exception e){e.printStackTrace();}
//		}
//		
//		//3단계 : ResultSet > CRUD 기능에 따라 메소드를 분할 및 변경하자. 해당 메소드 밑으로가 분할
//		public ResultSet getResultSet(String sql)
//		{
//			try
//			{
//				rs = stmt.executeQuery(sql); // 4단계 : 데이터 추출
//			}
//			catch(Exception e){e.printStackTrace();}
//			return rs;
//		}
		
		//C : Create - Insert
		public boolean insert(DepartmentVo department)
		{
			boolean result = false;
			String sql ="""
					insert into department(dept_id,dept_name,unit_id,start_date)
					values(?,?,?,curdate())
					""";
			try
			{
				getPreparedStatement(sql);
				pstmt.setString(1, department.getDeptId());//첫번쨰를 0번이 아니라 1번자리로 친다.
				pstmt.setString(2, department.getDeptName());
				pstmt.setString(3, department.getUnitId());
				int rows = pstmt.executeUpdate();
				if(rows==1) result = true;
//				getStatement();
//				if(stmt != null)
//				{
//					StringBuilder sb = new StringBuilder();
//					sb.append("Insert into department(dept_id,dept_name,unit_id,start_date) ");
//					sb.append(" values('");//이거 따옴표 하나(')안넣으면 순수 문자열로 안들어가고 변수처럼 취급해서 안들어감.
//					sb.append(department.getDeptId()+"' , '");
//					sb.append(department.getDeptName()+"' , '");
//					sb.append(department.getUnitId()+"' , ");
//					sb.append(" curdate() )");
//					//위에 "' '" 이꼴 보기 싫어서 preparedStatment가 개발됐다.
//					int resultRow = stmt.executeUpdate(sb.toString());
//					System.out.println("rows --> " + resultRow);
//					if(resultRow==1)
//					{
//						result = true;
//					}
//				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return result;
		}
		
		
		
		//전체 리스트 출력
		public List<DepartmentVo> getList()
		{
			List<DepartmentVo> list = new ArrayList<DepartmentVo>();
			String sql = """
					select dept_id,
					dept_name,
					unit_id,
					start_date
					from department
					""";
			try
			{
				getStatement();
				rs = stmt.executeQuery(sql); // 4단계 : 데이터 추출
				while(rs.next())
				{//한번 돌때, rs 객체의 1개 row를 가져옴. 이걸 EmployeeVo에 담고, 그걸 list에 넣기
					DepartmentVo department = new DepartmentVo();
					department.setDeptId(rs.getString(1));
					department.setDeptName(rs.getString(2));
					department.setUnitId(rs.getString(3));
					department.setStartDate(rs.getString(4));
					list.add(department);
				}
			}
			catch(Exception e){e.printStackTrace();}
			return list;
		}
		
		
		
		//5단계 : Close
//		public void close()
//		{
//			try
//			{
//				if(rs!=null) rs.close();
//				if(stmt!=null) stmt.close();
//				if(connection!=null) connection.close();
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
}
