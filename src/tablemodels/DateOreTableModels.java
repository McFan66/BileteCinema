/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import dvdrental.OraSpectacol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class DateOreTableModels extends AbstractTableModel {

    private String[] columnNames = new String[]{"Ora", "Pret"};
    private List<OraSpectacol> date = new ArrayList<>();

    public DateOreTableModels() {
    }

    public DateOreTableModels(List<OraSpectacol> date) {
        this.date = date;
    }

    @Override
    public int getRowCount() {
        return date.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OraSpectacol oraSpectacol = date.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return oraSpectacol.getOra();
            case 1:
                return oraSpectacol.getPret();
            default:
                return null;
        }
    }

    public void setDate(List<OraSpectacol> date) {
        this.date = date;
    }

    public List<OraSpectacol> getDate() {
        return date;
    }

    
}
