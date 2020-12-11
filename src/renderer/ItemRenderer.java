/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import models.Spectacol;

/**
 *
 * @author Stefan
 */
public class ItemRenderer extends JLabel implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Spectacol){
           Spectacol s=(Spectacol)value;
            setText(s.getTitlu());
        }
        return this;
    }


}
