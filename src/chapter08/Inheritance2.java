package chapter08;

public class Inheritance2 {
	
	public static void main(String[] args)
	{
		Circle redC = new Circle("빨강색",10);
		Rectangle yellowR = new Rectangle("노랑색",10,20);
		Triangle greenT = new Triangle("초록색");
		
		redC.draw();
		yellowR.draw();
		greenT.draw();
		
		System.out.println(redC.getArea());
		System.out.println(yellowR.getArea());
		System.out.println(greenT.getArea());
	}
}
