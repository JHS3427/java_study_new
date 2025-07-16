package chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args)
	{
		ArrayList list = new ArrayList();
		ArrayList<String> list2 = new ArrayList<String>();
		
		System.out.println(list.size());
		//리스트는 배열이 아니라서 .length말고 .size로 크기 표현. 단, size는 채워진 공간 수 만큼 출력해줌
		list.add(100);
		list.add(new String("홍길동"));
		list.add(123.456);
		list.add(new Scanner(System.in));
		System.out.println(list.size());
		//System.out.println(list[0]); //이렇게 접근 불가
		System.out.println(list.get(0));//메소드 접근하듯 이렇게 가져와야함
		System.out.println(list.get(1));//메소드 접근하듯 이렇게 가져와야함
		System.out.println(list.get(3));//메소드 접근하듯 이렇게 가져와야함
		
		list2.add("홍길동");
		//list2.add(123);//list2는 제너릭으로 문자열만 넣는거로 선언했기 때문에 숫자로 넣으면 에러
		list2.add(String.valueOf(123));//숫자를 문자열로 만드는 String.valueOf()
		
		list2.set(0, "이순신");//해당 위치에 데이터를 바꿔준다.
		list2.add(1,"김유신");// n번째 자리에 데이터 삽입
		list2.remove(0);//n번째 삭제.
		list2.remove(1);//n번째 삭제.
		for (String str : list2)
		{
			System.out.println(str);
		}
	}
}
