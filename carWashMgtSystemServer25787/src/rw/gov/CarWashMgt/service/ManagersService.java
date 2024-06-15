/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.gov.CarWashMgt.model.Managers;

/**
 *
 * @author ADMIN
 */
public interface ManagersService extends Remote {
    Managers saveManagers(Managers themanager) throws RemoteException;
    Managers updateManagers(Managers themanager) throws RemoteException;
    Managers deleteManagers(Managers themanager) throws RemoteException;
    Managers searchManagers(Managers themanager) throws RemoteException;
    List<Managers> findAll() throws RemoteException;
}
