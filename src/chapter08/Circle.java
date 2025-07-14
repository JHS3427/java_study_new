package chapter08;

public class Circle extends Shape implements ShapeInterface{
	
	int radius;
	public static final double PI = 3.14;
	/*public Circle()
	{
		//this(Shape.red);
	}*/
	public Circle(String color, int radius)
	{	
		super(color);
		//this.color = color;
		this.radius = radius;
	}
	@Override
	public void draw()
	{
		System.out.println(color + "원을 그린다.");
	}
	
	/*@Override
	public double getArea(double radius)
	{
		double result = 0.0;
		this.radius = radius;
		
		result = radius*radius*Math.PI;
		
		return result;
	}*/
	public double getArea() {
		return PI*radius*radius;
	}
}
