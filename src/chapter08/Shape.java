package chapter08;

//abstract public class Shape {
//	
//	public static String red = "red";
//	public static String blue = "blue";
//	public static String yellow = "yellow";
//	public static String green = "green";
//	public static String orange = "orange";
//	
//	abstract public void draw();
//}위는 내코드, 아래는 강사님 코드.

public class Shape{
	String color;
	
	protected Shape(String color)//상속받은 클래스만 사용가능
	{
		this.color = color;
	}
	//abstract public double getArea(double length); 내가 만들어본거

}