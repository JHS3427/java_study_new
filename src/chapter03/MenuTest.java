package chapter03;

import java.util.Scanner;

public class MenuTest {

	public static void main(String[] args) {		
		
		System.out.println("********************************************");
		System.out.println("\t Welcome to Shopping Mall");
		System.out.println("\t Welcome to Food Market");
		System.out.println("********************************************");
		System.out.println("\t 1. 햄버거(🍔):100\t 2. 피자(🍕):200");
		System.out.println("\t 3. 라멘(🍜):300\t 4. 샐러드(🥗):400");
		System.out.println("\t 0. 나가기");
		System.out.println("********************************************");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 선택해주세요(숫자) > ");
		int menuNumber = scan.nextInt();
		
		System.out.println("선택한 메뉴 : " + menuNumber);

	}

}










