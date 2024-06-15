/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gov.CarWashMgt.model.Employees;

/**
 *
 * @author ADMIN
 */
public class EmployeesDao {
    
    public Employees registerEmployee(Employees empObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(empObj);
            tr.commit();
            ss.close();
            return empObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Employees updateEmployee(Employees empObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(empObj);
            tr.commit();
            ss.close();
            return empObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Employees deleteEmployee(Employees empObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(empObj);
            tr.commit();
            ss.close();
            return empObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Employees findEmployeeById(Employees empObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Employees emp = (Employees) ss.get(Employees.class, empObj.getId());
            ss.close();
            return emp;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Employees> retrieveAllEmployees(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Employees> emp = ss.createQuery("SELECT emps FROM Employees emps").list();
            ss.close();
            return emp;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
