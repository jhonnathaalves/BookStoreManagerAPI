package com.jhonnathafreitas.bookstoremanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonnathafreitas.bookstoremanager.dto.BookDTO;
import com.jhonnathafreitas.bookstoremanager.dto.MessageResponseDTO;
import com.jhonnathafreitas.bookstoremanager.entity.Book;
import com.jhonnathafreitas.bookstoremanager.exception.BookNotFoundException;
import com.jhonnathafreitas.bookstoremanager.mapper.BookMapper;
import com.jhonnathafreitas.bookstoremanager.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}
