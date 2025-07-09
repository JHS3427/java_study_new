package vending_machine_ver2;
//순서 메뉴생성/출력>동전투입>코인체크>메뉴선택>주문/결제/파이널체크

//동전투입>코인체크에서 동전투입때 user는 이게 숫자인지만 확인
//코인체크 때 VendingMachine 은 이게 100/500원이 맞는지 확인.
//동전투입>코인체크 한번 넣고 더 넣을지 말지를 메소드로 묶어서 리콜.

//메뉴 선택 전에, 현재 입금한 금액에서 선택 가능한 것들만 보여줘야함. + 주문 가능 테이블을 이때 만들어둔다

//메뉴선택이 2개로 나뉨 - 메뉴 선택(입력) 사용자 사이드// 메뉴 선택(입력 받은 값 확인) 자판기 사이드

//주문은 현재 입금된 금액 이하에서 진행. 이후 즉시 결제. 남는돈 있으면 재사용 혹은 반환 확인


public class VendingMachine {
	//Field
	String[] nameList = {"밀크커피","아메리카노","유자차","우유"};
	int [] priceList = {300,400,300,200};
	
	Menu[] menuPan = new Menu[nameList.length];
	Menu[] budgetmenuPan = new Menu[nameList.length];
	User user = new User();
	
	int receivedNumber = 0;
	int totalbudget = 0;
	int selectedMenuNum=-1;
	int drinkFee=0;
	//Constructor
	
	public VendingMachine()
	{
		menuMaking();
		menuPrinting();
		System.out.println("사용자는 돈을 넣어주세요");
		/*
		user.onlyInsertNumber();
		receivedNumber=user.inputNumber;
		System.out.println("입금 금액 : " + receivedNumber);
		coinCheck();
		*/
		inputCoinAgain();
		insideBudgetMenu();//예산 금액 내의 메뉴 출력 + 해당 메뉴 묶기
		
		/*
		selectedMenuCheck();
		order(selectedMenuNum);
		*/
		menuSelect_order();
		pay();
		lastCheck();
	}
	
	//Method
	
	//메뉴 생성
	public void menuMaking()
	{
		for(int i = 0 ; i< nameList.length; i++)
		{
			int tempoMenuIdx=i+1;
			int tempoMenuPrice=priceList[i];
			String tempoMenuName=nameList[i];
			
			Menu tempoMenu = new Menu(tempoMenuIdx,tempoMenuPrice,tempoMenuName);
			//Menu에 Constructor 잘 만들어두면 아래의 3줄을 위의 1줄로 줄이기 가능
			/*
			tempoMenu.no = i+1;
			tempoMenu.price = priceList[i];
			tempoMenu.name = nameList[i];
			*/
			menuPan[i] = tempoMenu;
		}
	}
	//메뉴 출력
	public void menuPrinting()
	{
		System.out.println("*******************************");
		System.out.println("\t 번호 \t 제품명 \t 가격");
		for(Menu tempoMenu : menuPan)
		{
			System.out.print("\t" + tempoMenu.no);
			System.out.print("\t" + tempoMenu.name);
			System.out.print("\t" + tempoMenu.price + "\n");
		}
	}
	//코인 체크
	public void coinCheck()
	{
		if(receivedNumber==100 || receivedNumber==500)
		{
			System.out.println("이건 동전이 맞습니다.");
			totalbudget += receivedNumber;
		}
		else
		{
			System.out.println("이건 동전이 아닙니다.");
		}
	}
	
