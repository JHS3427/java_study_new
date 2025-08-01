package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;

import db.DbConn;
import db.GenericRepositoryInterface;

public class AladinBookRepository extends DbConn
implements GenericRepositoryInterface<Book>{

	public AladinBookRepository()
	{
		super();
		System.out.println("알라딘 생성");
	}
	@Override
	public int insert(Book book)
	{
//		if(book!=null)
//		{
//			return library.add(book);
//		}
//		else
//		{
//			return false;
//		}
		int rows = 0;
		String sql = """
				insert into book_aladin(title,author,price,bdate)
				values(?,?,?,now())
				""";
		try
		{
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
//			pstmt.setString(4, book.getTitle());
			rows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}

	public int getCount() 
	{
		int rows= 0;

		String sql = """
				select count(*) from book_aladin
				""";
		try
		{
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				rows = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	public List<Book> findAll()
	{
		List<Book> list = new ArrayList<Book>();
		String sql = """
				select bid,
				title,
				author,
				price,
				isbn,
				bdate
				from book_aladin
				""";
		try
		{
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Book book = new Book();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
				list.add(book);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	public Book find(String id)
	{
		Book book = new Book();
		String sql = """
				Select bid,
				title,
				author,
				price,
				isbn,
				bdate
				from book_aladin
				where bid = ?
				""";
		try
		{
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	};
	public int update(Book book)
	{
		int rows = 0;
		String sql = """
				update book_aladin 
				set title=?,
				 	author=?,
				 	price=?,
				 	bdate=now()
				where bid=?
				""";
		try
		{
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBid());
			rows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rows;	
	}
	public int remove(String id)
	{
		int rows = 0;
		String sql = """
			delete from book_aladin
			where bid=?
			""";
		try
		{
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rows;		
	}
	
}
//	
//	List<Book> library = new ArrayList<Book>();
//	
//	public Yes24BookRepository()
//	{
//		System.out.println("에스 24 도서관 생성");
//	}
//	@Override
//	public boolean insert(Book book)
//	{
//		if(book!=null)
//		{
//			return library.add(book);
//		}
//		else
//		{
//			return false;
//		}
//	}
//	
//	@Override
//	public List<Book> selectAll()
//	{
//		
//		return this.library;
//	}
//	
//	@Override
//	public Book select(String id)
//	{
//		Book Tb = new Book();
//		for(Book book :this.library)
//		{
//			if(book.getId().equals(id))
//			{
//				Tb = book;
//				break;
//			}
//		}
//		return Tb;
//	}
//	
//	@Override
//	public void update(Book book)
//	{
//		int idx = -1;
//		int i =0;
//		for(Book b : library) {
//			if(b.getId().equals(book.getId()))
//			{
//				idx = i;
//				break;
//			}
//			i++;			
//		}
//		library.set(idx,book);
//	}
//	
//	@Override
//	public void remove(String id)
//	{
//		Iterator<Book> ie = library.iterator();
//		while(ie.hasNext())
//		{
//			Book book = ie.next();
//			if(book.getId().equals(id))
//			{
//				ie.remove();
//				break;
//			}
//		}
//	}
//
//	@Override
//	public void remove(Book book)
//	{
//		Iterator<Book> ie = library.iterator();
//		while(ie.hasNext())
//		{
//			Book b= ie.next();
//			if(b == book)
//			{
//				ie.remove();
//				break;
//			}
//		}
//		
//	}
//	
//	
//	@Override
//	public int getCount()
//	{
//		return library.size();
//	}
//	
//	
//}