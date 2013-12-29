package com.wsy.model;

public class Back {
	private String goodsISBN;
	private String goodsname;
	private String operatorId;
	private String borrowDate;
	private String backDate;
	private String salesmanName;
	private String salesmanISBN;
	private int typeId;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
	public String getGoodsISBN() {
		return goodsISBN;
	}
	public void setGoodsISBN(String bookISBN) {
		this.goodsISBN = bookISBN;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getSalesmanISBN() {
		return salesmanISBN;
	}
	public void setSalesmanISBN(String readerISBN) {
		this.salesmanISBN = readerISBN;
	}
	public String getSalesmanName() {
		return salesmanName;
	}
	public void setSalesmanName(String readerName) {
		this.salesmanName = readerName;
	}
}
