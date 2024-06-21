package com.exam.dto;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

@Alias("CartDTO")
public class CartDTO {

	int cart_num;
	int book_id;
	String member_id;
	int quantity;
	String book_name;
	int book_price;
	String bImage;
	
	public CartDTO() {}

	public CartDTO(int cart_num, int book_id, String member_id, int quantity, String book_name, int book_price,
			String bImage) {
		super();
		this.cart_num = cart_num;
		this.book_id = book_id;
		this.member_id = member_id;
		this.quantity = quantity;
		this.book_name = book_name;
		this.book_price = book_price;
		this.bImage = bImage;
	}

	public int getCart_num() {
		return cart_num;
	}

	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public String getbImage() {
		return bImage;
	}

	public void setbImage(String bImage) {
		this.bImage = bImage;
	}

	@Override
	public String toString() {
		return "CartDTO [cart_num=" + cart_num + ", book_id=" + book_id + ", member_id=" + member_id + ", quantity="
				+ quantity + ", book_name=" + book_name + ", book_price=" + book_price + ", bImage=" + bImage + "]";
	}

	

	
	
	
}
