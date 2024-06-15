/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.gov.CarWashMgt.model.Employees;

/**
 *
 * @author ADMIN
 */
public interface EmployeesService extends Remote {
    Employees saveEmployees(Employees theemps) throws RemoteException;
    Employees updateEmployees(Employees theemps) throws RemoteException;
    Employees deleteEmployees(Employees theemps) throws RemoteException;
    Employees searchEmployees(Employees theemps) throws RemoteException;
    List<Employees> findAll() throws RemoteException;
}
