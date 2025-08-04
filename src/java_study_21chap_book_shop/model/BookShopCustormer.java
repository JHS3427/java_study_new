package java_study_21chap_book_shop.model;

public class BookShopCustormer {
	//Field
	String UserId; //PK
	String UserPw;
	String UserName;
	String UserAddress;
	String Phone;
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserPw() {
		return UserPw;
	}
	public void setUserPw(String userPw) {
		UserPw = userPw;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
}
