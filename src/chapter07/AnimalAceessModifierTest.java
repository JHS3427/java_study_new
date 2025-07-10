package chapter07;
import java.util.Calendar;
import commons.Animal;
public class AnimalAceessModifierTest {
	
	public static void main(String[] args)
	{
		//calendar 객체 생성(?)
		// Calendar c= new Calendar(); //상속관계가 없으므로 객체 생성 불가.
		Calendar c = Calendar.getInstance(); // 생성된 객체의 인스턴스 주소를 가져옴. - Singleton(싱글톤 패턴)
		System.out.println(c.getTime());
		
		
		AnimalAccessModifier.sname = "스택틱";
		AnimalAccessModifier.sage = 10;
		AnimalAccessModifier.getInfo3();
		
		AnimalAccessModifier aam = new AnimalAccessModifier("호순이",5);
		
		aam.sname = "스택틱2";
		aam.sage =12 ;
		aam.getInfo3();
		
//		//final 변수 테스트
//		aam.fname =" 홍갈순";//final 키워드 변수는 외부에서 값을 변경 X
//		aam.fage =10;
		
		int start = AnimalAccessModifier.START;
		int con = AnimalAccessModifier.COUNTINUE;
		int end = AnimalAccessModifier.END;
		
		Animal comDog = new Animal();
		aam.name = "심바";
		aam.age =5 ;
		System.out.println("name = "+ aam.name);
		System.out.println("age = "+ aam.age);
		System.out.println("name = "+ aam.getPname());
		System.out.println("age = "+ aam.getPage());
		comDog.setName("기린이");
		comDog.setAge(11);
//		aam.pname = "호순이";// 클래스가 다르므로 접근 불가(private)
//		aam.page = 2;// 클래스가 다르므로 접근 불가(private)
		
//		comDog.name = "예삐"; // 패키지가 다르므로 접근 불가(default)
//		comDog.age = 3;			//패키지가 다르므로 접근 불가
		System.out.println("name = "+ comDog.getName());
		System.out.println("age = "+ comDog.getAge());
	}
}
