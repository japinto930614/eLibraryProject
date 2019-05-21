package com.elibrary.mum.project.model;

import javax.persistence.*;

@Entity
@Table(name = "BOOKCOPIES")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookCopyId;
    private Long bookCopyNumber;


    public int getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(int bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public Long getBookCopyNumber() {
        return bookCopyNumber;
    }
}
