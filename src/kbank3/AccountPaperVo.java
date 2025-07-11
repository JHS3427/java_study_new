package kbank3;

/**
 * 입출금 용지
 */

public class AccountPaperVo {
	//Field
	
	private String name;
	private String accountNumber;
	private String password;
	private int money;

	private static AccountPaperVo accountPaper = new AccountPaperVo();
	
	public static void showInfo()//static쓰는 이유 : 생성자가 private라 호출이 안되서 static으로라도 써야함.
	{//그냥 name을 쓰면 안들어가는 이유 - 이 메소드는 static인데 name 변수가 static이 아니라서 에러 발생
		System.out.print(accountPaper.getName() + "\t");
		System.out.print(accountPaper.getAccountNumber() + "\t");
		System.out.print(accountPaper.getPassword() + "\t");
		System.out.print(accountPaper.getMoney() + "\n");
	}
	
	//Constructor
	private AccountPaperVo() {}
	
	//Method
	
	public static AccountPaperVo getInstance() {return accountPaper;}
	//외부에서 쓰긴 써야하는데 private라 생성자를 사용하지 못하니까 static에 저장되있는걸 가져다 쓴다.
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getAccountNumber() {return accountNumber;}
	public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public int getMoney() {return money;}
	public void setMoney(int money) {this.money = money;}
	
}
