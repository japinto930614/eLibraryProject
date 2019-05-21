package com.elibrary.mum.project.model;

import javax.persistence.*;

@Entity
@Table(name = "CkeckingRecords")
public class CkeckingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int checkingRecordId;
    @OneToMany
    private BookCopy copy;
    @OneToMany
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCheckingRecordId() {
        return checkingRecordId;
    }

    public void setCheckingRecordId(int checkingRecordId) {
        this.checkingRecordId = checkingRecordId;
    }

    public BookCopy getCopy() {
        return copy;
    }

    public void setCopy(BookCopy copy) {
        this.copy = copy;
    }
}
