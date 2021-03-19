
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import models.Bilet;
import models.Spectacol;
import observer.FObserver;
import observer.ObserverData;
import observer.Subject;
import repositories.BiletFileRepository;
import repositories.BiletRepository;
import utils.DateUtils;
import utils.IdUtils;

/**
 *
 * @author Stefan
 */
public class BiletServiceImpl implements BiletService, Subject {

    private List<FObserver> observers = new ArrayList<>();
    private int id = IdUtils.getValueForKey("object.bilet");
    private BiletRepository biletRepository = new BiletFileRepository();

    private static BiletServiceImpl singleInstance;

    private BiletServiceImpl() {

    }

    public static BiletServiceImpl getInstance() {
        if (singleInstance == null) {
            singleInstance = new BiletServiceImpl();
        }
        return singleInstance;
    }

    @Override
    public List<Bilet> getAll() {
        return biletRepository.getAll();
    }

    @Override
    public boolean salveazaBilet(Bilet bilet) {
        if (bilet.getId() == 0) {
            bilet.setId(++id);
        }
        if (biletRepository.adaugaBilet(bilet)) {
            IdUtils.addProperty("object.bilet", id);
            notifyObservers(bilet);
            return true;
        }
        return false;
    }

    @Override
    public void remove(Bilet bilet) {
        biletRepository.stergereBilet(bilet);
    }

    @Override
    public List<Bilet> getBileteByData(Date dataInceput, Date dataFinal) {
        List<Bilet> listaBilete = new ArrayList<Bilet>();
        listaBilete = biletRepository.getAll();
        List<Bilet> listaNoua = new ArrayList<Bilet>();
        for (Bilet b : listaBilete) {
            if (dataInceput.before(b.getDataVanzare()) && dataFinal.after(b.getDataVanzare())) {
                listaNoua.add(b);
            }
        }
        return listaNoua;
    }

    @Override
    public List<Bilet> getBileteBySpectacolAndData(Spectacol spectacol, Date dataInceput, Date dataFinal) {
        List<Bilet> listaBilete = new ArrayList<Bilet>();
        listaBilete = biletRepository.getAll();
        List<Bilet> listaNoua = new ArrayList<Bilet>();
        for (Bilet b : listaBilete) {
            if (dataInceput.before(b.getDataVanzare()) && dataFinal.after(b.getDataVanzare()) && spectacol == b.getSpectacol()) {
                listaNoua.add(b);
            }
        }
        return listaNoua;
    }

    @Override
    public List<Bilet> getBileteBySpectaolDataAndOra(Spectacol spectacol, Date data, Date oraInceput, Date oraFinal) {
        List<Bilet> listaBilete = new ArrayList<Bilet>();
        listaBilete = biletRepository.getAll();
        List<Bilet> listaNoua = new ArrayList<Bilet>();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(DateUtils.resetYearMonthDayMinuteSecond(oraInceput));
        c2.setTime(DateUtils.resetYearMonthDayMinuteSecond(oraFinal));
        for (Bilet b : listaBilete) {
            Calendar c = Calendar.getInstance();
            c.setTime(DateUtils.resetYearMonthDayMinuteSecond(b.getDataVanzare()));
            c.setTime(b.getDataVanzare());
            if (spectacol == b.getSpectacol() && DateUtils.testTwoDatesEqual(data, b.getDataVanzare()) && c1.getTime().before(c.getTime()) && c2.getTime().after(c.getTime())) {
                listaNoua.add(b);
            }
        }
        return listaNoua;
    }

    @Override
    public void addObserver(FObserver observer) {
        observers.add(observer);
    }


    @Override
    public void removeObserver(FObserver observer) {
        observers.remove(observer);
    }

    @Override
    public List<Bilet> getBileteBySpectacolDataAndOra(Spectacol spectacol, Date dataOra) {
        List<Bilet> listaBilete = new ArrayList<Bilet>();
        listaBilete=biletRepository.getAll();
        List<Bilet> listaFinala = new ArrayList<Bilet>();
        for (Bilet b:listaBilete){
            if (spectacol.equals(b.getSpectacol()) && dataOra.compareTo(b.getDataOra())==0)
                listaFinala.add(b);
        }
        return listaFinala;
    }

    @Override
    public void notifyObservers(ObserverData observerData) {
        for (FObserver observer : observers) {
            observer.update(observerData);
        }
    }

}

