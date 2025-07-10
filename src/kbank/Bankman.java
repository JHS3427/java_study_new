package kbank;

public class Bankman {
	//Field
	String name;
	AccountPaperVo AccountPaper;
	AccountVo bankHong = new AccountVo();
	public Bankman()
	{
		
		System.out.println("확인해보겠습니다.");
	}
	
	//Method
	
	public void searchAccount()
	{
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();
		System.out.println("입력하신 정보는 다음과 같습니다");
		System.out.print(accountPaper.getCustomerName() + "\t");
		System.out.print(accountPaper.getAccountNumber() + "\t");
		System.out.print(accountPaper.getPassword() + "\n");
		bankHong.name=accountPaper.getCustomerName();
		bankHong.accountNumber = accountPaper.getAccountNumber();
		bankHong.password = accountPaper.getPassword();
		//bankHong.money = 4000000;
		bankHong.money = accountPaper.getMoney();
	}
	
	public int askingToCustomer()
	{
		int result = 0;
		
		System.out.println("잔액이 " +bankHong.money +"원이 맞습니까?");
		result = bankHong.money;
		return result;
	}
	
	public void checking(int bankmoney,int difference)
	{
		if(bankmoney == (difference+bankHong.money))
		{
			System.out.println("누락이 있었습니다. 여기 "+difference+"원 입니다.");
		}			
	}
}
