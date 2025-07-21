package chapter17;

public class MainThreadTest {

	public static void main(String[] args) {//메인 쓰레드
		// 1~10 정수 출력
		for(int i = 0 ; i<=10;i++)
		{
			System.out.println(i);
		}
		ThreadExtends ts = new ThreadExtends(); // - 독립된 실행 = 각자 실행 후 각자 종료
		ts.start();
		
		Thread t = new Thread(new RunnableImpl());// - 독립된 실행 = 각자 실행 후 각자 종료
		//두번쨰는 ri.start로 바로 실행 불가.
		//runnable은 start가 하나밖에 안돼서 앞에서 하나 썻으면 다음부턴 Thread로 만들고, 매개변수로 클래스 주면 됨
		t.start();
		
		System.out.println("메인 메소드 종료/메인 쓰레드 종료");
	}
}
