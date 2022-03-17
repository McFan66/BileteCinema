package dvdrental;
// Generated Jun 25, 2021 3:38:36 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Vanzari generated by hbm2java
 */
public class Vanzare  implements java.io.Serializable {


     private Integer id;
     private Integer idCasier;
     private Date data;
     private int suma;
  private Set<Bilet> bilete
            = new HashSet<Bilet>(0);
    public Vanzare() {
    }

    public  Vanzare(Integer id,  Integer idCasier, Date data, int suma) {
       this.id = id;
       this.idCasier = idCasier;
       this.data = data;
       this.suma = suma;
    }
    
    public Vanzare(Date data, int suma){
        this.data = data;
        this.suma = suma;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdCasier() {
        return this.idCasier;
    }
    
    public void setIdCasier(Integer idCasier) {
        this.idCasier = idCasier;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public int getSuma() {
        return this.suma;
    }
    
    public void setSuma(int suma) {
        this.suma = suma;
    }

    public Set<Bilet> getBilete() {
        return bilete;
    }

    public void setBilete(Set<Bilet> bilete) {
        this.bilete = bilete;
    }




}


