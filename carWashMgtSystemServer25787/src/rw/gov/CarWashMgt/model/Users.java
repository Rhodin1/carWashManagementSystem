/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author ADMIN
 */
@Entity
public class Users implements Serializable {
    @Id
    
    
    @Column(name="User_Id")
    private Integer Id;
    @Column(name="Full_Name")
    private String Names;
    @Column(name="UserName")
    private String userName;
    private String Password;
    @OneToOne(mappedBy = "users")
    private Employees employees;
    @OneToOne
    @JoinColumn(name = "manager_id_fk")
    private Managers manager;

    public Users() {
    }

    public Users(Integer Id) {
        this.Id = Id;
    }

    public Users(Integer Id, String Names, String userName, String Password, Employees employees, Managers manager) {
        this.Id = Id;
        this.Names = Names;
        this.userName = userName;
        this.Password = Password;
        this.employees = employees;
        this.manager = manager;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String Names) {
        this.Names = Names;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Managers getManager() {
        return manager;
    }

    public void setManager(Managers manager) {
        this.manager = manager;
    }

    
}
