/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rw.gov.CarWashMgt.service.implementation.CarsServiceImpl;
import rw.gov.CarWashMgt.service.implementation.EmployeesServiceImpl;
import rw.gov.CarWashMgt.service.implementation.InvoiceServiceImpl;
import rw.gov.CarWashMgt.service.implementation.ManagersServiceImpl;
import rw.gov.CarWashMgt.service.implementation.ServicesServiceImpl;
import rw.gov.CarWashMgt.service.implementation.UsersServiceImpl;

/**
 *
 * @author ADMIN
 */
public class Server {
    public static void main(String[] args) {
        try{
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Registry theRegistry = LocateRegistry.createRegistry(81);
            theRegistry.rebind("cars", new CarsServiceImpl());
            theRegistry.rebind("emp", new EmployeesServiceImpl());
            theRegistry.rebind("inv", new InvoiceServiceImpl());
            theRegistry.rebind("man", new ManagersServiceImpl());
            theRegistry.rebind("serv", new ServicesServiceImpl());
            theRegistry.rebind("user", new UsersServiceImpl());
            System.out.println("Server is Running on port 81");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
