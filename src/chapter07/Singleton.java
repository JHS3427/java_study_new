package chapter07;

/*
 * 싱글톤 디자인 패턴 적용 - 싱글톤 예시 만들어보기
 */
public class Singleton {

	//Field
	private static Singleton singleton = new Singleton();
	private String name;
	//Constructor : new Singleton(); - 불가. 싱글톤 디자인 패턴이라 다른데서 부르면 안되서 private로 사용.
	private Singleton()
	{	
	}
	
	//Method
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	//static을 쓰는 이유. - Singleton은 private라서 어디서 호출해서 new Singletoe이 불가해서 생성이 안됨.
	//이에 따라 static을 넣고, 이걸 이용해서 메인돌때 생성하게 만듬.
	public static Singleton getInstance()
	{
		return singleton;
	}
}
