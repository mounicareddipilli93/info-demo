package com.infoper.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoper.demo.model.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

}
