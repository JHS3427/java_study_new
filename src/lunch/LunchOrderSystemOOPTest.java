package lunch;

public class LunchOrderSystemOOPTest {

	public static void main(String[] args) {
		//LunchOrderSystemOOP system = new LunchOrderSystemOOP();// "="앞쪽도 생략 가능(생성자에 메인함수가 들어있기 때문이다.)
		//system.title = "더조은";
		//system.showMainMenu();
		
		//생성자를 통해 객체 초기화 후 실행 메소드를 호출하는 경우
		new LunchOrderSystemOOP("행복");
	}
}