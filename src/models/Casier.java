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
public class Casier implements Serializable {

    private static final long serialVersionUID = -1299534847589271528L;
    
    private int id;
    private String numePrenume;
    private String codOperator;
    private String parola;

    public Casier(String numePrenume, String codOperator, String parola) {
        this.numePrenume = numePrenume;
        this.codOperator = codOperator;
        this.parola = parola;
    }

    public Casier(int id, String numePrenume, String codOperator, String parola) {
        this.id = id;
        this.numePrenume = numePrenume;
        this.codOperator = codOperator;
        this.parola = parola;
    }
    
    

    public Casier() {
    }

    public String getCodOperator() {
        return codOperator;
    }

    public String getNumePrenume() {
        return numePrenume;
    }

    public String getParola() {
        return parola;
    }

    public void setCodOperator(String codOperator) {
        this.codOperator = codOperator;
    }

    public void setNumePrenume(String numePrenume) {
        this.numePrenume = numePrenume;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        final Casier other = (Casier) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Casier{" + "id=" + id + ", numePrenume=" + numePrenume + ", codOperator=" + codOperator + ", parola=" + parola + '}';
    }
    
    
}
