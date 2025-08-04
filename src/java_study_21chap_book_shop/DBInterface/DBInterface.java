package java_study_21chap_book_shop.DBInterface;

import java.sql.ResultSet;

public interface DBInterface {

	ResultSet search(String sql,String ID); //- 카트에서만 안쓸듯
	//int insert(String Id);
	void showall(String UserId);
	void change(int Amount,String userId,String bookId);
	void delete(String UserId,String bookId);
	void deleteall(String UserId);
	
}
