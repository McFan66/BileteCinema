/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Stefan
 */
public class CustomLabel extends JLabel implements MouseListener {

    private int linie;
    private int coloana;

    public CustomLabel() {
        setOpaque(true);
        setBackground(Color.red);
        setForeground(Color.WHITE);
        addMouseListener(this);
        setSize(50, 50);
        setPreferredSize(new Dimension(50, 50));
        setFont(new Font("Tahoma", Font.BOLD, 12));
        setHorizontalAlignment(SwingConstants.CENTER);
        setText("0");
    }

    public CustomLabel(int linie, int coloana) {
        this.linie = linie;
        this.coloana = coloana;
        setOpaque(true);
        setFont(new Font("Tahoma", Font.BOLD, 12));
        setText("0");

    }

    public int getLinie() {
        return linie;
    }

    public void setLinie(int linie) {
        this.linie = linie;
    }

    public int getColoana() {
        return coloana;
    }

    public void setColoana(int coloana) {
        this.coloana = coloana;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            setBackground(Color.GREEN);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            setBackground(Color.RED);
            setText("X");

        }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
