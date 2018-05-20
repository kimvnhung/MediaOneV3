/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Database.AccountDB;
import Database.DatabaseCreation;
import Database.DatabaseConnection;
import Khac.TextReader;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.Account;
import utils.CuaHang;

/**
 *
 * @author h
 */
public class LoginFrame extends javax.swing.JFrame {

    
    public ArrayList<Account> listAccount;
    
    
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUserName = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtfUsername = new javax.swing.JTextField();
        passfPassword = new javax.swing.JPasswordField();
        btDangNhap = new javax.swing.JButton();
        lbNotice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MediaOne");
        setLocation(new java.awt.Point(500, 150));
        setName("mainFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(400, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lbUserName.setText("Username:");

        lbPassword.setText("Password:");

        txtfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfUsernameKeyPressed(evt);
            }
        });

        passfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passfPasswordKeyPressed(evt);
            }
        });

        btDangNhap.setText("Đăng nhập");
        btDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangNhapActionPerformed(evt);
            }
        });

        lbNotice.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btDangNhap)
                    .addComponent(txtfUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(passfPassword)
                    .addComponent(lbNotice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUserName)
                    .addComponent(txtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPassword)
                    .addComponent(passfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btDangNhap)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangNhapActionPerformed
        String user = txtfUsername.getText();
        String pass = passfPassword.getText();
        try {
            // TODO add your handling code here:
               
            AccountDB acc = new AccountDB();
            if(acc.getCountOfAccTable() == 0){
                if(user != null && pass != null){
                    acc.addAminAcount(new Account(user,pass));
                    
                    //thêm thông tin
                    TextReader tr = new TextReader("data.sql");
                    for(String query: tr.getData()){
                        myConnectionClass.executeQuery(query);
                    }
                    
                    
                    new HomeFrame(user).setVisible(true);
                    this.dispose();
                }
            }else{
                listAccount = acc.getListAccount();
                listAccount.addAll(acc.getListAdminAccount());
                for(Account x: listAccount){
                    if(user.equals(x.getUsername()) && pass.equals(x.getPassword())){
                        this.dispose();
                        new HomeFrame(user).setVisible(true);
                        
                    }
                }
                lbNotice.setText("Sai tài khoản hoặc mật khẩu");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btDangNhapActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            myConnectionClass = new DatabaseConnection();
            lbNotice.setText("Nhập Mật khẩu");
        } catch (ClassNotFoundException ex) {
            lbNotice.setText("ClassNotFoundException");
        } catch (SQLException ex) {//khi chưa tạo database
            try {
            //lần đầu đăng nhập
            lbNotice.setText("Tạo mật khẩu cho chủ cửa hàng!");
            //lbNotice.setText(ex.getMessage());
            lbNotice.setForeground(Color.RED);
            
            //tạo database
            DatabaseCreation create = new DatabaseCreation();
            
            create.createDatabase();
            JOptionPane.showMessageDialog(this,"creating completed");
                
            
            
            //Đọc file MediaOne.sql rồi ghi vào String query
            
            
            myConnectionClass = new DatabaseConnection();
            TextReader tr = new TextReader("MediaoneV3.sql");
            for(String query:tr.getData()){
                myConnectionClass.executeQuery(query);
            }
              
            //ghi ra ngày bắt đầu bán
            FileWriter fw = new FileWriter("theStart.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(new Date().getTime());
            pw.close();
                
            } catch (FileNotFoundException ex1) {
                lbNotice.setText(ex1.getMessage());
            } catch (IOException ex1) {
                lbNotice.setText(ex1.getMessage());
            } catch (Exception ex1) {
                JOptionPane.showMessageDialog(this, ex1.getMessage());
            }
            
        }
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btDangNhap.doClick();
        }
    }//GEN-LAST:event_formKeyPressed

    private void txtfUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfUsernameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btDangNhap.doClick();
        }
    }//GEN-LAST:event_txtfUsernameKeyPressed

    private void passfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passfPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btDangNhap.doClick();
        }
    }//GEN-LAST:event_passfPasswordKeyPressed
    
    
    
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    private DatabaseConnection myConnectionClass;
    private Connection connection;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDangNhap;
    private javax.swing.JLabel lbNotice;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JPasswordField passfPassword;
    private javax.swing.JTextField txtfUsername;
    // End of variables declaration//GEN-END:variables
}
