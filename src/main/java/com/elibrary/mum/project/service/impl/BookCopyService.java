package com.elibrary.mum.project.service.impl;

import com.elibrary.mum.project.model.Book;
import com.elibrary.mum.project.model.BookCopy;
import com.elibrary.mum.project.model.CheckOutRecord;
import com.elibrary.mum.project.model.CheckinRecord;
import com.elibrary.mum.project.repository.IBookCopyRepository;
import com.elibrary.mum.project.service.IBookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
        return iBookCopyRepository.findAll(Sort.by("bookCopyNumber"));
    }

    @Override
    public Optional<BookCopy> findByBookCopyNumber(int bookCopyNumber) {
        return iBookCopyRepository.findById(bookCopyNumber);
    }

    public List<BookCopy> getOverdueCopies(){
        List<BookCopy> overdues = new ArrayList<BookCopy>();

        List<BookCopy> bookCopies = getAllBookCopies();

        for(BookCopy bookCopy : bookCopies){
            int size = bookCopy.getCheckOutRecords().size();
            if(size > 0) {
                CheckOutRecord checkOutRecord = bookCopy.getCheckOutRecords().get(size - 1);
                if (checkOutRecord.getOverdueDate().isBefore(LocalDate.now()) ||
                        checkOutRecord.getOverdueDate().isEqual(LocalDate.now())) {
                    overdues.add(bookCopy);
                }
            }
        }

        for(Iterator<BookCopy> it = overdues.iterator(); it.hasNext();) {
            BookCopy s = it.next();
            int size = s.getCheckinRecords().size();
            if(size > 0){
                CheckinRecord checkinRecord = s.getCheckinRecords().get(size - 1);
                if(checkinRecord.getCheckInDate().isBefore(LocalDate.now()) ||
                        checkinRecord.getCheckInDate().isEqual(LocalDate.now())){
                    it.remove();
                }
            }
        }
        return overdues;
    }
}
