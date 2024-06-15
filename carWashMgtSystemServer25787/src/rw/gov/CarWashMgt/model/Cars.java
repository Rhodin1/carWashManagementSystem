/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author ADMIN
 */
@Entity
public class Cars implements Serializable {
    @Id
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="car_Id")
    private Integer Id;
    @Column(name="car_plate_no")
    private String PlateNo;
    @Column(name="car_Brand")
    private String CarBrand;
    @Column(name="Mgn_Year")
    private Integer MgnYear;
    private String Owner;
    @Column(name="Fuel_Type")
    private String FuelType;
    @Column(name="Trans_Type")
    private String TransmissionType;
    @ManyToMany
    @JoinTable(
            name = "car_recieved_service",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "serv_id")
    )
    private Set<Services> services;

    public Cars() {
    }

    public Cars(Integer Id) {
        this.Id = Id;
    }

    public Cars(Integer Id, String PlateNo, String CarBrand, Integer MgnYear, String Owner, String FuelType, String TransmissionType, Set<Services> services) {
        this.Id = Id;
        this.PlateNo = PlateNo;
        this.CarBrand = CarBrand;
        this.MgnYear = MgnYear;
        this.Owner = Owner;
        this.FuelType = FuelType;
        this.TransmissionType = TransmissionType;
        this.services = services;
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

    public String getCarBrand() {
        return CarBrand;
    }

    public void setCarBrand(String CarBrand) {
        this.CarBrand = CarBrand;
    }

    public Integer getMgnYear() {
        return MgnYear;
    }

    public void setMgnYear(Integer MgnYear) {
        this.MgnYear = MgnYear;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String FuelType) {
        this.FuelType = FuelType;
    }

    public String getTransmissionType() {
        return TransmissionType;
    }

    public void setTransmissionType(String TransmissionType) {
        this.TransmissionType = TransmissionType;
    }

    public Set<Services> getServices() {
        return services;
    }

    public void setServices(Set<Services> services) {
        this.services = services;
    }

    
}
