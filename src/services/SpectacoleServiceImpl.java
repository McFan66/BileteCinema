/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import java.util.Date;
import models.Spectacol;
import repositories.SpectacoleFileRepository;
import repositories.SpectacoleRepository;
import utils.IdUtils;

/**
 *
 * @author Stefan
 */
public class SpectacoleServiceImpl implements SpectacoleService{

    private int id=IdUtils.getValueForKey("object.spectacol");
    private SpectacoleRepository spectacoleRepository = new SpectacoleFileRepository();
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public static void main(String[] args) {
        SpectacoleService  spectacoleService=new SpectacoleServiceImpl();
            Spectacol s1 = new Spectacol("Film", "Vizita", new Date(), "viziteaza");
//        s1.setId(1);
       Spectacol s2 = new Spectacol("Film", "Cursa", new Date(), "intrecere");
//        s2.setId(2);
        spectacoleService.salveazaSpectacol(s1);
       spectacoleService.salveazaSpectacol(s2);
       
    }
    
}
