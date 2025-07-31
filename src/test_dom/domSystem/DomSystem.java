package test_dom.domSystem;

import java.util.Scanner;

import test_dom.domService.DomService;
import test_dom.domService.DomServiceImpl;

public class DomSystem {
	public Scanner scan;
	DomService DS;
	public static final int REGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;
	
	public DomSystem()
	{
		scan = new Scanner(System.in);
		DS = new DomServiceImpl(this);
		showMenu();
		selectMenu();
	}
	
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴(숫자)> ");
		if(scan.hasNextInt()) {
			
			switch(scan.nextInt()) {
				case REGISTER:	DS.register();		break;
				case LIST:		DS.list();			break;
				case SEARCH: 	DS.search();		break;
//				case UPDATE:	DS.update();		break;
//				case DELETE:	DS.delete();		break;
				case EXIT:		DS.exit();			break;
				default:	
					System.out.println("=> 메뉴 준비중 입니다.");
			}			
			
		} else {
			System.out.println("🚫 올바르지 않은 형식입니다. 다시 선택해주세요");
			scan.next();
			selectMenu();
		}
	}	
	
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		System.out.println("======= 학생 성적 관리 시스템 =======");
		System.out.println("전체 학생수 : " + DS.getCount());
		System.out.println("-------------------------------------------------");
		System.out.println("1. 등록");
		System.out.println("2. 조회");
		System.out.println("3. 검색");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("6. 종료");
		System.out.println("-------------------------------------------------");
	}
}
