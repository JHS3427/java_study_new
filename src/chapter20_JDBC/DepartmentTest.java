package chapter20_JDBC;

import java.util.List;

public class DepartmentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentVo insertVo = new DepartmentVo();
		insertVo.setDeptId("QQQ");
		insertVo.setDeptName("테스트3");
		insertVo.setUnitId("C");
		
		if(dao.insert(insertVo))
		{// 객체 지향이니 이렇게 주는게 좋다 
			List<DepartmentVo> list = dao.getList();
			list.forEach((department) ->{
				System.out.print(department.getDeptId()+"\t");
				System.out.print(department.getDeptName()+"\t");
				System.out.print(department.getUnitId()+"\t");
				System.out.print(department.getStartDate()+"\n");
			});
		}
		dao.close();
	}

}
