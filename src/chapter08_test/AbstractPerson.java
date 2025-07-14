package chapter08_test;

public class AbstractPerson extends AbstractClient{

	String name;
	int age;
	String address;
	String phone;
	
	public AbstractPerson(String name, int age, String address, String phone)
	{
		this.name = name;
		this.age = age;
		this.address =address;
		this.phone = phone;
	}
	
	public void print()
	{
		System.out.println(name+ " " + age + address+ phone);
	}
	
}
