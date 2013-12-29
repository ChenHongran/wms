package com.wsy.model;
import java.sql.Date;
public class OrderAndGoodsInfo {
	private String ISBN;
	private Date orderdate;
	private String number;
	private String operator;
	private String checkAndAccept;
	private Double zk;
	private String typeId;
	private String goodsname;
	private String producer;
	private String salesman;
	private String company;
	private Date date;
	private Double price;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBookname() {
		return goodsname;
	}
	public void setBookname(String bookname) {
		this.goodsname = bookname;
	}
	public String getCheckAndAccept() {
		return checkAndAccept;
	}
	public void setCheckAndAccept(String checkAndAccept) {
		this.checkAndAccept = checkAndAccept;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String isbn) {
		ISBN = isbn;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getPublisher() {
		return company;
	}
	public void setPublisher(String publisher) {
		this.company = publisher;
	}
	public String getTraslator() {
		return salesman;
	}
	public void setTraslator(String traslator) {
		this.salesman = traslator;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getWriter() {
		return producer;
	}
	public void setWriter(String writer) {
		this.producer = writer;
	}
	public Double getZk() {
		return zk;
	}
	public void setZk(Double zk) {
		this.zk = zk;
	}
	
}
