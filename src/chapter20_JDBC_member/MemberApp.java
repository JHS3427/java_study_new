package chapter20_JDBC_member;

import java.util.List;
import java.util.Scanner;

public class MemberApp {
	Scanner scan = new Scanner(System.in);
	
	public static final int INSERT = 1; 
	public static final int LIST = 2; 
	public static final int UPDATE = 3; 
	public static final int DELETE = 4; 
	public static final int EXIT = 9; 
	MemberDAO memberDAO;
	//생성자
	public MemberApp() {
		memberDAO = new MemberDAO();
		showMenu();
		selectMenu();
		
	}
	
	public void insert() 
	{
		MemberVo member = new MemberVo();
		System.out.println("=> 이름과 이메일을 입력해주세요 <==");
		System.out.println("이름 입력");
		member.setNAME(scan.next());;
		System.out.println("이메일 입력");
		member.setEMAIL(scan.next());

		int result = memberDAO.insert(member);
		if(result==1)
		{
			System.out.println("등록성공");
		}
		else
		{
			System.out.println("등록실패");			
		}
		
		selectMenu();
	}
	public void list()
	{
		List<MemberVo> list = memberDAO.listAll();
		System.out.println("*****************************************");
		System.out.println("아이디 \t 이름 \t 이메일 \t 등록일");
		
		if(list.size() !=0)
		{
			list.forEach((member) -> {
				System.out.print(member.getMEMBER_ID() + " \t");
				System.out.print(member.getNAME() + " \t");
				System.out.print(member.getEMAIL() + " \t");
				System.out.print(member.getCREATED_AT() + " \n");
				
			});
		}
		else
		{
			System.out.println("등록된 데이터가 없습니다");
		}
		showMenu();
		selectMenu();
	}
	public void update()
	{//1. 업데이트 가능 여부 확인 : 
		System.out.println("검색할 ID를 입력하세여");
		MemberVo member = memberDAO.search(scan.nextInt());
		if(member.getMEMBER_ID()!=0)
		{
			//업데이트 데이터 입력.
			System.out.println("=> 이름과 이메일을 입력해주세요 <==");
			System.out.println("이름 입력");
			member.setNAME(scan.next());;
			System.out.println("이메일 입력");
			member.setEMAIL(scan.next());
			
			int result = memberDAO.update(member);//member 객체에 member_id 필수.
			if(result == 1) 
			{
				System.out.println("업데이트 성공");
			}
			else
			{
				System.out.println("업데이트 실패");
			}
		}
		else
		{
			System.out.println("등록된 데이터가 없습니다.")	;		
		}
		
		showMenu();
		selectMenu();
	}
	
	public void delete() 
	{
		System.out.println("삭제할 ID를 입력하세여");
		int result = memberDAO.delete(scan.nextInt());//member 객체에 member_id 필수.
		if(result == 1) 
		{
			System.out.println("삭제 성공");
		}
		else
		{
			System.out.println("삭제 실패");
		}
		showMenu();
		selectMenu();
		
	}
	
	public void exit() {
		System.out.println("프로그램 종료");
		memberDAO.close();
		System.exit(0);
	}
	
	public void selectMenu()
	{
		System.out.println("메뉴 : ");
		int menuNo =scan.nextInt();
		switch(menuNo)
		{
			case INSERT: insert(); break;
			case LIST: list(); break;
			case UPDATE: update(); break;
			case DELETE: delete(); break;
			case EXIT: exit(); break;
		}
		selectMenu();
	}
	public void showMenu()
	{
		System.out.println("**********************************************************************");
		System.out.println("\t 1. 등록");
		System.out.println("\t 2. 조회(전체)");
		System.out.println("\t 3. 수정");
		System.out.println("\t 4. 삭제");
		System.out.println("\t 9. 종료");
		System.out.println("**********************************************************************");
	}
	
}
