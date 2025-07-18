package com.bookmgm.model;

public class Book {

	//Field
	//책 등록번호. 도서명. 저자. 가격
	private String id;
	private String name;
	private String author;
	private int price;
	
	//constructor
	
	//method - setter getter
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getAuthor() {return author;}
	public void setAuthor(String author) {this.author = author;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	
}
