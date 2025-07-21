package chapter17;

public class ThreadExtends extends Thread{
	
	public ThreadExtends()
	{
		super("쓰레드1");
	}
	
	@Override
	public void run() {//Thread가 호출되었을때 무조건 1회 수행
		//1~10까지 출력

		for(int i = 0 ; i<=10;i++)
		{
			try{
				sleep(1000); //1초 슬립.
				System.out.println(getName()+"--->"+i);//메인이 종료됐는데도 얘는 따로 돈다. 쓰레드가 달라서.
			}
			catch(Exception e)
			{e.printStackTrace();}
				
		}
	}	
}


