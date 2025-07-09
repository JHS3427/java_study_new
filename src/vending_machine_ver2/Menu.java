package vending_machine_ver2;

public class Menu {
	//Field
	int no;
	int price;
	String name;
	
	//Constructor
	public Menu()
	{
		//this(1,2,"홍"); - 자기자신 부르는방법
	}
	public Menu(int no, int price, String name)
	{
		this.no = no;
		this.price = price;
		this.name = name;
	}
	//Method
	
	public int getNo() {return no;}
	public int getPrice() {return price;}
	public String getName() {return name;}
}
