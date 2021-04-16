/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristi
 */
public class SplashScreenForm extends javax.swing.JPanel {
    
    private OnBaraCompletata onBaraCompletata;
    
    public SplashScreenForm() {
        initComponents();
        
        
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                progressBar.setMaximum(1000);
                while (i <= 1000) {
                    // progressBar.setString(String.format("%s", i));
                    progressBar.setValue(i);
                   
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FrmSplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i=i+1;
                }
                onBaraCompletata.executeOnBaraCompletata();
                
            }
            
             
            
        });
        
        th.start();
        
    }

    @Override
    protected void paintComponent(Graphics gr){
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setColor(new Color(157, 0, 102));
        g.fillRect(75, 0, getWidth()/2, getHeight()/2);
    }
    
//    private static void createAndShowGUI() {
//        JFrame f = new JFrame();
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setTitle("yolo");
//        f.getContentPane().add(new FrmSplashScreen1());
//        f.setSize(1000,1000);
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//        
//        
//
//    }
//    
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//        
//        
//    }
    
    
    public interface OnBaraCompletata{
        void executeOnBaraCompletata();
    }
    
    public void setOnBaraCompletata(OnBaraCompletata onBaraCompletata){
        this.onBaraCompletata=onBaraCompletata;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();

        progressBar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
