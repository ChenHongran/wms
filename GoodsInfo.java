package com.wsy.model;

import java.sql.Date;

public class GoodsInfo {
	private String ISBN;
	private String typeid;
	private String producer;
	private String salesman;
	private String company;
	private Date date;
	private Double price;
	private String goodsname;

	public String getGoodsname() {
		return goodsname;
	}
	public void setBookname(String bookname) {
		this.goodsname = bookname;
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

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPublisher() {
		return company;
	}
	public void setPublisher(String publisher) {
		this.company = publisher;
	}
	public String getTranslator() {
		return salesman;
	}
	public void setTranslator(String translator) {
		this.salesman = translator;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getWriter() {
		return producer;
	}
	public void setWriter(String writer) {
		this.producer = writer;
	}
}
