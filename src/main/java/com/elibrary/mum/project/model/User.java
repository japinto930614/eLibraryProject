package com.elibrary.mum.project.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class User {
    private Long id;
    private Long userNumber;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private LocalDate registrationDate;
    private double overduefine;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CheckOutRecord> checkOutRecords;


    private CheckinRecord checkinRecord;

    public CheckinRecord getCheckinRecord() {
        return checkinRecord;
    }

    public void setCheckinRecord(CheckinRecord checkinRecord) {
        this.checkinRecord = checkinRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getOverduefine() {
        return overduefine;
    }

    public void setOverduefine(double overduefine) {
        this.overduefine = overduefine;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }
}
