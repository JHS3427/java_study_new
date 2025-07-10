package kbank;

public class KBBank {

	
	public static void main(String[] args)
	{
		
		Customer customer = new Customer();
		customer.withdrawlMoney("홍길동");
		Bankman bankman = new Bankman();
		bankman.searchAccount();
		int bankexpect = bankman.askingToCustomer();
		int difference=customer.answer(bankexpect);
		bankman.checking(customer.Account.money,difference);
		customer.accountUpdate(difference);
	}
}
