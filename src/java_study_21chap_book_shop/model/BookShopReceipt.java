package java_study_21chap_book_shop.model;

public class BookShopReceipt {
	int BuyingIdx;
	String UserId;
	String BookId;
	int Amount;
	int AmountPriceSum;
	String BuyingDate;
	String UserAddress;
	
	public int getBuyingIdx() {
		return BuyingIdx;
	}
	public void setBuyingIdx(int buyingIdx) {
		BuyingIdx = buyingIdx;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getAmountPriceSum() {
		return AmountPriceSum;
	}
	public void setAmountPriceSum(int amountPriceSum) {
		AmountPriceSum = amountPriceSum;
	}
	public String getBuyingDate() {
		return BuyingDate;
	}
	public void setBuyingDate(String buyingDate) {
		BuyingDate = buyingDate;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	
}
