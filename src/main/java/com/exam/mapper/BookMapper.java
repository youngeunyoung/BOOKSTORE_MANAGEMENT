package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.BookDTO;

@Mapper
public interface BookMapper {

	public List<BookDTO> booksList();
	public BookDTO booksRetrieve(int book_id);
}
