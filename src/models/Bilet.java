/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class Bilet implements Serializable {
    private int id;
    private int numarBilet;
    private Spectacol spectacol;
    private int pret;
    private int loc;
    private int rand;

    public Bilet(int numarBilet, Spectacol spectacol, int pret, int loc, int rand) {
        this.numarBilet = numarBilet;
        this.spectacol = spectacol;
        this.pret = pret;
        this.loc = loc;
        this.rand = rand;
    }

    public Bilet() {
    }
    
    public Bilet (int id){
        this.id = id;
    }

    public int getLoc() {
        return loc;
    }

    public int getNumarBilet() {
        return numarBilet;
    }

    public int getPret() {
        return pret;
    }

    public int getRand() {
        return rand;
    }

    public Spectacol getSpectacol() {
        return spectacol;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public void setNumarBilet(int numarBilet) {
        this.numarBilet = numarBilet;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

    public void setSpectacol(Spectacol spectacol) {
        this.spectacol = spectacol;
    }
    
    public String getNumeSpectacol() {
    return spectacol.getTitlu();
    }
    
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bilet other = (Bilet) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
