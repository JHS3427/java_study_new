package chapter08_test;

public class Inheritance {

	public static void main(String[] args) {
		Person h1 = new Person("강동",10,"02-123-4567","강남구");
		Animal a1 = new Animal("코끼리",300,h1);
		
		h1.printInfo();
		a1.printInfo();
		
		AbstractAnimal AA = new AbstractAnimal("이무기",1000,"박무기");
		AbstractPerson AP = new AbstractPerson("박수무",40,"010-9999-9999","우리집");
		AA.print();
		AP.print();
		
		Numtest num = new Numtest(1.1);
		num.notSqrt(1.5);
		
		Round Round = new Round("Black",5,5,5);
		Round.areaPrint();
	}

}
