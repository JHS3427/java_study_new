package chapter12;

public class WrapperTest {

	public static void main(String[] args) {
		int num1 = 100;
		Integer num2 = new Integer(num1);//이렇게 사용하는 거는 다음 버젼에서 업뎃하면서 없어질지 모르는걸 얘기함.
		//위는 권장하지 않음. 아래를 권장함.
		Integer num3 = Integer.valueOf(num2);
		//위와 아래의 차이점. parseInt의 경우 문자열을 int 기본형으로 변경. valueOf보다 빠르고 가벼움.
		//valueOf의 경우 Integer 클래스 형식으로 만들고, 기본형처럼 작업이 필요한 경우, 이를 기본형으로 변경시켜줌
		//parseInt에 비하면 무겁지만, 배열이면서 동시에 기본형변환까지 가능해서 사용 범위가 넓음.
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
