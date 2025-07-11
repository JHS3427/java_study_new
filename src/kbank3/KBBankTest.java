package kbank3;

public class KBBankTest {

	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB");
		AccountPaperVo accountPaper = AccountPaperVo.getInstance(); // 싱글톤이다.
		
		//System.out.println("1번 : " + accountPaper.getName());
		
		BankMan staffPark = new BankMan("박보검",kbsystem); //은행 직원은 고객 리스트 정보를 알고 있다.
		
		//은행직원이 고객 정보 리스트 출력
		//staffPark.getKbSystem().showAccountList();
		
		Customer hong = new Customer("홍길동","kb-1234","1234",0);
		hong.setAccountPaper(accountPaper);
		//AccountPaperVo.showInfo();//데이터가 잘 들어가 있는지 확인.
		//hong.getAccountPaper().showInfo();위와 같은 내용이다. 대신 추천할만한 방식은 아님.
		
		
		//은행 직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper());
		staffPark.validateCheck();//고객에게 받은 출금용지에 빈칸여부 확인하는 작업.
		//hong.answer(staffPark.checkresult);
		AccountPaperVo.showInfo();
		boolean validateFlag = true;
		while(validateFlag)
		{
			if(staffPark.validateCheck(hong.answer(staffPark.checkresult)))
			{
				validateFlag=false;
			}
		}
		AccountPaperVo.showInfo();
		System.out.println("출금진행");
		staffPark.processWithdrawal();
		
		hong.confirmBalance(hong.getAccountPaper()); // 은행 시스템을 이용하여 잔액을 확인
		}

}
