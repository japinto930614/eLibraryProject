package com.elibrary.mum.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOKCOPIES")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookCopyId;
    private int bookCopyNumber;

    @ManyToOne()
    @JoinColumn(name = "bookId", nullable = false)
    @NotNull(message = "* BookCopyId is required")
    private Book book;

    @OneToMany(mappedBy = "bookCopy", cascade = CascadeType.ALL)
    private List<CheckinRecord> checkinRecords = new ArrayList<>();

    @OneToMany(mappedBy = "bookCopy", cascade = CascadeType.ALL)
    private List<CheckOutRecord> checkOutRecords = new ArrayList<>();

    public int getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(int bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public List<CheckOutRecord> getCheckOutRecords() {
        return checkOutRecords;
    }

    public void setCheckOutRecords(List<CheckOutRecord> checkOutRecords) {
        this.checkOutRecords = checkOutRecords;
    }

    public int getBookCopyNumber() {
        return bookCopyNumber;
    }

    public void setBookCopyNumber(int bookCopyNumber) {
        this.bookCopyNumber = bookCopyNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<CheckinRecord> getCheckinRecords() {
        return checkinRecords;
    }

    public void setCheckinRecords(List<CheckinRecord> checkinRecords) {
        this.checkinRecords = checkinRecords;
    }
}
