package chapter20_JDBC_member;

import java.util.List;

//인터페이스에 상속시켜둠으로 다른사람과 이름의 혼동을 최소화 한다. - 다형성 지키기.

public interface GenericInterface<T> {

	public int delete(int Id);
	public int update(T entity);
	public List<T> listAll();
	public int insert(T entity);
	public T search(int Id);
	//public List<MemberVo> search(String name);-member에서만 쓸 수 있어서 이걸 바꾼다.
	//public List<Object> search(String name); 어디서든 쓰기 위해 object로 선언하고, 나중에 형변환시킴
	//MemberVo member = (MemberVO)obj
	public List<T> search(String name); //-매개변수처럼 T위치에 MemberVo주면 member에서 사용 가능.
}
