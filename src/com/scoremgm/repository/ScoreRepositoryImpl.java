package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository {

	List<Member> storage = new ArrayList<Member>();
	
	@Override
	public int getCount() {
		return storage.size();
	}
	
	@Override
	public boolean insert(Member member) {
		if(member == null)
		{return false;}
		
		return storage.add(member);	
	}
	@Override
	public List<Member> findAll()
	{
		return storage;
	}
	
	@Override
	public Member find(String no)
	{
		Member member = null;
		no = "2025-"+no;
		if(no != null)
		{
			for (Member m : storage)
			{
				if(m.getNo().equals(no))
				{
					member= m;
				}
			}
			//외부에서 생성된 member 변수의 scope Iterable 관리
			/*forEach의 경우 메소드 취급이라서 메소드 새로부르면 스택 밀림. 그에따라
			*앞에서 선언한 member 변수가 사라져 버리고, 이에따라 member=m;에서 에러가 발생함.
			*
			* 강사님 설명 : forEach의 경우 메소드 호출이므로 스택에 새로운 블록으로 생성되어 실행됨.
			* 이에따라 전에 실행중이던 find 메소드를 일시 중지하고 실행 주도권이 forEach로 넘어옴.
			* 이에 따라 find의 member 변수는 삭제됨. 따라서 member=m;에 접근이 안됨. 이는 자바스크립트에서도 마찬가지.
			*/
//			storage.forEach(m ->
//			{
//				if(m.getNo().equals(no))
//				{
//					member = m;
//				}
//			});
		}
		else
		{
			
		}
		return member;
		//아래는 내방식
//		for (Member m : storage)
//		{
//			if(m.getNo().equals(no))
//			{
//				return m;
//			}
//		}
//		return null;
	}
	
	@Override
	public void update(Member member)
	{
		int idx= -1;
		for (int i = 0 ; i < storage.size();i++)
		{
			Member m = storage.get(i);
			if(m.getNo().equals(member.getNo()))
			{
				idx = i;
				break;
			}
		}
		storage.set(idx, member);
	}
	
	@Override
	public void remove(String no)
	{
//		내가 한 방식
//		Iterator<Member> ie = storage.iterator();
//		while(ie.hasNext())
//		{
//			Member n1 = ie.next();
//			if(n1.getNo().equals(no))
//			{
//				ie.remove();
//			}
//		}
		//강사님 방식
		//iterator은 storage 안에 있는걸 순서대로 꺼냈다가(인덱스 기억) 처리할거 하고 인덱스대로 다시 넣는거다.
		//따라서 다른 변수로 만드는게 아니라 storage를 건드는 셈이다.
		Iterator<Member> ie = storage.iterator();
		while(ie.hasNext())
		{
			Member member = ie.next();
			if(member.getNo().equals("2025-"+no))
			{
				ie.remove();
				break;
			}
		}
	}
}
