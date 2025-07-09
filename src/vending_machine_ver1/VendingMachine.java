package vending_machine_ver1;

import commons.Menu;

public class VendingMachine {
	String[] nameList = {"밀크커피","아메리카노","유자차","우유"};
	int [] priceList = {300,400,300,200}; 
	Menu[] menuList;
	Menu[] orderMenuList; //user가 주문 가능한 메뉴(투입금액기준)과 menuList와 같지 않을 수 있다. 따라서 사용자가 사용 가능한 메누만 나오는 메뉴판이 필요.
	int orderMenuCount=0;
	String title;
	User user;
	int totalCoin;
	Menu orderMenu;
	int change;
	
	final static int EXIT = 9;//클래스 변수는 static을 붙이면 method 에어리어의 static 저장공간에 저장된다. 안붙이면 int라서 stack에 저장
		//클래스명.상수명으로 다른데에서 호출 가능
	
	//Constructor
	public VendingMachine(User user)
	{
		this("스벅", user);
	}
	public VendingMachine(String title,User user)
	{
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	//Method
	/*
	 * 메뉴를 체크하는 기능
	 */
	public boolean selectMenuCheck(int menuNo)
	{
		boolean result = false;
		
		for(int i =0; i<orderMenuCount;i++)
		{
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo)
			{
				result = true;
			}
		}
		return result;
	}
	
	
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu() { // 정확한 메뉴 선택!!!!!!
		//총 투입금액에 맞는 메뉴를 보여준다.
		System.out.println("=> 메뉴를 선택해 주세요.");
		System.out.println("=> 취소는 " +VendingMachine.EXIT +"번을 입력해주세요.");//그냥 EXIT으로도 호출 가능
		int menuNo = user.selectMenu();
		if(menuNo != VendingMachine.EXIT)//다만 이런 클래스의 static 상수는 이런식으로 부르는게 일반적
		{
			if(selectMenuCheck(menuNo))
			{
				placeOrder(menuNo);
			}
			else
			{
				selectMenu();
			}
		}
		else
		{
			System.out.println("동전을 반환하고 프로그램을 종료합니다.");
			System.out.println("동전 반환 : " + totalCoin);
			System.exit(0);
		}
	}
	
	/*
	 * 주문 메소드
	 */
	public void placeOrder(int menuNo)
	{// 주문 가능한 메뉴 리스트에서 선택한 menuNo를 비교하여 메뉴 주소를 orderMenu에 대입.
		/*for(Menu selectedMenu : orderMenuList) - 내가 작성 - 이 방식의 경우 전부 null이면 에러발생할거임
		{
			if(menuNo == selectedMenu.getNo())
			{
				orderMenu = selectedMenu;
				System.out.println("selectedMenu");
				break;
			}
		}*/
		for (Menu menu : orderMenuList)
		{
			if(menu != null)//menu.getNo 이런거 사용하기 전에 menu자체가 null 인지 아닌지 확인을 먼저 해야함
			{
				if(menu.getNo() == menuNo)
				{
					orderMenu = menu;
				}
			}
		}
		System.out.println("주문완료");
		processPayment();
	}
	
	/*
	 * 결제 메소드
	 */
	public void processPayment()
	{
		if(orderMenu != null)
		{
			if(orderMenu.getPrice()<=totalCoin)
			{
				int price = orderMenu.getPrice();
				if(price <= totalCoin)
				{
					change = totalCoin - price;
					
					System.out.println("=> 결제완료");
					finalCheck();
					init();//사용한 객체 초기화 => orderMenuList, orderMenu, totalCoin
				}
			}
		}
	}
	/*
	 * 종료 후 객체 초기화
	 */
	public void init()
	{
		orderMenuCount = 0;
		orderMenuList= null;
		orderMenu= null;
		totalCoin=0;
	}
	
	
	/*
	 * 종료 메소드
	 */
	public void finalCheck()
	{
		//잔돈이 최소 주문 금액보다 크면 계속 주문
		int price = menuList[menuList.length-1].getPrice() ;
		if(change >= price)
		{
			totalCoin = change;
			createOrderMenuList(totalCoin);
			System.out.println("=> 결제 내역");
			System.out.println("잔돈 =>" + change);
			System.out.println("가격 => " + orderMenu.getPrice());		
			selectMenu();
		}
		else
		{
			System.out.println("=> 결제 내역");
			System.out.println("잔돈 =>" + change);
			System.out.println("끝");		
		}
	}
	
