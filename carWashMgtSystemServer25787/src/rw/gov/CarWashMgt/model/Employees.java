/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ADMIN
 */
@Entity
public class Employees implements Serializable {
    @Id
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="emp_Id")
    private Integer Id;
    @Column(name="first_Name")
    private String FName;
    @Column(name="last_Name")
    private String LName;
    @Column(name="Birth_date")
    private Date BirthDate;
    private String Gender;
    @Column(name="phone_Number")
    private String PhoneNumber;
    @OneToOne
    @JoinColumn(name="usr_Id_fk")
    private Users users;
    @OneToMany(mappedBy="employees")
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
