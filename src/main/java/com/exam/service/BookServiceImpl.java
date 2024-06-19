package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.BookDTO;
import com.exam.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService{

	BookMapper bookMapper;
	
	public BookServiceImpl(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@Override
    public List<BookDTO> booksList() {
        return bookMapper.booksList();
    }

	@Override
	public BookDTO booksRetrieve(int book_id) {
		return bookMapper.booksRetrieve(book_id);
	}
	
	 @Override
	    public List<BookDTO> getBooksBySessionIdPaged(int session_id, int size, int offset) {
	        return bookMapper.getBooksBySessionIdPaged(session_id, size, offset);
	    }

	    @Override
	    public int getBooksCountBySessionId(int session_id) {
	        return bookMapper.getBooksCountBySessionId(session_id);
	    }

}
