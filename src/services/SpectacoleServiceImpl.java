 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import models.Bilet;
import models.Spectacol;
import observer.FObserver;
import observer.ObserverData;
import observer.Subject;
import repositories.SpectacoleFileRepository;
import repositories.SpectacoleRepository;
import utils.IdUtils;

/**
 *
 * @author Stefan
 */
public class SpectacoleServiceImpl implements SpectacoleService, Subject{

    private int id=IdUtils.getValueForKey("object.spectacol");
    private SpectacoleRepository spectacoleRepository = new SpectacoleFileRepository();
    private List<FObserver> observeri = new ArrayList<>();
    
    @Override
    public int getLastID() {
        return id;
    }

    @Override
    public boolean salveazaSpectacol(Spectacol spectacol) {
        if(spectacol.getId()==0){
            spectacol.setId(++id);
        }
        if(spectacoleRepository.salveazaSpectacol(spectacol)){
            IdUtils.addProperty("object.spectacol", id);
            return true;
        }
        return false;
    }

    @Override
    public void remove(Spectacol spectacol) {
        spectacoleRepository.stergeSpectacol(spectacol);
    }

    @Override
    public List<Spectacol> getAll() {
        return spectacoleRepository.getAll();
    }

    @Override
    public List<Spectacol> getSpectacoleBetweenDates(Date dataInceput, Date dataFinal) {
        List<Spectacol> listaSpectacole = new ArrayList<Spectacol>();
        listaSpectacole = spectacoleRepository.getAll();
        List<Spectacol> listaNoua = new ArrayList<Spectacol>();
        for (Spectacol s:listaSpectacole){
            if (s.getDataOra().after(dataInceput) && s.getDataOra().before(dataFinal))
                listaNoua.add(s);
        }
        return listaNoua;
    }
    
        public static void main(String[] args) {
        SpectacoleService  spectacoleService=new SpectacoleServiceImpl();
            Spectacol s1 = new Spectacol("Film", "Idk man", new Date(), "film actiune", 50, 20);   
//        s2.setId(2);
        spectacoleService.remove(s1);
       
    }

    @Override
    public List<Spectacol> getSpectacoleWithDurataAfterDate(Date data) {
        List<Spectacol> listaSpectacole = new ArrayList<Spectacol>();
        listaSpectacole = spectacoleRepository.getAll();
        List<Spectacol> listaNoua = new ArrayList<Spectacol>();
        for (Spectacol s:listaSpectacole){
            Calendar c = Calendar.getInstance();
            c.setTime(s.getDataOra());
            c.add(Calendar.DAY_OF_MONTH, s.getDurata());
            Date dataCalendar = c.getTime();
            if (dataCalendar.after(data))
                listaNoua.add(s);
        }
        return listaNoua;
    }

    @Override
    public void addObserver(FObserver observer) {
        observeri.add(observer);
    }

    @Override
    public void notifyObservers(ObserverData observerData) {
        for (FObserver observer:observeri){
            observer.update(observerData);
        }
    }

    @Override
    public void removeObserver(FObserver observer) {
        observeri.remove(observer);
    }
    
}
