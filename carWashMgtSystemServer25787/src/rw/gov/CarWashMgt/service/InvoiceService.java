/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.gov.CarWashMgt.model.Invoice;

/**
 *
 * @author ADMIN
 */
public interface InvoiceService extends Remote{
    Invoice saveInvoice(Invoice theinvoice) throws RemoteException;
    Invoice updateInvoice(Invoice theinvoice) throws RemoteException;
    Invoice deleteInvoice(Invoice theinvoice) throws RemoteException;
    Invoice searchInvoice(Invoice theinvoice) throws RemoteException;
    List<Invoice> findAll() throws RemoteException;
}
