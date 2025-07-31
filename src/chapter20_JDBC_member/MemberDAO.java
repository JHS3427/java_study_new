package chapter20_JDBC_member;

import java.util.ArrayList;
import java.util.List;

import db.DbConn;

public class MemberDAO extends DbConn implements GenericInterface<MemberVo>{
	
	public MemberDAO()
	{
		super();
	}
	
	//CRUD 기능 구현 - 애플리케이션 기반의 DB연동은 기본적으로 Autocommit = true임.
	//데이터 추가
	@Override
	public int insert(MemberVo memberVo)
	{//1. return타입 잡기. 2.prepareStatement에 쓸 SQL만들기. 3.
		int rows = 0;
		/*String sql = """
				insert into MEMBER(NAME,EMAIL)
				values (?,?)
				""";
				*/
		String sql = """
				insert into MEMBER(NAME,EMAIL,created_at)
				values (?,?,now())
				""";
		try
		{
			getPreparedStatement(sql);
			pstmt.setString(1, memberVo.getNAME());
			pstmt.setString(2, memberVo.getEMAIL());
			rows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	// 전체 리스트 출력
	@Override
	public List<MemberVo> listAll()
	{
		List<MemberVo> memlist = new ArrayList<MemberVo>();
		String sql = """
				Select member_id,NAME,EMAIL,left(created_at,10)
				from member
				""";
		try
		{
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				MemberVo member = new MemberVo();
				member.setMEMBER_ID(rs.getInt(1));
				member.setNAME(rs.getString(2));
				member.setEMAIL(rs.getString(3));
				member.setCREATED_AT(rs.getString(4));
				memlist.add(member);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return memlist;
	}
	
	//데이터 수정 - 새로 입력할 데이터 받기.
	@Override
	public int update(MemberVo member)
	{
		int rows = 0;
		String sql = """
				update member
				set name = ?,
				email = ?
				where member_id = ?
				""";
		try
		{
			getPreparedStatement(sql);
			pstmt.setString(1, member.getNAME());
			pstmt.setString(2, member.getEMAIL());
			pstmt.setInt(3, member.getMEMBER_ID());
			rows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rows;
	}
	
	//데이터 삭제
	@Override
	public int delete(int memberId)
	{
		int rows = 0;
		String sql = """
				Delete from member
				where member_id =?
				""";
		try
		{
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rows = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	
	//데이터 1개 탐색
	@Override
	public MemberVo search(int memberId)
	{
		MemberVo member = new MemberVo();
		
		String sql = """
				select 
				member_id,
				name, 
				email, 
				created_at 
				from MEMBER
				where MEMBER_ID = ?
				""";
		try
		{
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				member.setMEMBER_ID(rs.getInt(1));
				member.setNAME(rs.getString(2));
				member.setEMAIL(rs.getString(3));
				member.setCREATED_AT(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return member;
	}
	
	// 데이터 1개 탐색,이름 검색.
	@Override
	public List<MemberVo> search(String name)
	{
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
				select 
				member_id,
				name, 
				email, 
				created_at 
				from MEMBER where name = ?
				""";
		try 
		{
			getPreparedStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				MemberVo memberVo = new MemberVo();
				memberVo.setMEMBER_ID(rs.getInt(1));
				memberVo.setNAME(rs.getString(2));
				memberVo.setEMAIL(rs.getString(3));
				memberVo.setCREATED_AT(rs.getString(4));
				
				list.add(memberVo);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
}
