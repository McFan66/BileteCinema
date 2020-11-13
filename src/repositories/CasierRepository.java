/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import models.Casier;

/**
 *
 * @author Stefan
 */
public interface CasierRepository {
    public boolean salveazaCasier(Casier casier);
    public void stergereCasier(Casier casier);
    public Casier login(String codOperator, String parola);
    public ArrayList<Casier> getAll();
}
