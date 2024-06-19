package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.exam.dto.BookDTO;

@Mapper
public interface BookMapper {

	public List<BookDTO> booksList(@Param("limit") int limit, @Param("offset") int offset);
	public BookDTO booksRetrieve(int book_id);
	int booksCount();
}
