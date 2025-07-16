package chapter11;

import java.util.Scanner;
//모든 예외를 묶어서 한번에 처리할 때는 Exception
public class ExceptionTest2 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("num1> ");
		int num1 = scan.nextInt();
		
		System.out.println("num2> ");
		int num2 = scan.nextInt();
		
		
		try
		{
			int result = num1/num2;
			System.out.println("Result = " + result);
			int[] numbers = {1,2,3};
			System.out.println(numbers[0]);
			//System.out.println(numbers[5]);
		}
		catch(Exception ae)//모든 예외의 부모가 Exception이라서 이렇게 처리하면 모든 예외를 한번에 받을 수 있다.
		{//대신 이렇게 받으면 구체적으로 어떤 예외가 발생했는지를 알수는 없다.
			System.out.println("예외발생");
			ae.printStackTrace();//빨간 에러 그대로 찍어줌
		}
		finally
		{
			scan.close();
			System.out.println("시스템종료");
		}
	}
}
