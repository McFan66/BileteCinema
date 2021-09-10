/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dvdrental.Bilet;
import dvdrental.Spectacol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.BiletB;
import models.SpectacolB;

/**
 *
 * @author Stefan
 */
public interface BiletService {
    
    public List<Bilet> getAll();
    public boolean salveazaBilet(Bilet bilet);
    public void remove(Bilet bilet);
    public List<Bilet> getBileteByData(Date dataInceput, Date dataFinal);
    public List<Bilet> getBileteBySpectacolAndData(Spectacol spectacol, Date dataInceput, Date dataFinal);
    public List<Bilet> getBileteBySpectaolDataAndOra(Spectacol spectacol, Date data, Date oraInceput, Date oraFinal);
    public List<Bilet> getBileteBySpectacolDataAndOra(Spectacol spectacol, Date dataOra);
    
}
