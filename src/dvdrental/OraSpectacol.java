/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import models.IComboTextLabel;

/**
 *
 * @author Stefan
 */
public class OraSpectacol implements IComboTextLabel {

    private Integer id;
    private String ora;
    private int pret;
    private int idSpectacol;
    private Spectacol spectacol;
    private Set<Bilet> bilete = new HashSet<Bilet>(0);

    public Set<Bilet> getBilete() {
        return bilete;
    }

    public void setBilete(Set<Bilet> bilete) {
        this.bilete = bilete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public Spectacol getSpectacol() {
        return spectacol;
    }

    public void setSpectacol(Spectacol spectacol) {
        this.spectacol = spectacol;
        this.idSpectacol = spectacol.getId();
    }

    public int getIdSpectacol() {
        return idSpectacol;
    }

    public void setIdSpectacol(int idSpectacol) {
        this.idSpectacol = idSpectacol;
    }

    @Override
    public String toString() {
        return "OraSpectacol{" + "id=" + id + ", ora=" + ora + ", pret=" + pret + ", idSpectacol=" + idSpectacol + ", spectacol=" + spectacol + ", bilete=" + bilete + '}';
    }

    @Override
    public String getTextLabel() {
        return ora;
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
        final OraSpectacol other = (OraSpectacol) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Bilet> getListaBilete() {
        return new ArrayList<Bilet>(bilete);
    }

}
