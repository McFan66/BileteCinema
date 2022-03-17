/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.OraSpectacol;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Stefan
 */
public class OraSpectacolHibernateRepository implements OraSpectacolRepository {

    Session session = null;
    
    public OraSpectacolHibernateRepository(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public boolean salveazaOraSpectacol(OraSpectacol oraSpectacol) {
        if (!session.isOpen()) {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        org.hibernate.Transaction tx = session.beginTransaction();
       
        if (oraSpectacol.getId()>0){
            session.saveOrUpdate(oraSpectacol);
            tx.commit();
            return true;
        }
        int id = (int) session.save(oraSpectacol);
        oraSpectacol.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0;
    }

    @Override
    public void stergeOraSpectacol(OraSpectacol oraSpectacol) {
        try {
            if (!session.isOpen()){
                session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            session.getTransaction().begin();
            session.delete(oraSpectacol);
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
    
}
