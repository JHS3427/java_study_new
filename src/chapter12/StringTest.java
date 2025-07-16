package chapter12;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동"; // 기본 데이터 타입으로 인식 > Stack에 저장됨
		String name2 = new String("홍길동");// 클래스 취급으로 Heap에 저장, name2 는 주소값을 가짐.
		String num = String.valueOf(123);
		name2 = "w-elcomeToJAvaworld";
		String[] sname2 = name2.split("-");
		String phone = "010-1234-56789";
		String subject = "java,css,html,mysql";
		String[] phones = phone.split("-");
		String[] subjects = subject.split(",");
		String jphone = String.join(",", phones);//배열을 string 한줄로 묶어줌

		System.out.println(subject.contains("html"));//true
		System.out.println(jphone);//010,1234,56789
		System.out.println(subjects[0]);//java
		System.out.println(phones[0]);//010
		System.out.println(sname2[0]);//w
		System.out.println(name2.substring(7));//7번째부터 뒤를 뽑아서 출력
		System.out.println(name2.substring(7,10));//7번째부터 뒤를 뽑아서 10번째까지 출력
		System.out.println(name2.length());
		System.out.println(name2.toUpperCase());
		System.out.println(name2.toLowerCase());
		System.out.println(num + 10);
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		
		if(name1 == name2)
		{System.out.println("True");}
		else
		{
			System.out.println("False");
		}
		if(name1.equals(name2)) // 이거는 name2의 주소에 저장된 값을 가져오는거라 같다.
		{
			System.out.println("True2");
		}

	}

}
