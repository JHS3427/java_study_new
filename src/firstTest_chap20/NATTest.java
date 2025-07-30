package firstTest_chap20;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import firstTest_chap20_db.NATdb;

public class NATTest{

	public static void main(String[] args) {
		/*
		NATdb nat = new NATdb();
		nat.getStatement();
		String sql = "select NUM0, NUM1, CHAR2, DATETIME from new_alt_table";
		ResultSet rs = nat.getResultSet(sql);
		try 
		{
			while(rs.next())
			{
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\n");
			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		nat.natClose();
	*/
		NATDAO natdao = new NATDAO();
		natdao.insert();
		natdao.getAllList();
		natdao.close();
	}
}
