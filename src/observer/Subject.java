
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import models.Bilet;

/**
 *
 * @author Stefan
 */
public interface Subject {
    void addObserver(FObserver observer);
    void notifyObservers(Bilet bilet);
    void removeObserver(FObserver observer);
}
