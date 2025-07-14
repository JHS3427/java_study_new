package chapter08_test;

public class Numtest extends AbstractClient implements NewInterface{
	
	double number;
	
	public Numtest(double Nym)
	{
		this.number = Nym;
	}
	public void print()
	{
		
	}
	public void printingInfo()
	{
		System.out.println("number : " + number);
	}
	public double notSqrt(double Num)
	{
		double result = Num*Num;
		System.out.println("number*number = " + result);
		return result;
	}
}
