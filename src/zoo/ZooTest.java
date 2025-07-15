package zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooTest {

	public static void main(String[] args) {
//		Tiger tiger = new Tiger();
//		Lion lion = new Lion();
//		lion.sleep();
//		lion.eat();
//		
//		AnimalInterface lion2 = new Lion("심바아빠",12);
//		lion2.eat();
		
		
		//여긴 라이온 만 들어감
		List<Lion> list = new ArrayList<Lion>();
		//여긴 AnimalInterface를 상속받는 라이온, 타이거가 들어갈 수 있음
		List<AnimalInterface> list2 = new ArrayList<AnimalInterface>();
		Lion lion1 = new Lion();
		list.add(lion1);
		Tiger tiger1 = new Tiger();
		//list.add(tiger1); 이건 못들어감. list는 lion만 들어감
		list2.add(lion1);
		list2.add(tiger1);//list2는 AnimalInterface라서
		//묵시적 형변환으로 인하여 둘다 들어가기 가능.
		list.get(0).sleep();
		list2.get(0).sleep();
		list2.get(1).sleep();
		System.out.println(list2.get(0).getName());
		System.out.println(list2.get(1).getName());
		
		
		Lion lion2 = (Lion)list2.get(0);//객체의 저장된 속성(값)은 강제(명시적) 형변환을 통해 진행.
		System.out.println("Lion2.name ==" + lion2.name);
	}
}
