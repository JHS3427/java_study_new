package chapter13;

import java.util.HashMap;
import java.util.Map;

/**
 *  맵 인터페이스
 */
public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> subjects = new HashMap<Integer,String>();
		// 1. 데이터 저장 작업 : C(Create)
		subjects.put(1,"java");
		subjects.put(2,"mysql");
		subjects.put(3,"html");
		subjects.put(4,"css");
		// 2. 데이터 출력 : R(Reading)
		//subjects.forEach(System.out::println);클래스 참조 형식의 람다코드는 사용 불가. 값이 키/벨류로 명확하지 않아서 불가
		subjects.forEach((key,value)->
			System.out.println(key + " , " + value)
		);
		
		//3. 데이터 업데이트 : U(Update)
		//mysql --> oracle
		if(subjects.containsKey(2))
		{
			subjects.replace(2, "oracle");
		}
		subjects.forEach((key,value)->System.out.println(key + " , " + value));
		
		//4. 데이터 삭제 : D (Delete)
		//oracle 삭제 - 이름.remove(키값)
		subjects.remove(2);
		
		subjects.forEach((key,value)->System.out.println(key + " , " + value));
		
		System.out.println("a");
		subjects.clear();// 전체 삭제.
		subjects.forEach((key,value)->System.out.println(key + " , " + value));
		System.out.println("a");
	}
}
