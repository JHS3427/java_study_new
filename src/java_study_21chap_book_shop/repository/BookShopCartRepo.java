package java_study_21chap_book_shop.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java_study_21chap_book_shop.DBInterface.DBConnection;
import java_study_21chap_book_shop.DBInterface.DBInterface;
import java_study_21chap_book_shop.model.BookShopBookModel;
import java_study_21chap_book_shop.model.BookShopCart;

public class BookShopCartRepo extends DBConnection
implements DBInterface{
	
	BookShopCart cartmodle;
	List<BookShopBookModel> bookModel;
	
	public BookShopCartRepo()
	{
		bookModel = new ArrayList<BookShopBookModel>();
		String sql = "Select BookId,Title,Author,Price,BigSort,InputDate from book_market_books";
		getPreparedStatement(sql);
		try
		{
//			System.out.println("책 ID // 제목 // 작가 // 가격 // 대분류 // 등록날짜");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				BookShopBookModel book = new BookShopBookModel();
				book.setBookId(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setBigSort(rs.getString(5));
				book.setInputDate(rs.getString(6));
				bookModel.add(book);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void booklist()
	{
		bookModel.forEach((model) ->
		{
			System.out.print(model.getBookId()+ " // ");
			System.out.print(model.getTitle()+ " // ");
			System.out.print(model.getAuthor()+ " // ");
			System.out.print(model.getPrice()+ " // ");
			System.out.print(model.getBigSort()+ " // ");
			System.out.print(model.getInputDate()+ " // \n ");
		});
		
//		String sql = "Select BookId,Title,Author,Price,BigSort,InputDate from book_market_books";
//		getPreparedStatement(sql);
//		try
//		{
////			System.out.println("책 ID // 제목 // 작가 // 가격 // 대분류 // 등록날짜");
//			rs = pstmt.executeQuery();
//			while(rs.next())
//			{
//				BookShopBookModel book = new BookShopBookModel();
//				System.out.print(rs.getString(1) + " // ");
//				book.setBookId(rs.getString(1));
//				System.out.print(rs.getString(2) + " // ");
//				book.setTitle(rs.getString(2))
//				System.out.print(rs.getString(3) + " // ");
//				book.setAuthor(rs.getString(3));
//				System.out.print(rs.getInt(4) + " // ");
//				book.setPrice(rs.getInt(4));
//				System.out.print(rs.getString(5) + " // ");
//				book.setBigSort(rs.getString(5));
//				System.out.print(rs.getString(6) + " // \n");
//				book.setInputDate(rs.getString(6));
//				bookModel.add(book);
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
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
	public int insertcart(String UserId, String bookId, int Amount)
	{
		int rows = 0;
		int price = 0;
		String sql1 = "Select Price from book_market_books where bookId = ? ";
		try
		{
			getPreparedStatement(sql1);
			pstmt.setString(1, bookId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				price = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("가격은 : " + price);
		if(price == 0)
		{
			System.out.println("책 ID 입력값이 이상합니다.");
		}
		else
		{
			String sql2 = "Insert into book_market_cart"
					+ "(UserId, BookId, Amount, AmountPriceSum) "
					+ "values (?,?,?,?)";
			try
			{
				getPreparedStatement(sql2);
				pstmt.setString(1, UserId);
				pstmt.setString(2, bookId);
				pstmt.setInt(3, Amount);
				pstmt.setInt(4, Amount * price);
				rows = pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return rows;
	}
	public void showall(String UserId)
	{
		String sql = "Select UserId, BookId,Amount,AmountPriceSum from book_market_cart"
				+ " where UserId = ?";
		getPreparedStatement(sql);
		try
		{
			System.out.println(" 유저ID *** 책 ID *** 수량 *** 각 도서별 총 금액");
			pstmt.setString(1, UserId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getString(1) + " *** ");
				System.out.print(rs.getString(2) + " *** ");
				System.out.print(rs.getInt(3) + " *** ");
				System.out.print(rs.getInt(4) + " *** \n ");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	};
	public void change(int Amount,String UserId,String bookId)
	{
		int price = 0;
		String sql1 = "select Price from book_market_books where bookId = ?";
		try
		{
			getPreparedStatement(sql1);
			pstmt.setString(1, bookId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				price = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String sql = "update book_market_cart"
				+ " set Amount = ? , AmountPriceSum = Amount * ? "
				+ " where UserId = ?"
				+ " and BookId = ?";
		try
		{
			getPreparedStatement(sql);
			pstmt.setInt(1, Amount);
			pstmt.setInt(2, price);
			pstmt.setString(3, UserId);
			pstmt.setString(4, bookId);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	};
	public void delete(String UserId,String bookId)
	{
		String sql = "delete from book_market_cart where UserId = ? and bookId = ?";
		try
		{
			getPreparedStatement(sql);
			pstmt.setString(1, UserId);
			pstmt.setString(2, bookId);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	};
	public void deleteall(String UserId)
	{
		String sql = "delete from book_market_cart where UserId = ?";
		try
		{
			getPreparedStatement(sql);
			pstmt.setString(1, UserId);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
