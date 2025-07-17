package chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 인터페이스
 */

public class SetTEst {
	public static void main(String[] args) {
			Set<String> foods = new HashSet<String>();
			
			// 1. 데이터 저장 작업 : C(Create)
			foods.add("된장찌개");
			foods.add("김치찌개");
			foods.add("짜장면");
//			foods.add("짜장면"); 중복데이터 저장 X
			
			// 2. 데이터 출력 : R(Reading)
			foods.forEach(System.out::println);
			System.out.println("");
			// 3. 데이터 업데이트 : U(Update)
			//짜장면-->짬뽕
			if(foods.contains("짜장면"))
			{
				foods.remove("짜장면");
			}
			foods.add("짬뽕");
			foods.forEach(System.out::println);
			// 4. 데이터 삭제 : D(Delete)
			// 김치찌개 삭제.
			//1) if(foods.contains("김치찌개")){foods.remove("김치찌개");} - set은 순서 문제가 없어서 이래도 괜찮음
			
			//2)는 아래.
			Iterator ie = foods.iterator();//제너릭으로 타입을 제한하지 않으면 Iterator는 object 타입으로 생성됨.
			while(ie.hasNext())
			{
				String food = (String)ie.next();
				//오른쪽 ie.next(); 는 기본으로 나오는 타입이 object이다. 따라서 왼쪽 food에 맞추려면
				//(String)ie.next();로 해야한다. 또는 while 위에 제너릭으로 Iterator<String> ie 로 하면 된다.
				if(food.equals("김치찌개"))
				{
					ie.remove();
				}
			}
			foods.forEach(System.out::println);
	}

}
