/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import dvdrental.Bilet;
import java.util.Comparator;
import models.BiletB;

/**
 *
 * @author Stefan
 */
public class ComparatorBilet implements Comparator<Bilet> {

    @Override
    public int compare(Bilet b1, Bilet b2) {
        return b2.getData().compareTo(b1.getData());
    }
    
}
