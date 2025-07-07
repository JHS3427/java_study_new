package chapter05;

import java.util.Scanner;

/*
 * 반복문 : do { 실행문(조건식이 true인 경우에만 실행); } while(조건식)
 * 		  처음 실행문은 조건식에 관계없이 무조건 한 번 실행됨
 * 		  종료되는 시점을 정확하게 알고 있는 경우 사용됨
 */
public class DoWhileTest {

	public static void main(String[] args) {
		// 1~10까지 정수의 합계를 출력
		// 시작과 종료값은 실행시 외부에서 입력을 통해 진행함
		Scanner scan = new Scanner(System.in);
		int start = 0, end = 0, i = 0, sum = 0;
		
		System.out.print("start> ");
		i = start = scan.nextInt();		
		
		System.out.print("end> ");
		end = scan.nextInt();		
		
		do {
			sum += i;
			i++; //i+=10;
		} while(i<=end);
		
		System.out.println("sum = " + sum);

	}

}
