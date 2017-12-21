/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snv_app;

import MesClasses.Cnx;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author xor
 */
public class Tableau_de_produit extends javax.swing.JFrame {

    Connection cn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    DefaultTableModel tm;
    
    public Tableau_de_produit() {
         
        initComponents();
         setExtendedState(Tableau_de_produit.MAXIMIZED_BOTH);
        tm=(DefaultTableModel)jTable1.getModel();
        
        
        get_id.setVisible(false);
        get_nom.setVisible(false);
        get_qte.setVisible(false);
        
        
    }

    public void show_table () {
        
        tm=(DefaultTableModel)jTable1.getModel();
        cn=Cnx.connect();
        
        String sql = "select id,Nom_prod,qte,date_format(Date_entree,'%d-%m-%Y'),fournisseur from produit_entree order by Date_entree desc " ;
      
        try {
            
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while (rs.next()) {
                if (rs.getInt(3)<300 && rs.getInt(3)>0) {
                tm.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
               
            }
                else {
                    tm.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            }
            
        }catch (SQLException ex) {
         Logger.getLogger(Tableau_de_produit.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_des = new javax.swing.JButton();
        btn_res_prod = new javax.swing.JButton();
        btn_stk = new javax.swing.JButton();
        get_id = new javax.swing.JTextField();
        get_nom = new javax.swing.JTextField();
        get_qte = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btn_des.setText("Déstocker");
        btn_des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desActionPerformed(evt);
            }
        });

        btn_res_prod.setText("Annuler une action :");
        btn_res_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_res_prodActionPerformed(evt);
            }
        });

        btn_stk.setText("Stocker");
        btn_stk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stkActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numéro de produit", "Désignation", "Quantité", "Date d'entrée", "Fournisseur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btn_res_prod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_des)
                .addGap(18, 18, 18)
                .addComponent(btn_stk)
                .addGap(18, 18, 18)
                .addComponent(get_id, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(get_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(get_qte, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_des)
                    .addComponent(btn_res_prod)
                    .addComponent(btn_stk)
                    .addComponent(get_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(get_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(get_qte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu");

        jMenuItem1.setText("Menu pricipal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        show_table();
        
    }//GEN-LAST:event_formWindowOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int sri = jTable1.getSelectedRow();
        
        
        get_id.setText(model.getValueAt(sri,0).toString());
        get_nom.setText(model.getValueAt(sri, 1).toString());
        get_qte.setText(model.getValueAt(sri,2).toString());
        
        
        try {
            int i = Integer.parseInt(get_qte.getText());
            if (i == 0) {
              btn_des.setEnabled(false);
          } else {
              btn_des.setEnabled(true);
          }
            
        }catch(NumberFormatException ex){
}
          
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
        Menu_Admin ma = new Menu_Admin();
        ma.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_stkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stkActionPerformed

        Interface_stocke stk = new Interface_stocke();

        String get_idd = get_id.getText();
        String get_nomm = get_nom.getText();
        String get_qtee = get_qte.getText();

        if (get_idd.equals("") || get_nomm.equals(""))

        {
            JOptionPane.showMessageDialog(null,"Veuillez sélectioner une ligne","Attention",JOptionPane.ERROR_MESSAGE);
        } else {

            stk.prod_selected.setText(get_nomm);
            stk.ref.setText(get_idd);
            stk.qte_stk.setText(get_qtee);
            stk.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_stkActionPerformed

    private void btn_res_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_res_prodActionPerformed

    }//GEN-LAST:event_btn_res_prodActionPerformed

    private void btn_desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desActionPerformed

        Destockage des = new Destockage();

        String get_idd = get_id.getText();
        String get_nomm = get_nom.getText();
        String get_qtee = get_qte.getText();

        if (get_idd.equals("") || get_nomm.equals(""))

        {
            JOptionPane.showMessageDialog(null,"Veuillez sélectioner une ligne","Attention",JOptionPane.ERROR_MESSAGE);
        } else {
            des.prod_selected.setText(get_nomm);
            des.id_selected.setText(get_idd);
            des.qte_stk.setText(get_qtee);

            des.setVisible(true);
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btn_desActionPerformed

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
            java.util.logging.Logger.getLogger(Tableau_de_produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tableau_de_produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tableau_de_produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tableau_de_produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tableau_de_produit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_des;
    private javax.swing.JButton btn_res_prod;
    private javax.swing.JButton btn_stk;
    public javax.swing.JTextField get_id;
    public javax.swing.JTextField get_nom;
    public javax.swing.JTextField get_qte;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
