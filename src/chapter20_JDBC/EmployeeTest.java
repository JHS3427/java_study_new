package chapter20_JDBC;

import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
//		dao.getStatement();
		//ResultSet rs = dao.getResultSet("select emp_id, emp_name from employee");
//		try
//		{
//			while(rs.next())
//			{
//				System.out.print(rs.getString(1) + " \t ");
//				System.out.print(rs.getString(2) + " \n ");
//			}
//		}
//		catch(Exception e)
//		{ e.printStackTrace();}
		List<EmployeeVo> list = dao.getList();
		list.forEach( (employee)->
		{
			System.out.print(employee.getEmpID()+ "\t ");
			System.out.print(employee.getEmpName()+ "\t ");
			System.out.print(employee.getHireDate()+ "\t ");
			System.out.print(employee.getSalary()+ "\n");
		});
//		dao.close();
		
	}

}
