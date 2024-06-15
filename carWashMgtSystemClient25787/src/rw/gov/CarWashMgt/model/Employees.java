/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Employees implements Serializable {
    private Integer Id;
    private String FName;
    private String LName;
    private Date BirthDate;
    private String Gender;
    private String PhoneNumber;
    private Users users;
    private List<Invoice> invoices;

    public Employees() {
    }

    public Employees(Integer Id) {
        this.Id = Id;
    }

    public Employees(Integer Id, String FName, String LName, Date BirthDate, String Gender, String PhoneNumber, Users users, List<Invoice> invoices) {
        this.Id = Id;
        this.FName = FName;
        this.LName = LName;
        this.BirthDate = BirthDate;
        this.Gender = Gender;
        this.PhoneNumber = PhoneNumber;
        this.users = users;
        this.invoices = invoices;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    
}
