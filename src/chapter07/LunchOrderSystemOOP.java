package chapter07;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	//필드
	//주문할 메뉴 : Lunchmenu;
	Scanner scan = new Scanner(System.in);
	String[] lunchMenuNames = {"햄버거(🍔)","피자(🍕)","라멘(🍜)","샐러드(🥗)"};
	int[] lunchMenuPrice= {100,200,300,400};
	LunchMenu[] lunchMenuList = new LunchMenu[4];
	LunchOrderItem[] orderItemList = new LunchOrderItem[4];
	int orderCount = 0;
	int amount = 0;// 결제금액 - 사용자 입력
	int change = 0;// 잔돈
	LunchPaymentItem paymentItem;
	//시스템 메뉴 = 메인 메뉴라고 칭함 = MainMenu
	//constructor;
	
	//Method
	/*
	 * 런치 메뉴 생성
	 */
	public void createLunchMenu() 
	{
		for(int i = 0; i<lunchMenuList.length; i++)
		{
			LunchMenu menu = new LunchMenu(); // 이거 바깥에 선언하면 4번다 똑같은 값 나온다.
			/*for문 안에 넣어야 하는 이유 :
			 * for문 안에 안넣고 바깥으로 빼면 새로 생성이 안되고 저장위치가 1개라는 얘기다.
			 * 즉, lunchMenuList[i]에는 전부 같은 주소가 저장되고,
			 * 이에 따라 menu 마지막에 저장된 값이 모든 lunchMenuList 배열 안에 저장된다
			 * call by reference라서 이럼.
			 */
			menu.no = i+1;
			menu.name = lunchMenuNames[i];
			menu.price = lunchMenuPrice[i];
			
			lunchMenuList[i] = menu;
			/*
			 *아래 내가 쓴 방식의 경우는 작동안함.
			 *현재 lunchMenuList에는 LunchMenu 형식의 위치값이 들어가야 한다.
			 *그런데 내가 한 방식은 두가지가 잘못됐다
			 *1)위치값이 들어가야 하는 자리에 값을 입력하려고 했다.
			 *2)선언만 해서 null인 곳에 null.name 이런식으로 넣으려고 해서 null point exception이 뜸. 
			 */
			/*lunchMenuList[i].name = lunchMenuNames[i];// - 내방식 - 실패
			lunchMenuList[i].price = lunchMenuPrice[i];*/
		}
		//showLunchMenu();
	}
	
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
		selectLunchMenu();
	}
	
	/*
	 * 메인 메뉴 출력 메소드
	 */
	public void showMainMenu()
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
		createLunchMenu();
		selectMainMenu();
		
	}//show main menu
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
		
		selectLunchMenu();
		
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
	}/*
	 * 런치 메뉴 선택
	 */
	public void selectLunchMenu()
	{
		System.out.print("주문 메뉴(숫자)> ");
		if(scan.hasNextInt())
		{
			lunchMenuCheck(scan.nextInt());
		}
		else
		{
			System.out.println(" => 입력된 값이 올바르지 않음. 재입력 요청!");
			scan.next();//잘못된 값을 일단 받아주는 용도다.
			selectLunchMenu();//리컬시브 콜. - While 안쓰고 자기 자신을 다시 불러서 사용 가능
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
			showMainMenu();
		}
		
	}
	//
	/*
	 * 런치 메뉴 체크
	 */
	public void lunchMenuCheck(int lunchMenu)
	{
		// lunchMenu가 1~4이면 주문 가능. 그 이외의 다른 번호 : 메뉴 준비중 >다시 입력
		if(1 <= lunchMenu && lunchMenu<=4)
		{//주문 진행 ==> OrderItem객체 생성
			order(lunchMenu);
		}
		else
		{
			System.out.println("런치 메뉴 준비중");
			showLunchMenu();
		}
	}
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
		showMainMenu();
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
		showMainMenu();
			
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
		showMainMenu();
	}
	
	/*
	 * 결제 내역 메소드 paymentList()
	 */
	public void paymentList()
	{
		if(paymentItem == null)
		{
			System.out.println("결제 내역이 없습니다.");
			showMainMenu();
		}
		else
		{
			System.out.print(paymentItem.name + "\t");
			System.out.print(paymentItem.totalPayment + "\t");
			System.out.print(paymentItem.amount + "\t");
			System.out.print(paymentItem.change + "\n");
		}
		showMainMenu();
	}
}//class 
