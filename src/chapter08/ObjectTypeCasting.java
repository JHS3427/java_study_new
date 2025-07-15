package chapter08;

public class ObjectTypeCasting {

	public static void main(String[] args) {
		Circle yellowC = new Circle("노랑",1);
		Rectangle blueR = new Rectangle("파랑",1,2);
		
		Shape s = new Circle("초록색",100);//자동 형 변환
		//현재 Circle은 Shape를 포함하고 있기 때문에 S는 circle 내의 shape 으로 선언된 부분만 접근이 가능하다.
		
		yellowC.draw();
		blueR.draw();
		//s.draw(); Shape 클래스는 draw()메소드 없음. 따라서 해당 안된다.
		//Rectangle = new Cicle("초록",1000)에러. 얘는 안됨.
		//s.color("기린"); 
		//S가 가지는 영역은 Circle만큼 갖는다. 단. Shape이 커버 못치는데는 못채움
		
		Circle cs = (Circle)s;//부모에서 자식클래스로 확장하는 "강제(명시적) 형변환"
		//Rectangle r = (Rectangle) s; //이거 안됨. Circle 타입으로 만들어 둔 상태에서 Rectangle로 변경 불가.
		//생성된 같은 모습의 자식만 가능.
		Shape s2 = new Shape("빨강");
		//Circle cs2 = (Circle)s2;//"강제(명시적) 형변환"-이거 안됨
		//S2(shape)는 Circle 보다 작음(없는 항목이 존재), 그런데 그걸 Circle로 강제로 늘리려고 하면 없는 부분이 생겨서
		//JVM이 만들지 못함. 따라서 에러 발생.
		
		
		//인터페이스를 통해 자식의 모습으로 객체를 구현하는 것을 권장함!!!.
		ShapeInterface si = new Circle("코랄",1);
		si.draw(); // 자식인 circle의 draw가 호출됨.
		System.out.println(si.getArea());
		Circle cs3 = (Circle) si;
		cs3.draw();
		System.out.println(cs3.getArea());
		
		//부모와 자식 클래스를 만들기 > 자식들이 공통으로 쓰는 메소드 뽑아서 부모에 넣기 > 그 메소드들 다시 인터페이스로 묶기
		// >>그렇게 묶은 인터페이스를 상속 받아 오버라이딩
		//상속받은 인터페이스를 통한 객체 생성 : 인터페이스 기반의 설계!!!
		//사각형과 삼각형 해보기
		
		ShapeInterface si2 = new Rectangle("흰색",1,5);
		ShapeInterface si3 = new Triangle("흰색");
	//	(추상 메소드 모음)		+	  (상속받아 오버라이딩) - 객체 지향의 다형성을 구현(코드화)함
		si2.draw();
		si3.draw();
		System.out.println(si2.getArea());
		System.out.println(si3.getArea());		
		
		
		cs.draw();
		//cs2.draw();
		
		//반드시 부모의 모습으로 선언하고 자식의 모습으로 할당한다 : (부모클래스) 이름 = new (자식클래스)(변수); 
		
		
	}

}
