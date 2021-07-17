/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dvdrental.Casier;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.CasierB;
import services.CasierService;
import services.CasierServiceImpl;

/**
 *
 * @author Stefan
 */
public class FrmAdministrareCasieri extends javax.swing.JDialog implements FrmAddCasier.OnCasierSaved {

    private CasierService casierService = new CasierServiceImpl();
    private ArrayList<Casier> listaCasieri;
    private DefaultTableModel defaultTableModel;
    private String[] columnNames = new String[]{"Nume Complet", "Cod Operator"};
    private String[][] data;

    /**
     * Creates new form FrmAdministrareCasieri
     */
    public FrmAdministrareCasieri(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        listaCasieri = casierService.getAll();
        data = new String[listaCasieri.size()][2];

        int x = 0;
        for (Casier c : listaCasieri) {
            data[x][0] = c.getNumeComplet();
            data[x][1] = c.getCodOperator();
            x++;
        }
        //tblCasieri.setModel(dataModel);
        defaultTableModel = new DefaultTableModel(data, columnNames);
        initComponents();
        tblCasieri.setModel(defaultTableModel);
        setTitle("Administrare Casieri");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdauga = new javax.swing.JButton();
        btnEditeaza = new javax.swing.JButton();
        btnSterge = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCasieri = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAdauga.setText("Adauga");
        btnAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdaugaActionPerformed(evt);
            }
        });

        btnEditeaza.setText("Editeaza");
        btnEditeaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditeazaActionPerformed(evt);
            }
        });

        btnSterge.setText("Sterge");
        btnSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStergeActionPerformed(evt);
            }
        });

        tblCasieri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nume Complet", "Cod Operator"
            }
        ));
        jScrollPane1.setViewportView(tblCasieri);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAdauga)
                .addGap(50, 50, 50)
                .addComponent(btnEditeaza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSterge)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdauga)
                    .addComponent(btnEditeaza)
                    .addComponent(btnSterge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdaugaActionPerformed
        FrmAddCasier addCasier = new FrmAddCasier(FrmAdministrareCasieri.this, true);
        addCasier.setOnCasierSaved(this);
        addCasier.setLocationRelativeTo(this);
        addCasier.setVisible(true);
    }//GEN-LAST:event_btnAdaugaActionPerformed

    private void btnEditeazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditeazaActionPerformed
        int index = tblCasieri.convertRowIndexToModel(tblCasieri.getSelectedRow());
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Va rugam selectati un casier.");
            return;
        }
        Casier c = listaCasieri.get(index);
        FrmAddCasier addCasier = new FrmAddCasier(FrmAdministrareCasieri.this, true, c);
        addCasier.setOnCasierSaved(this);
        addCasier.setLocationRelativeTo(this);
        addCasier.setTitle("Editeaza Casier");
        addCasier.setVisible(true);
    }//GEN-LAST:event_btnEditeazaActionPerformed

    private void btnStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStergeActionPerformed
        int index = tblCasieri.convertRowIndexToModel(tblCasieri.getSelectedRow());
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Va rugam selectati un casier.");
            return;
        }
        Casier cc = listaCasieri.get(index);
        int raspuns = JOptionPane.showConfirmDialog(this, String.format("Sunteti sigur ca vreti sa stergeti casierul %s?", cc.getNumeComplet()), "Stergere Casier", JOptionPane.YES_NO_OPTION);
        if (raspuns == JOptionPane.YES_OPTION) {
            casierService.remove(cc);
            listaCasieri = casierService.getAll();
            data = new String[listaCasieri.size()][2];

            int x = 0;
            for (Casier c : listaCasieri) {
                data[x][0] = c.getNumeComplet();
                data[x][1] = c.getCodOperator();
                x++;
            }
            defaultTableModel.setDataVector(data, columnNames);
        }
    }//GEN-LAST:event_btnStergeActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdministrareCasieri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrareCasieri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrareCasieri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrareCasieri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAdministrareCasieri dialog = new FrmAdministrareCasieri(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdauga;
    private javax.swing.JButton btnEditeaza;
    private javax.swing.JButton btnSterge;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCasieri;
    // End of variables declaration//GEN-END:variables

    @Override
    public void saveCasier(Casier cc) {
        int index = listaCasieri.indexOf(cc);
        if (index == -1) {
            listaCasieri.add(cc);
        } else {
            listaCasieri.set(index, cc);
        }
        data = new String[listaCasieri.size()][2];

        int x = 0;
        for (Casier c : listaCasieri) {
            data[x][0] = c.getNumeComplet();
            data[x][1] = c.getCodOperator();
            x++;
        }
        defaultTableModel.setDataVector(data, columnNames);
    }
}
