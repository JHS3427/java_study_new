package vending_machine_ver2;

import java.util.Scanner;

public class User {
	//사용자 이름, 입력을 위한 스캐너 객체 생성
	String name;
	Scanner scan;
	int totalInputCoin=0;
	int inputNumber = 0;
	//
	
	public User()
	{
		scan = new Scanner(System.in);
	}
	
	//getter 메소드
	
	public String getName()
	{
		return name;
	}
	
	public Scanner getScan()
	{
		return scan;
	}
	/*
	 * 동전 넣기1
	 */
	public void insertCoin()//잘 만들었는데, 동전 체크는 기계가 해야하니 여기서는 데이터 넘기기만 해야함. 메소드 새로 만들예정
	{
		/*
		 * 신경쓸 점 1. 동전은 100/500원뿐
		 * 2. 더넣을지 말지 결정
		 * 3. 넣은거 합계 계산.
		 */
		
		System.out.println("100원 또는 500원 동전을 넣어주세요.");
		if(scan.hasNextInt())
		{
			int inputCoin = scan.nextInt();
			if(inputCoin==100 || inputCoin==500)
			{
				totalInputCoin +=inputCoin;
				System.out.println("더 넣으시겠습니까?(그만 두시려면 n을 누르세요)");
				if(!(scan.next().equals("n")))
				{
					insertCoin();	
				}
			}
			else
			{
				System.out.println("잘못된 동전입니다. 다시 입력하세요");
				insertCoin();				
			}
		}
		else
		{
			System.out.println("동전이 아닙니다. 다시 입력하세요.");
			scan.next();
			insertCoin();
		}
		
	}
	/*
	 * 동전 넣기 2
	 */
	public void onlyInsertNumber()
	{
		System.out.println("난 숫자가 적혀있는걸 넣을거야. 맞는 동전인지는 기계가 판단해주겠지.");
		System.out.println("그만 둘꺼면 \"도망\"이라고 적어야지");
		if(scan.hasNextInt())
		{
			inputNumber = scan.nextInt();
			System.out.println("자판기에 " + inputNumber + " 이라는 숫자를 넣을거야");
		}
		else
		{
			System.out.println("이건 아니네. 다시 시도해야지.");
			String again = scan.next();
			if(again.equals("도망"))
			{
				System.exit(0);
			}
			else
			{
				onlyInsertNumber();
			}
		}
	}
	/*
	 * 메뉴 고르기 - 사람
	 */
	public int menuSelect()
	{
		System.out.println("메뉴를 고르자. 단, 메뉴는 숫자만 입력해야해.");
		int result = -1;
		
		if(scan.hasNextInt())
		{
			result = scan.nextInt();
		}
		else
		{
			scan.next();
		}
		return result;
	}
}
