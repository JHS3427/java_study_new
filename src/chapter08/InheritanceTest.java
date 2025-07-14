package chapter08;

public class InheritanceTest {

	public static void main(String[] args) {
		//Client C1 = new Client(); 추상 메서드가 선언된 추상 클래스는 객체 선언이 불가해서 이게 에러뜸
		Person lee = new Person();
		Person kim = new Person("김유신","종로구","010-9876-9876",12);
		Animal dog = new Animal("명수",5,lee);
		Animal cat = new Animal("야옹이",5,kim);
//		System.out.println("c1.name == > " + C1.name);
//		System.out.println("p1.name == > " + p1.name);
//		System.out.println("a1.name == > " + a1.name);
//		System.out.println("p2.name == > " + p2.name);
		
		//C1.printInfo();
		lee.printInfo();
		kim.printInfo();
		dog.printInfo();
		cat.printInfo();
		
		lee.register();
		dog.register();
		
	}

}
