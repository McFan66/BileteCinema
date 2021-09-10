
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import models.BiletB;

/**
 *
 * @author Stefan
 */
public interface Subject {
    void addObserver(FObserver observer);
    void notifyObservers(ObserverData observerData);
    void removeObserver(FObserver observer);
}
