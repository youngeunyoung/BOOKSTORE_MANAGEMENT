package com.exam.service;

import java.util.List;

import com.exam.dto.BookDTO;

public interface BookService {

	public List<BookDTO> booksList(int page, int size);
	public BookDTO booksRetrieve(int book_id);
	int booksCount();
}
