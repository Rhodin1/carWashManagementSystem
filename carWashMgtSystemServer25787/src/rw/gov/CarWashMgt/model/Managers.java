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
public class Managers implements Serializable {
    @Id
    
    
    @Column(name="manager_Id")
    private Integer Id;
    @Column(name="manger_full_Name")
    private String Name;
    private String PhoneNumber;
    @OneToOne(mappedBy = "manager")
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
