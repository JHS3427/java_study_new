package java_study_21chap_book_shop.application;

import java.util.Scanner;

import java_study_21chap_book_shop.service.BookShopService;

public class BookShopShower {
	//Field
/*
	 * 1. 고객 정보 확인//2. 장바구니 항목 추가//3. 장바구니 보기.
	 * 4. 장바구니 수량 변경//5. 장바구니 항목 제거//6. 장바구니 전체 항목 제거
	 * 7. 영수증 표기// 8. 종료
	 */
	public Scanner scan;
	public BookShopService service;
	static final int CUSTOMERINFO = 1;
	static final int CARTADD = 2;
	static final int CARTCHECK = 3;
	static final int CARTAMOUNTCHANGE=4;
	static final int CARTMEMBERDELETE=5;
	static final int CARTMAKEEMPTY=6;
	static final int SHOWRECEIPT = 7;
	static final int EXIT = 8;
	//Constructor
	public BookShopShower() 
	{
		scan = new Scanner(System.in);
		service = new BookShopService(this);
		customerinfocheck();
		showselectmenu();
	}
	
	
	//Method 
	public void customerinfocheck()
	{
		System.out.println("******************************");
		System.out.println("*\t \t 서점에 어서 오세요. \t  \t *");
		System.out.println("*\t \t 아이디와 비밀번호를 입력하세요. \t *");
		System.out.println("******************************");
		service.IdPwChecker();
		//service 쪽에서 비밀번호 입력받는 메소드 + 확인 메소드 =>
		//여기서 리턴값으로 결과 전달.
	}	
	

	/* 필요시 항목 추가하기.
	 * 1. 고객 정보 확인//2. 장바구니 항목 추가//3. 장바구니 보기.
	 * 4. 장바구니 수량 변경//5. 장바구니 항목 제거//6. 장바구니 전체 항목 제거
	 * 7. 영수증 표기// 8. 종료
	 */
	public void showselectmenu()
	{
		System.out.println("****************************************************************************************");
		System.out.print("1. 고객 정보 확인 \t \t \t");
		System.out.print("2. 장바구니 항목 추가 \t \t \t");
		System.out.print("3. 장바구니 보기 \n");
		System.out.print("4. 장바구니 수량 변경 \t \t");
		System.out.print("5. 장바구니 항목 제거 \t \t \t");
		System.out.print("6. 장바구니 전체 항목 제거 \n");
		System.out.print("7. 영수증 표기 \t \t \t");
		System.out.println("8. 종료 \t \t");
		System.out.println("****************************************************************************************");
		System.out.println("원하시는 서비스 번호를 입력하세요.");
		int serviceNum = scan.nextInt();
		switch(serviceNum)
		{
		case CUSTOMERINFO:
			service.memberInfoCheck();
			break;
		case CARTADD:
			service.cartInsert();
			break;
		case CARTCHECK:
			service.cartshowall();
			break;
		case CARTAMOUNTCHANGE:
			service.cartAmountChange();
			break;
		case CARTMEMBERDELETE:
			service.cartDeleteone();
			break;
		case CARTMAKEEMPTY:
			service.cartDeleteAll();
			break;
		case SHOWRECEIPT:
			service.payment();
			break;
		case EXIT:
			System.out.println("시스템 종료.");
			System.exit(1);
			break;
		default :
			System.out.println("메뉴 준비중입니다, 다른 번호를 입력하세요.");
			showselectmenu();
			break;
		}
		showselectmenu();
	}
}
