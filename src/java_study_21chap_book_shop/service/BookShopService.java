package java_study_21chap_book_shop.service;

import java_study_21chap_book_shop.application.BookShopShower;
import java_study_21chap_book_shop.model.BookShopCustormer;
import java_study_21chap_book_shop.repository.BookShopCartRepo;
import java_study_21chap_book_shop.repository.BookShopMemberRepo;

public class BookShopService {

	//Field
	BookShopShower BShower;
	BookShopCartRepo cart;
	BookShopMemberRepo bsmr;
	BookShopCustormer bsc;
	String ID;
	//Constructor
	public BookShopService()
	{
		
	}
	
	public BookShopService(BookShopShower BookShower)
	{
		this.BShower = BookShower;
		bsmr = new BookShopMemberRepo();
		cart = new BookShopCartRepo();
	}
	
	//Method
	
	//1. 아이디 입력받고 확인하기
	public void IdPwChecker()
	{
		System.out.println("아이디를 입력하세요 : ");
		ID = BShower.scan.next();
		String idChecker = bsmr.memberIdCheck(ID);
		if (idChecker != "")
		{
			System.out.println(idChecker);
			System.out.println("비밀번호를 입력하세요.");
			String pw = BShower.scan.next();
			bsmr.PwChecker(idChecker,pw);
		}
		else
		{
			//아이디가 없는 경우 : 1. 계정찾기 , 2. 아이디 새로 만들기 , 3. 재시도
			System.out.println("아이디가 없습니다.");
			System.out.println("1. 계정찾기 , 2. 아이디 새로 만들기 , 3. 재시도");
			int scr = BShower.scan.nextInt();
			if( scr == 1 )
			{
				System.out.println("계정 찾기 입니다.");
				System.out.println("ID를 입력하세요");
				String Sid = BShower.scan.next();
				System.out.println("이름을 입력하세요");
				String Sn = BShower.scan.next();
				System.out.println("전화번호를 입력하세요");
				String Sph = BShower.scan.next();
				bsmr.search(Sid, Sn, Sph);
			}
			else 
			{
				IdPwChecker();
			}
		}
		
	}
	//2. 비밀번호 입력받고 확인하기

	
	public void memberInfoCheck()
	{
		System.out.println("고객 정보를 불러옵니다");
		this.bsc = bsmr.memberInfo(ID);
		System.out.println("아이디 \t 비밀번호 \t 이름 \t 전화번호");
		System.out.println(bsc.getUserId() + " \t "
				+ bsc.getUserPw() + " \t "
				+ bsc.getUserName()+" \t "
				+ bsc.getUserAddress()+" \t "
				+ bsc.getPhone());
	}
	
	public void cartInsert()
	{
		//책 리스트 보여주기

		System.out.println("책 리스트 입니다.");
		System.out.println("책 ID // 제목 // 작가 // 가격 // 대분류 // 등록날짜");
		cart.booklist();
		System.out.println("장바구니에 넣을 책 ID를 입력해주세요.");
		String bookId = BShower.scan.next();
		System.out.println("장바구니에 넣을 책의 수량을 입력해주세요.");
		int Amount = BShower.scan.nextInt();
		int rows = cart.insertcart(ID,bookId,Amount);
		if(rows != 0)
		{
			System.out.println("입력 완료. 메뉴로 돌아갑니다.");
		}
		else
		{
			System.out.println("입력 실패. 메뉴로 돌아갑니다.");
		}
		//넣을 책 선택 후 장바구니로
	}
	public void cartshowall()
	{
		System.out.println("장바구니의 모든 내역을 보여드립니다.");
		cart.showall(ID);
	}
	public void cartAmountChange()
	{
		System.out.println("변경하실 책 ID를 입력하세요.");
		String bookId = BShower.scan.next();
		System.out.println("변경하실 책 수량 입력하세요.");
		int Amount = BShower.scan.nextInt();
		cart.change(Amount, ID, bookId);
	}
	public void cartDeleteone()
	{
		System.out.println("제거하실 책 ID를 입력하세요.");
		String bookId = BShower.scan.next();
		cart.delete(ID, bookId);
	}
	public void cartDeleteAll()
	{
		System.out.println("제거하실 책 ID를 입력하세요.");
		cart.deleteall(ID);
	}
	public void payment()
	{
		System.out.println("전부 결제합니다.");
		bsmr.payment(ID);
		System.out.println("장바구니는 비우겠습니다.");
		cart.deleteall(ID);
		System.out.println("배송받을 분의 고객정보와 같습니까?");
		String Checker = BShower.scan.next();
		if(Checker.equals("Y"))
		{
			System.out.println("-----배송 받을 고객 정보-----");
			bsmr.paymentshow(ID);
		}
		else if(Checker.equals("N"))
		{
			System.out.println("-----배송 받을 고객 정보를 입력하세요-----");
			System.out.println("이름 : ");
			String name = BShower.scan.next();
			String phone = BShower.scan.next();
			String Address = BShower.scan.next();
			bsmr.paymentshow(name,phone,Address,ID);
		}
	}
}
