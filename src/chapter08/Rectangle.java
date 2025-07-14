package chapter08;

public class Rectangle extends Shape implements ShapeInterface{

	int width, height;
	public Rectangle(String color, int width, int height) 
	{
		super(color);
		//this.color = color;
		this.width = width;
		this.height = height;
	}
	@Override
	public void draw()
	{
		System.out.println(color + "사각형을 그린다.");
	}

	@Override
	/*public double getArea(double length)
	{
		double result = 0.0;
		
		result = length*length;
		
		return result;
	}*/
	
	public double getArea()
	{
		return height*width;
	}

}
