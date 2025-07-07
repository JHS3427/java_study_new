package chapter07_250707_example;

import java.util.Scanner;

public class OrderSystem {
	//Field
	String[] drinkMenuList= {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
	int[] drinkMenuPrice = {2800,3500,4000};
	Menu[] menuTable = new Menu[3];
	Order[] orderTable = new Order[3];
	int orderTableIdx = 0;
	Scanner scan = new Scanner(System.in);
	//Constructor
	
	//Method
		
	public void showMenu()
	{
		System.out.println("===메뉴판===");
		for(int i = 0; i<drinkMenuList.length;i++)
		{
			Menu menu = new Menu();
			menu.EmoName = drinkMenuList[i];
			menu.Price = drinkMenuPrice[i];
			menuTable[i] = menu;
		}
		int menuIdx= 0;
		for(Menu menuPrinter : menuTable)
		{
			menuIdx++;
			System.out.println(menuIdx +". "+menuPrinter.EmoName + " : " + menuPrinter.Price);
		}
	}//showMenu
	
	public int intTypeChecker()
	{
		if(scan.hasNextInt())
		{
			int inputInt = scan.nextInt();
			if(inputInt>3 || inputInt<1)
			{
				System.out.println("메뉴 준비중입니다.");
			}
			else
			{
				System.out.println("입력값 : "+ inputInt);
				return inputInt;
			}
		}
		else
		{
			scan.next();
			System.out.println("정수값이 아닌 잘못된 값을 입력함.");
		}
		return -1;
	}
	
	public void menuCollect()
	{
		System.out.print("주문할 메뉴 번호 입력 : ");
		int pickDrink = intTypeChecker();
		while(pickDrink==-1)
		{
			System.out.println(pickDrink);
			System.out.print("재입력 : ");
			pickDrink = intTypeChecker();
		}
		pickDrink=pickDrink-1;
		System.out.print("주문 메뉴 : " + menuTable[pickDrink].EmoName);
		System.out.print(", 결제 예정 금액 : " + menuTable[pickDrink].Price + "\n");
		if(orderTable[pickDrink] == null)
		{
			Order order = new Order();
			order.Menu = menuTable[pickDrink].EmoName;
			order.Price = menuTable[pickDrink].Price;
			order.Qty = 1;
			order.PriceSum = menuTable[pickDrink].Price*order.Qty;
			orderTable[pickDrink] = order;
		}
		else
		{
			orderTable[pickDrink].Qty+=1;
			orderTable[pickDrink].PriceSum = orderTable[pickDrink].Price*orderTable[pickDrink].Qty;
		}
		System.out.println("메뉴 추가를 그만하시려면 n을 입력하세요.");
		if(scan.next().equals("n"))
		{
			for(int j = 0 ; j<3;j++)
			{
				System.out.println(orderTable[j].Menu);
				System.out.println(orderTable[j].Price);
				System.out.println(orderTable[j].Qty);
				System.out.println(orderTable[j].PriceSum);
			}
		}
		else
		{
			menuCollect();
		}
	}
	public void methodCollect()
	{
		showMenu();
		menuCollect();
		
	}
	
	
}
