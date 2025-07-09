package vending_machine_ver1;

public class RestArea {
	String name;
	User user;
	VendingMachine machine;

	//Constructor
	public RestArea()
	{
		this("만남의 광장");
	}
	public RestArea(String name)
	{
		this.name = name;//객체 생성시 받은 파라미터 값의 사용 범위를 전체로 넓힘 = 멤버변수 초기화 작업
		user = new User("정국");
		welcome();
		machine = new VendingMachine(user);
	}
	
	public void welcome()
	{
		System.out.println("------------------------------------------");
		System.out.println(name + " 휴게소에 오신것을 환영합니다.");
		System.out.println(name + " 휴게소에 오신것을 환영합니다.");
		System.out.println("------------------------------------------");
	}
}
