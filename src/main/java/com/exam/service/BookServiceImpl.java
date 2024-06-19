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
	public List<BookDTO> booksList(int page, int size) {
		int offset = (page -1) * size;
		return bookMapper.booksList(size,offset);
	}

	@Override
	public BookDTO booksRetrieve(int book_id) {
		return bookMapper.booksRetrieve(book_id);
	}
	
	@Override
	public int booksCount() {
		return bookMapper.booksCount();
	}

}
