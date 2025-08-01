package com.bookmgm.service;

import java.util.List;
import java.util.Random;

import com.bookmgm.application.BookManagementApplication;
import com.bookmgm.model.Book;
import com.bookmgm.repository.InMemoryBookRepository;

import db.GenericRepositoryInterface;

public class DefaultBookService implements BookService {
	
	BookManagementApplication bma;
	GenericRepositoryInterface<Book> repository ;
	
	public DefaultBookService()
	{}
	
	public DefaultBookService(BookManagementApplication bma) {
		this.bma = bma;
		selectRepository();
//		repository = new InMemoryBookRepository();
	}
	
	
	@Override
	public void register()
	{
//		selectRepository();
		
		System.out.println("도서 등록");
		Book book = createBook();
		if(repository.insert(book)==1)
		{
			//등록 성공
			System.out.println("✅도서 등록");
		}
		else
		{
			//등록 실패
			System.out.println("✅✅✅✅도서 등록 실패✅✅✅✅");
		}
		bma.showMenu();
	}
	
	@Override
	public void list()
	{
		if(getCount()!=0)
		{
//			List<Book> LB = repository.selectAll();
//			for(Book b : LB)
//			{
//				System.out.println(b.getId() + " \t "+ b.getName()+ " \t "+ b.getAuthor()+ " \t "+ b.getPrice());
//			}
			List<Book> library = repository.findAll();
			library.forEach(book ->{
				System.out.print("["+book.getRno()+"] \t");
				System.out.print("["+book.getBid()+"] \t");
				System.out.print("["+book.getTitle()+"] \t -");
				System.out.print("["+book.getAuthor()+"] \t");
				System.out.print("["+book.getPrice()+"] \t");
				System.out.print("["+book.getIsbn()+"] \t");
				System.out.println("["+book.getBdate()+"] \n");
			});
		}
		else
		{
			System.out.println("등록된 도서가 없습니다.");
		}
		bma.showMenu();
	}
//	
	@Override
	public void search()
	{
		if(getCount()!=0)
		{
			System.out.println("도서번호 입력");
			Book book = repository.find(bma.scan.next());
			if(book.getBid() != null)
			{
				printBook(book);
			}
			else
			{
				System.out.println("검색한 도서가 없습니다.");
			}
		}
		else
		{
			System.out.println("등록된 도서가 없습니다.");
		}
		bma.showMenu();
	}
//	/**
//	 * 도서 출력 - 검색 수정 시 결과 출력.
//	 */
//
	public void printBook(Book book)
	{
		System.out.print("["+book.getBid()+"] \t");
		System.out.print("["+book.getTitle()+"] \t -");
		System.out.print("["+book.getAuthor()+"] \t");
		System.out.print("["+book.getPrice()+"] \t");
		System.out.print("["+book.getIsbn()+"] \t");
		System.out.println("["+book.getBdate()+"] \n");
	}
//	
//	
//	
	@Override
	public void update()
	{
		if(getCount()!=0)
		{
			System.out.println("도서번호 입력");
			Book book = repository.find(bma.scan.next());//옛날 도서의 전체 정보.
			if(book.getBid() != null)
			{
				repository.update(createBook(book));
				System.out.print("수정");
				printBook(book);
			}
			else
			{
				System.out.println("검색결과가 없습니다.");
			}
		}
		else
		{
			System.out.println("등록된 도서가 없습니다.");
		}
		bma.showMenu();
	}
//	
	@Override
	public void delete()
	{
		if(getCount()!=0)
		{
			System.out.println("도서번호 입력");
			String id = bma.scan.next();
			Book book = repository.find(id);//옛날 도서의 전체 정보.
			if(book.getBid() != null)
			{
				//repository.remove(book.getId());
				repository.remove(id);//book 형식을 넘기는 거로 오버로딩 한거 테스트
				System.out.println("도서가 삭제되었습니다.");
			}
			else
			{
				System.out.println("검색결과가 없습니다.");
			}
		}
		else
		{
			System.out.println("등록된 도서가 없습니다.");			
		}
		bma.showMenu();
	}
//	
	@Override
	public void exit()
	{
		System.out.print("프로그램 종료");
		repository.close();
		System.exit(0);
	}
	
	@Override
	public int getCount()
	{
		return repository.getCount();
	}
	
	public Book createBook()
	{
		Book book = new Book();
		Random rd = new Random();
//		book.setId(String.valueOf(rd.nextInt(1000,9999)));
		book.setIsbn((rd.nextInt(1000,9999)));
		System.out.println("도서명 :");
		book.setTitle(bma.scan.next());
		System.out.println("작가명 :");
		book.setAuthor(bma.scan.next());
		System.out.println("가격 :");
		book.setPrice(bma.scan.nextInt());
				
		return book;
	}
//	
//	/**
//	 * 도서 생성 오버로딩
//	 * @param book - old version
//	 * @return
//	 * 도서 수정시 도서 정보를 일부 수정하여 반환
//	 */	
	public Book createBook(Book book)//오버로딩
	{
		System.out.println("도서명 :");
		book.setTitle(bma.scan.next());
		System.out.println("작가명 :");
		book.setAuthor(bma.scan.next());
		System.out.println("가격 :");
		book.setPrice(bma.scan.nextInt());
//		System.out.println("등록일자 :");
//		book.setBdate(bma.scan.next());
				
		return book;
	}
//	
//	/**
//	 * 도서관 선택
//	 */	
	public void selectRepository()
	{
		System.out.println("도서관을 선택하세요.");	
		System.out.println("1. 교육센터 \t 2.알라딘 \t 3.Yes24");
		int rno = bma.scan.nextInt();
		if(rno==1)
		{
			repository = new InMemoryBookRepository(1);
		}
		else if(rno==2)
		{
			repository = new InMemoryBookRepository(2);
		}
		else if(rno==3)
		{
			repository = new InMemoryBookRepository(3);
		}
				
	}
	
}