	//동전투입>코인체크 한번 넣고 더 넣을지 말지를 메소드로 묶어서 리콜.
	public void inputCoinAgain()
	{
		user.onlyInsertNumber();
		receivedNumber=user.inputNumber;
		System.out.println("입금 금액 : " + receivedNumber);
		coinCheck();
		
		System.out.println("한번 더 입금하시겠습니까? 그만두시려면 n을 입력하세요 ");
		if(user.scan.next().equals("n"))
		{
			System.out.println("입력 금액 : "+ totalbudget);
		}
		else
		{
			inputCoinAgain();
		}
		
	}
	//입금 금액 이하의 메뉴 보여주기
	public void insideBudgetMenu()
	{
		int budgetmenuPanIdx=0;
		System.out.println("***********************************************");
		System.out.println("현재 입금하신 금액 내에서 선택 가능한 품목은 아래와 같습니다.");
		System.out.println("***********************************************");
		for(Menu menu : menuPan)
		{
			if(totalbudget >= menu.getPrice())
			{
				System.out.print(menu.getNo() + "\t");
				System.out.print(menu.getName() + "\t");
				System.out.println(menu.getPrice());
				budgetmenuPan[budgetmenuPanIdx] = menu;
				budgetmenuPanIdx++;
			}
		}
	}
	
	
	//메뉴 선택 - 사용자가 제대로 입력했는지 확인
	public void selectedMenuCheck()
	{
		int selectedMenu = user.menuSelect();
		if(selectedMenu == -1)
		{
			System.out.println("잘못 입력했습니다. 다시 고르세요");
			selectedMenuCheck();		
		}
		else
		{
			selectedMenuNum = selectedMenu;
		}
	}
	
	//주문
	public void order(int selectedMenuNum)
	{
		boolean tf=false;
		Menu SelectedMenu = new Menu();
		for (Menu menu : budgetmenuPan)
		{
			if(menu!=null)
			{
				if(selectedMenuNum==menu.no)
				{
					tf=true;
					SelectedMenu=menu;
					break;
				}
			}
		}
		if(tf)
		{
			System.out.print(SelectedMenu.no +"\t");
			System.out.print(SelectedMenu.name+"\t");
			System.out.print("결제 금액 : "+SelectedMenu.price+"\t");
			drinkFee= SelectedMenu.price;
		}
		else
		{
			System.out.println("그런번호 없습니다. 다시 고르세요.");
			menuSelect_order();
		}
	}
	//메뉴 선택과 주문 묶어두기
	public void menuSelect_order()
	{
		selectedMenuCheck();
		order(selectedMenuNum);
	}
	
	//결제
	public void pay()//결제하고 잔액 이하의 제품이 있는지 확인하고, 있으면 돈 더넣을지, 잔돈 받을지 그대로 뽑아먹을지 물어보기
	{
		totalbudget = totalbudget - drinkFee;
		System.out.println("잔액은 : " + totalbudget + "원 입니다.");
		for(int i = 0; i<nameList.length;i++)
		{
			Menu menu = menuPan[i];
			if(totalbudget>=menu.price)
			{
				System.out.println("잔액으로 구매할 수 있는 음료가 있습니다");
				insideBudgetMenu();
				break;
			}
		}
	}
	
	
	//파이널 체크
	public void lastCheck()
	{
		System.out.println("현재 있는 금액으로 음료를 구매하고 싶으면\"a\"를 입력하시오");
		System.out.println("거스름돈을 받고 싶으면\"b\"을 입력하시오");
		System.out.println("돈을 더 넣은 후 구매를 원하시면\"c\"를 입력하시오");
		System.out.println("종료를 원하시면\"n\"을 입력하시오");
		String schecker = user.scan.next();
		
		if(schecker.equals("a"))
		{
			menuSelect_order();
			pay();
			lastCheck();
		}
		else if(schecker.equals("b"))
		{
			System.out.println("거스름돈입니다 : " + totalbudget);
		}
		else if(schecker.equals("c")){
			inputCoinAgain();
			insideBudgetMenu();//예산 금액 내의 메뉴 출력 + 해당 메뉴 묶기
			menuSelect_order();
			pay();
			lastCheck();
		}
		else if(schecker.equals("n")){}
		else{
			System.out.println("잘못 입력하셨습니다. \n");			
			lastCheck();
		}
	}
	

}
