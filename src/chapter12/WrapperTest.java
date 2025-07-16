package chapter12;

public class WrapperTest {

	public static void main(String[] args) {
		int num1 = 100;
		Integer num2 = new Integer(num1);//이렇게 사용하는 거는 다음 버젼에서 업뎃하면서 없어질지 모르는걸 얘기함.
		//위는 권장하지 않음. 아래를 권장함.
		Integer num3 = Integer.valueOf(num2);
		int num4 = Integer.parseInt("12312");
		
		double dnum = Double.valueOf("123.333");
		//위쪽은 원래는 왼쪽이 클래스 형태로 받아야하지만, double처럼 기본형이라서  JVM이 알아서 바꿔주는거다. 
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(dnum);
	}

}
