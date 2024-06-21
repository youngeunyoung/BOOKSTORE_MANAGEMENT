package com.exam.dto;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

@Alias("OrderDTO")
public class OrderDTO {

	int order_id;
	int cart_num;
	String orderName;
	String post;
	String addr1;
	String addr2;
	String phone1;
	String phone2;
	String phone3;
	String email1;
	String email2;
	LocalDate orderDate;
	
	String member_id;
	int book_id;
	int book_name;
	int book_price;
	String bImage;
	int quantity;
	
	int totalPrice;
	
	public OrderDTO() {}


	
	public OrderDTO(int order_id, int cart_num, String orderName, String post, String addr1, String addr2,
			String phone1, String phone2, String phone3, String email1, String email2, LocalDate orderDate,
			String member_id, int book_id, int book_name, int book_price, String bImage, int quantity, int totalPrice) {
		super();
		this.order_id = order_id;
		this.cart_num = cart_num;
		this.orderName = orderName;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.orderDate = orderDate;
		this.member_id = member_id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_price = book_price;
		this.bImage = bImage;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}



	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public int getCart_num() {
		return cart_num;
	}


	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getAddr1() {
		return addr1;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public String getAddr2() {
		return addr2;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getPhone1() {
		return phone1;
	}


	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}


	public String getPhone2() {
		return phone2;
	}


	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


	public String getPhone3() {
		return phone3;
	}


	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}


	public String getEmail1() {
		return email1;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public int getBook_name() {
		return book_name;
	}


	public void setBook_name(int book_name) {
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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	public int getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void initSaleTotal() {
		this.totalPrice = this.book_price * this.quantity;
	}


	@Override
	public String toString() {
		return "OrderDTO [order_id=" + order_id + ", cart_num=" + cart_num + ", orderName=" + orderName + ", post="
				+ post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", phone3=" + phone3 + ", email1=" + email1 + ", email2=" + email2 + ", orderDate=" + orderDate
				+ ", member_id=" + member_id + ", book_id=" + book_id + ", book_name=" + book_name + ", book_price="
				+ book_price + ", bImage=" + bImage + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}



	
	

	
	
}
