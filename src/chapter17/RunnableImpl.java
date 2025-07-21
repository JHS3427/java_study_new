package chapter17;

public class RunnableImpl implements Runnable{
	
	public RunnableImpl() {}
	
	@Override//runnable은 void run만 가져오면 implements 문제 없음
	public void run()
	{
		for(int i = 0 ; i<=10;i++)
		{
			try{
				Thread.sleep(1000); //1초 슬립.-Runnable에는 없고 Thread에 있어서 Thread.sleep으로 사용
				System.out.println("Runnable --->"+i);//메인이 종료됐는데도 얘는 따로 돈다. 쓰레드가 달라서.
			}
			catch(Exception e)
			{e.printStackTrace();}
				
		}
	}

}
