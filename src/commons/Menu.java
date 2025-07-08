package commons;

public class Menu {
	//Field
	int no; // 타입 앞에 public 안붙이면 같은 패키지에서만 발동하게됨..
	int price;
	String name;
	
	//Constructor
	public Menu() {	}
	public Menu(int no, String name, int price)
	{
		this.no = no;
		this.name = name;
		this.price = price;
	}
	//Method
	public int getNo() {return no;}
	public String getName() {return name;}
	public int getPrice() {return price;}
	
}
