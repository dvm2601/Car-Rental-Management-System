/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpResponse;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vmm.DBLoader;

/**
 *
 * @author hp
 */
public class UserHome extends javax.swing.JFrame {

    public UserHome() {
        initComponents();
        setSize(1600,900);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        getallcars();
    }

    void getallcars() {
        try {

            ResultSet rs = DBLoader.executeQuery("Select * from car_details");
            int i = 0;
            CarDesign arr[] = new CarDesign[100000000];  // Bad idea, we’ll fix this too later

            int x = 20, y = 20;

            while (rs.next()) {
                arr[i] = new CarDesign();  // 🔴 You forgot this!

                String car_id = rs.getInt("Car_id") + "";
                String Car_Names = rs.getString("Car_Names");
                String price_per_day_without_driver = rs.getInt("perday_price_without_driver") + "";
                String price_per_day_with_driver = rs.getInt("perday_price_with_driver") + "";
                String Security = rs.getInt("Security") + "";
                String photo = rs.getString("Photo");
                String description = rs.getString("Description");
                String brand = rs.getString("Brand");
                String car_type = rs.getString("Car_Type");

                ImageIcon i2 = null;
                try {

                    System.out.println("Trying to load image from: " + photo);
                    File file = new File(photo);  // photo = "src/myuploads/bmw m5.jpg"
                    BufferedImage img = ImageIO.read(file);
                    Image resized = img.getScaledInstance(arr[i].lb1.getWidth(), arr[i].lb1.getHeight(), Image.SCALE_SMOOTH);
                    i2 = new ImageIcon(resized);
                } catch (Exception e) {
                    System.out.println("In Photo Catch");
                    e.printStackTrace();
                }
                arr[i].lb1.setIcon(i2);

                arr[i].lb2.setText("Car Name: " + Car_Names);
                arr[i].lb3.setText("Price Without Driver: " + price_per_day_without_driver);
                arr[i].lb4.setText("Price With Driver: " + price_per_day_with_driver);
                arr[i].lb5.setText("Security: " + Security);

                arr[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // your booking code here
                        Booking b = new Booking(car_id);
                        b.setVisible(true);

                    }
                });

                arr[i].setBounds(x, y, 1000, 350);
                main1.add(arr[i]);
                main1.repaint();
                arr[i].repaint();
                y += 360;
                i++;
            }

            main1.setPreferredSize(new Dimension(700, 350 * i));
            main1.revalidate();
        } catch (Exception ex) {
            System.out.println("In Catch");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        main1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bt4 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UserHome");
        getContentPane().setLayout(null);

        bt1.setBackground(new java.awt.Color(0, 0, 0));
        bt1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        bt1.setForeground(new java.awt.Color(255, 183, 25));
        bt1.setText("Logout");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(240, 190, 300, 140);

        bt2.setBackground(new java.awt.Color(0, 0, 0));
        bt2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        bt2.setForeground(new java.awt.Color(255, 183, 25));
        bt2.setText("Change Password");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(630, 190, 300, 140);

        main1.setBackground(new java.awt.Color(25, 25, 25));
        main1.setPreferredSize(new java.awt.Dimension(1417, 40000));

        javax.swing.GroupLayout main1Layout = new javax.swing.GroupLayout(main1);
        main1.setLayout(main1Layout);
        main1Layout.setHorizontalGroup(
            main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1417, Short.MAX_VALUE)
        );
        main1Layout.setVerticalGroup(
            main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40000, 40000)
        );

        jScrollPane1.setViewportView(main1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 380, 1080, 360);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 75)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 183, 25));
        jLabel1.setText("User Home");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(630, 30, 300, 90);

        bt4.setBackground(new java.awt.Color(255, 183, 25));
        bt4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bt4.setText("<-----");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(20, 20, 73, 25);

        bt3.setBackground(new java.awt.Color(0, 0, 0));
        bt3.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        bt3.setForeground(new java.awt.Color(255, 183, 25));
        bt3.setText("Booking History");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(1020, 190, 300, 140);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myuploads/userhome.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1600, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // TODO add your handling code here:
        UserLoginPage up = new UserLoginPage();
        up.setVisible(true);
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        UserPasswordChange up = new UserPasswordChange();
        up.setVisible(true);
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        int lo = JOptionPane.showConfirmDialog(this,"Are you sure you wanna log out?");
        if(lo==JOptionPane.YES_OPTION){
            global.uname = "";
            Welcome w = new Welcome();
            w.setVisible(true);
        }
        else {

        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        UserBookingHistory bookingHistory = new UserBookingHistory();
        bookingHistory.setVisible(true);
    }//GEN-LAST:event_bt3ActionPerformed

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
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel main1;
    // End of variables declaration//GEN-END:variables
}
