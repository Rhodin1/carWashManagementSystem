/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gov.CarWashMgt.model.Cars;

/**
 *
 * @author ADMIN
 */
public class CarsDao {
    
    public Cars registerCar(Cars carObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(carObj);
            tr.commit();
            ss.close();
            return carObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Cars updateCar(Cars carObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(carObj);
            tr.commit();
            ss.close();
            return carObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Cars deleteCar(Cars carObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(carObj);
            tr.commit();
            ss.close();
            return carObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Cars findCarById(Cars carObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Cars car = (Cars) ss.get(Cars.class, carObj.getId());
            ss.close();
            return car;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Cars> retrieveAllCars(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Cars> car = ss.createQuery("SELECT cars FROM Cars cars").list();
            ss.close();
            return car;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
