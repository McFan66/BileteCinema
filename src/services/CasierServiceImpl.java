/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.Casier;
import repositories.CasierFileRepository;
import repositories.CasierRepository;
import utils.IdUtils;

/**
 *
 * @author Stefan
 */
public class CasierServiceImpl implements CasierService {
    private int id=IdUtils.getValueForKey("object.casier");
    private CasierRepository casierRepository = new CasierFileRepository();
    
    @Override
    public int getLastID() {
        return id;
    }

    @Override
    public Casier login(String codOperator, String parola) {
        return casierRepository.login(codOperator, parola);
    }

    @Override
    public boolean salveazaCasier(Casier casier) {
        if (casier.getId()==0){
            casier.setId(++id);
        }
        if (casierRepository.salveazaCasier(casier)){
            IdUtils.addProperty("object.casier", id);
            return true;
        }
        return false;
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
