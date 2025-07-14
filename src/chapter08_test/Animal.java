package chapter08_test;

public class Animal extends Client {
	
	String name="실바";
	//int age;
	Person owner;
	public Animal(String animal, int age, Person owner)
	{
		super(animal,age);
		this.owner = owner;
	}
	@Override
	public void printInfo()
	{
		System.out.println(name + "\t" + age);
		System.out.println("주인 정보 : "
		+this.owner.name + "\t" + this.owner.age+"\t"+this.owner.address);
		
	}
}
