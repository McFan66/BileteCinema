/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.Date;
import java.util.List;
import models.Bilet;
import models.Spectacol;

/**
 *
 * @author Stefan
 */
public interface BiletRepository {
    public boolean adaugaBilet (Bilet bilet);
    public void editareBilet (Bilet bilet);
    public void stergereBilet (Bilet bilet);
    public List<Bilet> getAll ();
    public List<Bilet> cautareBiletDupaSpectacol (Spectacol spectacol);
    public List<Bilet> cautareBiletDupaLoc (int rand, int loc);
    public List<Bilet> cautareBiletDupaData (Date dataStart, Date dataSfarsit);

}
