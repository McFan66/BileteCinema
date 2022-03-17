/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import dvdrental.Bilet;
import gui.TicketForm;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import models.BiletB;

/**
 *
 * @author Stefan
 */
public class ItemBiletListRenderer extends JPanel implements ListCellRenderer<Bilet> {

    private Bilet bilet;
    private SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat sdfOra = new SimpleDateFormat("HH:mm");

    public ItemBiletListRenderer() {
        initComponents(); 
    }
    
    

   @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;

        // Dreptunghi stanga rosu
        g.setColor(new Color(157, 0, 102));
        //g.fillRect(0, 0, 75, getHeight());
        double diameter = 50d;
        double xValueInset = diameter * 0.05d;
        double yValueInset = diameter * 2d / 3d;
        int inaltime=7;
        GeneralPath margine = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 26);
        margine.moveTo(0, 0);
        margine.lineTo(75, 0);
        margine.lineTo(75, getHeight());
        margine.lineTo(0, getHeight());
        //margine.lineTo(0, getHeight() / 2 + 25);
        //margine.curveTo(0, getHeight()/2+25, 40, getHeight()/2, 0, getHeight()/2-25);
        //margine.curveTo(yValueInset, getHeight() / 2 + diameter / 2 - xValueInset, yValueInset, getHeight() / 2 - diameter / 2 + xValueInset, 0, getHeight() / 2 - 25);
        //   margine.curveTo(50 * 0.05, 25*4/3, 40, getHeight()/2-20, 0, getHeight()/2-25);
        margine.lineTo(0, getHeight()/2+98);
        margine.curveTo(inaltime, getHeight()/2+96, inaltime, getHeight()/2+90, 0, getHeight()/2+88);
        margine.lineTo(0, getHeight()/2+83);
        margine.curveTo(inaltime, getHeight()/2+81, inaltime, getHeight()/2+75, 0, getHeight()/2+73);
        margine.lineTo(0, getHeight()/2+68);
        margine.curveTo(inaltime, getHeight()/2+66, inaltime, getHeight()/2+60, 0, getHeight()/2+58);
        margine.lineTo(0, getHeight()/2+53);
        margine.curveTo(inaltime, getHeight()/2+51, inaltime, getHeight()/2+45, 0, getHeight()/2+43);
        margine.lineTo(0, getHeight()/2+38);
        margine.curveTo(inaltime, getHeight()/2+36, inaltime, getHeight()/2+30, 0, getHeight()/2+28);
        margine.lineTo(0, getHeight()/2+25);
        margine.curveTo(32, getHeight()/2+23, 32, getHeight()/2-23, 0, getHeight()/2-25);
        margine.lineTo(0, getHeight()/2-28);
        margine.curveTo(inaltime, getHeight()/2-30, inaltime, getHeight()/2-36, 0, getHeight()/2-38);
        margine.lineTo(0, getHeight()/2-43);
        margine.curveTo(inaltime, getHeight()/2-45, inaltime, getHeight()/2-51, 0, getHeight()/2-53);
        margine.lineTo(0, getHeight()/2-58);
        margine.curveTo(inaltime, getHeight()/2-60, inaltime, getHeight()/2-66, 0, getHeight()/2-68);
        margine.lineTo(0, getHeight()/2-73);
        margine.curveTo(inaltime, getHeight()/2-75, inaltime, getHeight()/2-81, 0, getHeight()/2-83);
        margine.lineTo(0, getHeight()/2-88);
        margine.curveTo(inaltime, getHeight()/2-90, inaltime, getHeight()/2-96, 0, getHeight()/2-98);
        margine.lineTo(0, 0);
        margine.closePath();
        g.draw(margine);
        g.fill(margine);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //Fundal
        g.setColor(new Color(234, 213, 188));
        g.fillRect(75, 0, getWidth() - 75, getHeight());

        //Chenar
        g.setColor(new Color(157, 0, 102));
        float thickness = 1.8f;
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(thickness));
        g.drawRect(85, 10, getWidth() - 95, getHeight() - 20);
        g.setStroke(oldStroke);

        // g.setColor(Color.BLACK);
        //g.draw(createDefaultStar(50, 200, 200));
        //Stele
        g.setPaint(Color.white);
        g.fill(createStar(40, getHeight()/6, 5, 11, 5, 90));
        g.fill(createStar(40, getHeight()/6*2, 5, 11, 5, 90));
        g.fill(createStar(40, getHeight()/6*3, 5, 11, 5, 90));
        g.fill(createStar(40, getHeight()/6*4, 5, 11, 5, 90));
        g.fill(createStar(40, getHeight()/6*5, 5, 11, 5, 90));

       // g.setColor(new Color(255, 0, 0, 100));
        //g.fillArc(-30, 71, 50, 50, 90, -180);

        //chenare
        thickness = 1.5f;
        g.setColor(new Color(157, 0, 102));
        g.setStroke(new BasicStroke(thickness));
        g.drawRect(85, getHeight() - 60, 75, 50);
        g.drawRect(160, getHeight() - 60, 75, 50);
        g.drawRect(235, getHeight() - 60, 75, 50);
        g.drawRect(310, 10, getWidth() - 95 - 75 - 75 - 75, getHeight() - 20);
        g.drawRect(310, 10, 0, getHeight()-20-50);
        g.drawRect(85, getHeight() - 60, 225, 0);
        g.setStroke(oldStroke);

        //text
        g.setColor(new Color(66, 66, 66));
        g.setFont(new Font("Arial", Font.BOLD, 13));
        g.drawString("RAND", 90, getHeight()-60+20);
        g.drawString("LOC", 90, getHeight()-60+38);
        g.drawString("PRET", 180, getHeight()-60+20);
        g.drawString(String.valueOf(bilet.getRand()+1), 132, getHeight()-60+20);
        g.drawString(String.valueOf(bilet.getLoc()), 123, getHeight()-60+38);
      //  g.drawString(String.valueOf(bilet.getSpectacol().getPret()) + " RON", 175, getHeight()-60+38);
        g.drawString(String.valueOf(bilet.getOraSpectacol().getPret() + " RON"), 175, getHeight()-60+38);
      
        g.drawString(sdfData.format(bilet.getSpectacol().getData()), 240, getHeight()-60+20);
        g.drawString(bilet.getOraSpectacol().getOra(), 255, getHeight()-60+38);

        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("BILET INTRARE", 117, 85);

        
        Font tnm=new Font("Times New Roman", Font.PLAIN, 24);
        g.setFont(tnm);
        FontMetrics lungime = g.getFontMetrics(tnm);
        Rectangle2D caseta = lungime.getStringBounds(bilet.getSpectacol().getTitlu(), g);
        
        int x = (int) (85+(getWidth()-62-85-15-caseta.getWidth())/2);
        System.out.println(getWidth());
        g.drawString(bilet.getSpectacol().getTitlu(), x, 110);

        Font font = new Font("Lucida Console", Font.BOLD, 25);

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(-90), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        g.setFont(rotatedFont);
        g.drawString(String.format("%010d", bilet.getNumarBilet()), getWidth()-10-23, getHeight()-20);
        
        
