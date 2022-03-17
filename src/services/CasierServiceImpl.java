/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dvdrental.Casier;
import java.util.ArrayList;
import repositories.CasierHibernateRepository;
import repositories.CasierRepository;
import utils.IdUtils;

/**
 *
 * @author Stefan
 */
public class CasierServiceImpl implements CasierService {
    private final CasierRepository casierRepository = new CasierHibernateRepository();
    

    @Override
    public Casier login(String codOperator, String parola) {
        return casierRepository.login(codOperator, parola);
    }

    @Override
    public boolean salveazaCasier(Casier casier) {
        return casierRepository.salveazaCasier(casier);
    }

    @Override
    public ArrayList<Casier> getAll() {
        return casierRepository.getAll();
    }

    @Override
    public void remove(Casier casier) {
        casierRepository.stergereCasier(casier);
    }
    
}
