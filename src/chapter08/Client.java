package chapter08;

//abstract 메소드를 하나라도 가지고 있으면 그 클래스는 abstract 클래스가 된다.
//abstract(추상)클래스는 객체 생성이 불가능 하다.
//대신 static으로 사용은 가능

/*
 * 더 구체적으로는, 자식 클래스를 통해 부모 클래스가 생성될 때를 한정으로 1회 생성자 호출이 가능하다.
 * 그러나 생성 이후에는 해당 클래스를 new를 통해서 불러와야 하는데, 그건 불가능하다.
 */


abstract public class Client {
	public static String name;
	public static int age;
	
//	public Client()
//	{
//		this("홍길동",10);
//	}
//	public Client(String name)
//	{
//		this(name,10);
//	}
//	private Client(String name,int age)
//	{
//		this.name = name;
//		this.age = age;
//	}
	
	//Method
	
	
	//부모가 가진 printInfo() 메소드를 강제적으로 상속함.
	//이런 강제적 상속 메소드는 body(중괄호)가 없다.
	//오버라이드 되는 메소드는 바디 없이 이름만 선언됨. --> 추상메소드(바디가 없는 메소드)라고 명명함.
	//이러한 추상 메소드(abstract method)를 가지려면 abstract class여야 한다.(class파일에 abstract 붙여야한다)
	abstract public void printInfo();
	abstract public void payment();
	abstract public void register();
	
}
