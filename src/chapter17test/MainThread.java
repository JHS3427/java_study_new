package chapter17test;

public class MainThread {

	public static void main(String[] args)
	{
		System.out.println("1234");
		ThreadT TT = new ThreadT();
		TT.start();
		
		System.out.println("5678");
		Thread TT2 = new Thread(new RunnableImpl());
		TT2.start();
		System.out.println("9101112");
		
	}
}
