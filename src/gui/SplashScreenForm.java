/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Cristi
 */
public class SplashScreenForm extends javax.swing.JPanel {
    
    private OnBaraCompletata onBaraCompletata;
    
    public SplashScreenForm() {
        initComponents();
        progressBar.setUI(new FancyProgressBar());
        progressBar.setBackground(new Color(255, 255, 255));
        
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
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 700, 400);
        
        try {
            BufferedImage imagine = ImageIO.read(new File("src/resources/SplashScreenLogo.png"));
            g.drawImage(imagine, 40, -5, 600, 395, null);
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            InputStream test2 = new BufferedInputStream(new FileInputStream("src/resources/PottaOne-Regular.ttf"));
            Font test = Font.createFont(Font.TRUETYPE_FONT, test2);
            test = test.deriveFont(Font.PLAIN,36);
            g.setFont(test);
            g.drawString("Cinema", 193, 180);
            g.drawString("Max", 392, 180);
            
            BufferedImage logo = ImageIO.read(new File("src/resources/logobiletalb.png"));
            g.drawImage(logo, 335, 135, 50, 62, this);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        class FancyProgressBar extends BasicProgressBarUI {

        @Override
        protected void paintDeterminate(Graphics g, JComponent c) {

            Graphics2D g2d = (Graphics2D) g.create();

           // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int iStrokWidth = 2;
            g2d.setStroke(new BasicStroke(iStrokWidth));
            g2d.setColor(new Color(0, 0, 0));

            int width = progressBar.getWidth();
            int height = progressBar.getHeight();
            
            Rectangle2D outline = new Rectangle2D.Double(iStrokWidth/2, iStrokWidth/2, width-iStrokWidth, height-iStrokWidth);

            g2d.draw(outline);

            int iInnerHeight = height - (iStrokWidth * 4);
            int iInnerWidth = width - (iStrokWidth * 4);

            double dProgress = progressBar.getPercentComplete();
            if (dProgress < 0) {
                dProgress = 0;
            } else if (dProgress > 1) {
                dProgress = 1;
            }

            iInnerWidth = (int) Math.round(iInnerWidth * dProgress);

            g2d.setPaint(new Color(0, 0, 0));
            
            Rectangle2D rect = new Rectangle2D.Double(iStrokWidth*2, iStrokWidth*2, iInnerWidth, iInnerHeight);

            g2d.fill(rect);
            g2d.dispose();
        }

        @Override
        protected void paintIndeterminate(Graphics g, JComponent c) {
            super.paintIndeterminate(g, c); //To change body of generated methods, choose Tools | Templates.
        }

    }


    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
