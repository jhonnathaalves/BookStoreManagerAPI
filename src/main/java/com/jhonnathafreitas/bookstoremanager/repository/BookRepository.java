package com.jhonnathafreitas.bookstoremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonnathafreitas.bookstoremanager.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{	
	

}
