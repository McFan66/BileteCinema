/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.Bilet;
import dvdrental.Spectacol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import utils.HibernateUtil;

/**
 *
 * @author Stefan
 */
public class BiletHibernateRepository implements BiletRepository {

    Session session = null;

    public BiletHibernateRepository() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public boolean adaugaBilet(Bilet bilet) {

        if (!session.isOpen()) {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        org.hibernate.Transaction tx = session.beginTransaction();
        if (bilet.getId() != null && bilet.getId() > 0) {
            session.saveOrUpdate(bilet);
            tx.commit();
            return true;
        }
        int id = (int) session.save(bilet);
        bilet.setId(id);
        if (id > 0) {
            tx.commit();
        } else {
            tx.rollback();
        }
        return id > 0;
    }

    @Override
    public void stergereBilet(Bilet bilet) {

        session.getTransaction().begin();
        session.delete(bilet);

        session.getTransaction().commit();

    }

    @Override
    public ArrayList<Bilet> getAll() {
        ArrayList<Bilet> listaBilete = new ArrayList();

        session.getTransaction().begin();
        Query q = session.createQuery("from Bilet");
        listaBilete = (ArrayList<Bilet>) q.list();
        // YOUR CODE

        session.getTransaction().commit();

        return listaBilete;
    }

    @Override
    public List<Bilet> cautareBiletDupaSpectacol(Spectacol spectacol) {
        int idSpectacol = spectacol.getId();
        Query q = session.createQuery("from Bilet where idSpectacol= :idSpectacol").setProperties(idSpectacol);
        List<Bilet> listaBilete = q.list();
        return listaBilete;
    }

    @Override
    public List<Bilet> cautareBiletDupaLoc(int rand, int loc) {
        Bilet bilet = new Bilet();
        bilet.setRand(rand);
        bilet.setLoc(loc);
        Query q = session.createQuery("from Bilet where rand= :rand and loc= :loc").setProperties(bilet);
        List<Bilet> listaBilete = q.list();
        return listaBilete;
    }

    @Override
    public List<Bilet> cautareBiletDupaData(Date dataStart, Date dataSfarsit) {
        Query q = session.createQuery("from Bilete where data between :dataStart and :dataSfarsit").setDate("dataStart", dataStart).setDate("dataSfarsit", dataSfarsit);
        List<Bilet> listaBilete = q.list();
        return listaBilete;
    }

    @Override
    public int selectMaxNumarBilet() {
        Criteria criteria = session
                .createCriteria(Bilet.class)
                .setProjection(Projections.max("numarBilet"));
        Integer maxNumarBilet = (Integer) criteria.uniqueResult();
        return maxNumarBilet;
    }

}
