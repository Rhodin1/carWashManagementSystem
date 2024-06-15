/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.gov.CarWashMgt.model.Services;

/**
 *
 * @author ADMIN
 */
public interface ServicesService extends Remote {
    Services saveServices(Services theservices) throws RemoteException;
    Services updateServices(Services theservices) throws RemoteException;
    Services deleteServices(Services theservices) throws RemoteException;
    Services searchServices(Services theservices) throws RemoteException;
    List<Services> findAll() throws RemoteException;
}
