/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.gov.CarWashMgt.dao.InvoiceDao;
import rw.gov.CarWashMgt.model.Invoice;
import rw.gov.CarWashMgt.service.InvoiceService;

/**
 *
 * @author ADMIN
 */
public class InvoiceServiceImpl extends UnicastRemoteObject implements InvoiceService{
    public InvoiceServiceImpl() throws RemoteException{
    
    }
    private InvoiceDao dao = new InvoiceDao();

    @Override
    public Invoice saveInvoice(Invoice theinvoice) throws RemoteException {
        return dao.registerInvoice(theinvoice);
    }

    @Override
    public Invoice updateInvoice(Invoice theinvoice) throws RemoteException {
        return dao.updateInvoice(theinvoice);
    }

    @Override
    public Invoice deleteInvoice(Invoice theinvoice) throws RemoteException {
        return dao.deleteInvoice(theinvoice);
    }

    @Override
    public Invoice searchInvoice(Invoice theinvoice) throws RemoteException {
        return dao.findInvoiceById(theinvoice);
    }

    @Override
    public List<Invoice> findAll() throws RemoteException {
        return dao.retrieveAllInvoice();
    }
    
}
