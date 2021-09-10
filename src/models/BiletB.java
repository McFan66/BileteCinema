/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dvdrental.Spectacol;
import java.io.Serializable;
import java.util.Date;
import observer.ObserverData;

/**
 *
 * @author Stefan
 */
public class BiletB implements Serializable, ObserverData {

    private int id;
    private int numarBilet;
    private Spectacol spectacol;
    private Date dataOra;
    private int loc;
    private int rand;
    private Date dataVanzare;
    private int locReal;

    public int getLocReal() {
        return locReal;
    }

    public void setLocReal(int locReal) {
        this.locReal = locReal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataVanzare() {
        return dataVanzare;
    }

    public void setDataVanzare(Date dataVanzare) {
        this.dataVanzare = dataVanzare;
    }

    public BiletB(int numarBilet, Spectacol spectacol, int loc, int rand) {
        this.numarBilet = numarBilet;
        this.spectacol = spectacol;
        this.loc = loc;
        this.rand = rand;
    }

    public BiletB() {
    }

    public BiletB(int id) {
        this.id = id;
    }

    public int getLoc() {
        return loc;
    }

    public int getNumarBilet() {
        return numarBilet;
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

    public void setRand(int rand) {
        this.rand = rand;
    }

    public void setSpectacol(Spectacol spectacol) {
        this.spectacol = spectacol;
    }

    public String getNumeSpectacol() {
        return spectacol.getTitlu();
    }

    public String getDetalii() {
        return String.format("Bilet: Randul %s, Locul %s", rand+1, loc);
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
        final BiletB other = (BiletB) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public void setDataOra(Date dataOra) {
        this.dataOra = dataOra;
    }

    @Override
    public String toString() {
        return "Bilet{" + "id=" + id + ", numarBilet=" + numarBilet + ", spectacol=" + spectacol + ", loc=" + loc + ", rand=" + rand + '}';
    }

}
