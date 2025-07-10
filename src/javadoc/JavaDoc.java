package javadoc;


/**
 * 이게 자바독. JaVaDoc 문서를 생ㅅ
 *
 */

public class JavaDoc {
	private String name;
	private int age;
	/**
	 * 문자열 타입의 이름을 반환합니다.
	 * @return name 이름
	 */
	public String getName() {
		return name;
	}
	/**
	 * 문자열 타입의 이름을 받아 멤버변수 name을 초기화합니다.
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 정수 타입의 나이를 받아 멤버변수 age를 초기화합니다.
	 * @param age 나이
	 */
	//문자열타입이 아닌 정수타입의 이름을 
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/** 기본생성자입니다.
	 * 
	 */
	public JavaDoc() {
				
	}
	/**
	 * 문자열 타입의 name의 파라미터를 받아 객체를 생성합니다.
	 * @param name
	 */
	public JavaDoc(String name) {
		
		this.name = name;
	}
	/**
	 * 문자열 타입의 name, 정수형 타입의 age 파라미터를 받아 객체를 생성합니다.
	 * @param name
	 * @param age
	 */
	public JavaDoc(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
