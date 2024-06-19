package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.exam.dto.BookDTO;

@Mapper
public interface BookMapper {

	//public List<BookDTO> booksList(@Param("limit") int limit, @Param("offset") int offset);
	public List<BookDTO> booksList();
	public BookDTO booksRetrieve(int book_id);
	public List<BookDTO> getBooksBySessionIdPaged(@Param("session_id") int session_id,
            @Param("size") int size,
            @Param("offset") int offset);

	int getBooksCountBySessionId(@Param("session_id") int session_id);
}
