package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookCopyService {
    Book add(Book book);
    List<Book> getAllBooks();
    Optional<Book> findByBookNumber(Long bookNumber);


}
