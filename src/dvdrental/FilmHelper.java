/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.util.List;
import models.SpectacolB;
import org.hibernate.Query;
import utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Stefan
 */
public class FilmHelper {

    Session session = null;

    public FilmHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public boolean saveSpectacol(SpectacolB spectacol) {
        org.hibernate.Transaction tx = session.beginTransaction();
        int id = (int) session.save(spectacol);
        spectacol.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0;
    }

    public List getNumeSpectacole(int startID, int endID) {
        List<SpectacolB> listaSpectacole = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Spectacole as spectacole where spectacole.id between '" + startID + "' and '" + endID + "'");
            listaSpectacole = (List<SpectacolB>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaSpectacole;
    }
}
