/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import repositories.SpectacoleFileRepository;
import repositories.SpectacoleRepository;

class MyComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List objects;
    private Object selectedObject;
    
    public Object getElementAt(int index) {
        return objects.get(index);
    }
    
    public int getSize() {
        return objects.size();
    }
    
    public void setSelectedItem(Object anItem) {
        selectedObject = anItem; // to select and register an
    } // item from the pull-down list

    // Methods implemented from the interface ComboBoxModel
    public Object getSelectedItem() {
        return selectedObject; // to add the selection to the combo box
    }
    
    public void setObjects(List objects) {
        this.objects = objects;
    }
    
}

public class JComboBoxModel {
    
    public static void main(String[] a) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpectacoleRepository spectacoleFileRepository = new SpectacoleFileRepository();
        MyComboBoxModel model = new MyComboBoxModel();
        List spectacole=spectacoleFileRepository.getAll();
        System.out.println(spectacole);
        model.setObjects(spectacoleFileRepository.getAll());
        JComboBox cbox = new JComboBox(model);        
        cbox.setMaximumRowCount(5);        
        frame.add(cbox);        
        
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
    
}
