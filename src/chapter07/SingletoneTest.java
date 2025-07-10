package chapter07;

public class SingletoneTest {
	
	public static void main(String[] args)
	{
//		Singleton singleton = new Singleton(); //생성자가 private으로 접근제어 되어 not visible 에러 발생
		Singleton singleton = Singleton.getInstance();//이미 생성된 Singleton의 getInstance를 받아옴.
		
		singleton.setName("싱글톤");
		System.out.println("name : " + singleton.getName() );
	}

}
