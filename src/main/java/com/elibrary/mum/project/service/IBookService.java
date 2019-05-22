package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.Book;

import java.util.List;

public interface IBookService {
     Book addBook(Book book);
     List<Book> getListOfBook();
     void removeBook(Long id);
     Book findOneBook(Long id);


}
