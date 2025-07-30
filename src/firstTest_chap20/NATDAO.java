package firstTest_chap20;

import firstTest_chap20_db.NATdb;

public class NATDAO extends NATdb {
	
	public NATDAO()
	{
		super();
	}
	
	public void getAllList()
	{
		String sql = "select NUM0, NUM1, CHAR2, DATETIME from new_alt_table";
		getStatement();
		try
		{
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\n");
			}
			System.out.println("출력 끝");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert()
	{
		String sql="""
				insert into new_alt_table(NUM0,NUM1,CHAR2,DATETIME)
				values(?,?,?,curdate())
				""";
		try
		{
			getpreparedStatement(sql);
			pstmt.setInt(1, 5);
			pstmt.setInt(2, 4848);
			pstmt.setString(3, "aaabbb");
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		natClose();
	}
	
}
