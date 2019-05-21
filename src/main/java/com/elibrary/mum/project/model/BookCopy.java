package com.elibrary.mum.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOOKCOPIES")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookCopyId;
    private Long bookCopyNumber;

    @ManyToOne()
    @JoinColumn(name = "bookCopyId", nullable = false)
    @NotNull(message = "* BookCopy is required is required")
    private CheckinRecord checkinRecord;

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
