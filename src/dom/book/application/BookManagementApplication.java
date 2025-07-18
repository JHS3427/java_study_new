package dom.book.application;

import java.util.Scanner;

import dom.book.service.BookService;
import dom.book.service.BookServiceInterface;

public class BookManagementApplication {
	//여기가 사용자와 컨택해서 보여주는 지점.
	//메뉴 보여주기/값 입력받기/프로그램한테 받은 값 보여주기/ 
	
	Scanner scan;
	public static final int REGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;

	public BookServiceInterface BS;
	
	public BookManagementApplication()
	{
		scan = new Scanner(System.in);
		BS = new BookService(this);
		showMenu();
	}
	
	public static void main(String[] args) {
		
	}

	public void showMenu()
	{
		String[] labels = {"도서 등록","도서 조회","도서 검색","도서 수정","도서 삭제","시스템 종료"};
		System.out.println("----====도서 관리 시스템====----");
		//System.out.println("전체 도서 수 : " + service.getCount());
		for(int i=0;i<labels.length;i++)
		{
			System.out.println((i+1)+". "+labels[i]);
		}
		selectMenu();
	}
	public void selectMenu()
	{
		System.out.println("고르시오");
		int num = scan.nextInt();
		switch(num)
		{
		case REGISTER:	BS.register();	break;
		case LIST:		BS.list();		break;
		case SEARCH:	BS.search();	break;
		case UPDATE:	BS.update();	break;
		case DELETE:	BS.delete();	break;
		case EXIT:
			System.out.println("시스템 종료.");
			BS.exit();
			break;
		default:
			System.out.println("준비중입니다. 다른번호 누르시오");
			selectMenu();
		}
	}
	
}
