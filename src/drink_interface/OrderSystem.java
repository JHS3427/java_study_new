package drink_interface;

import java.util.Scanner;

//import commons.Menu;

public class OrderSystem {
//Field
	Scanner scan = new Scanner(System.in);
	String[] names= {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
	int[] price = {2800,3000,4000};
	Menu[] menuList = new MenuItem[names.length];
	String brandName;
	Order order;
	Payment payment;
	//Constructor
	public OrderSystem()//이름이 없는 경우 - 디폴트
	{
		this("MEGA");
	}
	public OrderSystem(String brandName)
	{
		this.brandName = brandName;
		init();
	}
	
	//Method
	
	public void init() {
		payment = new Payment();
		createMenuList();
		showMenu();
		selectMenu();
	}
	/*
	 * 메뉴 선택
	 */
	public void selectMenu()
	{
		System.out.println("메뉴 선택(숫자) : ");
		if(scan.hasNextInt())
		{
			int menu = scan.nextInt();
			//System.out.println(menu);
			if(menu>=1 && menu<=3)
			{
				placeOrder(menu);
			}
			else
			{
				System.out.println("메뉴 준비중.");
				selectMenu();
			}
		}
		else
		{
			System.out.println("올바르지 않은 입력값입니다. 다시 입력하세요.");
			scan.next();
			selectMenu();
		}
	}
	
	/*
	 * 주문
	 */
	public void placeOrder(int menu)
	{
		//번호에 맞는 메뉴를 메뉴리스트에서 검색한다. 검색한 메뉴를 Order 생성자의 매개변수로 입력.
		order = new Order(searchMenu(menu));//Order의 매개변수와 searchMenu의 리턴값의 형식을 반드시 맞출것.
		if(order.orderMenu!=null) order.getInfo();//order변수에 제대로 들어갔는지 확인
	
		System.out.println("주문완료");
		
		processPayment();
	}
	/*
	 * 결제
	 */
	public void processPayment()
	{
		System.out.println("결제 금액(숫자) : ");
		if(scan.hasNextInt())
		{
			payment.setAmount(scan.nextInt());
			System.out.println("=>총 입금 금액 : "+ payment.getAmount());
			if(payment.getPayment(order.orderMenu.getPrice())) {
				//결제 완료
				System.out.println("=>결제 완료!! 잔돈 : " + payment.getChange());
				showMenu();
				selectMenu();
			}
			else
			{//결제 금액 부족.
				System.out.println("결제 실패, 결제 금액 부족, 다시 입력");
				processPayment();
			}
		}
		else
		{
			System.out.println("올바르지 않은 입력값입니다. 다시 입력하세요.");
			scan.next();
			processPayment();
		}
		
	}
	
	
	public Menu searchMenu(int menuNo)
	{
		Menu menu = null;
		
		for(Menu m : menuList)//menuList[0](주소) --> m --> Menu(아메리카노)의 정보
		{
			if(m.getNo() == menuNo)
			{
				menu = m;//menu = m.no하면 에러임. 왜냐하면 menu는 Menu로 설정되서 주소값이 나와야 하기 떄문.
				break;
			}
		}
		
		return menu;
	}
	public void showMenu()
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
		System.out.println("\t "+ brandName + " coffee");
		for(Menu menu : menuList)
		{
			System.out.print(menu.getNo() + "\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "\n");
		}
	}
	public void createMenuList()
	{
		for(int i =0;i<names.length;i++)
		{
			Menu menu = new MenuItem((i+1),names[i],price[i]);
			menuList[i] = menu;
		}
	}
}
