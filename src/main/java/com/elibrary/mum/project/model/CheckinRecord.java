package com.elibrary.mum.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CheckingRecords")
public class CheckinRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkingRecordId;


    @ManyToOne()
    @JoinColumn(name = "bookCopyId", nullable = false)
    @NotNull(message = "* BookCopy is required is required")
    private BookCopy bookCopy;




    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @NotNull(message = "* User is required")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCheckingRecordId() {
        return checkingRecordId;
    }

    public void setCheckingRecordId(Long checkingRecordId) {
        this.checkingRecordId = checkingRecordId;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
}
