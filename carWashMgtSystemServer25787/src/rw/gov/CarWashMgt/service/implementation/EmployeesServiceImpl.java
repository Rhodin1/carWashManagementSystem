/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.gov.CarWashMgt.dao.EmployeesDao;
import rw.gov.CarWashMgt.model.Employees;
import rw.gov.CarWashMgt.service.EmployeesService;

/**
 *
 * @author ADMIN
 */
public class EmployeesServiceImpl extends UnicastRemoteObject implements EmployeesService{
    public EmployeesServiceImpl() throws RemoteException{
    
    }
    private EmployeesDao dao = new EmployeesDao();

    @Override
    public Employees saveEmployees(Employees theemps) throws RemoteException {
        return dao.registerEmployee(theemps);
    }

    @Override
    public Employees updateEmployees(Employees theemps) throws RemoteException {
        return dao.updateEmployee(theemps);
    }

    @Override
    public Employees deleteEmployees(Employees theemps) throws RemoteException {
        return dao.deleteEmployee(theemps);
    }

    @Override
    public Employees searchEmployees(Employees theemps) throws RemoteException {
        return dao.findEmployeeById(theemps);
    }

    @Override
    public List<Employees> findAll() throws RemoteException {
        return dao.retrieveAllEmployees();
    }
    
}
