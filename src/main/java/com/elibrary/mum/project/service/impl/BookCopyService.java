package com.elibrary.mum.project.service.impl;

import com.elibrary.mum.project.model.Book;
import com.elibrary.mum.project.model.BookCopy;
import com.elibrary.mum.project.repository.IBookCopyRepository;
import com.elibrary.mum.project.service.IBookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCopyService implements IBookCopyService {

    @Autowired
    public IBookCopyRepository iBookCopyRepository;
    @Override
    public BookCopy add(BookCopy bookCopy) {
        return iBookCopyRepository.save(bookCopy);
    }

    @Override
    public List<BookCopy> getAllBookCopies() {
        return iBookCopyRepository.findAll(Sort.by("title"));
    }

    @Override
    public Optional<BookCopy> findByBookCopyNumber(int bookCopyNumber) {
        return iBookCopyRepository.findById(bookCopyNumber);
    }
}
