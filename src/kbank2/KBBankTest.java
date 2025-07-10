package kbank2;

public class KBBankTest {
	//입출금 용지 1장 비치됨
	public static void main(String[] args)
	{
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();
		System.out.println("1번 : " + accountPaper.getName());
		BankMan staffPark = new BankMan("박보검");
		staffPark.showAccountList();
		Customer hong = new Customer(null,"kb-1234","1234",100);
		
		//홍길동이 출금용지에 이름 계좌번호 비밀번호를 작성
		hong.setAccountPaper(accountPaper);
		System.out.println("2번 : " + accountPaper.getName());
		
		//은행 직원이 용지를 확인
		//staffPark.setAccountPaper(hong.getAccountPaper());
		//staffPark.check(hong.getAccountPaper()); //--밑밑이랑 같은 함수 써서 변수따라 달라지는 그거로 할수도 있다.
		staffPark.checkPaper(hong.getAccountPaper(),hong);
		//금액이 누락되어 고객에게 금액을 물어봄
		//고객이 100만원이라 응답
	//	staffPark.askMoney(hong.answerMoney());||staffPark.askMoney(hong.getMoney());
		//은행이 계좌 정보를 검증함
	//	staffpark.check();
		//출금처리하고 잔액 400만원으로 업데이트
	//	staffpark.changeProcess();
		//고객이 잔액 확인 후 퇴장
	//	hong.confirmBalance();
	}
}
