/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gov.CarWashMgt.model.Invoice;

/**
 *
 * @author ADMIN
 */
public class InvoiceDao {
    
    public Invoice registerInvoice(Invoice invoiceObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(invoiceObj);
            tr.commit();
            ss.close();
            return invoiceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Invoice updateInvoice(Invoice invoiceObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(invoiceObj);
            tr.commit();
            ss.close();
            return invoiceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Invoice deleteInvoice(Invoice invoiceObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(invoiceObj);
            tr.commit();
            ss.close();
            return invoiceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Invoice findInvoiceById(Invoice invoiceObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Invoice invoice = (Invoice) ss.get(Invoice.class, invoiceObj.getId());
            ss.close();
            return invoice;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Invoice> retrieveAllInvoice(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Invoice> invoice = ss.createQuery("SELECT invoices FROM Invoice invoices").list();
            ss.close();
            return invoice;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
