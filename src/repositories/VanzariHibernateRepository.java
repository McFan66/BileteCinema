/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.Casier;
import dvdrental.Spectacol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Vanzare;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Stefan
 */
public class VanzariHibernateRepository implements VanzariRepository{

    Session session = null;
    
    public VanzariHibernateRepository(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    @Override
    public boolean adaugaVanzare(Vanzare vanzare) {
        return false;
    }

    @Override
    public void stergeVanzare(Vanzare vanzare) {
        session.getTransaction().begin();
        session.delete(vanzare);
        session.getTransaction().commit();
    }

    @Override
    public ArrayList<Vanzare> getAll() {
        ArrayList<Vanzare> listaVanzari = new ArrayList<>();
        session.getTransaction().begin();
        Query q = session.createQuery("from Vanzari");
        listaVanzari = (ArrayList<Vanzare>) q.list();
        return listaVanzari;
        
    }

    @Override
    public List<Vanzare> cautareVanzariByData(Date dataInceput, Date dataFinal) {
       Query q = session.createQuery("from Vanzari where data between :dataInceput and :dataFinal").setDate("dataInceput", dataInceput).setDate("dataFinal", dataFinal);
       List<Vanzare> listaVanzari = q.list();
       return listaVanzari;
    }

    @Override
    public List<Vanzare> cautareVanzariBySpectacol(Spectacol spectacol) {
        Query q = session.createQuery("distinct v.vanzare from VanzareBilet v where v.bilet.spectacol.id=:idSpectacol").setProperties(spectacol.getId());
        return null;
    }

    @Override
    public List<Vanzare> cautareVanzariByCasier(Casier casier) {
        int idCasier = casier.getId();
        Query q = session.createQuery("from Vanzari where id_casier= :idCasier").setProperties(idCasier);
        List<Vanzare> listaVanzari = q.list();
        return listaVanzari;
    }
    
}
