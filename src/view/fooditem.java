
package view;

import Model.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.ButtonGroup;

public class fooditem extends javax.swing.JFrame {

  Connection conn =null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public fooditem() {
        initComponents();
        conn=DBconnect.connect();
        tableload();
        buttonGroup();
    }

 public void tableload(){
        
        try {
            String sql="SELECT Id,Foodname,Company,Quantity,Price,Type FROM food ";
            pst =conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table3.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
        }
          
    }
     public void tabledata(){
        
        int r=table3.getSelectedRow();
        
        String id=table3.getValueAt(r,0).toString();
        String name=table3.getValueAt(r,1).toString();
         String bread=table3.getValueAt(r,2).toString();
          String age=table3.getValueAt(r,3).toString();
           String price=table3.getValueAt(r,4).toString();
            String gender=table3.getValueAt(r,5).toString();
            
            idtext.setText(id);
            nametext.setText(name);
            breadtxt.setText(bread);
            agetxt.setText(age);
            pricetxt.setText(price);
            
            
                if (gender.equals("CAT")) {
        jRadioButton1.setSelected(true);
    } else if (gender.equals("DOG")) {
        jRadioButton2.setSelected(true);
    
            
            
        
        
    }
    }
     
      public void Search(){
        
        String srch= searchbox.getText();
        try {
            String sql="SELECT * FROM food WHERE Foodname LIKE '%"+srch+"%' OR Id LIKE '%"+srch+"%'";
            pst =conn.prepareStatement(sql);
            rs =pst.executeQuery();
            table3.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
       public void update(){
        String id=idtext.getText();
        String foodname=nametext.getText();
        String company=breadtxt.getText();
        String quantity=agetxt.getText();
        String price=pricetxt.getText();
        String type = jRadioButton1.isSelected() ? "CAT" : "DOG";
        try {
            
            String sql= " UPDATE food SET Foodname='"+foodname+"',Company='"+company+"',Quantity='"+quantity+"',Price='"+price+"',Type='"+type+"'WHERE Id= '"+id+"' ";
              pst =conn.prepareStatement(sql);
              pst.execute();
              JOptionPane.showMessageDialog(null, "UPDATED");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "error");
        }
       
        
    }
        public void delete(){
        int check =JOptionPane.showConfirmDialog(null, "DO YOU WANT TO DELETE");
        
       if(check==0){
           String id=idtext.getText();
           try {
               String sql=" DELETE FROM food WHERE Id='"+id+"'";    
               pst =conn.prepareStatement(sql);
               pst.execute();
               JOptionPane.showMessageDialog(null, "DELETED");
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "ERROR");
               
               
           }
       
       } 
          
    }
            public void clear (){
        searchbox.setText("");
        idtext.setText("id");
        nametext.setText("");
        breadtxt.setText("");
        agetxt.setText("");
        pricetxt.setText("");
        
        
   }
    
    
    
       private void buttonGroup() {
       ButtonGroup group = new ButtonGroup();
       group.add(jRadioButton1);
       group.add(jRadioButton2);}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        insertbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nametext = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        breadtxt = new javax.swing.JTextField();
        agetxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        idtext = new javax.swing.JLabel();
        Idtext = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 25)); // NOI18N
        jLabel1.setText("Food Registeration");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 20, 220, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel2.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, 80, 30));

        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel2.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 23, 80, 30));

        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel2.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 23, 80, 30));

        clearbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 63, 80, 30));

        backbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        jPanel2.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 63, 90, 30));

        exitbtn.setBackground(new java.awt.Color(204, 0, 0));
        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel2.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 103, 80, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 150));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setText("food name  :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 110, -1));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setText("Company     :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel4.setText("quantity    :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, -1));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel5.setText("Price            :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));
        jPanel1.add(nametext, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, 30));
        jPanel1.add(pricetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 160, 30));

        jRadioButton1.setBackground(new java.awt.Color(153, 153, 153));
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1.setText("CAT");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(153, 153, 153));
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton2.setText("DOG");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/large_petazy.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 190));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 100, -1, 190));
        jPanel1.add(breadtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 160, 30));
        jPanel1.add(agetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 160, 30));

        table3.setBackground(new java.awt.Color(204, 255, 204));
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        table3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table3KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table3);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 400, 150));

        idtext.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        idtext.setText("id");
        jPanel1.add(idtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 120, 30));

        Idtext.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        Idtext.setText("Id number  :");
        jPanel1.add(Idtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 110, 30));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 320, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 320, -1));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jPanel8.setBackground(new java.awt.Color(153, 255, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.setBackground(new java.awt.Color(153, 255, 153));
        searchbox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEARCH", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Perpetua Titling MT", 1, 14))); // NOI18N
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel8.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 12, 270, 70));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 320, 100));

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel7.setText("Type             : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 680, 530));

        setSize(new java.awt.Dimension(695, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
 String foodname;
        String company;
        String quantity;
        int price;
        int id;

        foodname =nametext.getText();
        company=breadtxt.getText();
        quantity=agetxt.getText();
        price=Integer.parseInt(pricetxt.getText());
        String type = jRadioButton1.isSelected() ? "CAT" : "DOG";

        try {
            String sql="INSERT INTO food(Foodname,Company,Quantity,Price,Type)VALUES ('"+foodname+"','"+company+"','"+quantity+"','"+price+"','"+type+"')";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"inserted");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);

        }
        tableload();
    
    }//GEN-LAST:event_insertbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
     update();
        tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
         delete();
        tableload();
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        Mainframe b1 =new Mainframe();
        b1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked

        tabledata();
    }//GEN-LAST:event_table3MouseClicked

    private void table3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table3KeyReleased

        tabledata();

    }//GEN-LAST:event_table3KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased

      search();
    }//GEN-LAST:event_searchboxKeyReleased

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
            java.util.logging.Logger.getLogger(fooditem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fooditem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fooditem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fooditem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fooditem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Idtext;
    private javax.swing.JTextField agetxt;
    private javax.swing.JButton backbtn;
    private javax.swing.JTextField breadtxt;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel idtext;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametext;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table3;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables

    private void search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
