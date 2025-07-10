package kbank;

public class AccountPaperVo {//출금 용지
//작성 고객 이름, 출금 요청 날짜 및 시간, 출금 요청 금액, 출금 가능 및 수행 여부
	//Field
	private String customerName;
	private String accountNumber;
	private String password;
	private int money;
	//Constructor
	private static AccountPaperVo accountPaper = new AccountPaperVo();
	
	private AccountPaperVo() {	}
	

	public String getCustomerName() {return customerName;}
	public void setCustomerName(String customerName) {this.customerName = customerName;}
	
	public String getAccountNumber() {return accountNumber;}
	public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public int getMoney() {return money;}
	public void setMoney(int money) {this.money = money;}


	public static AccountPaperVo getInstance()
	{
		return accountPaper;
	}
}
