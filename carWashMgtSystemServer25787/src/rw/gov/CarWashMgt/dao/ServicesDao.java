/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gov.CarWashMgt.model.Services;

/**
 *
 * @author ADMIN
 */
public class ServicesDao {
    
    public Services registerService(Services serviceObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(serviceObj);
            tr.commit();
            ss.close();
            return serviceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Services updateService(Services serviceObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(serviceObj);
            tr.commit();
            ss.close();
            return serviceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Services deleteService(Services serviceObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(serviceObj);
            tr.commit();
            ss.close();
            return serviceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Services findServiceById(Services serviceObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Services service = (Services) ss.get(Services.class, serviceObj.getId());
            ss.close();
            return service;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Services> retrieveAllServices(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Services> service = ss.createQuery("SELECT services FROM Services services").list();
            ss.close();
            return service;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
