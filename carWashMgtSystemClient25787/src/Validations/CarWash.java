/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import rw.gov.CarWashMgt.model.Cars;
import rw.gov.CarWashMgt.model.Employees;
import rw.gov.CarWashMgt.model.Managers;
import rw.gov.CarWashMgt.model.Services;
import rw.gov.CarWashMgt.model.Users;

/**
 *
 * @author ADMIN
 */
public class CarWash {
    
    
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/carWash_managment_system_db";
    private String username = "postgres";
    private String password = "Rayonnant@12";
    
    public Integer checkUser(Users user){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT * FROM users WHERE user_id=? OR full_name=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user.getId());
            pst.setString(2, user.getNames());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return 1;
            }
            con.close();
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return 0;
    }
    
    
    
    
    public Integer checkUserLogin(Users user){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return 1;
            }
            con.close();
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return 0;
    }
    
    
    
    
    
    public Integer checkEmployeeExist(Employees employee){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT * FROM employees WHERE first_name=? AND last_name=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, employee.getFName());
            pst.setString(2, employee.getLName());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return 1;
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    
    
    
    public Integer checkCarExist(Cars car){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT * FROM cars WHERE car_plate_no=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, car.getPlateNo());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return 1;
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    
    
    
    
     public Integer checkInvoiceCarExist(Cars car){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT * FROM cars WHERE Plate_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, car.getPlateNo());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return 1;
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    
    
    
    public Integer checkManagerExist(Managers manager){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT * FROM managers WHERE manger_full_name=? AND phonenumber=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, manager.getName());
            pst.setString(2, manager.getPhoneNumber());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return 1;
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    
    
    
    public Integer CheckServiceExist(Services service){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT * FROM services WHERE service_Name=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, service.getName());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return 1;
            }
            con.close();
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return 0;
    }
    
    
    
   
    public Services autoFill(Services service){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT service_price FROM services WHERE service_name =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, service.getName());
            ResultSet rs = pst.executeQuery();
            boolean found = false;
            Services theServices = new Services();
            if(rs.next()){
                found = true;
                theServices.setPrice(rs.getDouble(1));
            }
            con.close();
            if(found){
                return theServices;
            }
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return null;
    }
    
    
    
    
    public Employees autoFillEmpname(Employees employee){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT CONCAT(first_name,' ',last_name) FROM employees WHERE emp_Id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, employee.getId());
            ResultSet rs = pst.executeQuery();
            boolean found = false;
            Employees theEmployees = new Employees();
            if(rs.next()){
                found = true;
                theEmployees.setFName(rs.getString(1));
                
            }
            con.close();
            if(found){
                return theEmployees;
            }
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return null;
    }
    
    
    
    
    public Employees autoFillEmpusername(Employees employee){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT CONCAT(first_name,last_name) FROM employees WHERE emp_Id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, employee.getId());
            ResultSet rs = pst.executeQuery();
            boolean found = false;
            Employees theEmployees = new Employees();
            if(rs.next()){
                found = true;
                theEmployees.setLName(rs.getString(1));
            }
            con.close();
            if(found){
                return theEmployees;
            }
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return null;
    }
    
    public Employees autoFillEmpphoneNumber(Employees employee){
        try{
            Connection con = DriverManager.getConnection(jdbcUrl,username,password);
            String sql = "SELECT phone_Number FROM employees WHERE emp_Id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, employee.getId());
            ResultSet rs = pst.executeQuery();
            boolean found = false;
            Employees theEmployees = new Employees();
            if(rs.next()){
                found = true;
                theEmployees.setPhoneNumber(rs.getString(1));
            }
            con.close();
            if(found){
                return theEmployees;
            }
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return null;
    }
}
