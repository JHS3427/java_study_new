package com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.app.ScoreMgmSystem;
import com.scoremgm.model.Member;
import com.scoremgm.repository.ScoreRepository;
import com.scoremgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService {

	Scanner scan;
	ScoreMgmSystem sms;
	ScoreRepository repository = new ScoreRepositoryImpl();
	
	public ScoreServiceImpl(){}
	
	public ScoreServiceImpl(ScoreMgmSystem sms)//받았던 주소를 전역변수로 확대해서 클래스 어디에서든 사용.
	{
		this.sms = sms;
		this.scan = sms.scan;
	}

	/**
	 * 학생정보 임시저장 객체 생성
	 * @return List
	 */
	public List createMemberInfo()
	{	
		String[] labels = {"학생명","전공","국어","영어","수학"};
		List memberInfo = new ArrayList();
		Random rd = new Random();
		String no = "2025-"+rd.nextInt(1000,9999);//학번 생성
		memberInfo.add(no);
		for(int i = 0 ; i<labels.length;i++)
		{
			if(i>=2)
			{
				System.out.println(labels[i] + "> ");
				memberInfo.add(scan.nextInt());				
			}
			else
			{
				//i = 0 또는 i =1 일때
				System.out.println(labels[i] + "> ");
				memberInfo.add(scan.next());
			}
		}
		return memberInfo;
	}
	
	/**
	 * 학생정보 임시저장 객체 생성2 : update용(수정용)
	 * @param no 학번
	 * @return List
	 */
	public List createMemberInfo(Member member)
	{	
		String[] labels = {"국어","영어","수학"};
		List memberInfo = new ArrayList();
		
		System.out.println("학번 : " + member.getNo() + " , "+"이름" + member.getName());
		
		for(int i = 0 ; i<labels.length;i++)
		{
				System.out.println(labels[i] + "> ");
				memberInfo.add(scan.nextInt());				
		}
		return memberInfo;
	}
	
	/**
	 * 학생정보 저장소(Storage)의 갯수 가져오기
	 */
	public int getCount()
	{
		return repository.getCount();
	}
	
	/** 
	 * 학생 등록
	 */
	@Override
	public void register()
	{
		List memberInfo = createMemberInfo();
		//memberInfo.forEach(System.out::println);
		
		//멤버 생성
		Member member = new Member();
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));//기본 데이터 타입을 넣어도 Integer 바꿔서 넣어준다.
		member.setEng((Integer)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
		
		//저장소 등록을 위한 Repository 호출
		if(repository.insert(member))
		{
			//성공
			System.out.println("=>등록 완료!" + getCount());
		}
		else
		{
			System.out.println("=>등록 실패!");			
		}
		//메인 메뉴 호출!!
		sms.showMenu();
		sms.selectMenu();
	}
	@Override
	public void list() {
		List<Member> list = repository.findAll(); 
		if(getCount() !=0)
		{
			System.out.print("학번" + "\t \t");
			System.out.print("이름" + "\t");
			System.out.print("학과" + "\t");
			System.out.print("국어" + "\t");
			System.out.print("영어" + "\t");
			System.out.print("수학" + "\n");
			list.forEach((member)->
			{
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			});
	//		for(Member member : list)
	//		{
	//			System.out.print(member.getNo() + "\t");
	//			System.out.print(member.getName() + "\t");
	//			System.out.print(member.getDepartment() + "\t");
	//			System.out.print(member.getKor() + "\t");
	//			System.out.print(member.getEng() + "\t");
	//			System.out.print(member.getMath() + "\n");
	//		}
		}
		else
		{
			System.out.println("등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	
	/** 
	 * 검색 : 학번 기준
	 */
	@Override
	public void search() 
	{
		if(getCount() !=0)
		{
			System.out.print("학번 뒷 4자리만 입력> ");
			String no = scan.next();
			Member member = repository.find(no);
			if(member != null)
			{
				System.out.print("검색결과 = > \n");
				System.out.print("학번" + "\t \t");
				System.out.print("이름" + "\t");
				System.out.print("학과" + "\t");
				System.out.print("국어" + "\t");
				System.out.print("영어" + "\t");
				System.out.print("수학" + "\n");
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			}
			else
			{
				System.out.println("검색한 학생 정보 없음");
				
			}
		}
		else
		{
			System.out.println("등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	public void update()
	{
		if(getCount() !=0)
		{
			System.out.print("학번 뒷 4자리만 입력> ");
			String no = scan.next();
			Member member = repository.find(no); // 학생의 기존 정보(수정 전 정보)
			if(member != null)
			{
				//수정할 학생의 정보 입력 - 학번 제외
				List memberInfo = createMemberInfo(member);
				member.setKor((int)memberInfo.get(0));
				member.setEng((int)memberInfo.get(1));
				member.setMath((int)memberInfo.get(2));
				
				//레포지토리의 Storage에 member 업데이트 호출
				repository.update(member);
				
				System.out.print("수정결과 = > \n");
				System.out.print("학번" + "\t \t");
				System.out.print("이름" + "\t");
				System.out.print("학과" + "\t");
				System.out.print("국어" + "\t");
				System.out.print("영어" + "\t");
				System.out.print("수학" + "\n");
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			}
			else
			{
				System.out.println("검색한 학생 정보 없음");
				
			}
		}
		else
		{
			System.out.println("등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();	
	}
	
	/**
	 * 삭제
	 */
	@Override
	public void delete()
	{
		if(getCount() !=0)
		{
			System.out.print("학번 뒷 4자리만 입력> ");
			String no = scan.next();
			Member member = repository.find(no); // 학생의 기존 정보(수정 전 정보)
			if(member != null)
			{
				//삭제 여부 재확인
				System.out.println("정말로 삭제하시겠습니까?(y : 삭제 / 그외 : 삭제 취소)");
				if(scan.next().equals("y"))
				{
					//이후 레포지토리에서 삭제 명령어 진행
					repository.remove(no);
					System.out.println("삭제 완료");
				}
			}
			else
			{
				System.out.println("검색한 학생 정보 없음");
			}
		}
		else
		{
			System.out.println("등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
		
	}
	
	@Override
	public void exit() {
		System.out.println("프로그램 종료");
		System.exit(0);
	}
}
