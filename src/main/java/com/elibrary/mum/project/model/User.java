package com.elibrary.mum.project.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private Long userNumber;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private LocalDate registrationDate = LocalDate.now();
    private LocalDate lastOverdueGenerated;

    private double overduefine = 0.0;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CheckOutRecord> checkOutRecords;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CheckinRecord> checkinRecord;

    @ManyToOne()
    @JoinColumn(name = "userTypeId", nullable = false)
    @NotNull(message = "* User is required")
    private UserType userType;

    public List<CheckinRecord> getCheckinRecord() {
        return checkinRecord;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setCheckinRecord(List<CheckinRecord> checkinRecord) {
        this.checkinRecord = checkinRecord;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCheckOutRecords(List<CheckOutRecord> checkOutRecords) {
        this.checkOutRecords = checkOutRecords;
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

    public Long getUserId() {
        return userId;
    }

    public List<CheckOutRecord> getCheckOutRecords() {
        return checkOutRecords;
    }

    public LocalDate getLastOverdueGenerated() {
        return lastOverdueGenerated;
    }

    public void setLastOverdueGenerated(LocalDate lastOverdueGenerated) {
        this.lastOverdueGenerated = lastOverdueGenerated;
    }
}
