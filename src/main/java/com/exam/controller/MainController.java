package com.exam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.BookDTO;
import com.exam.service.BookService;

@Controller
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	BookService bookService;
	
	public MainController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/main")
    public String main(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "6") int size,
                       @RequestParam(defaultValue = "1") int session_id,
                       ModelMap m) {
		
		
		int offset = (page - 1) * size;
		List<BookDTO> booksList = bookService.getBooksBySessionIdPaged(session_id, size, offset);
        int totalBooks = bookService.getBooksCountBySessionId(session_id);
        int totalPages = (int) Math.ceil((double) totalBooks / size);

        m.addAttribute("booksList", booksList);
        m.addAttribute("currentPage", page);
        m.addAttribute("totalPages", totalPages);
        m.addAttribute("pageSize", size);
        m.addAttribute("session_id", session_id);
        return "main";
    }

	/*@GetMapping("/main")
	public String main(@RequestParam(required = false, defaultValue = "2") int session_id,
			           ModelMap m) {
		
		List<BookDTO> booksList = bookService.booksList();
		m.addAttribute("booksList", booksList);
		return "main";
	}*/
}
