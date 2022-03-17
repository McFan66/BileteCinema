/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dvdrental.Casier;

/**
 *
 * @author Stefan
 */
public class AppSingleTone {

    private static AppSingleTone singleInstance;

    private Casier casierAutentificat;

    private AppSingleTone() {
    }

    public static AppSingleTone getAppSingleToneInstance() {
        if (singleInstance == null) {
            singleInstance = new AppSingleTone();
        }
        return singleInstance;
    }

    public void setCasierAutentificat(Casier casierAutentificat) {
        this.casierAutentificat = casierAutentificat;
    }

    public Casier getCasierAutentificat() {
        return casierAutentificat;
    }

}
