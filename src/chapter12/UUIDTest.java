package chapter12;

import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();//static이라 선언 없이 바로 수행
		System.out.println(uuid);
	}
}
