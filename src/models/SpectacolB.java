/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import observer.ObserverData;

/**
 *
 * @author Stefan
 */
public class SpectacolB implements Serializable, ObserverData {

    private static final long serialVersionUID = 7321852490118346537L;

    private int id;
    private String tipul;
    private String titlu;
    private Date dataOra;
    private String descriere;
    private int pret;
    private int durata;
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public SpectacolB(String tipul, String titlu, Date dataOra, String descriere, int pret, int durata) {
        this.tipul = tipul;
        this.titlu = titlu;
        this.dataOra = dataOra;
        this.descriere = descriere;
        this.pret = pret;
        this.durata = durata;
    }

    public SpectacolB() {
    }
    
    public SpectacolB(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public String getDescriere() {
        return descriere;
    }

    public String getTipul() {
        return tipul;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setDataOra(Date dataOra) {
        this.dataOra = dataOra;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setTipul(String tipul) {
        this.tipul = tipul;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
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
        final SpectacolB other = (SpectacolB) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        SpectacolB s1=new SpectacolB();
        s1.setId(1);
        SpectacolB s2=new SpectacolB();
        s2.setId(1);
        System.out.println(s1.equals(s2));
    }

    @Override
    public String toString() {
        return "Spectacol{" + "id=" + id + ", tipul=" + tipul + ", titlu=" + titlu + ", dataOra=" + dataOra + ", descriere=" + descriere + '}';
    }
    
    public String getDetalii() {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return String.format("%s %s %s %s", tipul, titlu, formatter.format(dataOra), pret);
    }
    
    

//    @Override
//    public String toString() {
//        return this.titlu;
//    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
