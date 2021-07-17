/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Stefan
 */
public class Vanzare {
    private CasierB casier;
    private int id;
    private Date dataOra;
    private ArrayList<Bilet> bilete;

    public Vanzare(CasierB casier, int id, Date dataOra, ArrayList bilete){
        this.casier=casier;
        this.id=id;
        this.dataOra=dataOra;
        this.bilete=bilete;
    }
    
    public Vanzare(){
        
    }
    public ArrayList<Bilet> getBilete() {
        return bilete;
    }

    public CasierB getCasier() {
        return casier;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public int getId() {
        return id;
    }

    public void setBilete(ArrayList<Bilet> bilete) {
        this.bilete = bilete;
    }

    public void setCasier(CasierB casier) {
        this.casier = casier;
    }

    public void setDataOra(Date dataOra) {
        this.dataOra = dataOra;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
