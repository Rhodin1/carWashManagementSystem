/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class Invoice implements Serializable {
    private Integer Id;
    private String PlateNo;
    private Integer EmpId;
    private Date Date;
    private String serviceName;
    private double Price;
    private Employees employees;

    public Invoice() {
    }

    public Invoice(Integer Id) {
        this.Id = Id;
    }

    public Invoice(Integer Id, String PlateNo, Integer EmpId, Date Date, String serviceName, double Price, Employees employees) {
        this.Id = Id;
        this.PlateNo = PlateNo;
        this.EmpId = EmpId;
        this.Date = Date;
        this.serviceName = serviceName;
        this.Price = Price;
        this.employees = employees;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getPlateNo() {
        return PlateNo;
    }

    public void setPlateNo(String PlateNo) {
        this.PlateNo = PlateNo;
    }

    public Integer getEmpId() {
        return EmpId;
    }

    public void setEmpId(Integer EmpId) {
        this.EmpId = EmpId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    
    
}
