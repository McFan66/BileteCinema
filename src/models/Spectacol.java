/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Stefan
 */
public class Spectacol implements Serializable {

    private int id;
    private String tipul;
    private String titlu;
    private Date dataOra;
    private String descriere;

    public Spectacol(String tipul, String titlu, Date dataOra, String descriere) {
        this.tipul = tipul;
        this.titlu = titlu;
        this.dataOra = dataOra;
        this.descriere = descriere;
    }

    public Spectacol() {
    }
    
    public Spectacol(int id){
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
        final Spectacol other = (Spectacol) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Spectacol s1=new Spectacol();
        s1.setId(1);
        Spectacol s2=new Spectacol();
        s2.setId(1);
        System.out.println(s1.equals(s2));
    }

}
