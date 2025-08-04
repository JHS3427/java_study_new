package java_study_21chap_book_shop.repository;

import java.sql.ResultSet;

import java_study_21chap_book_shop.DBInterface.DBConnection;
import java_study_21chap_book_shop.DBInterface.DBInterface;
import java_study_21chap_book_shop.model.BookShopBookModel;
import java_study_21chap_book_shop.model.BookShopCustormer;

public class BookShopMemberRepo extends DBConnection
implements DBInterface{

	BookShopCustormer bsc;
	BookShopBookModel bsbm;
	public BookShopMemberRepo()
	{
		super();
	}
	
	public String memberIdCheck(String ID)
	{
		String rows = "";
		String sql = "Select UserId from book_market_member where UserId = ?";
		ResultSet rs = search(sql,ID);
		try
		{
			if(rs.next())
			{
				rows = rs.getString(1);
				if(rows == "rrr")
				{
					System.out.print("ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ");
				}
			}
			else
			{
				System.out.print("aaaaaaaaaaa");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	public ResultSet search(String sql,String ID)
	{
		getPreparedStatement(sql);
		try
		{
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	

	public void PwChecker(String ID,String inputpw)
	{
		String sql = "Select UserPw from book_market_member where UserId = ?";
		ResultSet rs = search(sql,ID);
		try
		{
			if(rs.next())
			{
				String pw = rs.getString(1);				
				System.out.println(pw);
				System.out.println(inputpw);
				if(pw == inputpw)
				{
					System.out.print("CCCCCCCCCCCC");
				}
				else
				{
					System.out.print("DDDDDDDDDDDDDD");
				}
			}
			else
			{
				System.out.print("bbbbbbbbbbbb");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public BookShopCustormer memberInfo(String ID)
	{
		bsc = new BookShopCustormer();
		String sql = "select UserId, UserPw, UserName,UserAddress, Phone "
				+ "from book_market_member where UserId = ? ";
		ResultSet rs = search(sql, ID);
		try
		{
			while(rs.next())
			{
				bsc.setUserId(rs.getString(1));
				bsc.setUserPw(rs.getString(2));
				bsc.setUserName(rs.getString(3));
				bsc.setUserAddress(rs.getString(4));
				bsc.setPhone(rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return bsc;
	}
	public int insert(String Id)
	{
		return 0;
	}
	public void showall(String UserId)
	{}
	public void change(int Amount,String userId,String bookId)
	{}
	public void delete(String UserId,String bookId)
	{}
	public void deleteall(String UserId)
	{}
	
	public void payment(String UserId)
	{
		String sql1 = "Select Username, Phone, UserAddress, now() "
				+ "from book_market_member where UserId = ?";
		String sql2 = "Select BookId, Amount, AmountPriceSum"
				+ " from book_market_cart where UserId = ?";
		String sql3 = "select sum(AmountPriceSum)"
				+ " from book_market_cart where userid = ?";
		getPreparedStatement(sql1);
		try
		{
			pstmt.setString(1,UserId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getString(1) + " \t ");
				System.out.println(rs.getString(2));
				System.out.print(rs.getString(3) + " \t ");
				System.out.println(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("장바구니 상품 목록 : ");

		getPreparedStatement(sql2);
		try
		{
			pstmt.setString(1,UserId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getString(1) + " \t ");
				System.out.print(rs.getInt(2) + " \t ");
				System.out.println(rs.getInt(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.print("장바구니 상품 총 금액 : ");

		getPreparedStatement(sql3);
		try
		{
			pstmt.setString(1,UserId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getInt(1) + " \t ");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
