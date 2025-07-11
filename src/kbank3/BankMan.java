package kbank3;

public class BankMan {
	//Field
	String name;//private일 필요 없음.
	int checkresult;
	//AccountPaperVo는 다른사람이 접근하면 안되니까 private
	private AccountPaperVo accountPaper;//고객들과 주고받는 입출금 용지 - 새로 만드는거 아니니까 new일 필요 없음.
	private AccountVo[] accountList;//고객정보 리스트.
	private BankSystem kbSystem;
	
	public static final int ACCOUNT_NAME=1;
	public static final int ACCOUNT_NUMBER=2;
	public static final int ACCOUNT_PASSWORD=3;
	public static final int ACCOUNT_MONEY=4;
	//Constructor
	
	public BankMan() {}
	public BankMan(String name, BankSystem kbSystem)
	{
		this.name = "[은행직원 : " + name + "]";
		this.kbSystem = kbSystem;
		System.out.println(this.name +" 업무 시작");
	}

	
	
	//Method
	//고객의 출금 정보 유효성 체크 결과에 따라 질문
	public void ask(int status)
	{
		switch(status)
		{
			case ACCOUNT_NAME:
				System.out.println(this.name + " 이름을 입력해주세요");
				checkresult=ACCOUNT_NAME;
				break;
			case ACCOUNT_NUMBER:				
				System.out.println(this.name + " 계좌번호를 입력해주세요");
				checkresult=ACCOUNT_NUMBER;
				break;
			case ACCOUNT_PASSWORD:				
				System.out.println(this.name + " 비밀번호를 입력해주세요");
				checkresult=ACCOUNT_PASSWORD;
				break;
			case ACCOUNT_MONEY:
				System.out.println(this.name + " 금액을 입력해주세요");	
				checkresult=ACCOUNT_MONEY;			
				break;
		}
	}
	
	
	/**
	 * 고객의 출금정보 유효성 체크 : 고객에게 전달받은 용지에 빈값이 있는지 체크하는ㅏ
	 * @return
	 */
	public void validateCheck() {
		System.out.println(this.name + " 고객 정보에 대한 유효성 체크를 진행함.");		
		if(accountPaper.getName()==null)
		{
			ask(ACCOUNT_NAME);
		}
		else if(accountPaper.getAccountNumber()==null)
		{
			ask(ACCOUNT_NUMBER);
		}
		else if(accountPaper.getPassword()==null)
		{
			ask(ACCOUNT_PASSWORD);			
		}
		else if(accountPaper.getMoney() == 0)
		{
			ask(ACCOUNT_MONEY);
		}
		else
		{
			System.out.println("이상 없습니다");
		}
	}
	
	public boolean validateCheck(AccountPaperVo updateAccountPaper)
	{
		System.out.println("재확인");
		boolean result = false;
		this.accountPaper = updateAccountPaper;
		if(accountPaper.getName()==null)
		{
			ask(ACCOUNT_NAME);
		}
		else if(accountPaper.getAccountNumber()==null)
		{
			ask(ACCOUNT_NUMBER);
		}
		else if(accountPaper.getPassword()==null)
		{
			ask(ACCOUNT_PASSWORD);			
		}
		else if(accountPaper.getMoney() == 0)
		{
			ask(ACCOUNT_MONEY);
		}
		else
		{
			System.out.println("이상 없습니다");
			result=true;
		}
		return result;
	}
	
	public void processWithdrawal() {
		System.out.println(this.name + "출금 요청 처리 진행 중입니다. 잠시만 기다려주세요");
		//고객계정 검색 - BankSystem. > 이후 잔고와 요청량 비교등 진행.
		int accountIdx = kbSystem.searchAccount(accountPaper);
		System.out.println(accountIdx);
		if( accountIdx !=-1)
		{
			//고객 정보 일치
			AccountVo account = kbSystem.accountList[accountIdx];
			if(account.getBalance()>=accountPaper.getMoney())
			{
				//출금진행
				int money = account.getBalance() - accountPaper.getMoney();
				account.setBalance(money);
				kbSystem.accountList[accountIdx] = account;//이거 안하면 지역변수만 바뀌고 전역은 안 바뀔 수 있다.
				
				processCompleted();
			}
			else
			{
				//잔액부족
				System.out.println(this.name + " 잔액이 부족합니다");
			}
		}
		else
		{
			//고객 정보 불일치
			System.out.println(this.name + " 계좌정보가 다릅니다. 확인 후 다시 진행해주세요");			
		}
		
	}

	/**
	 * 
	 * @return
	 */
	public void processCompleted()
	{
		System.out.println(this.name + " 출금처리가 완료되었습니다");
		System.out.println(this.name + " 출금액은 " + accountPaper.getMoney() + "원 입니다");
	}
	
	
	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}
	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		System.out.println(this.name + "고객에게 출금용지 받음");
	}
	public AccountVo[] getAccountList() {
		return accountList;
	}
	public void setAccountList(AccountVo[] accountList) {
		this.accountList = accountList;
	}
	public BankSystem getKbSystem() {
		return kbSystem;
	}
	public void setKbSystem(BankSystem kbSystem) {
		this.kbSystem = kbSystem;
	}


	
	
	
}
