package chapter11;

public class SelfErrTest {

	public static void main(String[] args)
	{
		try
		{
			T1();
			System.out.println("1111");
		}
		catch(Exception e)
		{
			System.out.println("12222");
		}
		String num1 = "100";
		String num2 = "200";
		
		int num3 = Integer.valueOf(num1) + Integer.valueOf(num2);
		System.out.println(num3);
		
		String members = "aaa,bbb,ccc";
		String[] mem = members.split(",");
		System.out.println(mem[0]);
		
	}
	public static void T1() throws Exception
	{
		System.out.println("1");
		try {
			try {
				int a = 1/0;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				System.out.println("aaaaa");
			}
		}
		catch(Exception e)
		{
			System.out.println("vvvvvv");
		}
	}
}
