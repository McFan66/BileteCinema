/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.Casier;
import dvdrental.Spectacol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Vanzare;

/**
 *
 * @author Stefan
 */
public interface VanzariRepository {
    public boolean adaugaVanzare(Vanzare vanzare);
    public void stergeVanzare(Vanzare vanzare);
    public ArrayList<Vanzare> getAll();
    public List<Vanzare> cautareVanzariByData(Date dataInceput, Date dataFinal);
    public List<Vanzare> cautareVanzariBySpectacol(Spectacol spectacol);
    public List<Vanzare> cautareVanzariByCasier (Casier casier);
}
