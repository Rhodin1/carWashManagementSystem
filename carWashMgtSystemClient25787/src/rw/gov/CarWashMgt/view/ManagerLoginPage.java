/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.CarWashMgt.view;

import Utility.BDUtility;
import Validations.CarWash;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import rw.gov.CarWashMgt.model.Managers;

/**
 *
 * @author ADMIN
 */
public class ManagerLoginPage extends javax.swing.JFrame {

    /**
     * Creates new form ManagerLoginPage
     */
    public ManagerLoginPage() {
        initComponents();
        BDUtility.setImage(this, "images/car-wash-back.jpeg", 900, 650);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, Color.BLUE));
        usrNameTxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
        phoneNumberTxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
    }
    
    public static String generateOtp(int optLenght){
        SplittableRandom splittableRandom = new SplittableRandom();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<5; i++){
            sb.append(splittableRandom.nextInt(0,10));
        }
        return sb.toString();
    }
    
    
    
    public class send_and_generate {
    // Method to generate OTP
    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    // Method to send OTP via email
    public void sendOtp(String recipientEmail, String otp) {
        // Set up email server properties
        String host = "smtp.gmail.com"; // Replace with your SMTP server
        final String user = "h1rhodin@gmail.com"; // Replace with your email
        final String password = "xmta bqks rywr bcxm"; // Replace with your email password

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587"); // Replace with your SMTP server port
        props.put("mail.smtp.starttls.enable", "true");

        // Get the session object
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        // Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Your OTP Code");
            message.setText("Your OTP code is: " + otp);

            // Send message
            Transport.send(message);
            System.out.println("OTP from Rhodin sent successfully ");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // Method to send password reset confirmation via email
    public void sendPasswordResetConfirmation(String recipientEmail, String newPassword) {
        // Set up email server properties
        String host = "smtp.gmail.com"; // Replace with your SMTP server
        final String user = "h1rhodin@gmail.com"; // Replace with your email
        final String password = "xmta bqks rywr bcxm"; // Replace with your email password

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587"); // Replace with your SMTP server port
        props.put("mail.smtp.starttls.enable", "true");

        // Get the session object
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        // Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Password Reset Confirmation");
            message.setText("Your  account password has been successfully reset. \n Your new password is: " + newPassword);

            // Send message
            Transport.send(message);
            System.out.println("Password reset confirmation sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        usrNameTxt = new javax.swing.JTextField();
        homeBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        phoneNumberTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 650));
        setUndecorated(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN PAGE");

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MANAGER");

        jLabel3.setBackground(new java.awt.Color(0, 0, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Phone Number");

        loginBtn.setBackground(new java.awt.Color(0, 0, 153));
        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        usrNameTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        homeBtn.setForeground(new java.awt.Color(0, 0, 102));
        homeBtn.setText("Home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Full Names");

        phoneNumberTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(0, 0, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Email");

        emailTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(328, 328, 328)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(298, 298, 298)
                            .addComponent(jLabel1))
                        .addComponent(homeBtn))
                    .addComponent(loginBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usrNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usrNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        BDUtility.openForm(HomePage.class.getSimpleName(), new HomePage());
    }//GEN-LAST:event_homeBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(usrNameTxt.getText().trim().isEmpty() || phoneNumberTxt.getText().trim().isEmpty() || emailTxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required", "Empty fields", JOptionPane.ERROR_MESSAGE);
            }else{
                Managers theManagers = new Managers();
                theManagers.setName(usrNameTxt.getText());
                theManagers.setPhoneNumber(phoneNumberTxt.getText());
                CarWash dao = new CarWash();
                if(dao.checkManagerExist(theManagers)==1){
                     // Generate and send OTP
                    send_and_generate otpService = new send_and_generate();
                    String generatedOtp = otpService.generateOtp();
                    String userEmail = emailTxt.getText();
                    otpService.sendOtp(userEmail, generatedOtp);        
                    // Prompt the user to enter the OTP
                    String enteredOtp = JOptionPane.showInputDialog(this, "Enter the OTP sent to your email:", "OTP Verification", JOptionPane.PLAIN_MESSAGE);
        
                    // Validate the OTP
                    if (!generatedOtp.equals(enteredOtp)) {
                        JOptionPane.showMessageDialog(this, "Invalid OTP", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else{  
                        this.dispose();
                        BDUtility.openForm(ManagerPage.class.getSimpleName(), new ManagerPage()); 
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials", "INVALID", JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_loginBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerLoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField phoneNumberTxt;
    private javax.swing.JTextField usrNameTxt;
    // End of variables declaration//GEN-END:variables
}
