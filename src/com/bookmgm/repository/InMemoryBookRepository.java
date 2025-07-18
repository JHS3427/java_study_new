package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;

public class InMemoryBookRepository implements BookRepository{
	
	List<Book> library = new ArrayList<Book>();
	
	public InMemoryBookRepository()
	{
		System.out.println("교육센터 도서관 생성");
	}
	
	@Override
	public boolean insert(Book book)
	{
		if(book!=null)
		{
			return library.add(book);
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public List<Book> selectAll()
	{
		
		return this.library;
	}
	
	@Override
	public Book select(String id)
	{
		Book Tb = new Book();
		for(Book book :this.library)
		{
			if(book.getId().equals(id))
			{
				Tb = book;
				break;
			}
		}
		return Tb;
	}
	
	@Override
	public void update(Book book)
	{
		int idx = -1;
		int i =0;
		for(Book b : library) {
			if(b.getId().equals(book.getId()))
			{
				idx = i;
				break;
			}
			i++;			
		}
		library.set(idx,book);
	}
	
	@Override
	public void remove(String id)
	{
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext())
		{
			Book book = ie.next();
			if(book.getId().equals(id))
			{
				ie.remove();
				break;
			}
		}
	}

	@Override
	public void remove(Book book)
	{
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext())
		{
			Book b= ie.next();
			if(b == book)
			{
				ie.remove();
				break;
			}
		}
		
	}
	
	
	@Override
	public int getCount()
	{
		return library.size();
	}
	
	
}
