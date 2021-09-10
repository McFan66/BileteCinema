/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

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
public interface BiletRepository {
    public boolean adaugaBilet (Bilet bilet);
    public void stergereBilet (Bilet bilet);
    public ArrayList<Bilet> getAll ();
    public List<Bilet> cautareBiletDupaSpectacol (Spectacol spectacol);
    public List<Bilet> cautareBiletDupaLoc (int rand, int loc);
    public List<Bilet> cautareBiletDupaData (Date dataStart, Date dataSfarsit);
}
