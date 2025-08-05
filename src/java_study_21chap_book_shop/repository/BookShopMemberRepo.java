package java_study_21chap_book_shop.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java_study_21chap_book_shop.DBInterface.DBConnection;
import java_study_21chap_book_shop.DBInterface.DBInterface;
import java_study_21chap_book_shop.model.BookShopBookModel;
import java_study_21chap_book_shop.model.BookShopCustormer;
import java_study_21chap_book_shop.model.BookShopReceipt;

public class BookShopMemberRepo extends DBConnection
implements DBInterface{

	BookShopCustormer bsc;
	BookShopBookModel bsbm;
	BookShopReceipt bsr;
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
			}
			else
			{
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	public void search(String ID,String Name,String phone)
	{
		String sql = "select UserPw "
				+ " from book_market_member "
				+ " where UserId = ? and UserName = ? and Phone = ?";
		getPreparedStatement(sql);
		try
		{
			pstmt.setString(1, ID);
			pstmt.setString(2, Name);
			pstmt.setString(3, phone);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
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
				if(pw.equals(inputpw))
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
		List<BookShopReceipt> list = new ArrayList<BookShopReceipt>();
		String sql1 = "select bmm.userId, bmm.useraddress, "
				+ " bmc.bookId, bmc.amount, bmc.amountpricesum, now() from book_market_member bmm"
				+ " left outer join book_market_cart bmc on bmc.UserId = bmm.UserId"
				+ " where bmm.userId = ?";
		getPreparedStatement(sql1);
		try
		{
			pstmt.setString(1,UserId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				bsr = new BookShopReceipt();
				bsr.setUserId(rs.getString(1));
				bsr.setUserAddress(rs.getString(2));
				bsr.setBookId(rs.getString(3));
				bsr.setAmount(rs.getInt(4));
				bsr.setAmountPriceSum(rs.getInt(5));
				bsr.setBuyingDate(rs.getString(6));
				list.add(bsr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(bsr.getAmount()!=0)
		{
			String sql2 = "insert into book_market_receipt(UserId,BookId,Amount, "
					+ " AmountPriceSum,BuyingDate,UserAddress) "
					+ " values(?,?,?,?,?,?)";
			getPreparedStatement(sql2);
		
			list.forEach(bdate -> {
				try
				{
					pstmt.setString(1,bdate.getUserId());
					pstmt.setString(2,bdate.getBookId());
					pstmt.setInt(3,bdate.getAmount());
					pstmt.setInt(4,bdate.getAmountPriceSum());
					pstmt.setString(5,bdate.getBuyingDate());
					pstmt.setString(6,bdate.getUserAddress());
					pstmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			});
		}
	}
	public void paymentshow(String ID)
	{
		String sql = "select UserName, phone, UserAddress, now() from book_market_member"
				+ " where userid = ?";
		String sql2 = "select bookId, amount, amountpricesum from book_market_receipt "
				+ " where userId = ?";
		String sql3 = "select sum(amountpricesum) from book_market_receipt "
				+ " where userId = ?";
		ResultSet rs = search(sql,ID);
		ResultSet rs2 = search(sql2,ID);
		ResultSet rs3 = search(sql3,ID);
		try {
			while(rs.next())
			{
				System.out.println("이름 : "+rs.getString(1));
				System.out.println("전화번호 : " +rs.getString(2));
				System.out.println("주소 : "+rs.getString(3));
				System.out.println("배송일 : "+rs.getString(4));
			}
			while(rs2.next())
			{
				System.out.print("책 ID : "+rs2.getString(1) + " \t ");
				System.out.print("수량 : " +rs2.getInt(2) + " \t ");
				System.out.println("해당 책의 총 가격 : "+rs2.getInt(3));
			}
			while(rs3.next())
			{
				System.out.println("총액 : "+rs3.getInt(1));
			}
			rs.close();
			rs2.close();
			rs3.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void paymentshow(String NName, String NPhone, String NAddress, String ID)
	{
		String sql = "select bookId, amount, amountpricesum from book_market_receipt "
				+ " where userId = ?";
		String sql2 = "select sum(amountpricesum) from book_market_receipt "
				+ " where userId = ?";
		System.out.println("이름 : "+ NName);
		System.out.println("전화번호 : " +NPhone);
		System.out.println("주소 : "+ NAddress);
		System.out.println("배송일 : ???");
		ResultSet rs = search(sql,ID);
		ResultSet rs2 = search(sql2,ID);		
		try {
			while(rs.next())
			{
				System.out.print("책 ID : "+rs.getString(1) + " \t ");
				System.out.print("수량 : " +rs.getInt(2) + " \t ");
				System.out.println("해당 책의 총 가격 : "+rs.getInt(3));
			}
			while(rs2.next())
			{
				System.out.println("총액 : "+rs2.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
