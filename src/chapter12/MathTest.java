package chapter12;

public class MathTest {

	public static void main(String[] args) {
		// 모든 메소드가 static으로 정의되어있음 : 클래스명.메소드명()
		
		System.out.println(Math.abs(-50));
		System.out.println(Math.floor(1.294567));//소수 첫째자리까지 표현, 반올림은 없음
		System.out.println(Math.max(100, 15000));
		System.out.println(Math.min(100, 90));
		System.out.println(Math.random());
		System.out.println(Math.floor(Math.random()*100));//정수 2자리 랜덤 호출

	}

}
