package dom.book.service;

import dom.book.application.BookManagementApplication;
import dom.book.repository.BookDataRepositoryInterface;

public class BookService implements BookServiceInterface{

	BookManagementApplication bma2;
	BookDataRepositoryInterface repository;
	
	public BookService()
	{}
	public BookService(BookManagementApplication bma)
	{
		this.bma2=bma;

	}
	
	public void register()
	{
		System.out.println("등록 페이지입니다.");
	}
	public void list()
	{
		
	}
	public void search()
	{
		
	}
	public void update()
	{
		
	}
	public void delete()
	{
		
	}
	public void exit()
	{
		
	}
}
