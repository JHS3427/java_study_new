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
			sms.showMenu();
			sms.selectMenu();
		}
	}
	public void search() {}
	public void update() {}
	public void delete() {}
	@Override
	public void exit() {
		System.out.println("프로그램 종료");
		System.exit(0);
	}
}
