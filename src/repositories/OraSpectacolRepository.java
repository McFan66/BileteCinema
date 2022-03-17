/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.OraSpectacol;

/**
 *
 * @author Stefan
 */
public interface OraSpectacolRepository {
    public boolean salveazaOraSpectacol(OraSpectacol oraSpectacol);
    public void stergeOraSpectacol(OraSpectacol oraSpectacol);
}
