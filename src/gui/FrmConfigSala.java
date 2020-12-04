/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ccomponents.CustomLabel;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import models.Casier;
import models.MatriceSerializabila;
import models.Vanzare;
import repositories.CasierFileRepository;

/**
 *
 * @author Stefan
 */
public class FrmConfigSala extends javax.swing.JDialog {

    private MatriceSerializabila matriceSerializabila;
    private File fisierConfigurareSala = new File("configSala.ser");

    /**
     * Creates new form FrmConfigSala
     */
    public FrmConfigSala(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (fisierConfigurareSala.exists()) {
            btnSalvare.setEnabled(true);
            init();
            int coloane =matriceSerializabila.getColoane()+1;
            CustomLabel[][] matrice = new CustomLabel[matriceSerializabila.getLinii()][coloane];
            spnLinii.setValue(matriceSerializabila.getLinii());
            spnColoane.setValue(matriceSerializabila.getColoane());
            panelAfisare.setLayout(new GridLayout(matriceSerializabila.getLinii(), coloane));
            for (int i = 0; i < matriceSerializabila.getLinii(); i++) {
                for (int j = 0; j < coloane; j++) {
                    matrice[i][j] = new CustomLabel(i, j) {
                        @Override
                        public void onLabelClicked(int linie, int coloana) {
                            if (!matrice[linie][coloana].isVanzare()) {
                                matriceSerializabila.enableDisable(linie, coloana - 1);
                                //matriceSerializabila.afisareMatrice();
                                int c = 1;
                                for (int i = 1; i < coloane; i++) {
                                    if (matrice[linie][i].isAvailable()) {
                                        matrice[linie][i].setText(String.valueOf(c));
                                        c++;
                                    }
                                }
                            }
                        }
                    };
                    if (j == 0) {
                        matrice[i][j].setText("R" + String.valueOf(i + 1));
                        matrice[i][j].setBackground(Color.yellow);
                    } else {
                        if (matriceSerializabila.getValuetAtLineAndColumn(i, j) == -1) {
                            matrice[i][j].setBackground(Color.red);
                            matrice[i][j].setText("X");
                            matrice[i][j].setAvailable(false);
                        } else if (matriceSerializabila.getValuetAtLineAndColumn(i, j) == 0) {
                            matrice[i][j].setAvailable(true);
                           // matrice[i][j].setBackground(Color.green);
                            matrice[i][j].setText(String.valueOf(j));
                        }
                    }

//                    if (j == 0) {
//                        matrice[i][j].setText("R" + String.valueOf(i + 1));
//                        matrice[i][j].setBackground(Color.yellow);
//                    } else {
//                        matrice[i][j].setText(String.valueOf(j));
//                    }
                    panelAfisare.add(matrice[i][j]);
                }
            }
            panelAfisare.revalidate();
            panelAfisare.repaint();
        }
        //setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAfisare = new javax.swing.JPanel();
        lblLinii = new javax.swing.JLabel();
        lblColoane = new javax.swing.JLabel();
        btnGenerare = new javax.swing.JButton();
        btnSalvare = new javax.swing.JButton();
        spnLinii = new javax.swing.JSpinner();
        spnColoane = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurare Sala Cinema");

        panelAfisare.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelAfisare.setLayout(new java.awt.GridLayout(4, 4));

        lblLinii.setText("Linii");

        lblColoane.setText("Coloane");

        btnGenerare.setText("Generare");
        btnGenerare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerareActionPerformed(evt);
            }
        });

        btnSalvare.setText("Salvare");
        btnSalvare.setEnabled(false);
        btnSalvare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvareActionPerformed(evt);
            }
        });

        spnLinii.setModel(new javax.swing.SpinnerNumberModel(3, 3, 20, 1));

        spnColoane.setModel(new javax.swing.SpinnerNumberModel(3, 3, 20, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAfisare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblLinii)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnLinii, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lblColoane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnColoane, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvare)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLinii)
                    .addComponent(spnLinii, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColoane)
                    .addComponent(spnColoane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerare)
                    .addComponent(btnSalvare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAfisare, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerareActionPerformed
        int linii = Integer.parseInt(spnLinii.getValue().toString());
        int coloane = Integer.parseInt(spnColoane.getValue().toString()) + 1;
        panelAfisare.removeAll();
        panelAfisare.setLayout(new GridLayout(linii, coloane));
        btnSalvare.setEnabled(true);
        CustomLabel[][] matrice = new CustomLabel[linii][coloane];
        matriceSerializabila = new MatriceSerializabila(linii, coloane - 1);
        for (int i = 0; i < linii; i++) {
            for (int j = 0; j < coloane; j++) {
                matrice[i][j] = new CustomLabel(i, j) {
                    @Override
                    public void onLabelClicked(int linie, int coloana) {
                        if (!matrice[linie][coloana].isVanzare()) {
                            matriceSerializabila.enableDisable(linie, coloana - 1);
                            // matriceSerializabila.afisareMatrice();
                            int c = 1;
                            for (int i = 1; i < coloane; i++) {
                                if (matrice[linie][i].isAvailable()) {
                                    matrice[linie][i].setText(String.valueOf(c));
                                    c++;
                                }
                            }
                        }
                    }
                };
                // matrice[i][j].setVanzare(true);
                if (j == 0) {
                    matrice[i][j].setText("R" + String.valueOf(i + 1));
                    matrice[i][j].setBackground(Color.yellow);
                } else {
                    matrice[i][j].setText(String.valueOf(j));
                }
                panelAfisare.add(matrice[i][j]);
            }
        }
        panelAfisare.revalidate();
        panelAfisare.repaint();

    }//GEN-LAST:event_btnGenerareActionPerformed

    private void btnSalvareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvareActionPerformed
        save();
    }//GEN-LAST:event_btnSalvareActionPerformed

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
            java.util.logging.Logger.getLogger(FrmConfigSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConfigSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConfigSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConfigSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmConfigSala dialog = new FrmConfigSala(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void save() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fout = null;
            fout = new FileOutputStream(fisierConfigurareSala);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(matriceSerializabila);
            fout.close();
        } catch (IOException ex) {
            Logger.getLogger(CasierFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fisierConfigurareSala);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            matriceSerializabila = (MatriceSerializabila) objectInputStream.readObject();
        } catch (IOException ex) {
            //  Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerare;
    private javax.swing.JButton btnSalvare;
    private javax.swing.JLabel lblColoane;
    private javax.swing.JLabel lblLinii;
    private javax.swing.JPanel panelAfisare;
    private javax.swing.JSpinner spnColoane;
    private javax.swing.JSpinner spnLinii;
    // End of variables declaration//GEN-END:variables
}
