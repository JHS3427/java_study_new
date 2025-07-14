package chapter08_test;

public class Shape {
	String color;
	int width;
	int height;
	int depth;
	
	protected Shape(String color,int len1,int len2,int len3)
	{
		this.color = color;
		this.width = len1;
		this.height = len2;
		this.depth = len3;
	}
	
	public int getBupi()
	{
		int result = width*height*depth;
		return result;		
	}
	
	public void areaPrint() {};
	
}
