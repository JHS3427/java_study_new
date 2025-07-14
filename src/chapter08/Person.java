package chapter08;

public class Person extends Client {
	//부모 클래스의 생성자 호출 메소드 : super()
	// 이거 주석처리 해서 name,age 필드는 부모 클래스 에서 사용
	//만약 super 써놓고 Person 클래스에서 name age를 선언해버리면 선언한걸 갖다써서 super가 의미가 없어진다.

//	String name;
//	int age;
	String name;
	int age;
	String address;
	String phone;

		
	public Person()
	{
		this("이순신","강남구","010-1234-1234",20);
	}
	public Person(String name, String address, String phone, int age)
	{
//		super(name,age);
		this.name = name;
		this.address = address;
		this.phone = phone;
		//this.name = name;
	}
	@Override
	public void register()
	{
		System.out.println(name + " 고객이 접수를 한다");
	}
	@Override
	public void payment() {}
	
	
	@Override
	public void printInfo()//부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
	{
		System.out.print("고객(Person) 정보 =>");
		System.out.print(name + ",");
		System.out.print(age + ",");
		System.out.print(address + ",");
		System.out.print(phone + "\n");
	}
}
