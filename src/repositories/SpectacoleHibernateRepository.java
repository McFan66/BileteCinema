/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.Spectacol;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Stefan
 */
public class SpectacoleHibernateRepository implements SpectacoleRepository {

    Session session = null;

    public SpectacoleHibernateRepository() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void stergeSpectacol(Spectacol spectacol) {
        try {
            if (!session.isOpen()){
                session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            session.getTransaction().begin();
            session.delete(spectacol);
            // YOUR CODE

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            try {
                session.getTransaction().rollback();
            } catch (RuntimeException rbe) {

            }
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public ArrayList<Spectacol> getAll() {
      
        ArrayList<Spectacol> listaSpectacole = new ArrayList();
       
            
            try {
                 if (!session.isOpen()){
                session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            session.getTransaction().begin();
            Query q = session.createQuery("from Spectacol");
            listaSpectacole = (ArrayList<Spectacol>) q.list();
            // YOUR CODE

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            try {
                session.getTransaction().rollback();
            } catch (RuntimeException rbe) {

            }
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listaSpectacole;
    }

    @Override
    public List<Spectacol> cautareSpectacol(String titlu) {
        org.hibernate.Transaction tx = session.beginTransaction();
        Spectacol spectacol = new Spectacol();
        Query q = session.createQuery("from Spectacol where titlu like %:titlu%").setProperties(titlu);
        List<Spectacol> listaSpectacole = q.list();
        tx.commit();
        return listaSpectacole;
    }

    @Override
    public boolean salveazaSpectacol(Spectacol spectacol) {
        if (!session.isOpen()) {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        org.hibernate.Transaction tx = session.beginTransaction();
        System.out.println("Salveaza spectacol" + spectacol);
        if (spectacol.getId() != null && spectacol.getId() > 0) {
            session.saveOrUpdate(spectacol);
            tx.commit();
            return true;
        }
        int id = (int) session.save(spectacol);
        spectacol.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0;
    }

}
