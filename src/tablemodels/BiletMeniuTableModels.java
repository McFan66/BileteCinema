/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import dvdrental.Bilet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class BiletMeniuTableModels extends AbstractTableModel{

    private List<Bilet> date = new ArrayList<Bilet>();
    private String[] columnNames = new String[]{"Numele Spectacolului", "Data si Ora", "Pretul", "Randul si locul"};

    public BiletMeniuTableModels() {
    }
    
    

    public BiletMeniuTableModels(List<Bilet> date) {
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
        Bilet bilet = date.get(rowIndex);
        DateFormat formatterData = new SimpleDateFormat("dd.MM.yyyy");
        
        String dataSiOra = new String();
        dataSiOra = String.valueOf(formatterData.format(bilet.getSpectacol().getData()) + " " + bilet.getOraSpectacol().getOra());
        String randulSiLocul = new String();
        randulSiLocul = String.valueOf("Rand: " + bilet.getRand() + "   Loc: " + bilet.getLocReal());
        switch (columnIndex){
            case 0:
                return bilet.getSpectacol().getTitlu();
            case 1:
                return dataSiOra;
            case 2:
                return String.valueOf(bilet.getOraSpectacol().getPret() + " RON");
            case 3:
                return randulSiLocul;
            default:
                return null;
        }
    }

    public List<Bilet> getDate() {
        return date;
    }

    public void setDate(List<Bilet> date) {
        this.date = date;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
    
    
}
