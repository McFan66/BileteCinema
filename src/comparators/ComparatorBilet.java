/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import java.util.Comparator;
import models.Bilet;

/**
 *
 * @author Stefan
 */
public class ComparatorBilet implements Comparator<Bilet> {

    @Override
    public int compare(Bilet b1, Bilet b2) {
        return b2.getDataVanzare().compareTo(b1.getDataVanzare());
    }
    
}
