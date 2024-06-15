/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gov.CarWashMgt.model.Managers;

/**
 *
 * @author ADMIN
 */
public class ManagersDao {
    
    public Managers registerManager(Managers managerObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(managerObj);
            tr.commit();
            ss.close();
            return managerObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Managers updateManager(Managers managerObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(managerObj);
            tr.commit();
            ss.close();
            return managerObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Managers deleteManager(Managers managerObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(managerObj);
            tr.commit();
            ss.close();
            return managerObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Managers findManagerById(Managers managerObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Managers manager = (Managers) ss.get(Managers.class, managerObj.getId());
            ss.close();
            return manager;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Managers> retrieveAllManagers(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Managers> manager = ss.createQuery("SELECT managers FROM Managers managers").list();
            ss.close();
            return manager;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
