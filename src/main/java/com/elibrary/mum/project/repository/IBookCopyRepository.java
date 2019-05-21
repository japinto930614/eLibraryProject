package com.elibrary.mum.project.repository;

import com.elibrary.mum.project.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBookCopyRepository extends JpaRepository<BookCopy,Integer> {
}
