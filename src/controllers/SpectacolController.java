/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dvdrental.Spectacol;
import gui.FrmAddSpectacol;
import gui.FrmAdministrareSpectacole;
import java.awt.Component;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 *
 * @author Stefan
 */
public class SpectacolController {
    
    private FrmAddSpectacol frmAddSpectacol;
    public SpectacolController() {
       
    }
    
    public void actionCreate(JDialog parent){
        frmAddSpectacol=new FrmAddSpectacol(parent, true);
        frmAddSpectacol.setVisible(true);
    }
    
    public void saveSpectacol(){
        JTextField txtnNumeSpectacol=frmAddSpectacol.getTxtNumeSpectacol();
        String numeSpectacol=txtnNumeSpectacol.getText();
    }
    
    public void actionUpdate(){
        
    }
    
    public void actionView(){
        
    }
    
    public void actionIndex(){
        
    }
    
    public void actionDelete(){
        
    }
    
}
