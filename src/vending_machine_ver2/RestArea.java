package vending_machine_ver2;

public class RestArea {
	//Field
	String RestAreaName;
	VendingMachine machine;
	public RestArea()
	{
		this("유명한");
	}
	public RestArea(String name)
	{
		this.RestAreaName = name;
		System.out.println("====="+RestAreaName+" 휴게소에 오신것을 환영합니다.=====");
		machine = new VendingMachine();
	}

}
