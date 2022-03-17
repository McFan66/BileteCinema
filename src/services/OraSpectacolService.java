/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dvdrental.OraSpectacol;
import dvdrental.Spectacol;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public interface OraSpectacolService {
    public boolean salveazaOraSpectacol(OraSpectacol oraSpectacol);
    public void stergeOraSpectacol(OraSpectacol oraSpectacol);
}
