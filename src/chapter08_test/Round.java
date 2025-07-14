package chapter08_test;

public class Round extends Shape {
	String shape = "Round";
	
	public Round(String color,int l1,int l2,int l3)
	{
		super(color,l1,l2,l3);
	}
	
	public void areaPrint()
	{
		System.out.println(color + " " + shape + "area : " + getBupi()*3.14*4/3);
	}
	
}
