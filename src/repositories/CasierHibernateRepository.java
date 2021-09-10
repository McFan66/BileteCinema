/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.Casier;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Stefan
 */
public class CasierHibernateRepository implements CasierRepository {

    Session session = null;

    public CasierHibernateRepository() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public boolean salveazaCasier(Casier casier) {
        org.hibernate.Transaction tx = session.beginTransaction();
       
        if (casier.getId()>0){
            session.saveOrUpdate(casier);
            tx.commit();
            return true;
        }
        int id = (int) session.save(casier);
        casier.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0;
    }

    @Override
    public void stergereCasier(Casier casier) {
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(casier);
        tx.commit();
    }

    @Override
    public Casier login(String codOperator, String parola) {
        org.hibernate.Transaction tx = session.beginTransaction();
        Casier casier = new Casier();
        casier.setCodOperator(codOperator);
        casier.setParola(parola);
        Query q = session.createQuery("FROM Casier where Cod_opetator= :codOperator and Parola= :parola").setProperties(casier);
        Casier c = (Casier) q.uniqueResult();
        tx.commit();
        return c;
    }

    @Override
    public ArrayList<Casier> getAll() {
        ArrayList<Casier> listaCasieri = new ArrayList();
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Casier");
            listaCasieri = (ArrayList<Casier>) q.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCasieri;
    }

}
