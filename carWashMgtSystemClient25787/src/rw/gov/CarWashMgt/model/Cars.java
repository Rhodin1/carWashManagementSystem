/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class Cars implements Serializable {
    private Integer Id;
    private String PlateNo;
    private String CarBrand;
    private Integer MgnYear;
    private String Owner;
    private String FuelType;
    private String TransmissionType;
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
