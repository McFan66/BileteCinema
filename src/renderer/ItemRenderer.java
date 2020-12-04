/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import models.Spectacol;

/**
 *
 * @author Stefan
 */
public class ItemRenderer extends BasicComboBoxRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);

        Spectacol item = (Spectacol) value;
      //  setOpaque(true);
//    if (index == -1) {
//      setText(item.getText());
//      setIcon(null);
//    } else {
//      setText(item.getText());
//      setIcon(item.getIcon());
//    }

        if (index != -1) {
            setText(item.getTitlu());
        }
        else{
            setText("--Selectati spectacolul--");
        }
        return this;
    }
}
