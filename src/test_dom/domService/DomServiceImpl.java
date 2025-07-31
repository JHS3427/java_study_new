package test_dom.domService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.scoremgm.model.MemberVo;

import test_dom.domRepo.DomRepository;
import test_dom.domSystem.DomSystem;

public class DomServiceImpl implements DomService{
	Scanner scan;
	DomSystem DSM;
	DomRepository DRP;
	public DomServiceImpl() {}
	public DomServiceImpl(DomSystem DSM)
	{
		this.DSM = DSM;
		this.scan = DSM.scan;
		
	}
	
	public List createMemberInfo() {
		String[] labels = {"학생명","전공","국어","영어","수학"};
		List memberInfo = new ArrayList();

		for(int i=0;i<labels.length;i++) {
			if(i>=2) {
				System.out.print(labels[i] + "> ");
				memberInfo.add(scan.nextInt());
			} else {
				System.out.print(labels[i] + "> ");
				memberInfo.add(scan.next());
			}
		}		
		return memberInfo;
	}
	public void register()
	{
		
		List memberInfo = createMemberInfo();

		MemberVo member = new MemberVo();
//		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(0));
		member.setDepartment((String)memberInfo.get(1));
		member.setKor((int)memberInfo.get(2));
		member.setEng((int)memberInfo.get(3));
		member.setMath((int)memberInfo.get(4));

		if(DRP.insert(member) == 1) {
			System.out.println("=> 등록 완료!! ");
		} else {
			System.out.println("=> 등록 실패!!");
		}
		
		//메뉴호출!!
		DSM.showMenu();
		DSM.selectMenu();
	}
	}
	public void exit() {}
	public void list() {}
	public void search() {}
//	public void update() {}
//	public void delete() {}
	public int getCount() {
		return 0;
	}
}
