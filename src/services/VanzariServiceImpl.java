/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dvdrental.Vanzare;
import models.VanzareB;
import repositories.VanzariHibernateRepository;
import repositories.VanzariRepository;

/**
 *
 * @author Stefan
 */
public class VanzariServiceImpl implements VanzariService{

    private VanzariRepository vanzareRepository = new VanzariHibernateRepository();
    
    @Override
    public boolean salveazaVanzare(Vanzare vanzare) {
        return vanzareRepository.adaugaVanzare(vanzare);
    }

    @Override
    public void stergeVanzare(Vanzare vanzare) {
       vanzareRepository.stergeVanzare(vanzare);
       
    }
    
}
