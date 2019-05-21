package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.Book;

import java.util.List;

public interface IBookService {
     void addBook();
     List<Book> getListOfBook();
     boolean removeOfBook(Book book);
     Book findOneBook(Long id);
    void updateBook(Book book);

}
