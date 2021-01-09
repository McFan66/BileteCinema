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
public abstract class CustomLabel extends JLabel implements MouseListener {

    private int linie;
    private int coloana;
    private boolean available = true;
    private boolean vanzare;
    private Color defaultColor;
    private boolean rightClickPressed;

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
        addMouseListener(this);
        setOpaque(true);
        setFont(new Font("Tahoma", Font.BOLD, 12));
        setHorizontalAlignment(SwingConstants.CENTER);
        setText("0");
        this.defaultColor=getBackground();
    }

    public int getLinie() {
        return linie;
    }

    public void setLinie(int linie) {
        this.linie = linie;
    }

    public boolean isVanzare() {
        return vanzare;
    }

    public void setVanzare(boolean vanzare) {
        this.vanzare = vanzare;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
        setRightClickPressed(e.getButton()==MouseEvent.BUTTON3);
        if (coloana != 0) {
            
             onLabelClicked(linie, coloana);
            if (vanzare) {
                if (available && e.getButton() == MouseEvent.BUTTON1) {
                    setBackground(Color.GREEN);
                    //setRightClickPressed(false);
                    setAvailable(!available);
                }
                if (!available && e.getButton()==MouseEvent.BUTTON3 && !this.getText().equals("X")){
                    setAvailable(!available);
                    //setRightClickPressed(true);
                }
                if (available){
                    setBackground(defaultColor);
                }
            }else{
                if (e.getButton() == MouseEvent.BUTTON1) {
                    setBackground(Color.red);
                    setText("X");
                    setAvailable(!available);
                }
                if (available){
                    setBackground(defaultColor);
                }
                
            }
           
           /* if (e.getButton() == MouseEvent.BUTTON1) {
                setBackground(Color.GREEN);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                setNotAvailable(!notAvailable);
                if (notAvailable) {
                    setBackground(Color.RED);
                    setText("X");
                } else {
                    setBackground(Color.green);
                }

            }*/
        }
    }

    public boolean isRightClickPressed() {
        return rightClickPressed;
    }

    public void setRightClickPressed(boolean rightClickPressed) {
        this.rightClickPressed = rightClickPressed;
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

    public abstract void onLabelClicked(int linie, int coloana);
}
