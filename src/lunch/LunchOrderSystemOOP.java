package lunch;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	//필드
	//주문할 메뉴 : Lunchmenu;
	Scanner scan;
	LunchOrderMenuManager menuManager;
	String[] lunchMenuNames = {"햄버거(🍔)","피자(🍕)","라멘(🍜)","샐러드(🥗)"};//선언 + 값의 할당이 동시에 일어나야함
	//선언따로 할당 따로 하려고하면 에러가 발생.
	int[] lunchMenuPrice= {100,200,300,400};//위랑 같음
	LunchMenu[] lunchMenuList;// = new LunchMenu[4]; //얘는 값이 정확하게 정해지지 않아서 된다
	LunchOrderItem[] orderItemList;// = new LunchOrderItem[4];//얘는 값이 정확하게 정해지지 않아서 된다
	int orderCount = 0;
	int amount = 0;// 결제금액 - 사용자 입력
	int change = 0;// 잔돈
	LunchPaymentItem paymentItem;
	String title;
	//시스템 메뉴 = 메인 메뉴라고 칭함 = MainMenu
	//constructor;
	public LunchOrderSystemOOP(String title) //기본생성자
	{
		this.title = title;
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager(this);//메뉴메니저로 시스템의 주소를 this로 넘겨줌
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		
		menuManager.createLunchMenu();
		menuManager.showMainMenu();
	}
	public LunchOrderSystemOOP() //기본생성자2 : 매개변수 없는 버젼
	{
		//this.title = title;
		scan = new Scanner(System.in);
		menuManager = new LunchOrderMenuManager(this);
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		
		menuManager.createLunchMenu();
		//showMainMenu();
	}
	//Method
	
	
	public void showLunchMenu()
	{
		int no=1;
		System.out.println("lunchMenuList = >");
		for(LunchMenu menu : lunchMenuList)
		{
			System.out.print(no + ". ");
			System.out.print(menu.name + "\t");
			System.out.print(menu.price + "\n");
			no++;
		}
		menuManager.selectLunchMenu();
	}
	
	/*
	 * 런치 메뉴 체크.
	 */
	public void lunchMainMenu()
	{
		System.out.println("******************************************");
		System.out.println("\t Welcome to Food Mart!!!");
		System.out.println("******************************************");
		System.out.println("\t 1. 음식 주문");		
		System.out.println("\t 2. 주문 내역");		
		System.out.println("\t 3. 음식 결제");		
		System.out.println("\t 4. 결제 내역");		
		System.out.println("\t 9. 프로그램 종료");		
		System.out.println("******************************************");
		System.out.println("***** Food Mart에 오신것을 환영합니다");
		
		menuManager.selectLunchMenu();
		
	}//show main menu
	//main menu check
	/*
	 * 메인 메뉴 선택
	 */
	public void selectMainMenu()
	{
		System.out.print("메인 메뉴(숫자)> ");
		if(scan.hasNextInt())
		{
			mainMenuCheck(scan.nextInt());
		}
		else
		{
			System.out.println(" => 입력된 값이 올바르지 않음. 재입력 요청!");
			scan.next();//잘못된 값을 일단 받아주는 용도다.
			selectMainMenu();//리컬시브 콜. - While 안쓰고 자기 자신을 다시 불러서 사용 가능
		}
	}
	/*
	 * 메인 메뉴 체크
	 */
	public void mainMenuCheck(int mainMenu)
	{
		switch(mainMenu)
		{
		case 1: showLunchMenu(); break;
		case 2: orderList(); break;
		case 3: payment(); break;
		case 4: paymentList(); break;
		case 9: 
			System.out.println("-- 음식 주문 시스템을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("메뉴 준비중");
			menuManager.showMainMenu();
		}
		
	}
	//
	
	/*
	 * 주문 아이뎀의 인덱스 확인
	 */
	public int searchOrderItemIdx(int lunchMenu)
	{
		int idx = -1;
		for(int i = 0; i<orderCount; i++)
		{
			LunchOrderItem orderItem = orderItemList[i];
			if(orderItem.no == lunchMenu)
			{
				idx = i;
			}
		}
		return idx;
	}
	/*
	 * orderItemListInit 주문 리스트 초기화
	 */
	public void orderItemListInit()
	{
		//orderItemList = new LunchOrderItem[4];
		
//		for(int i=0; i<orderCount;i++)
//		{
//			orderitemList[i] = null;
//		}
//		orderCount = 0;
		
		for(LunchOrderItem orderItem : orderItemList)
		{
			if(orderItem != null) orderItem=null;
		}
		orderCount=0;
	}
	
	/*
	 * 
	 * 음식 주문 메소드 order()
	*/
	public void order(int lunchMenu)
	{
		System.out.println(lunchMenu + " 주문 ");
		//lunchMenuList의 메뉴 번호 확인.
		for(LunchMenu menu : lunchMenuList)
		{
			if(menu.no == lunchMenu)
			{
				int idx = searchOrderItemIdx(lunchMenu);
				if(idx == -1)
				{
					orderItemList[orderCount] = new LunchOrderItem();
					
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty = 1;
					orderCount++;
				}
				else
				{
					orderItemList[idx].qty+=1;					
				}
				break;
			}
		}
		System.out.println("주문완료");
		menuManager.showMainMenu();
	}
	 /*
	 * 주문 내역 메소드  orderList
	 */
	public void orderList() {
		if(orderCount==0)
		{
			System.out.println("주문 내역 X");
		}
		else
		{
			System.out.println("번호\t 메뉴명 등");
			for(LunchOrderItem orderItem : orderItemList)
			{
				if(orderItem!=null)
				{
					System.out.print(orderItem.no + "\t");
					System.out.print(orderItem.name + "\t");
					System.out.print(orderItem.price + "\t");
					System.out.print(orderItem.qty + "\t");
				}
			}
		}
		menuManager.showMainMenu();
			
	}
	/*
	 * 결제 예정 금액 산출 메소드
	 */
	public int totalPayment() {
		int sum = 0;
		for(LunchOrderItem orderItem : orderItemList)
		{
			if(orderItem !=null)
			{
				sum += orderItem.qty * orderItem.price;
			}
		}
		return sum;
	}
	/*
	 * 결제 메소드 payment()
	 */
	public void payment()
	{
		if(orderCount==0)
		{
			System.out.println("선택한게 없음.");
		}
		else
		{
			int total=totalPayment();
			System.out.println("결제 예정 금액 : " + totalPayment());
			System.out.println("결제할 요금 입력");
			if(scan.hasNextInt()){
				amount += scan.nextInt();
				System.out.println("총 입력금액 " + amount);
				if(amount>=total) {
					change = amount - total;
					paymentItem = new LunchPaymentItem();
					paymentItem.name = orderItemList[0].name + "등..." ;
					paymentItem.totalPayment = total;
					paymentItem.amount = amount;
					paymentItem.change = change;
					System.out.println("결제 성공 " + amount);
					
					// 주문리스트 초기화
					orderItemListInit();
				}
				else
				{
					System.out.println("돈 부족 재입력");
					payment();
				}
			}
			else
			{
				System.out.println("오류입력 재입력");
			}			
		}
		menuManager.showMainMenu();
	}
	
	/*
	 * 결제 내역 메소드 paymentList()
	 */
	public void paymentList()
	{
		if(paymentItem == null)
		{
			System.out.println("결제 내역이 없습니다.");
			menuManager.showMainMenu();
		}
		else
		{
			System.out.print(paymentItem.name + "\t");
			System.out.print(paymentItem.totalPayment + "\t");
			System.out.print(paymentItem.amount + "\t");
			System.out.print(paymentItem.change + "\n");
		}
		menuManager.showMainMenu();
	}
}//class 
