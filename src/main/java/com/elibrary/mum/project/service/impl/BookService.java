package com.elibrary.mum.project.service.impl;

import com.elibrary.mum.project.model.Book;
import com.elibrary.mum.project.repository.IBookRepository;
import com.elibrary.mum.project.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    public IBookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getListOfBook() {
        return bookRepository.findAll(Sort.by("title"));
    }

    @Override
    public void removeBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findOneBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
