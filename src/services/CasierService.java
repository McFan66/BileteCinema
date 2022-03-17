/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dvdrental.Casier;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public interface CasierService {
    
    public Casier login(String codOperator, String parola);
    public boolean salveazaCasier(Casier casier);
    public ArrayList<Casier> getAll();
    public void remove(Casier casier);
}
