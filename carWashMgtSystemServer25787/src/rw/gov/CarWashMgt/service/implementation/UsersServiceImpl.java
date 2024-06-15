/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.gov.CarWashMgt.dao.UsersDao;
import rw.gov.CarWashMgt.model.Users;
import rw.gov.CarWashMgt.service.UsersService;

/**
 *
 * @author ADMIN
 */
public class UsersServiceImpl extends UnicastRemoteObject implements UsersService{
    public UsersServiceImpl() throws RemoteException{
    
    }
    private UsersDao dao = new UsersDao();

    @Override
    public Users saveUsers(Users theusers) throws RemoteException {
        return dao.registerUser(theusers);
    }

    @Override
    public Users updateUsers(Users theusers) throws RemoteException {
        return dao.updateUser(theusers);
    }

    @Override
    public Users deleteUsers(Users theusers) throws RemoteException {
        return dao.deleteUser(theusers);
    }

    @Override
    public Users searchUsers(Users theusers) throws RemoteException {
        return dao.findUserById(theusers);
    }

    @Override
    public List<Users> findAll() throws RemoteException {
        return dao.retrieveAllUsers();
    }
    
    
}
