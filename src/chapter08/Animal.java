package chapter08;

public class Animal extends Client{
	String name;
	int age;
	Person owner;
	
	public Animal()
	{
		this("예삐",3, null);
	}
	public Animal(String name , int age, Person owner)
	{
		this.age =age;//이렇게 해도 부모한테 전달은 되나 super가 권장됨.
		this.name = name;
		this.owner = owner;
	}
	
	//Method
	//sound(){}
	public void sound()
	{
		System.out.println(name + "짖는다");
	}
	public void register() {System.out.println(name + " 고객이 접수를 한다");}
	public void payment() {}
	//고객 정보 출력시 owner 정보 포함!
	
	@Override
	public void printInfo()//부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
	{
		System.out.print("고객(Animal) 정보 =>");
		System.out.print(name + ",");
		System.out.print(age + ",");
		System.out.print(owner.name + ",");
		System.out.print(owner.age + "\n");
	}
}
