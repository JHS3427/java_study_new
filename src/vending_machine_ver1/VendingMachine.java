package vending_machine_ver1;

import commons.Menu;

public class VendingMachine {
	String[] nameList = {"밀크커피","아메리카노","유자차","우유"};
	int [] priceList = {300,400,300,200}; 
	Menu[] menuList;
	String title;
	//Constructor
	public VendingMachine()
	{
		this("스벅");
	}
	public VendingMachine(String title)
	{
		this.title = title;
		createMenuList();
		showMenuList();
	}
	
	//Method
	
	/*
	 * 메뉴 리스트 출력 메소드
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
