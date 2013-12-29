package com.wsy.model;

public class Borrow {
	private int id;
	private String goodsISBN;
	private String salesmanISBN;
	private String num;
	private String borrowDate;
	private String backDate;
	private String goodsName;
	public String getBookName() {
		return goodsName;
	}
	public void setBookName(String bookName) {
		this.goodsName = bookName;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
	public String getBookISBN() {
		return goodsISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.goodsISBN = bookISBN;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getReaderISBN() {
		return salesmanISBN;
	}
	public void setReaderISBN(String readerISBN) {
		this.salesmanISBN = readerISBN;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
