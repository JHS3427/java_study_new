package kbank2;

/**
 * 은행 직원 클래스
 */

public class BankMan {
	String name;
	AccountPaperVo accountPaper;
	AccountVo[] accountList;	//은행 고객 리스트
	Customer customer;
	public BankMan()
	{
		this("변우석");
	}
	public BankMan(String name)
	{
		this.name = name;
		accountList = createAccountList();
	}
	/**
	 * 은행 직원이 관리하는 고객 리스트 출력
	 */
	public void showAccountList()
	{
		for(int i = 0 ; i < accountList.length; i++)
		{
			AccountVo account = accountList[i];
			System.out.println((i+1)+"\t");
			System.out.println(account.getName()+"\t");
			System.out.println(account.getAccountNumber()+"\t");
			System.out.println(account.getPassword()+"\t");
			System.out.println(account.getBalance()+"\n");
		}
	}
	/**
	 * 은행 직원이 관리하는 고객리스트 생성
	 * 
	 */
	
	
	public AccountVo[] createAccountList()
	{
		String[] names = {"홍길동","이순신","김유신"};
		String[] numbers = {"kb-1234","kb-9876","kb-3456"};
		String[] passwords = {"1234","9876","3456"};
		int [] balances = {500,1000,700};
		AccountVo[] list = new AccountVo[names.length];
		
		for(int i = 0; i <names.length;i++)
		{
			AccountVo account = new AccountVo();
			account.setName(names[i]);
			account.setAccountNumber(numbers[i]);
			account.setPassword(passwords[i]);
			account.setBalance(balances[i]);
			list[i] = account;
		}
		return list;
	}
	
	/**
	 * 입출금 용지 체크
	 */
	public void checkPaper(AccountPaperVo accountPaper, Customer customer)
	{
		this.customer = customer;
		
		System.out.println("[은행 직원 : "+name+"] 출금 용지 정보를 확인하는 중입니다" );
		if(accountPaper.getName()==null)
		{
			System.out.println("[은행 직원 : "+name+"] 이름을 입력해주세요" );
			System.out.println("[고객 : "+customer.getName()+"] 이름을 입력" );
			String name = customer.getScan().next();
			accountPaper.setName(name);
			System.out.println(accountPaper.getName());
		}
		else if(accountPaper.getAccountNumber()==null)
		{
			System.out.println("[은행 직원 : "+name+"] 계좌번호를 입력해주세요" );			
		}
		else if(accountPaper.getPassword()==null)
		{
			System.out.println("[은행 직원 : "+name+"] 비밀번호을 입력해주세요" );	
		}
		else if(accountPaper.getMoney()==0)
		{
			System.out.println("[은행 직원 : "+name+"] 금액을 입력해주세요" );
		}
		else
		{
			System.out.println("[은행 직원 : "+name+"] 정보 확인이 완료되었습니다." );
		}
	}
	
}
