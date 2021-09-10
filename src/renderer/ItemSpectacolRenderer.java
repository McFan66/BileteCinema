/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import dvdrental.Spectacol;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


/**
 *
 * @author Stefan
 */
public class ItemSpectacolRenderer extends JLabel implements ListCellRenderer<Object> {
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Spectacol){
           Spectacol s=(Spectacol)value;
            setText(s.getDetalii());
        }
        return this;
    }
    
}
