/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.gov.CarWashMgt.model.Cars;

/**
 *
 * @author ADMIN
 */
public interface CarsService extends Remote {
    Cars saveCars(Cars thecars) throws RemoteException;
    Cars updateCars(Cars thecars) throws RemoteException;
    Cars deleteCars(Cars thecars) throws RemoteException;
    Cars searchCars(Cars thecars) throws RemoteException;
    List<Cars> findAll() throws RemoteException;
}
