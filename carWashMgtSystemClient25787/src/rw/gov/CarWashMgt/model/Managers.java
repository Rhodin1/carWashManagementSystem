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
public class Managers implements Serializable {
    private Integer Id;
    private String Name;
    private String PhoneNumber;
    private Users users;

    public Managers() {
    }

    public Managers(Integer Id) {
        this.Id = Id;
    }

    public Managers(Integer Id, String Name, String PhoneNumber, Users users) {
        this.Id = Id;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.users = users;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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

    
    
    
}
