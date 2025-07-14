package chapter08_test;

public class Person extends Client {
	//String name;
	//int age;
	String phoneNum;
	String address;
	
	public Person(String name, int age, String phoneNum,String address)
	{
		super(name,age);
		this.phoneNum = phoneNum;
		this.address = address;
		System.out.println("사람");
	}
	@Override
	public void printInfo()
	{
		System.out.println(name + "\t" + age+ "\t"+phoneNum+ "\t"+address);
	}
	
}
