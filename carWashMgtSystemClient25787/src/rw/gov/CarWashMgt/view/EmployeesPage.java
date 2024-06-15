/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.view;

import Utility.BDUtility;
import Validations.CarWash;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rw.gov.CarWashMgt.model.Employees;
import rw.gov.CarWashMgt.service.EmployeesService;

/**
 *
 * @author ADMIN
 */
public class EmployeesPage extends javax.swing.JFrame {
    
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/carWash_managment_system_db";
    private String username = "postgres";
    private String password = "Rayonnant@12";
    
    DefaultTableModel tableModel = new DefaultTableModel();
    
    JCalendar calendar = new JCalendar();
    JButton getDateButton = new JButton("Get Date");

    /**
     * Creates new form EmployeesPage
     */
    public EmployeesPage() {
        initComponents();
        BDUtility.setImage(this, "images/abc1.jpg", 1000, 550);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        addColumnsHeaderNameToEmployeeTable();
    }
    
    private void addColumnsHeaderNameToEmployeeTable(){
        tableModel.setColumnCount(0);
        tableModel.addColumn("Employee ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Birth Date");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Phone Number");
        EmpTable1.setModel(tableModel);
    }
    
     private void addRowsDataToEmployeesTable(){
        try{
            tableModel.setRowCount(0);
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
            EmployeesService service = (EmployeesService)theRegistry.lookup("emp");
            List<Employees> employees = service.findAll();
            for(Employees theEmployees : employees){
                tableModel.addRow(new Object[]{
                    theEmployees.getId(),
                    theEmployees.getFName(),
                    theEmployees.getLName(),
                    theEmployees.getBirthDate(),
                    theEmployees.getGender(),
                    theEmployees.getPhoneNumber()
                    
                });
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        empRegisterBtn = new javax.swing.JButton();
        empUpdateBtn = new javax.swing.JButton();
        empDeleteBtn = new javax.swing.JButton();
        empPhoneNumberTxt = new javax.swing.JTextField();
        empGenderCombo = new javax.swing.JComboBox<>();
        empDOBChooser = new com.toedter.calendar.JDateChooser();
        empLastNameTxt = new javax.swing.JTextField();
        empFirstNameTxt = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        empIdTxt = new javax.swing.JTextField();
        empSearchBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        EmpTable1 = new javax.swing.JTable();
        EmpClearBtn1 = new javax.swing.JButton();
        exitBtn1 = new javax.swing.JButton();
        empDisplayBtn = new javax.swing.JButton();
        empPrintBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setUndecorated(true);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel26.setText("First Names");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel25.setText("Last Name");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel28.setText("Date of Birth");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel29.setText("Gender");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel30.setText("Phone Number");

        empRegisterBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        empRegisterBtn.setText("Register");
        empRegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empRegisterBtnActionPerformed(evt);
            }
        });

        empUpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        empUpdateBtn.setText("Update");
        empUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empUpdateBtnActionPerformed(evt);
            }
        });

        empDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        empDeleteBtn.setText("Delete");
        empDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empDeleteBtnActionPerformed(evt);
            }
        });

        empGenderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female", "Not sure", "Not Decided", "Prefer not to say" }));

        empFirstNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empFirstNameTxtActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel31.setText("Employee Id");

        empSearchBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        empSearchBtn.setText("Search");
        empSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empSearchBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("EMPLOYEES MANAGEMENT");

        EmpTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        EmpTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(EmpTable1);

        EmpClearBtn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EmpClearBtn1.setText("Clear");
        EmpClearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpClearBtn1ActionPerformed(evt);
            }
        });

        exitBtn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        exitBtn1.setText("X");
        exitBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtn1ActionPerformed(evt);
            }
        });

        empDisplayBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        empDisplayBtn.setText("Display");
        empDisplayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empDisplayBtnActionPerformed(evt);
            }
        });

        empPrintBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        empPrintBtn.setText("Print");
        empPrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empPrintBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(empPrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(EmpClearBtn1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(empSearchBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel26))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(empFirstNameTxt)
                                        .addComponent(empGenderCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(empLastNameTxt)
                                        .addComponent(empPhoneNumberTxt)
                                        .addComponent(empDOBChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel31)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(empRegisterBtn)
                                            .addGap(18, 18, 18)
                                            .addComponent(empUpdateBtn)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(empDeleteBtn)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(empDisplayBtn))
                                        .addComponent(empIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(exitBtn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmpClearBtn1)
                    .addComponent(empPrintBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(empFirstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(empLastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(empDOBChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empGenderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(empPhoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empUpdateBtn)
                            .addComponent(empDeleteBtn)
                            .addComponent(empRegisterBtn)
                            .addComponent(empDisplayBtn))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addComponent(empSearchBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void empRegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empRegisterBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(empFirstNameTxt.getText().trim().isEmpty() || empLastNameTxt.getText().trim().isEmpty() || empGenderCombo.getSelectedItem().equals("Select") || empPhoneNumberTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "All Fields are required", "Missing", JOptionPane.ERROR_MESSAGE);
            }else{
                Employees theEmployees = new Employees();
                theEmployees.setFName(empFirstNameTxt.getText());
                theEmployees.setLName(empLastNameTxt.getText());
                theEmployees.setBirthDate(empDOBChooser.getDate());
                theEmployees.setGender(empGenderCombo.getSelectedItem().toString());
                theEmployees.setPhoneNumber(empPhoneNumberTxt.getText());
                Date today = Calendar.getInstance().getTime();
                Date selectedDate = empDOBChooser.getDate();
                CarWash dao = new CarWash();
                if(selectedDate.before(today)){
                if(empFirstNameTxt.getText().length()>=2 && empLastNameTxt.getText().length()>=2 && empPhoneNumberTxt.getText().length()>=10){
                    int a = JOptionPane.showConfirmDialog(null, "Register?","APPROVE",JOptionPane.YES_NO_CANCEL_OPTION);
                    
                    if(a==0){
                        if(dao.checkEmployeeExist(theEmployees)==0){
                            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
                            EmployeesService service = (EmployeesService)theRegistry.lookup("emp");
                            Employees employees = service.saveEmployees(theEmployees);
                            if(employees!=null){
                                JOptionPane.showMessageDialog(this, "Data Saved Successful");
                            }else{
                                JOptionPane.showMessageDialog(this, "Data Not Saved");
                            }
                        }else{
                            JOptionPane.showMessageDialog(this, "Employee Already Exist");
                        }
                    }if(a==1){
                        empFirstNameTxt.setText("");
                        empLastNameTxt.setText("");
                        empDOBChooser.setDate(today);
                        empGenderCombo.setSelectedIndex(0);
                        empPhoneNumberTxt.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Enter Values with Accurate Lenght", "ERROR",JOptionPane.ERROR_MESSAGE);
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Date is in Future", "ERROR",JOptionPane.ERROR_MESSAGE);
                    empDOBChooser.setDate(today);
                }

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_empRegisterBtnActionPerformed

    private void empUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empUpdateBtnActionPerformed

        try{
            if(empIdTxt.getText().trim().isEmpty() || empFirstNameTxt.getText().trim().isEmpty() || empLastNameTxt.getText().trim().isEmpty() || empGenderCombo.getSelectedItem().equals("Select") || empPhoneNumberTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "FIRST SEARCH", "Missing", JOptionPane.ERROR_MESSAGE);
            }else{
                Employees theEmployees = new Employees();
                int id = Integer.parseInt(empIdTxt.getText());
                theEmployees.setId(id);
                theEmployees.setFName(empFirstNameTxt.getText());
                theEmployees.setLName(empLastNameTxt.getText());
                theEmployees.setBirthDate(empDOBChooser.getDate());
                theEmployees.setGender(empGenderCombo.getSelectedItem().toString());
                theEmployees.setPhoneNumber(empPhoneNumberTxt.getText());
                
                Date today = Calendar.getInstance().getTime();
                Date selectedDate = empDOBChooser.getDate();
                CarWash dao = new CarWash();
                if(empFirstNameTxt.getText().length()>=2 && empLastNameTxt.getText().length()>=2 && selectedDate.before(today) && empPhoneNumberTxt.getText().length()>=10){
                    int a = JOptionPane.showConfirmDialog(null, "Update?","APPROVE",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(a==0){
                        
                            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
                            EmployeesService service = (EmployeesService)theRegistry.lookup("emp");
                            Employees employees = service.updateEmployees(theEmployees);
                            if(employees!=null){
                                JOptionPane.showMessageDialog(this, "Data Updated Successful");
                            }else{
                                JOptionPane.showMessageDialog(this, "Data Updated Saved");
                            }
                        
                    }if(a==1){
                        empFirstNameTxt.setText("");
                        empLastNameTxt.setText("");
                        empDOBChooser.setDate(today);
                        empGenderCombo.setSelectedIndex(0);
                        empPhoneNumberTxt.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Enter Values with Accurate Lenght", "ERROR",JOptionPane.ERROR_MESSAGE);
                }

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_empUpdateBtnActionPerformed

    private void empDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empDeleteBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(empIdTxt.getText().trim().isEmpty() || empFirstNameTxt.getText().trim().isEmpty() || empLastNameTxt.getText().trim().isEmpty() || empGenderCombo.getSelectedItem().equals("Select") || empPhoneNumberTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "FIRST SEARCH", "Missing", JOptionPane.ERROR_MESSAGE);
            }else{
                Employees theEmployees = new Employees();
                int id = Integer.parseInt(empIdTxt.getText());
                theEmployees.setId(id);
                theEmployees.setFName(empFirstNameTxt.getText());
                theEmployees.setLName(empLastNameTxt.getText());
                theEmployees.setBirthDate(empDOBChooser.getDate());
                theEmployees.setGender(empGenderCombo.getSelectedItem().toString());
                theEmployees.setPhoneNumber(empPhoneNumberTxt.getText());
                
                Date today = Calendar.getInstance().getTime();
                Date selectedDate = empDOBChooser.getDate();
                if(empFirstNameTxt.getText().length()>=2 && empLastNameTxt.getText().length()>=2 && selectedDate.before(today) && empPhoneNumberTxt.getText().length()>=10){
                    int a = JOptionPane.showConfirmDialog(null, "Delete?","APPROVE",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(a==0){
                        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
                        EmployeesService service = (EmployeesService)theRegistry.lookup("emp");
                        Employees employees = service.deleteEmployees(theEmployees);
                        if(employees!=null){
                            JOptionPane.showMessageDialog(this, "Data Deleted Successful");
                        }else{
                            JOptionPane.showMessageDialog(this, "Data Deleted Saved");
                        }
                    }if(a==1){
                        empFirstNameTxt.setText("");
                        empLastNameTxt.setText("");
                        empDOBChooser.setDate(today);
                        empGenderCombo.setSelectedIndex(0);
                        empPhoneNumberTxt.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Enter Values with Accurate Lenght", "ERROR",JOptionPane.ERROR_MESSAGE);
                    empDOBChooser.setDate(today);
                }

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_empDeleteBtnActionPerformed

    private void empFirstNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empFirstNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empFirstNameTxtActionPerformed

    private void empSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empSearchBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(empIdTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter employee Id", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                Employees theEmployees = new Employees();
                int id = Integer.parseInt(empIdTxt.getText());
                theEmployees.setId(id);
                Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
                EmployeesService service = (EmployeesService)theRegistry.lookup("emp");
                Employees employees = service.searchEmployees(theEmployees);
                if(employees!=null){
                    empFirstNameTxt.setText("");
                    empLastNameTxt.setText("");
                    empDOBChooser.setDateFormatString("");
                    empGenderCombo.setSelectedIndex(0);
                    empPhoneNumberTxt.setText("");
                    tableModel.setRowCount(0);
                    tableModel.addRow(new Object[]{
                        employees.getId(),
                        employees.getFName(),
                        employees.getLName(),
                        employees.getBirthDate(),
                        employees.getGender(),
                        employees.getPhoneNumber()
                    });
                }else{
                    JOptionPane.showMessageDialog(this, "EMPLOYEE NOT FOUND");
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_empSearchBtnActionPerformed

    private void EmpTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpTable1MouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = EmpTable1.getSelectedRow();
        empFirstNameTxt.setText(tableModel.getValueAt(selectedRowIndex, 1).toString());
        empLastNameTxt.setText(tableModel.getValueAt(selectedRowIndex, 2).toString());
        Object dateObject = tableModel.getValueAt(selectedRowIndex, 3);
        Date dateValue = (Date) dateObject;
        empDOBChooser.setDate(dateValue);
        empGenderCombo.setSelectedItem(tableModel.getValueAt(selectedRowIndex, 4).toString());
        empPhoneNumberTxt.setText(tableModel.getValueAt(selectedRowIndex, 5).toString());
        empIdTxt.setText(tableModel.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_EmpTable1MouseClicked

    private void EmpClearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpClearBtn1ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO CLEAR EVERYTHING", "SELECT", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(a==0){
            tableModel.setRowCount(0);
            empFirstNameTxt.setText("");
            empLastNameTxt.setText("");
            empDOBChooser.setDateFormatString("");
            empGenderCombo.setSelectedIndex(0);
            empPhoneNumberTxt.setText("");
            empIdTxt.setText("");
        }
    }//GEN-LAST:event_EmpClearBtn1ActionPerformed

    private void exitBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtn1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitBtn1ActionPerformed

    private void empDisplayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empDisplayBtnActionPerformed
        // TODO add your handling code here:
        addColumnsHeaderNameToEmployeeTable();
        addRowsDataToEmployeesTable();
    }//GEN-LAST:event_empDisplayBtnActionPerformed

    private void empPrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empPrintBtnActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Employees List");
        MessageFormat footer = new MessageFormat("*****Car Wash*****");
        try{
            EmpTable1.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_empPrintBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeesPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EmpClearBtn1;
    private javax.swing.JTable EmpTable1;
    private com.toedter.calendar.JDateChooser empDOBChooser;
    private javax.swing.JButton empDeleteBtn;
    private javax.swing.JButton empDisplayBtn;
    private javax.swing.JTextField empFirstNameTxt;
    private javax.swing.JComboBox<String> empGenderCombo;
    private javax.swing.JTextField empIdTxt;
    private javax.swing.JTextField empLastNameTxt;
    private javax.swing.JTextField empPhoneNumberTxt;
    private javax.swing.JButton empPrintBtn;
    private javax.swing.JButton empRegisterBtn;
    private javax.swing.JButton empSearchBtn;
    private javax.swing.JButton empUpdateBtn;
    private javax.swing.JButton exitBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
