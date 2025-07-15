package chapter10;

public class OuterTest {

	public static void main(String[] args) {
		OuterClass Outer = new OuterClass();
		System.out.print(Outer.name);
		
		OuterClass.Inner Inner = new OuterClass.Inner();
		System.out.print( Inner.name);

	}

}
