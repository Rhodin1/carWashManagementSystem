/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.view;

import Utility.BDUtility;
import Validations.CarWash;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rw.gov.CarWashMgt.model.Invoice;
import rw.gov.CarWashMgt.model.Services;
import rw.gov.CarWashMgt.service.InvoiceService;

/**
 *
 * @author ADMIN
 */
public class InvoicesPage extends javax.swing.JFrame {
    
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/carWash_managment_system_db";
    private String username = "postgres";
    private String password = "Rayonnant@12";
    
    DefaultTableModel tableModel = new DefaultTableModel();
    /**
     * Creates new form InvoicesPage
     */
    
    String billNo = "";
    Double totalAmount = 0.0;
    Double bHeight = 0.0;
    
    ArrayList<String> ServiceName = new ArrayList<>();
    ArrayList<String> Employee = new ArrayList<>();
    ArrayList<String> Date = new ArrayList<>();
    ArrayList<String> PlateNumber = new ArrayList<>();
    ArrayList<String> Amount = new ArrayList<>();
    
    
    public InvoicesPage() {
        initComponents();
        BDUtility.setImage(this, "images/abc1.jpg", 1000, 550);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        addColumnsHeaderNameToInvoiceTable();
        UpdateInvoiceCombo1();
        UpdateInvoiceCombo2();
        UpdateInvoiceCombo3();
    }
    
    private void addColumnsHeaderNameToInvoiceTable(){
        tableModel.setColumnCount(0);
        tableModel.addColumn("Invoice Id");
        tableModel.addColumn("Car Plate No");
        tableModel.addColumn("Emp Id");
        tableModel.addColumn("Date");
        tableModel.addColumn("Service Name");
        tableModel.addColumn("Amount");
        invoicesTable.setModel(tableModel);
    }
    
