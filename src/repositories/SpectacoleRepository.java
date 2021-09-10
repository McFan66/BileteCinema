/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.Spectacol;
import java.util.ArrayList;
import java.util.List;
import models.SpectacolB;

/**
 *
 * @author Stefan
 */
public interface SpectacoleRepository {
   // public void adaugaSpectacol (Spectacol spectacol);
   // public void editareSpectacol (Spectacol spectacol);
    public void stergeSpectacol (Spectacol spectacol);
    public ArrayList<Spectacol> getAll();
    public List<Spectacol> cautareSpectacol(String titlu);
    public boolean salveazaSpectacol(Spectacol spectacol);
}
