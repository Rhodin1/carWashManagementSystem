/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.gov.CarWashMgt.dao.CarsDao;
import rw.gov.CarWashMgt.model.Cars;
import rw.gov.CarWashMgt.service.CarsService;

/**
 *
 * @author ADMIN
 */
public class CarsServiceImpl extends UnicastRemoteObject implements CarsService{
    public CarsServiceImpl() throws RemoteException{
    
    }
    private CarsDao dao = new CarsDao();
    
    @Override
    public Cars saveCars(Cars thecars) throws RemoteException {
        return dao.registerCar(thecars);
    }

    @Override
    public Cars updateCars(Cars thecars) throws RemoteException {
        return dao.updateCar(thecars);
    }

    @Override
    public Cars deleteCars(Cars thecars) throws RemoteException {
        return dao.deleteCar(thecars);
    }

    @Override
    public Cars searchCars(Cars thecars) throws RemoteException {
        return dao.findCarById(thecars);
    }

    @Override
    public List<Cars> findAll() throws RemoteException {
        return dao.retrieveAllCars();
    }
    
    
}
