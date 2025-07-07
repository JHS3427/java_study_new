package chapter05;

import java.util.Scanner;

/*
 * 중첩 if
 */
public class IfOverlabTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean math_pass = false, eng_pass = false;
		
		System.out.print("수학> ");
		math_pass = (scan.nextInt() >= 60)? true: false;
		System.out.print("영어> ");
		eng_pass = (scan.nextInt() >= 60)? true: false;		
		
		//1. 중첩 if
		if(math_pass) {
			if(eng_pass) System.out.println("합격");			
		}
		else System.out.println("불합격1");

		//2. 논리연산자 &&를 이용하여 if ~ else
		if((math_pass) && (eng_pass)) System.out.println("합격");
		else System.out.println("불합격2");
		
	}

}













