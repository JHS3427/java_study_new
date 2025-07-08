package lunch;

public class LunchOrderMenuManager {
	//Field
	LunchOrderSystemOOP system;
	//constructor
	public LunchOrderMenuManager(LunchOrderSystemOOP system) {
		this.system = system;//여기 주석처리해도 코드상으로는 에러가 안뜨지만 실제 system은 null이라 널포인트 에러가 발생한다.
	}
	
	//method
	/*
	 * 런치 메뉴 체크
	 */
	public LunchOrderMenuManager() {}
	//method
	/*
	 * 런치 메뉴 체크
	 */
	public void lunchMenuCheck(int lunchMenu)
	{
		// lunchMenu가 1~4이면 주문 가능. 그 이외의 다른 번호 : 메뉴 준비중 >다시 입력
		if(1 <= lunchMenu && lunchMenu<=4)
		{//주문 진행 ==> OrderItem객체 생성
			system.order(lunchMenu);
		}
		else
		{
			System.out.println("런치 메뉴 준비중");
			system.showLunchMenu();
		}
	}
	
	/*
	 * 런치 메뉴 생성
	 */
	public void createLunchMenu() 
	{
		for(int i = 0; i<system.lunchMenuNames.length; i++)
		{
			LunchMenu menu = new LunchMenu(); // 이거 바깥에 선언하면 4번다 똑같은 값 나온다.
			/*for문 안에 넣어야 하는 이유 :
			 * for문 안에 안넣고 바깥으로 빼면 새로 생성이 안되고 저장위치가 1개라는 얘기다.
			 * 즉, lunchMenuList[i]에는 전부 같은 주소가 저장되고,
			 * 이에 따라 menu 마지막에 저장된 값이 모든 lunchMenuList 배열 안에 저장된다
			 * call by reference라서 이럼.
			 */
			menu.no = i+1;
			menu.name = system.lunchMenuNames[i];
			menu.price = system.lunchMenuPrice[i];
			
			system.lunchMenuList[i] = menu;
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

	public void showMainMenu()
	{
		System.out.println("******************************************");
		System.out.println("\t Welcome to [" + system.title + "] Food Mart!!!");
		System.out.println("******************************************");
		System.out.println("\t 1. 음식 주문");		
		System.out.println("\t 2. 주문 내역");		
		System.out.println("\t 3. 음식 결제");		
		System.out.println("\t 4. 결제 내역");		
		System.out.println("\t 9. 프로그램 종료");		
		System.out.println("******************************************");
		System.out.println("***** Food Mart에 오신것을 환영합니다");
		//createLunchMenu();
		system.selectMainMenu();
		
	}//show main menu
	/*
	 * 런치 메뉴 선택
	 */
	public void selectLunchMenu()
	{
		System.out.print("주문 메뉴(숫자)> ");
		if(system.scan.hasNextInt())
		{
			lunchMenuCheck(system.scan.nextInt());
		}
		else
		{
			System.out.println(" => 입력된 값이 올바르지 않음. 재입력 요청!");
			system.scan.next();//잘못된 값을 일단 받아주는 용도다.
			selectLunchMenu();//리컬시브 콜. - While 안쓰고 자기 자신을 다시 불러서 사용 가능
		}
	}
}
