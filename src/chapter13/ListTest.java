package chapter13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List 인터페이스
 */
public class ListTest {

	public static void main(String[] args) {
		//제너릭<>을 통해 데이터 타입을 정의한 후 사용함
		// List<int> list1 = new ArrayList<int>()args - 이거 오류
		List<Integer> list1 = new ArrayList<Integer>();// - 이거 오류
		List<String> list2 = new LinkedList<String>();
		List<Double> list3 = new Vector<Double>();
		
		// 1. 데이터 저장 작업 : C(Create)
		list1.add(100);
		list1.add(200);
		
		list2.add("300");
		list2.add("홍길동");
		
		list3.add(1.23);
		list3.add(100.1123);
		
		// 2. 데이터 출력 : R(Reading)
		for(int i = 0; i<list1.size();i++)
		{
			System.out.println(list1.get(i));
		}
		for(String s : list2)
		{
			System.out.println(s);
		}
		//아래는 컬렉션개체에서만(Iterable을 상속 받았을 때만) 쓰는 의존적인 거다.
		//즉, 상속여부나 정의 여부 확인하고 쓰기.
		//String[] slist = new String[5];
		//slist.forEach(); 이렇게 하면 작동을 안한다. 왜냐하면 String에는 없으니까.
		
		//forEach()의 매개변수는 람다식 메소드 호출 방식을 갖는다.
		//(매개변수-리스트에서 나오는거) -> {처리 로직}
		//이런걸 람다식(람다 표현 방식)
		list3.forEach((dnum)->{
			System.out.println(dnum);
			});
		//좀더 줄이기
		list3.forEach(dnum -> System.out.println(dnum));
		
		//list3.forEach(클래스타입::메소드명);
		list3.forEach(System.out::println);
		
		//3. 데이터 업데이트 : U(Update)
		list1.set(0, 1000);
		list2.set(0, "이순신");
		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
		
		
		//4. 데이터 삭제 : D (Delete)
		
		list1.remove(0);
		list2.remove(0);
		list3.remove(0);

		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
		list3.forEach(System.out::println);
		
		//** 데이터 삭제시 인덱스 중복으로 인한 내부 에러가 발생함!!!
		//Iterable(순회) 인터페이스를 통한 삭제를 권장!!
		
		List<String> list4 = new ArrayList<String>();
		list4.add("java");
		list4.add("mysql");
		list4.add("html");
		list4.add("css");
		list4.add("java");
		list4.add("css");

		list4.forEach(System.out::println);

		System.out.println("--------------------------");
		// 단순하게 iterator명.remove(내용)으로 날려버리면 인덱스 번호가 비어서 꼬이는 경우가 생긴다.
		Iterator<String> ie = list4.iterator();
		while(ie.hasNext())
		{
			String element = ie.next();
			System.out.println(element);
			if(element.equals("html"))
			{
				ie.remove();
			}
		}
		list4.forEach(System.out::println);		
	}

}
