package com.elibrary.mum.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CkeckingRecords")
public class CheckinRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int checkingRecordId;

    @OneToMany(mappedBy = "checkinRecord", cascade = CascadeType.ALL)
    private List<BookCopy> bookCopies;


    @OneToMany(mappedBy = "checkinRecord", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @NotNull(message = "* User is required")
    private User user;



    public int getCheckingRecordId() {
        return checkingRecordId;
    }

    public void setCheckingRecordId(int checkingRecordId) {
        this.checkingRecordId = checkingRecordId;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
