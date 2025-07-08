package chapter07;

public class Animal2 {
	//Field
	String name;
	int age;
	//Constructor 
	public Animal2() {
		System.out.println("객체 생성");		
	}
	public Animal2(String name) {
		this.name = name;
		System.out.println("객체 생성");
	}
	public Animal2(String name,int age) {
		this.name = name;
		this.age = age;
		System.out.println("객체 생성");
	}
	
	
}
