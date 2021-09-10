/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dvdrental.Spectacol;
import java.awt.Component;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import models.SpectacolB;

/**
 *
 * @author Stefan
 */
public class SpectacolPanel extends javax.swing.JPanel implements ListCellRenderer {

    /**
     * Creates new form SpectacolPanel
     */
    public SpectacolPanel() {
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

        lblNume = new javax.swing.JLabel();
        lblTip = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblPret = new javax.swing.JLabel();
        lblImagine = new javax.swing.JLabel();
        lblOra = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(410, 166));

        lblNume.setBackground(new java.awt.Color(179, 28, 27));
        lblNume.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNume.setForeground(new java.awt.Color(255, 255, 255));
        lblNume.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNume.setText("Nume Spectacol");
        lblNume.setOpaque(true);

        lblTip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTip.setText("Tipul: Tip Spectacol");

        lblData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblData.setText("Data: Data Spectacol");

        lblPret.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPret.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPret.setText("Pret: 000 RON");

        lblImagine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/no-image-icon.png"))); // NOI18N
        lblImagine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImagine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagineMousePressed(evt);
            }
        });

        lblOra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOra.setText("Ora:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagine, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTip, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(lblPret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOra, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagine, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNume, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTip, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPret, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblImagineMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagineMousePressed

    }//GEN-LAST:event_lblImagineMousePressed
    public void setSpectacol(Spectacol spectacol) {
        if (spectacol != null) {
            lblNume.setText(spectacol.getTitlu());
            lblTip.setText(String.format("Tipul: %s", spectacol.getTipul()));
            lblPret.setText(String.format("Pret: %s RON", String.valueOf(spectacol.getPret())));
            DateFormat formatterData = new SimpleDateFormat("dd.MM.yyyy");
            DateFormat formatterOra = new SimpleDateFormat("HH:mm");
            lblOra.setText(String.format("Ora: %s", formatterOra.format(spectacol.getData())));
            Calendar c = Calendar.getInstance();
            c.setTime(spectacol.getData());
            c.add(Calendar.DAY_OF_MONTH, spectacol.getDurata());
            lblData.setText(String.format("Data: %s-%s", formatterData.format(spectacol.getData()), formatterData.format(c.getTime())));
            System.out.println(spectacol.getImagePath());
            if (spectacol.getImagePath() != null) {
                ImageIcon icon = new ImageIcon(spectacol.getImagePath());
                Image image = icon.getImage();
                Image imagineNoua = image.getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
                lblImagine.setIcon(new ImageIcon(imagineNoua));
            } else {
                ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/resources/no-image-icon.png")); // NOI18N
                Image image = icon.getImage();
                Image imagineNoua = image.getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
                lblImagine.setIcon(new ImageIcon(imagineNoua));
            }
        }
        validate();
        updateUI();
        repaint();
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Spectacol) {
            setSpectacol((Spectacol) value);
        }
        return this;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblImagine;
    private javax.swing.JLabel lblNume;
    private javax.swing.JLabel lblOra;
    private javax.swing.JLabel lblPret;
    private javax.swing.JLabel lblTip;
    // End of variables declaration//GEN-END:variables
}
