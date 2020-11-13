/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.Casier;

/**
 *
 * @author Stefan
 */
public interface CasierService {
    
    public int getLastID();
    public Casier login(String codOperator, String parola);
    public boolean salveazaCasier(Casier casier);
    public ArrayList<Casier> getAll();
    public void remove(Casier casier);
}
