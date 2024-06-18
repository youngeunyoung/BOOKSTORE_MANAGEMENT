package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("BookDTO")
public class BookDTO {

	int book_id;
	String book_name;
	String book_session;
	String book_author;
	String book_publisher;
	String book_price;
	int book_num;
	String bImage;
	
	public BookDTO() {}

	public BookDTO(int book_id, String book_name, String book_session, String book_author, String book_publisher,
			String book_price, int book_num, String bImage) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_session = book_session;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_price = book_price;
		this.book_num = book_num;
		this.bImage = bImage;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_session() {
		return book_session;
	}

	public void setBook_session(String book_session) {
		this.book_session = book_session;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisehr(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public String getBook_price() {
		return book_price;
	}

	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}

	public int getBook_num() {
		return book_num;
	}

	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}

	public String getbImage() {
		return bImage;
	}

	public void setbImage(String bImage) {
		this.bImage = bImage;
	}

	@Override
	public String toString() {
		return "BookDTO [book_id=" + book_id + ", book_name=" + book_name + ", book_session=" + book_session
				+ ", book_author=" + book_author + ", book_publisher=" + book_publisher + ", book_price=" + book_price
				+ ", book_num=" + book_num + ", bImage=" + bImage + "]";
	}

	
}
