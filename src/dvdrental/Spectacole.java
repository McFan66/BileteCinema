package dvdrental;
// Generated Jun 25, 2021 3:38:36 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Spectacole generated by hbm2java
 */
public class Spectacole  implements java.io.Serializable {


     private int id;
     private String nume;
     private Date data;
     private int durata;
     private int pret;

    public Spectacole() {
    }

    public Spectacole(int id, String nume, Date data, int durata, int pret) {
       this.id = id;
       this.nume = nume;
       this.data = data;
       this.durata = durata;
       this.pret = pret;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNume() {
        return this.nume;
    }
    
    public void setNume(String nume) {
        this.nume = nume;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public int getDurata() {
        return this.durata;
    }
    
    public void setDurata(int durata) {
        this.durata = durata;
    }
    public int getPret() {
        return this.pret;
    }
    
    public void setPret(int pret) {
        this.pret = pret;
    }




}

