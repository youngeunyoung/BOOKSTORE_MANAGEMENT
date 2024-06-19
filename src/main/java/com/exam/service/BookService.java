package com.exam.service;

import java.util.List;

import com.exam.dto.BookDTO;

public interface BookService {

	public List<BookDTO> booksList();
	public BookDTO booksRetrieve(int book_id);
	public List<BookDTO> getBooksBySessionIdPaged(int session_id, int size, int offset);
    int getBooksCountBySessionId(int session_id);
	
}
