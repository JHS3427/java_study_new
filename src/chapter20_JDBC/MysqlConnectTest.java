package chapter20_JDBC;
//import가 빨갛게 뜰 수 있는데, 그거 module-info 안지워서 그런거니 지워버리자.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlConnectTest {

	public static void main(String[] args) {
		try
			{
			// 0단계 : 드라이버 다운로드 및 패스 추가 - 완료.
			// 1단계 : 드라이버 로딩 - Drivermanager 사용. 
			// https://docs.oracle.com/en/java/javase/21/docs//api/java.sql/java/sql/DriverManager.html#method-summary 
			// URL 형식 : String url = "jdbc:mysql://서버주소:포트번호/DB명?옵션들 추가,,,";
			// 위의 URL 형식은 드라이버 타입(mysql,oracle 등)에 따라 다르다			
			
			String url = "jdbc:mysql://localhost:3306/hrdb2019";
			String user = "root";
			String password = "mysql1234";
			//Connection connection = DriverManager.getConnection(String url, String user, String password);
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("1단계 성공");
			
			//2단계 : Statement 객체 생성
			Statement stmt = connection.createStatement();
			System.out.println("2단계 성공");
			
			//3단계  sql문 넣어보기 - 방법 3가지
			//1. 더하기로 하기 - 비추천. 2. """ """으로 묶기.
			//3. StringBuilder 객체 사용. -- 어느버젼에서나 사용 가능 
//			String sql = "select emp_id,emp_name,dept_id, salary from employee"
//					+" where dept_id = 'SYS'";

//			StringBuilder sb =new StringBuilder(100);
//			sb.append("select emp_id,emp_name,dept_id, salary from employee ");
//			sb.append(" where dept_id = 'SYS'");
			
//			-- JDK버젼 15 이상에서만 사용 가능. --> 자바스크립트에서는 ``(벡틱연산자 '~'키):"탬플릿 리터럴" 로 씀.
			String sql = """ 
					select row_number() over() as rno,
					emp_id,
					emp_name,
					dept_id, 
					salary,
					hire_date
					from employee 
					where dept_id = 'sys';					
					""";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs != null)
			{
				System.out.println("3단계 성공");
				while(rs.next())
				{
					// 향후에는 아래의 내용들을 ArralyList에 담아 사용함
					//List<row>가 담기는 객체 :employeeVo 이런식으로 진행
					System.out.print(rs.getInt(1) +" \t "); // - 첫번째 컬럼이 0번이 아니라 1번부터다.
					System.out.print(rs.getString(2)+" \t ");
					System.out.print(rs.getString(3)+" \t ");
					System.out.print(rs.getString(4)+" \t ");
					System.out.print(rs.getInt(5) +" \t");
					System.out.print(rs.getDate(6) +" \n");
					//System.out.print(rs.getInt("rno")); // - 내가 뽑아둔 DB에서 이름을 줘도 된다.
				}
				
				
				//4단계 : rs 객체에서 데이터 추출하기.
				System.out.println("4단계 성공");
				
				
			}
			//5단계 : 실행한 connection, stmt, rs 객체 close(종료) 하기

			if(rs != null) { rs.close();}
			if(stmt != null) { stmt.close();}
			if(connection != null) { connection.close();}
			System.out.println("5단계 성공 + 종료.");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
