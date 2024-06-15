/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.gov.CarWashMgt.dao.ManagersDao;
import rw.gov.CarWashMgt.model.Managers;
import rw.gov.CarWashMgt.service.ManagersService;

/**
 *
 * @author ADMIN
 */
public class ManagersServiceImpl extends UnicastRemoteObject implements ManagersService{
    public ManagersServiceImpl() throws RemoteException{
    
    }
    private ManagersDao dao = new ManagersDao();

    @Override
    public Managers saveManagers(Managers themanager) throws RemoteException {
        return dao.registerManager(themanager);
    }

    @Override
    public Managers updateManagers(Managers themanager) throws RemoteException {
        return dao.updateManager(themanager);
    }

    @Override
    public Managers deleteManagers(Managers themanager) throws RemoteException {
        return dao.deleteManager(themanager);
    }

    @Override
    public Managers searchManagers(Managers themanager) throws RemoteException {
        return dao.findManagerById(themanager);
    }

    @Override
    public List<Managers> findAll() throws RemoteException {
        return dao.retrieveAllManagers();
    }
    
}