//        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("PottaOne-Regular.");
//        Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48f);
        
        try {
            InputStream test2 = new BufferedInputStream(new FileInputStream("src/resources/PottaOne-Regular.ttf"));
            Font test = Font.createFont(Font.TRUETYPE_FONT, test2);
            test = test.deriveFont(Font.PLAIN,28);
            g.setFont(test);
            g.drawString("Cinema", 97, 50);
            g.drawString("Max", 240, 50);
            } catch (FontFormatException ex) {
            Logger.getLogger(TicketForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TicketForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            BufferedImage logo = ImageIO.read(new File("src/resources/logobilet.png"));
        
            g.drawImage(logo, 203, 18, 35, 45, null);
            } catch (IOException ex) {
            Logger.getLogger(TicketForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
//        g.setPaint(new RadialGradientPaint(
//                new Point(400, 200), 60, new float[]{0, 1},
//                new Color[]{Color.RED, Color.YELLOW}));
// g.fill(createStar(400, 200, 20, 60, 8, 0));
//        g.setPaint(new RadialGradientPaint(
//                new Point(200, 400), 50, new float[]{0, 0.3f, 1},
//                new Color[]{Color.RED, Color.YELLOW, Color.ORANGE}));
//        g.fill(createStar(200, 400, 40, 50, 20, 0));
        
        
    }

    private static Shape createDefaultStar(double radius, double centerX,
            double centerY) {
        return createStar(centerX, centerY, radius, radius * 2.63, 5,
                Math.toRadians(-18));
    }

    private static Shape createStar(double centerX, double centerY,
            double innerRadius, double outerRadius, int numRays,
            double startAngleRad) {
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++) {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0) {
                relX *= outerRadius;
                relY *= outerRadius;
            } else {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0) {
                path.moveTo(centerX + relX, centerY + relY);
            } else {
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(400, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 166, Short.MAX_VALUE)
        );
    }// </editor-fold>            

    @Override
    public Component getListCellRendererComponent(JList<? extends Bilet> list, Bilet value, int index, boolean isSelected, boolean cellHasFocus) {
        setBilet(value);
        return this;
    }

    public void setBilet(Bilet bilet) {
        this.bilet = bilet;
        validate();
        
        updateUI();
        //repaint();
        System.out.println("ne actualizam");
    }

}
