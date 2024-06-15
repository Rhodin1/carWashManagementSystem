/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class Services implements Serializable {
    private Integer Id;
    private String Name;
    private double Price;
    private Set<Cars> cars;

    public Services() {
    }

    public Services(Integer Id) {
        this.Id = Id;
    }

    public Services(Integer Id, String Name, double Price, Set<Cars> cars) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.cars = cars;
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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Set<Cars> getCars() {
        return cars;
    }

    public void setCars(Set<Cars> cars) {
        this.cars = cars;
    }

       
}
