package vending_machine_ver1;

import java.util.Scanner;

public class User {
	//Field
	String name;
	Scanner scan;
	
	//Constructor
	
	public User() {this("아무개");}
	public User(String name)
	{
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	
	//Method
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
	 * 동전 입력
	 */	
	public int insertCoin()
	{
		int resultCoin = 0;
		System.out.print("["+name+"] 동전 입력>");
		if(scan.hasNextInt())
		{
			//100원 또는 500원만 입력 가능
			int coin = scan.nextInt();
			resultCoin =coin;
//			if(coinCheck(coin))
//			{
//				
//			}
		}
		else
		{
			System.out.print("올바르지 않은 값, 다시 입력해주세요.");
			scan.next();
			insertCoin();
		}		
		return resultCoin;
	}
	
	
}
