package chapter11;

import java.util.Scanner;

/**
 * Exception 객체를 생성> 다른 메소드에게 예외처리를 넘김.
 * 
 * 일반적으로 자기 자신을 호출한 메소드에게 해당 에러를 넘김.
 */

public class ExceptionTest4 {

	//checkage 선언

	public static void CheckAge(int age) throws Exception
	{
//		try 
//		{
			if(age<0)
			{
				throw new Exception("나이는 0보다 커야한다");//강제로 에러띄워서 catch쪽으로 돌리는게 throw임
			}
			else
			{
				System.out.println("age : " + age);
			}
//		}
//		catch (Exception e)
//		{
//			System.out.println("age값은 0보다 커야 한다.");
//			e.printStackTrace();
//		}
		
	}
	public static void main(String[] args) throws Exception {
//키보드를 통해 나이를 입력받아 체크
		Scanner scan = new Scanner(System.in);
		
		System.out.println("나이 : ");
		int age = scan.nextInt();
		
		try
		{
			CheckAge(age);//메인이 마지막이라 받을 메소드가 없기떄문에 throws를 사용해도 exception은 발생함.
		}
		catch(Exception e)
		{
			System.out.println("Exception : age는 0보다 커야한다.");
		}
		finally
		{
			scan.close();
			System.out.println("프로그램 종료");
		}
	}//main
}//class
