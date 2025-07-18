package com.bookmgm.application;

import java.util.Scanner;

import com.bookmgm.service.BookService;
import com.bookmgm.service.DefaultBookService;

public class BookManagementApplication {

	public Scanner scan;
	public static final int REGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;
	
	public BookService service;
		
	public BookManagementApplication()
	{
		scan = new Scanner(System.in);
		service = new DefaultBookService(this);
		showMenu();
	}
	public static void main(String[] args) {
		new BookManagementApplication();
	}

	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		//배열을 이용하여 메뉴를 출력해보세요.
		String[] labels = {"도서 등록","도서 조회","도서 검색","도서 수정","도서 삭제","시스템 종료"};
//		this.bookMenu = new String[6];
//		this.bookMenu[0] = "1. 도서 등록";
//		this.bookMenu[1] = "2. 도서 조회";
//		this.bookMenu[2] = "3. 도서 검색";
//		this.bookMenu[3] = "4. 도서 수정";
//		this.bookMenu[4] = "5. 도서 삭제";
//		this.bookMenu[5] = "6. 시스템 종료";
		
		System.out.println("----====도서 관리 시스템====----");
		System.out.println("전체 도서 수 : " + service.getCount());
//		System.out.println("전체 도서수 : " + 0 );
//		int idx= 0;
//		for(String title : labels)
//		{
//			idx++;
//			System.out.println(idx + ". " +title);			
//		}
		for(int i=0;i<labels.length;i++)
		{
			System.out.println((i+1)+". "+labels[i]);
		}
		selectMenu();
	}

//	public void showMenu() {
//		System.out.println("====학생 성적 관리 시스템====");
//		System.out.println("전체 도서수 : " + 0 );
//		System.out.println("1. 도서 등록");
//		System.out.println("2. 조회");
//		System.out.println("3. 검색");
//		System.out.println("4. 수정");
//		System.out.println("5. 삭제");
//		System.out.println("6. 종료");
//		System.out.println("------------------------");
//	}
	/**
	 * 메뉴 선택
	 */
	public void selectMenu()
	{
		System.out.println("메뉴 선택(숫자)>");
		if(scan.hasNextInt())
		{
			
			int menu = scan.nextInt();
			System.out.println(menu);
			switch(menu)
			{
			case REGISTER:	service.register();	break;
			case LIST:		service.list();		break;
			case SEARCH:	service.search();	break;
			case UPDATE:	service.update();	break;
			case DELETE:	service.delete();	break;
			case EXIT:
				System.out.println("시스템 종료.");
				service.exit();
				break;
			default:
				System.out.println("준비중입니다. 다른번호 누르시오");
				selectMenu();
			}
		}
		else
		{
			scan.next();
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해주세요.");
			selectMenu();			
		}	
	}
	
}
