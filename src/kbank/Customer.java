package kbank;

public class Customer {
	//Field
	String name;
	AccountVo Account = new AccountVo();
	//AccountVo를 singleton으로 만들었을 때도 이렇게 선언해도 문제가 없는 이유
	//AccountVo 클래스 자체는 public이다.
	//하지만 AccountVo abc = new AccountVo();를 하려고 하면
	//해당 클래스의 생성자는 private니까 발동할수가 없다. 따라서 오류인거다
	
	//Constructor
	public Customer()
	{
		Account.name ="홍길동";
		Account.accountNumber = "085302123456789";
		Account.password = "1q2w3e4r";
		Account.money = 5000000;
		System.out.println("aaa");
	}
	
	//Method

	public void withdrawlMoney(String customerName)
	{
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();
		accountPaper.setCustomerName(customerName);
		accountPaper.setAccountNumber("085302123456789");
		accountPaper.setPassword("1q2w3e4r");
		accountPaper.setMoney(4000000);
	}
	
	public int answer(int ask)
	{
		int result2 = 0;
		
		System.out.println("당신이 말한것에서 "+(Account.money - ask)+"원 만큼 부족합니다");
		result2 = Account.money - ask;
		return result2;
	}
	
	public void accountUpdate(int withdrawlMoney)
	{
		Account.money = Account.money - withdrawlMoney;
		System.out.println("내 통장 잔액은 "+ Account.money+"원 이네");
	}
}
