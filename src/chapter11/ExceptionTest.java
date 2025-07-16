package chapter11;

import java.util.Scanner;
//구체적 예외에 대한 처리는 각 예외별 처리
public class ExceptionTest {

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
			System.out.println(numbers[5]);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("num2는 0을 입력할 수 없습니다.");
		}
		catch(ArrayIndexOutOfBoundsException aae)
		{
			System.out.println("배열 범위 초과");
			System.out.println(aae);//빨간색으로 나오는 메세지를 담아놓은거를 출력함. 객체 안에 담겨있는 내용출력
		}
	}
}
