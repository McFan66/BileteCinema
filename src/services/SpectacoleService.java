/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Spectacol;

/**
 *
 * @author Stefan
 */
public interface SpectacoleService {
    
    public int getLastID();
    public boolean salveazaSpectacol(Spectacol spectacol);
    public void remove(Spectacol spectacol);
    public List<Spectacol> getAll();
    public List<Spectacol> getSpectacoleBetweenDates(Date dataInceput, Date dataFinal);
}
