package chapter07;

public class AnimalAccessModifier {
	
	
	//Field
	
	String name; //같은 패키지에서만 접근 가능
	int age; //같은 패키지에서만 접근 가능
	static String sname; // 스태틱은 스태틱 영역에서 생성됨.
	static int sage; //
	
	final String fname = "홍길동";//final 키워드 적용 -> 외부에서 값을 변경할 수 없음
	final int fage = 10;
	

	public static final int START = 0;
	public static final int COUNTINUE = 1;
	public static final int END = -1;
	
	
	private String pname; // 같은 클래스 내부에서만 접근 가능
	private int page; // 같은 클래스 내부에서만 접근 가능
	
	//Constructor
	void getInfo() {System.out.println(pname+","+page);}
	public void getInfo2() {System.out.println(pname+","+page);}
	public static void getInfo3() {System.out.println(sname+","+sage);}
	
	
	public AnimalAccessModifier() {
		
	}
	public AnimalAccessModifier(String pname,int page) {
		this.pname = pname;
		this.page = page;
	}
	
	//Method
	//getter setter 메소드 - 중요한 데이터지만 접근 제한이 필요한 데이터를 주거나 받을때 사용.
	public String getPname() {return pname;} //중요 데이터를 다른 클레스로 넘기는 getter
	public int getPage() {return page;}
	
	public void setPname(String pname) {this.pname = pname;}
	public void setPage(int page) {this.page = page;}
}
