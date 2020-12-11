/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Stefan
 */
public class MyComboboxModel extends AbstractListModel implements ComboBoxModel{

    private Object selectedItem;
    private List<Object> listOfObjects;

    public MyComboboxModel() {
        listOfObjects=new ArrayList<>();
    }
    
    @Override
    public int getSize() {
        return listOfObjects.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listOfObjects.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem=anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    public void setListOfObjects(List listOfObjects) {
        this.listOfObjects = listOfObjects;
    }
    
    
}
