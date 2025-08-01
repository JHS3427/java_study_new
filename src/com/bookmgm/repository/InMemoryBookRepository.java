package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;

import db.DbConn;
import db.GenericRepositoryInterface;

public class InMemoryBookRepository
extends DbConn
implements GenericRepositoryInterface<Book>{
	
	static final String TJ ="book_tj";
	static final String YES24 ="book_yes24";
	static final String ALADIN ="book_aladin";
	String tableName ="";
	public InMemoryBookRepository(int rno)
	{
		super(); 
		// super(); 이거 없어도 작동하는 이유: 상속하면 컴파일러가 돌리면서 super 없으면
		// 자동으로 인지하고, 없는걸 추가해줌.
		//그럼 super() 왜쓰냐 -> 괄호안에 매개변수 집어넣어서 특정 매개변수를 갖는 생성자를 호출할 수 있음.
		createTitle(rno);
		System.out.println("교육센터 생성");
	}
	public void createTitle(int rno)
	{
		String name = null;
		if(rno == 1) 
		{
			name = "교육센터";
			System.out.println("교육센터 TJ");
			tableName = TJ;
		}
		else if(rno==2)
			{
			name = "알라딘";
			System.out.println("교육센터 알라딘");
			tableName = ALADIN;
			}
		else if(rno==3) 
			{
			name = "예스24";
			System.out.println("교육센터 예스24");
			tableName = YES24;
			}
		System.out.println("===도서관 선택 완료 " );
		
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
		String sql = "insert into "+ tableName +
				"(title,author,price,bdate) values(?,?,?,now())";
		try
		{
			getPreparedStatement(sql); //values는 들어가도 문제 없는데,컬럼명이나 테이블명에 들어가면 문제가 생긴다
//			pstmt.setString(1, tableName);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
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

		String sql = "select count(*) as count from "+ tableName;
		try
		{
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				rows = rs.getInt(1);
				//또는 getInt("count")로(=화면에 뜨는 컬럼명 = as 뒷부분) 줘도 된다.
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
				select row_number() over(order by  bid) as rno,
bid, title, author,isbn,price,bdate from 
				""" + tableName;
		try
		{
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Book book = new Book();
				book.setRno(rs.getInt(1));
				book.setBid(rs.getString(2));
				book.setTitle(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setIsbn(rs.getInt(6));
				book.setBdate(rs.getString(7));
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
		String sql = " Select bid,title,author,price,isbn,bdate from " 
		+ tableName	+ " where bid = ?";
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
	}
	public int update(Book book)
	{
		int rows = 0;
		String sql = 
				"update "
		+ tableName 
		+" set title=?,author=?,price=?,bdate=now()where bid=?";
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
		String sql = " delete from " + tableName  + " where bid=?";
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
	};
	
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
//				System.out.println("깊은복사 확인");
//				System.out.println(b.getAuthor());
//				System.out.println(book.getAuthor());
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
	
}
