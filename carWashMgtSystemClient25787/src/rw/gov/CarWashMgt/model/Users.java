/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.model;

import java.io.Serializable;
/**
 *
 * @author ADMIN
 */
public class Users implements Serializable {
    private Integer Id;
    private String Names;
    private String userName;
    private String Password;
    private Employees employees;
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
