package chapter17test;

public class ThreadT extends Thread{

	public ThreadT()
	{
		super("쓰레드테스트");
	}
	
	
	@Override
	public void run()
	{
		for(int i = 0; i<10;i++)
		{
			try
			{sleep(1000);
			System.out.println(i);
			}
			catch(Exception e)
			{
				
			}
		}
	}
}
