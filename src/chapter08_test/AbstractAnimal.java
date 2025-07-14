package chapter08_test;

public class AbstractAnimal extends AbstractClient{
	String animal;
	int age;
	String name;
	
	public AbstractAnimal(String type, int age, String name)
	{
		this.animal=type;
		this.age = age;
		this.name = name;
	}
	
	
	public void print()
	{
		System.out.print(animal + name + age);
	}

}
