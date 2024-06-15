/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gov.CarWashMgt.model.Users;

/**
 *
 * @author ADMIN
 */
public class UsersDao {
    
    public Users registerUser(Users userObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(userObj);
            tr.commit();
            ss.close();
            return userObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Users updateUser(Users userObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(userObj);
            tr.commit();
            ss.close();
            return userObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Users deleteUser(Users userObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(userObj);
            tr.commit();
            ss.close();
            return userObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Users findUserById(Users userObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Users user = (Users) ss.get(Users.class, userObj.getId());
            ss.close();
            return user;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Users> retrieveAllUsers(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Users> user = ss.createQuery("SELECT users FROM Users users").list();
            ss.close();
            return user;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
