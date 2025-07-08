package chapter07;

/*
 * 생성자 오버로딩, this()메소드 사용 예정
 */
public class Animal3 {
	//field
	int age;
	String name;
	String addr;
	//constructor
	public Animal3()
	{
		this("홍길동",12,"강남구");
	}
	public Animal3(String name)
	{
		this(name, 5, "강남구");//변수 3개짜리 생성자를 불러서 객체 초기화를 진행하는 모습
//		this.name = name;
//		this.age = 5;
//		this.addr = "강남구";
	}
	public Animal3(int age)
	{
		this("홍길동",age,"강남구");
//		this.age = age;
	}
	public Animal3(String name, int age)
	{
		this(name,age,"강남구");
//		this.name = name;
//		this.age = age;		
	}
	public Animal3(String name, int age, String addr)
	{
		this.name = name;
		this.age = age;		
		this.addr = addr;		
		
	}
	//method
	public void info() {
		System.out.println("name = " + name);
		System.out.println("age = "+ age);
		System.out.println("addr = " + addr);
	}
}
