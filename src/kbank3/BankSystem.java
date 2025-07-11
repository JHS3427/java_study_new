package kbank3;

public class BankSystem { // 여기저기서 쓸 수 있으므로 싱글톤으로 만들어도 괜찮다.
	String name;
	AccountVo[] accountList;
	
	public BankSystem (String name)
	{
		this.name = name;
		accountList = createAccountList();//accountList 생성 메소드(은행 고객 리스트 생성)
		
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
	{//names~list까지는 stack에 저장되지만 메소드 끝나면 전부 사라진다.
		String[] names = {"홍길동","이순신","김유신"};
		String[] numbers = {"kb-1234","kb-9876","kb-3456"};
		String[] passwords = {"1234","9876","3456"};
		int [] balances = {1500,1000,700};
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
	 * 계정 검색
	 * @param accountPaper
	 * @return
	 */
	public int searchAccount(AccountPaperVo accountPaper)
	{
		int resultIdx = -1;
		for(int i = 0 ; i < accountList.length;i++)
		{
			AccountVo account = accountList[i];
			if(account.getAccountNumber().equals(accountPaper.getAccountNumber())
				&& account.getPassword().equals(accountPaper.getPassword()))
				//account.getName().equals(accountPaper.getName())이거는 겉 껍데기"[]"이거 때문에 문제되서 제외
			{
				resultIdx=i;
				break;
			}
		}
		return resultIdx;
	}
}
