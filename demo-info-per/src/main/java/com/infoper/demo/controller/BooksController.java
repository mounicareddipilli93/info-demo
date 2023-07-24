package com.infoper.demo.controller;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infoper.demo.model.Books;
import com.infoper.demo.repo.BooksRepository;

@RestController
public class BooksController {
	@Autowired
	BooksRepository booksRepo;
	
	@GetMapping("/getbooks")
	public List<Books> getBooks() {
		return booksRepo.findAll();
	}
	
	@PostMapping("/postbooks")
	public void postBooks(@RequestBody Books book) {
		booksRepo.save(book);
	}
	
	@PutMapping("/updatebooks")
	public void updateBooks(Books book) {
		
		Optional<Books> bookobj = booksRepo.findById(book.getBookid());
		if(bookobj.isPresent()) {
			Books saveBook = bookobj.get();
			saveBook.setAuthor(book.getAuthor());
			saveBook.setBookname(book.getBookname());
			saveBook.setPrice(book.getPrice());

			booksRepo.save(saveBook);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBooks(@PathVariable("id") int id) {
		booksRepo.deleteById(id);
	}
}
