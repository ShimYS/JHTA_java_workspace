package com.sample.bookstore.vo;

import java.util.Date;

public class Book {
	
	private int no;
	private String title;
	private String writer;
	private String genre;
	private String publisher;
	private int price;
	private int discountPrice;
	private int stock;
	private Date registreredDate;
	private double Point;
	private int Like;
	
	public Book() {}
	
	public double getPoint() {
		return Point;
	}

	public void setPoint(double Point) {
		this.Point = Point;
	}

	public int getLike() {
		return Like;
	}

	public void setLike(int Like) {
		this.Like = Like;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Date getRegistreredDate() {
		return registreredDate;
	}

	public void setRegistreredDate(Date registreredDate) {
		this.registreredDate = registreredDate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
