/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dvdrental.OraSpectacol;
import dvdrental.Spectacol;
import java.util.ArrayList;
import repositories.OraSpectacolHibernateRepository;
import repositories.OraSpectacolRepository;

/**
 *
 * @author Stefan
 */
public class OraSpectacolServiceImpl implements OraSpectacolService{

    private OraSpectacolRepository oraSpectacolRepository = new OraSpectacolHibernateRepository();
    
    @Override
    public boolean salveazaOraSpectacol(OraSpectacol oraSpectacol) {
        return oraSpectacolRepository.salveazaOraSpectacol(oraSpectacol);
    }

    @Override
    public void stergeOraSpectacol(OraSpectacol oraSpectacol) {
        oraSpectacolRepository.stergeOraSpectacol(oraSpectacol);
    }

    
    
}
