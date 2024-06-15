/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.gov.CarWashMgt.dao.ServicesDao;
import rw.gov.CarWashMgt.model.Services;
import rw.gov.CarWashMgt.service.ServicesService;

/**
 *
 * @author ADMIN
 */
public class ServicesServiceImpl extends UnicastRemoteObject implements ServicesService{
    public ServicesServiceImpl() throws RemoteException{
    
    }
    private ServicesDao dao = new ServicesDao();

    @Override
    public Services saveServices(Services theservices) throws RemoteException {
        return dao.registerService(theservices);
    }

    @Override
    public Services updateServices(Services theservices) throws RemoteException {
        return dao.updateService(theservices);
    }

    @Override
    public Services deleteServices(Services theservices) throws RemoteException {
        return dao.deleteService(theservices);
    }

    @Override
    public Services searchServices(Services theservices) throws RemoteException {
        return dao.findServiceById(theservices);
    }

    @Override
    public List<Services> findAll() throws RemoteException {
        return dao.retrieveAllServices();
    }
    
}
