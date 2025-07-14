package chapter08_test;

public class Client {
	String name;
	int age;
	
	public Client(String name, int age)
	{
		this.name = name;
		this.age = age;
		System.out.println("Client 시작");
	}
	
	public void printInfo()
	{
		System.out.println(name + "\t" + age);
	}
}
