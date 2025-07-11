package kbank3;

import java.util.Scanner;

public class Customer {
	//Field
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo accountPaper;
	private Scanner scan;
	
	//Constructor
	public Customer() {}
	public Customer(String name, String accountNum, String pw, int money)
	{
		this.name = "[ 고객 : "+name + "]";
		this.accountNumber = accountNum;
		this.password = pw;
		this.money = money;
		this.scan = new Scanner(System.in);
		System.out.println(this.name + "입장!");
	}
	
	//Method
	

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getAccountNumber() {return accountNumber;}
	public void setAccountNumber(String accountNumber) {
		
		this.accountNumber = accountNumber;
		}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public int getMoney() {return money;}
	public void setMoney(int money) {this.money = money;}
	
	public AccountPaperVo getAccountPaper() {return accountPaper;}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		/*
		//이렇게 해도 작동은 하지만, customer에는 해당 정보 저장이 안된다.
		//그리고 이렇게하면 넘겨주는 기능을 구현 못한다
		accountPaper.setName(this.name);
		accountPaper.setAccountNumber(this.accountNumber);
		accountPaper.setPassword(this.password);
		accountPaper.setMoney(this.money);
*/
		this.accountPaper = accountPaper;
		this.accountPaper.setName(this.name);
		this.accountPaper.setAccountNumber(this.accountNumber);
		this.accountPaper.setPassword(this.password);
		this.accountPaper.setMoney(this.money);
		System.out.println(this.name + "직원에게 전달");
		}

	public Scanner getScan() {return scan;}
	public void setScan(Scanner scan) {this.scan = scan;}
	
	
	/**
	 * 은행직원으로부터 유효성 체크 결과를 받은 후 빠진 고객 정보를 입력한다.
	 * @param result
	 */
	public AccountPaperVo answer(int checkresult)
	{
		switch(checkresult)
		{
			case BankMan.ACCOUNT_NAME://public이니까 어디서든 호출 가능
				System.out.println(this.name + "고객명");
				String name = scan.next();
				accountPaper.setName(name);
				//이름
				break;
			case BankMan.ACCOUNT_NUMBER:
				System.out.println(this.name + "계좌번호");
				String accountNumber = scan.next();
				accountPaper.setAccountNumber(accountNumber);
				//계좌번호
				break;
			case BankMan.ACCOUNT_PASSWORD:
				System.out.println(this.name + "비번");
				String password = scan.next();
				accountPaper.setPassword(password);
				//비밀번호
				break;
			case BankMan.ACCOUNT_MONEY:
				//돈
				System.out.println(this.name + "금액");
				money = scan.nextInt();
				accountPaper.setMoney(money);
				break;
		}
		return accountPaper;
	}
	
	public void confirmBalance(AccountPaperVo accountPaper)
	{
		
	}
	
}
