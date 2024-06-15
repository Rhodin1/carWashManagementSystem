/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.gov.CarWashMgt.model.Users;

/**
 *
 * @author ADMIN
 */
public interface UsersService extends Remote {
    Users saveUsers(Users theusers) throws RemoteException;
    Users updateUsers(Users theusers) throws RemoteException;
    Users deleteUsers(Users theusers) throws RemoteException;
    Users searchUsers(Users theusers) throws RemoteException;
    List<Users> findAll() throws RemoteException;
}
