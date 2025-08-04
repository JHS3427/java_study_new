package java_study_21chap_book_shop.model;

public class BookShopBookModel {
	//Field
	String BookId;
	String Title;
	String Author;
	int Price;
	String BigSort;
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getBigSort() {
		return BigSort;
	}
	public void setBigSort(String bigSort) {
		BigSort = bigSort;
	}
	public String getInputDate() {
		return InputDate;
	}
	public void setInputDate(String inputDate) {
		InputDate = inputDate;
	}
	String InputDate;
}
