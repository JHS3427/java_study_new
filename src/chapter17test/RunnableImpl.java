package chapter17test;

public class RunnableImpl implements Runnable{

	public RunnableImpl()
	{
		
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i<10;i++)
		{
			try
			{
				Thread.sleep(1000);
				System.out.println("abc>>"+i);
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	
}
