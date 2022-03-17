package dvdrental;
// Generated Jun 25, 2021 3:38:36 PM by Hibernate Tools 4.3.1



/**
 * Persoane generated by hbm2java
 */
public class Casier  implements java.io.Serializable {


     private int id;
     private String nume;
     private String prenume;
     private String codOperator;
     private String parola;

    public String getCodOperator() {
        return codOperator;
    }

    public void setCodOperator(String codOperator) {
        this.codOperator = codOperator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Casier() {
    }

    public Casier(String nume, String prenume, String codOperator, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.codOperator = codOperator;
        this.parola = parola;
    }

    public Casier(int id, String nume, String prenume, String codOperator, String parola) {
       this.id = id;
       this.nume = nume;
       this.prenume = prenume;
       this.codOperator = codOperator;
       this.parola = parola;
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
    public String getPrenume() {
        return this.prenume;
    }
    
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNumeComplet(){
        return String.format("%s %s", nume, prenume);
    }

    @Override
    public String toString() {
        return "Casier{" + "id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", codOperator=" + codOperator + ", parola=" + parola + '}';
    }


}


