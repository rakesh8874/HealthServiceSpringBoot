package com.healthcorporation.healthservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String empNumber;
    private String empName;
    private String address;
    private String email;
    private long contactNo;
    private String gender;
    private Date doj;
    private Date dob;
    private String department;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userName")
    private AuthUser authUser;

    public Employee() {

    }

    public Employee(int id, String empNumber, String empName, String address, String email, long contactNo,
                    String gender, Date doj, Date dob, String department, AuthUser authUser) {
        this.id = id;
        this.empNumber = empNumber;
        this.empName = empName;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.gender = gender;
        this.doj = doj;
        this.dob = dob;
        this.department = department;
        this.authUser = authUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }
}