	/*
	 * 코인 체크 메소드
	 */

	public boolean coinCheck(int coin)
	{
		boolean result = false;
		
		if(coin == 100 || coin == 500)
		{
			result = true;
		}
		return result;
	}
	
	/*
	 * 투입한 금액보다 적은 금액의 제품군을 출력함
	 */
	public void createOrderMenuList(int totalCoin)
	{
		orderMenuList = new Menu[menuList.length];
		//orderMenuCount를 이용하여 향상된 for문 사용
		
		for(Menu menu : menuList)
		{
			if(menu.getPrice()<=totalCoin)
			{
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}
		/*
		for(int i = 0 ; i<menuList.length;i++)
		{
			Menu menu = menuList[i];
			if(menu.getPrice()<=totalCoin)
			{
				orderMenuList[i] = menu;//메뉴가 들어가는게 아니라 메뉴가 가리키는 주소를 넣음
			}
		}
		*/
	}
	
	/*
	 * 입력 되는 동전을 체크하는 작업 진행.
	 */
	
	public void checkInsertCoin()
	{
		System.out.println("=> 동전을 투입 해 주세요.");
		int coin = user.insertCoin();
		if(coin == 100 || coin == 500)//사용 가능 동전 체크
		{
			System.out.println(coin + " 사용가능");
			totalCoin += coin;
			System.out.println(" 총 수입금액 : " +totalCoin );
			//메뉴 선택을 위한 최소 금액을 체크
			if(totalCoin<200)
			{
				System.out.println("최소 금액 부족!!!");
				checkInsertCoin();
			}
			else
			{		
				//금액 추가 투입 여부 체크
				System.out.println("메뉴 선택은 n, 동전 투입 계속(아무키)");
				if(user.scan.next().equals("n"))
				{
					createOrderMenuList(totalCoin);
					showMenuList("주문 가능 메뉴 리스트");
					selectMenu();
				}
				else	{checkInsertCoin();	}
			}
		}
		else
		{			
			System.out.println("100원 또는 500원 동전만 사용 가능합니다.");
			checkInsertCoin();
		}
	}
	
	
	/*
	 * 전체 메뉴 리스트 출력 메소드
	 */
	public void showMenuList()
	{
		/* 일반 for문 사용
		for(int i = 0 ; i<menuList.length;i++)
		{
			Menu menu = menuList[i];
			System.out.print(menu.no + "\t");
			System.out.print(menu.name + "\t");
			System.out.print(menu.price + "\n");
		}
		*/
		System.out.println("\t "+ title + " coffee");
		for(Menu menu : menuList)
		{
			System.out.print(menu.getNo() + "\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "\n");
		}
	}
	// showMenuList 오버로딩 - 총 투입 금액 이하의 메뉴만 보여주는 메소드
	public void showMenuList(String msg)
	{
		System.out.println("\t "+ title + " coffee");
		System.out.println("\t "+ msg);
		
		for(int i = 0 ; i<orderMenuCount; i++)
		{
			Menu menu = orderMenuList[i];
			System.out.print(menu.getNo() + "\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "\n");
		}
	}
	
	
	/*
	 * 메뉴 리스트 생성 메소드
	 */
	public void createMenuList()
	{
		menuList = new Menu[nameList.length];
		for(int i=0;i<nameList.length;i++)
		{
			int no = i+1;
			String name = nameList[i];
			int price = priceList[i];
			Menu menu = new Menu(no,name,price);//가능하면 이런식으로 변수를 통해서 넣자. 그래야 직관적이다.
			menuList[i]=menu;
		}
	}
	
}
