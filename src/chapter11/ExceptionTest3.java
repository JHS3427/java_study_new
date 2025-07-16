package chapter11;

public class ExceptionTest3 {

	public static void main(String[] args) {
		
		String name1 = "홍길동";
		String name2 = null;
		
		ExceptionObject eO = null;
		//위는 되고 아래는 에러 뜨는 이유
		//위는 String으로 데이터를 직접 null을 줘서 if문에서 name1과 비교하면 name2위치 찾아가서 빈값인걸 확인함.
		//반면 아래는 eO라는 녀석의 주소를 null을 준거라 eO위치를 찾지 못해서 name2의 위치를 못찾아서 널보인트가 뜸.
		//문제 없게 하려면 아래를 추가.
		eO = new ExceptionObject();
		eO.name = "홍길동";
		try {
			if(name1.equals(name2)) {
				System.out.print("동일");
			}
			else
			{
				System.out.print("다름!!");
			}
		}
		catch(NullPointerException ne)
		{}
		
		try {
			if(name1.equals(eO.name)) {
				System.out.print("동일");
			}
			else
			{
				System.out.print("다름!!");
			}
		}
		catch(NullPointerException ne)
		{
			System.out.println("NullPointerException 발생");
			ne.printStackTrace();
		}
	}

}