    private void UpdateInvoiceCombo1(){
         try{
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            String sql = "SELECT * FROM employees";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
             while(rs.next()){
                invoiceEmpIdCombo.addItem(rs.getString("emp_id"));
             }
         }catch(Exception ex){
             ex.printStackTrace();
         }
     }
      private void UpdateInvoiceCombo2(){
         try{
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            String sql = "SELECT * FROM services";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
             while(rs.next()){
                invoiceServiceNameCombo.addItem(rs.getString("service_name"));
             }
         }catch(Exception ex){
             ex.printStackTrace();
         }
     }
       private void UpdateInvoiceCombo3(){
         try{
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            String sql = "SELECT * FROM cars";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
             while(rs.next()){
                invoicePlateNumberCombo.addItem(rs.getString("car_plate_no"));
             }
         }catch(Exception ex){
             ex.printStackTrace();
         }
     }
       private void addRowsDataToInvoiceTable(){
        try{
            tableModel.setRowCount(0);
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
            InvoiceService service = (InvoiceService)theRegistry.lookup("inv");
            List<Invoice> invoice = service.findAll();
            for(Invoice theInvoice : invoice){
                tableModel.addRow(new Object[]{
                    theInvoice.getId(),
                    theInvoice.getPlateNo(),
                    theInvoice.getEmpId(),
                    theInvoice.getDate(),
                    theInvoice.getServiceName(),
                    theInvoice.getPrice()
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

        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        invoicePlateNumberCombo = new javax.swing.JComboBox<>();
        invoiceEmpIdCombo = new javax.swing.JComboBox<>();
        invoiceDateChooser = new com.toedter.calendar.JDateChooser();
        invoiceServiceNameCombo = new javax.swing.JComboBox<>();
        invoiceAmountTxt = new javax.swing.JTextField();
        invoiceRegisterBtn = new javax.swing.JButton();
        invoiceUpdateBtn = new javax.swing.JButton();
        invoiceDeleteBtn = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        invoiceIdTxt = new javax.swing.JTextField();
        invoiceSearchBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        invoiceDisplayBtn = new javax.swing.JButton();
        invoiceClearBtn = new javax.swing.JButton();
        invoicePrintBtn = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        invoiceTotalAmountTxt = new javax.swing.JTextField();
        invoiceAddBtn = new javax.swing.JButton();
        invoicesPrintBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setUndecorated(true);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel39.setText("Car Plate Number");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel38.setText("Employee Id");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel40.setText("Date ");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel41.setText("Service Name");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel42.setText("Amount");

        invoicePlateNumberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        invoiceEmpIdCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        invoiceServiceNameCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        invoiceServiceNameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceServiceNameComboActionPerformed(evt);
            }
        });

        invoiceRegisterBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoiceRegisterBtn.setText("Register");
        invoiceRegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceRegisterBtnActionPerformed(evt);
            }
        });

        invoiceUpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoiceUpdateBtn.setText("Update");
        invoiceUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceUpdateBtnActionPerformed(evt);
            }
        });

        invoiceDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoiceDeleteBtn.setText("Delete");
        invoiceDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDeleteBtnActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel43.setText("Inovice Id");

        invoiceIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceIdTxtActionPerformed(evt);
            }
        });

        invoiceSearchBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoiceSearchBtn.setText("Search");
        invoiceSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceSearchBtnActionPerformed(evt);
            }
        });

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        invoicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoicesTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(invoicesTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("INVOICES MANAGEMENT");

        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        exitBtn.setText("X");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        invoiceDisplayBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoiceDisplayBtn.setText("Display");
        invoiceDisplayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDisplayBtnActionPerformed(evt);
            }
        });

        invoiceClearBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoiceClearBtn.setText("Clear");
        invoiceClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceClearBtnActionPerformed(evt);
            }
        });

        invoicePrintBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoicePrintBtn.setText("Print");
        invoicePrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicePrintBtnActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel44.setText("Total Amount");

        invoiceTotalAmountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceTotalAmountTxtActionPerformed(evt);
            }
        });

        invoiceAddBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoiceAddBtn.setText("Add");
        invoiceAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceAddBtnActionPerformed(evt);
            }
        });

        invoicesPrintBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoicesPrintBtn.setText("Print");
        invoicesPrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesPrintBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(308, 308, 308)
                        .addComponent(exitBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(586, 586, 586)
                                .addComponent(invoicesPrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(invoiceClearBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38)
                                            .addComponent(jLabel39))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(invoiceServiceNameCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 244, Short.MAX_VALUE)
                                            .addComponent(invoiceAmountTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invoiceDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(invoicePlateNumberCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(invoiceEmpIdCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(invoiceSearchBtn))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(invoiceIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(invoiceRegisterBtn)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(invoiceUpdateBtn)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(invoiceDeleteBtn))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(110, 110, 110)
                                                        .addComponent(invoicePrintBtn)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addComponent(invoiceDisplayBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(invoiceAddBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(invoiceTotalAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(128, 128, 128)))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(exitBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invoiceClearBtn)
                    .addComponent(invoicesPrintBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(invoicePlateNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38)
                            .addComponent(invoiceEmpIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addComponent(invoiceDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceServiceNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(invoiceAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceRegisterBtn)
                            .addComponent(invoiceUpdateBtn)
                            .addComponent(invoiceDeleteBtn)
                            .addComponent(invoiceDisplayBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)
                            .addComponent(invoiceSearchBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceTotalAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(invoiceAddBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoicePrintBtn)
                        .addGap(19, 19, 19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void invoiceRegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceRegisterBtnActionPerformed
        // TODO add your handling code here:
       try{
            if(invoicePlateNumberCombo.getSelectedItem().equals("Select")||invoiceEmpIdCombo.getSelectedItem().equals("Select")||invoiceDateChooser.getDateFormatString().trim().isEmpty()||invoiceServiceNameCombo.getSelectedItem().equals("Select")||invoiceAmountTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "All Fields are required", "Missing", JOptionPane.ERROR_MESSAGE);
            }else{
                Invoice theInvoice = new Invoice();
                theInvoice.setPlateNo(invoicePlateNumberCombo.getSelectedItem().toString());
                int id = Integer.parseInt(invoiceEmpIdCombo.getSelectedItem().toString());
                theInvoice.setEmpId(id);
                theInvoice.setDate(invoiceDateChooser.getDate());
                theInvoice.setServiceName(invoiceServiceNameCombo.getSelectedItem().toString());
                double price = Double.parseDouble(invoiceAmountTxt.getText());
                theInvoice.setPrice(price);
                Date today = Calendar.getInstance().getTime();
                Date selectedDate = invoiceDateChooser.getDate();
                CarWash dao = new CarWash();
                if(selectedDate.before(today)){
                    int a = JOptionPane.showConfirmDialog(null, "Register?","APPROVE",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(a==0){
                        
                        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
                        InvoiceService service = (InvoiceService)theRegistry.lookup("inv");
                        Invoice invoices = service.saveInvoice(theInvoice);
                        if(invoices!=null){
                            JOptionPane.showMessageDialog(this, "Data Saved Successful");
                            addRowsDataToInvoiceTable();
                        }else{
                            JOptionPane.showMessageDialog(this, "Data Not Saved");
                        }
                    }if(a==1){
                        invoicePlateNumberCombo.setSelectedIndex(0);
                        invoiceEmpIdCombo.setSelectedIndex(0);
                        invoiceDateChooser.setDateFormatString("");
                        invoiceServiceNameCombo.setSelectedIndex(0);
                        invoiceAmountTxt.setText("");
                        invoiceIdTxt.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Date is in Future", "ERROR",JOptionPane.ERROR_MESSAGE);
                    invoiceDateChooser.setDate(today);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_invoiceRegisterBtnActionPerformed

    private void invoiceUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceUpdateBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(invoiceIdTxt.getText().trim().isEmpty() || invoicePlateNumberCombo.getSelectedItem().equals("Select")||invoiceEmpIdCombo.getSelectedItem().equals("Select")||invoiceDateChooser.getDateFormatString().trim().isEmpty()||invoiceServiceNameCombo.getSelectedItem().equals("Select")||invoiceAmountTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Search Invoice First", "Missing", JOptionPane.ERROR_MESSAGE);
            }else{
                Invoice theInvoice = new Invoice();
                int id = Integer.parseInt(invoiceIdTxt.getText(),invoicePlateNumberCombo.getSelectedIndex());
                theInvoice.setEmpId(id);
                theInvoice.setPlateNo(invoicePlateNumberCombo.getSelectedItem().toString());
                theInvoice.setDate(invoiceDateChooser.getDate());
                theInvoice.setServiceName(invoiceServiceNameCombo.getSelectedItem().toString());
                double price = Double.parseDouble(invoiceAmountTxt.getText());
                theInvoice.setPrice(price);
                Date today = Calendar.getInstance().getTime();
                Date selectedDate = invoiceDateChooser.getDate();
                CarWash dao = new CarWash();
                if(selectedDate.before(today)){
                    int a = JOptionPane.showConfirmDialog(null, "Update?","APPROVE",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(a==0){
                        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
                        InvoiceService service = (InvoiceService)theRegistry.lookup("inv");
                        Invoice invoices = service.updateInvoice(theInvoice);
                        if(invoices != null){
                            JOptionPane.showMessageDialog(this, "Data Updated Successful");
                            addRowsDataToInvoiceTable();
                        }else{
                            JOptionPane.showMessageDialog(this, "Data Not Updated");
                        }
                    }if(a==1){
                        invoicePlateNumberCombo.setSelectedIndex(0);
                        invoiceEmpIdCombo.setSelectedIndex(0);
                        invoiceDateChooser.setDateFormatString("");
                        invoiceServiceNameCombo.setSelectedIndex(0);
                        invoiceAmountTxt.setText("");
                        invoiceIdTxt.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Date is in Future", "ERROR",JOptionPane.ERROR_MESSAGE);
                    invoiceDateChooser.setDate(today);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_invoiceUpdateBtnActionPerformed

    private void invoiceDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceDeleteBtnActionPerformed
        // TODO add your handling code here:
       try{
            if(invoiceIdTxt.getText().trim().isEmpty() || invoicePlateNumberCombo.getSelectedItem().equals("Select")||invoiceEmpIdCombo.getSelectedItem().equals("Select")||invoiceDateChooser.getDateFormatString().trim().isEmpty()||invoiceServiceNameCombo.getSelectedItem().equals("Select")||invoiceAmountTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "All Fields are required", "Missing", JOptionPane.ERROR_MESSAGE);
            }else{
                Invoice theInvoice = new Invoice();
                int id = Integer.parseInt(invoiceIdTxt.getText());
                theInvoice.setEmpId(id);
                theInvoice.setPlateNo(invoicePlateNumberCombo.getSelectedItem().toString());
                theInvoice.setDate(invoiceDateChooser.getDate());
                theInvoice.setServiceName(invoiceServiceNameCombo.getSelectedItem().toString());
                double price = Double.parseDouble(invoiceAmountTxt.getText());
                theInvoice.setPrice(price);
                Date today = Calendar.getInstance().getTime();
                Date selectedDate = invoiceDateChooser.getDate();
                CarWash dao = new CarWash();
                if(selectedDate.before(today)){
                    int a = JOptionPane.showConfirmDialog(null, "Delete?","APPROVE",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(a==0){
                        
                        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
                        InvoiceService service = (InvoiceService)theRegistry.lookup("inv");
                        Invoice invoices = service.deleteInvoice(theInvoice);
                        if(invoices!=null){
                            JOptionPane.showMessageDialog(this, "Data Deleted Successful");
                            addRowsDataToInvoiceTable();
                        }else{
                            JOptionPane.showMessageDialog(this, "Data Not Deleted");
                        }
                    }if(a==1){
                        invoicePlateNumberCombo.setSelectedIndex(0);
                        invoiceEmpIdCombo.setSelectedIndex(0);
                        invoiceDateChooser.setDateFormatString("");
                        invoiceServiceNameCombo.setSelectedIndex(0);
                        invoiceAmountTxt.setText("");
                        invoiceIdTxt.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Date is in Future", "ERROR",JOptionPane.ERROR_MESSAGE);
                    invoiceDateChooser.setDate(today);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_invoiceDeleteBtnActionPerformed

    private void invoiceSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceSearchBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(invoiceIdTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Invoice Id", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                Invoice theInvoice = new Invoice();
                int id = Integer.parseInt(invoiceIdTxt.getText());
                theInvoice.setId(id);
                Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",81);
                InvoiceService service = (InvoiceService)theRegistry.lookup("inv");
                Invoice invoices = service.searchInvoice(theInvoice);
                if(invoices!=null){
                    invoicePlateNumberCombo.setSelectedIndex(0);
                    invoiceEmpIdCombo.setSelectedIndex(0);
                    invoiceDateChooser.setDateFormatString("");
                    invoiceServiceNameCombo.setSelectedIndex(0);
                    invoiceAmountTxt.setText("");
                    tableModel.setRowCount(0);
                    tableModel.addRow(new Object[]{
                        invoices.getId(),
                        invoices.getPlateNo(),
                        invoices.getEmpId(),
                        invoices.getDate(),
                        invoices.getServiceName(),
                        invoices.getPrice()
                    });
                }else{
                    JOptionPane.showMessageDialog(this, "EMPLOYEE NOT FOUND");
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_invoiceSearchBtnActionPerformed

    private void invoiceIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceIdTxtActionPerformed

    private void invoicesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoicesTableMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = invoicesTable.getSelectedRow();
        invoicePlateNumberCombo.setSelectedItem(tableModel.getValueAt(selectedRowIndex, 1).toString());
        invoiceEmpIdCombo.setSelectedItem(tableModel.getValueAt(selectedRowIndex, 2).toString());
        Object dateObject = tableModel.getValueAt(selectedRowIndex, 3);
        Date dateValue = (Date) dateObject;
        invoiceDateChooser.setDate(dateValue);
        invoiceServiceNameCombo.setSelectedItem(tableModel.getValueAt(selectedRowIndex, 4).toString());
        invoiceAmountTxt.setText(tableModel.getValueAt(selectedRowIndex, 5).toString());
        invoiceIdTxt.setText(tableModel.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_invoicesTableMouseClicked

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void invoiceDisplayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceDisplayBtnActionPerformed
        // TODO add your handling code here:
        addColumnsHeaderNameToInvoiceTable();
        addRowsDataToInvoiceTable();
    }//GEN-LAST:event_invoiceDisplayBtnActionPerformed

    private void invoiceClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceClearBtnActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO CLEAR EVERYTHING", "SELECT", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(a==0){
            tableModel.setRowCount(0);

            invoicePlateNumberCombo.setSelectedIndex(0);
            invoiceEmpIdCombo.setSelectedIndex(0);
            invoiceDateChooser.setDateFormatString("");
            invoiceServiceNameCombo.setSelectedIndex(0);
            invoiceAmountTxt.setText("");
            invoiceIdTxt.setText("");
        }
    }//GEN-LAST:event_invoiceClearBtnActionPerformed

    private void invoicePrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicePrintBtnActionPerformed
        // TODO add your handling code here:
        bHeight = Double.valueOf(ServiceName.size());
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(), getPageFormat(pj));
        try{
            pj.print();
        }catch(PrinterException pe){
            pe.printStackTrace();
        }
    }//GEN-LAST:event_invoicePrintBtnActionPerformed

    private void invoiceServiceNameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceServiceNameComboActionPerformed
        // TODO add your handling code here:
        try{
             Services theService = new Services();
             theService.setName(invoiceServiceNameCombo.getSelectedItem().toString());
             CarWash dao = new CarWash();
             Services services = dao.autoFill(theService);
             if(services!=null){
                 invoiceAmountTxt.setText(String.valueOf(services.getPrice()));
             }
         }catch(Exception ex){
             ex.printStackTrace();
        }
    }//GEN-LAST:event_invoiceServiceNameComboActionPerformed

    private void invoiceTotalAmountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceTotalAmountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceTotalAmountTxtActionPerformed

    private void invoiceAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceAddBtnActionPerformed
        // TODO add your handling code here:
        if(invoicePlateNumberCombo.getSelectedItem().equals("Select")||invoiceEmpIdCombo.getSelectedItem().equals("Select")||invoiceDateChooser.getDateFormatString().trim().isEmpty()||invoiceServiceNameCombo.getSelectedItem().equals("Select")||invoiceAmountTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "All Fields are required", "Missing", JOptionPane.ERROR_MESSAGE);
        }else{
            ServiceName.add(invoiceServiceNameCombo.getSelectedItem().toString());
            Date.add(invoiceDateChooser.getDate().toString());
            PlateNumber.add(invoicePlateNumberCombo.getSelectedItem().toString());
            Employee.add(invoiceEmpIdCombo.getSelectedItem().toString());
            Amount.add(invoiceAmountTxt.getText());
            totalAmount = totalAmount + Double.valueOf(invoiceAmountTxt.getText());
            invoiceTotalAmountTxt.setText(totalAmount+"");
        }
        
    }//GEN-LAST:event_invoiceAddBtnActionPerformed

    private void invoicesPrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesPrintBtnActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Invoices List");
        MessageFormat footer = new MessageFormat("*****Car Wash*****");
        try{
            invoicesTable.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_invoicesPrintBtnActionPerformed

    public PageFormat getPageFormat(PrinterJob pj){
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();
        
        double bodyHeight = bHeight;
        double headerHeight = 5.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(8);
        double height = cm_to_pp(headerHeight+bodyHeight+footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height - cm_to_pp(1));
        
        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);
        
        return pf;
    }
    
    protected static double cm_to_pp(double cm){
        return toPPI(cm*0.393600787);
    }
    
    protected static double toPPI(double inch){
        return inch * 72d;
    }
    
    public class BillPrintable implements Printable{

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            int r= ServiceName.size();
            ImageIcon icon = new ImageIcon("C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\carWashMgtSystemClient25787\\src\\Utility\\images\\download (1).png");
            int result = NO_SUCH_PAGE;
            if(pageIndex ==0){
                Graphics2D g2d = (Graphics2D) graphics;
                double width = pageFormat.getWidth();
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
                
                try{
                 int y = 20;
                 int yShift = 10;
                 int headerRectHeight = 15;
                 
                 g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
                 g2d.drawImage(icon.getImage(), 50,20,90,30, rootPane);y+=yShift+30;
                 g2d.drawString("------------------------------------", 12, y);y+=yShift;
                 g2d.drawString("             CRCarWash          ", 12, y);y+=yShift;
                 g2d.drawString("           Kigali/Rwanda        ", 12, y);y+=yShift;
                 g2d.drawString("         www.CRCarWash.com      ", 12, y);y+=yShift;
                 g2d.drawString("          +250787065410         ", 12, y);y+=yShift;
                 g2d.drawString("------------------------------------", 12, y);y+=headerRectHeight;
                 
                 
                 int s=0; 
                     g2d.drawString(" Employee Id :    "+Employee.get(s)+"  ",10,y);y+=yShift;
                     g2d.drawString(" Plate Number:    "+PlateNumber.get(s)+"  ",10,y);y+=yShift;
                 
                 
                 g2d.drawString("                                     ", 10, y);y+=yShift;
                 g2d.drawString(" Service Name                 Price  ", 10, y);y+=yShift;
                 g2d.drawString("-------------------------------------", 10, y);y+=yShift;
                 for( s=0; s<r; s++){
                     g2d.drawString(" "+ServiceName.get(s)+"                  "+Amount.get(s), 10, y);y+=yShift; 
                 }
                 
                 g2d.drawString("-------------------------------------", 10, y);y+=yShift;
                 g2d.drawString(" Total Amount:              "+invoiceTotalAmountTxt.getText()+"  ", 10, y);y+=yShift;
                 g2d.drawString("-------------------------------------", 10, y);y+=yShift;
                 g2d.drawString(" Date  :"+invoiceDateChooser.getDate()+"  ", 10, y);y+=yShift;
                 
                 g2d.drawString("*************************************", 10, y);y+=yShift;
                 g2d.drawString("       THANK YOU!! COME AGAIN       ", 10, y);y+=yShift;
                 g2d.drawString("*************************************", 10, y);y+=yShift;
                 g2d.drawString("  SOFTWARE BY: HIRWA CLEMENT RHODIN  ", 10, y);y+=yShift;
                 g2d.drawString("        CONTACT: +250787065410       ", 10, y);y+=yShift;
                 g2d.drawString("-------------------------------------", 10, y);y+=yShift;
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                result = PAGE_EXISTS;
            }
            return result;
        }
        
    }
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
            java.util.logging.Logger.getLogger(InvoicesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoicesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoicesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoicesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoicesPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton invoiceAddBtn;
    private javax.swing.JTextField invoiceAmountTxt;
    private javax.swing.JButton invoiceClearBtn;
    private com.toedter.calendar.JDateChooser invoiceDateChooser;
    private javax.swing.JButton invoiceDeleteBtn;
    private javax.swing.JButton invoiceDisplayBtn;
    private javax.swing.JComboBox<String> invoiceEmpIdCombo;
    private javax.swing.JTextField invoiceIdTxt;
    private javax.swing.JComboBox<String> invoicePlateNumberCombo;
    private javax.swing.JButton invoicePrintBtn;
    private javax.swing.JButton invoiceRegisterBtn;
    private javax.swing.JButton invoiceSearchBtn;
    private javax.swing.JComboBox<String> invoiceServiceNameCombo;
    private javax.swing.JTextField invoiceTotalAmountTxt;
    private javax.swing.JButton invoiceUpdateBtn;
    private javax.swing.JButton invoicesPrintBtn;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
