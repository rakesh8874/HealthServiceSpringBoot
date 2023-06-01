package com.healthcorporation.healthservice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String email;
    private long contactNo;
    private Date dob;
    @OneToMany(mappedBy = "authUser")
    @JsonManagedReference
    private List<Employee> employee;

    public AuthUser() {
    }

    public AuthUser(int id, String userName, String password, String email, long contactNo, Date dob, List<Employee> employee) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.contactNo = contactNo;
        this.dob = dob;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Employee> getEmployee(){
        return employee;
    }

    public void setEmployee(List<Employee> employee){
        this.employee = employee;
    }

}
