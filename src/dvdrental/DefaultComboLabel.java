/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import models.IComboTextLabel;

/**
 *
 * @author Stefan
 */
public class DefaultComboLabel implements IComboTextLabel {

    private final String label;

    public DefaultComboLabel(String label) {
        this.label = label;
    }

    @Override
    public String getTextLabel() {
        return label;
    }

}
