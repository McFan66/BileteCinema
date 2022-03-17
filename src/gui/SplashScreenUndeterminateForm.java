/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
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
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Stefan
 */
public class SplashScreenUndeterminateForm extends javax.swing.JPanel {

    /**
     * Creates new form SplashScreenUndeterminateForm
     */
    public SplashScreenUndeterminateForm() {
        initComponents();
        UIManager.put("ProgressBar.cycleTime", new Integer(1500));
        progressBar.setVisible(true);
        progressBar.setIndeterminate(true);
        progressBar.setUI(new FancyProgressBar());
        progressBar.setBackground(new Color(255, 255, 255));
        progressBar.setSize(50, 10);
        

    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, -20, 200, 185);

        try {
            BufferedImage imagine = ImageIO.read(new File("src/resources/SplashScreenLogo.png"));
            g.drawImage(imagine, 10, -5, 190, 120, null);
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            InputStream test2 = new BufferedInputStream(new FileInputStream("src/resources/PottaOne-Regular.ttf"));
            Font test = Font.createFont(Font.TRUETYPE_FONT, test2);
            test = test.deriveFont(Font.PLAIN, 15);
            g.setFont(test);
            g.drawString("Cinema", 40, 60);
            g.drawString("Max", 120, 60);

            BufferedImage logo = ImageIO.read(new File("src/resources/logobiletalb.png"));
            g.drawImage(logo, 95, 39, 25, 31, this);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(getHeight() + " " + getWidth());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();

        progressBar.setMinimumSize(new java.awt.Dimension(10, 18));
        progressBar.setPreferredSize(new java.awt.Dimension(82, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            int width = 100;//SplashScreenUndeterminateForm.this.getWidth()/6*4;
            int height = progressBar.getHeight()/2;

            Rectangle2D outline = new Rectangle2D.Double(iStrokWidth / 2, iStrokWidth / 2, width - iStrokWidth, height - iStrokWidth);
            

            g2d.draw(outline);

            int iInnerHeight = height - (iStrokWidth * 4);
            int iInnerWidth = width - (iStrokWidth * 4);

//            double dProgress = progressBar.getPercentComplete();
//            if (dProgress < 0) {
//                dProgress = 0;
//            } else if (dProgress > 1) {
//                dProgress = 1;
//            }
//
//            iInnerWidth = (int) Math.round(iInnerWidth * dProgress);

            g2d.setPaint(new Color(0, 0, 0));

            Rectangle2D rect = new Rectangle2D.Double(iStrokWidth * 2, iStrokWidth * 2, 1, iInnerHeight);

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
