package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.Book;
import com.elibrary.mum.project.model.BookCopy;

import java.util.List;
import java.util.Optional;

public interface IBookCopyService {
    Book add(BookCopy bookCopy);
    List<BookCopy> getAllBookCopies();
    Optional<BookCopy> findByBookCopyNumber(int bookCopyNumber);

}
