/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class Billing extends javax.swing.JFrame {

    /**
     * Creates new form Billing
     */
    public Billing() {
        initComponents();
        conn=DBconnect.connect();
        tableload();
        tableload2();
        setupBillTable3();
    }

      Connection conn =null;
    PreparedStatement pst=null;
    ResultSet rs=null;
           
    public void tableload(){
        
        try {
            String sql="SELECT Petname,Price FROM Pet ";
            pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            billTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
        }
          
    }
    
        public void tabledata(){
        
        int r=billTable1.getSelectedRow();
        
        
        String name=billTable1.getValueAt(r,0).toString();
        
           String price=billTable1.getValueAt(r,1).toString();
            
            breedTF.setText(name);
     petPriceTF.setText(price);
           
    }
        
        
       public void tableload2(){
        
        try {
            String sql="SELECT Foodname,Price FROM food ";
            pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
          billTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
        }
          
    }   
       
        
       public void tabledata2(){
        
        int r=billTable2.getSelectedRow();
        
        
        String name=billTable2.getValueAt(r,0).toString();
        
        String price=billTable2.getValueAt(r,1).toString();
            
      foodTF.setText(name);
      foodPriceTF.setText(price);
           
    }   
       
       
          public void tableload3(){
        
        try {
            String sql="SELECT Bread,Price,Foodname,Foodprice FROM billing ";
            pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            billTable3.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"");
        }
          tabledata3();
    }
    
           public void tabledata3(){
        
        int r=billTable3.getSelectedRow();
        
        
        String name=billTable3.getValueAt(r,0).toString();
        
        String price=billTable3.getValueAt(r,1).toString();
            
      foodTF.setText(name);
      foodPriceTF.setText(price);
           
    }   
        
    private void setupBillTable3() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("bread");
    model.addColumn("bread Price");
  model.addColumn("fooditem");
  model.addColumn("foodprice");
    billTable3.setModel(model);
}    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        billTable1 = new javax.swing.JTable();
        breedTF = new javax.swing.JTextField();
        petPriceTF = new javax.swing.JTextField();
        foodPriceTF = new javax.swing.JTextField();
        foodTF = new javax.swing.JTextField();
        addBillBtn2 = new javax.swing.JButton();
        addBillBtn1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Food Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 150, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pet Breed");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 20));

        billTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTable2MouseClicked(evt);
            }
        });
        billTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billTable2KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(billTable2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 260, 100));

        billTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Breed", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTable1MouseClicked(evt);
            }
        });
        billTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billTable1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(billTable1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 270, 100));

        breedTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breedTFActionPerformed(evt);
            }
        });
        jPanel1.add(breedTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 150, 30));
        jPanel1.add(petPriceTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 120, 30));
        jPanel1.add(foodPriceTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 120, 30));
        jPanel1.add(foodTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 130, 30));

        addBillBtn2.setText("Add to Bill");
        addBillBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBillBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(addBillBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 160, -1));

        addBillBtn1.setText("Add to Bill");
        addBillBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBillBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(addBillBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 160, -1));

        billTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(billTable3);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 410, 150));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 470));

        setSize(new java.awt.Dimension(670, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void billTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billTable1KeyReleased

tabledata();

        // TODO add your handling code here:
    }//GEN-LAST:event_billTable1KeyReleased

    private void breedTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breedTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_breedTFActionPerformed

    private void billTable2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billTable2KeyReleased
     
        tabledata2();

// TODO add your handling code here:
    }//GEN-LAST:event_billTable2KeyReleased

    private void billTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTable1MouseClicked



        tabledata();

        // TODO add your handling code here:
    }//GEN-LAST:event_billTable1MouseClicked

    private void billTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTable2MouseClicked

    tabledata2();

        // TODO add your handling code here:
    }//GEN-LAST:event_billTable2MouseClicked

    
    
    private void addBillBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBillBtn1ActionPerformed
     
        String name;
        int price;
         
        name =breedTF.getText();
        price=Integer.parseInt(petPriceTF.getText());
        
        try {
            
            String sql="INSERT INTO billing(Bread,Price)VALUES ('"+name+"','"+price+"')"; 
            pst=conn.prepareStatement(sql);
                    pst.execute();
           
        } catch (Exception e) {
        }
        
        
        
        
        tableload3();
        
        
        
    }//GEN-LAST:event_addBillBtn1ActionPerformed

    private void addBillBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBillBtn2ActionPerformed
         
         
        String Foodname = foodTF.getText();
        int Foodprice = Integer.parseInt(foodPriceTF.getText());
        
        try {
            
            String sql="INSERT INTO billing(Foodname,foodprice)VALUES ('"+Foodname+"','"+Foodprice+"')"; 
            pst=conn.prepareStatement(sql);
                    pst.execute();
                      JOptionPane.showMessageDialog(null,"inserted");
           
        } catch (Exception e) {
        }
        
        tableload3();
        
    }//GEN-LAST:event_addBillBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBillBtn1;
    private javax.swing.JButton addBillBtn2;
    private javax.swing.JTable billTable1;
    private javax.swing.JTable billTable2;
    private javax.swing.JTable billTable3;
    private javax.swing.JTextField breedTF;
    private javax.swing.JTextField foodPriceTF;
    private javax.swing.JTextField foodTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField petPriceTF;
    // End of variables declaration//GEN-END:variables
}
