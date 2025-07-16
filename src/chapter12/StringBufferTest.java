package chapter12;

public class StringBufferTest {

	public static void main(String[] args) {
		String str = "홍길동";
		str = str+"은 자바를";//이렇게 할 때마다 힙에 새로운 공간을 잡고 객체를 만든다. 그래서 공간 문제가 생길수 있었다. 
		str = str+" 열심히 공부합니다.";//근데 요즘은 하드웨어가 좋아져서 크게 문제는 안된다
		System.out.println(str);
		
		StringBuffer sb = new StringBuffer();//아무튼 위 주석같은 문제를 해결하려고 StringBuffer 사용.
		
		sb.append("홍길동");
		sb.append("은 자바를");
		sb.append(" 열심히 공부합니다.");
		
		System.out.println(sb.capacity());
		System.out.println(sb.toString());
		System.out.println(sb);
	}
}
