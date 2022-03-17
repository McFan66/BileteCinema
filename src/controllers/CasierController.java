/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dvdrental.Casier;
import gui.FrmAddCasier;
import gui.FrmAdministrareCasieri;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import services.CasierService;
import services.CasierServiceImpl;

/**
 *
 * @author Stefan
 */
public class CasierController {

    private FrmAddCasier frmAddCasier;
    private FrmAdministrareCasieri frmAdministrareCasieri;
    private Casier casierSelectat;
    private CasierService casierService = new CasierServiceImpl();
    private OnCasierSaved onCasierSaved;
    private ArrayList<Casier> listaCasieri;
    private String[][] data;
    private DefaultTableModel defaultTableModel;
    private String[] columnNames = new String[]{"Nume Complet", "Cod Operator"};

    public void actionCreate(JDialog parent) {
        frmAddCasier = new FrmAddCasier(parent, true);
        frmAddCasier.setCasierController(this);
        frmAddCasier.setLocationRelativeTo(parent);
        frmAddCasier.setVisible(true);
    }
    
    public void actionIndex(Frame parent){
        frmAdministrareCasieri = new FrmAdministrareCasieri(parent, true);
        frmAdministrareCasieri.setCasierController(this);
        frmAdministrareCasieri.setLocationRelativeTo(parent);
        frmAdministrareCasieri.setVisible(true);
    }
    
    public void actionEdit(JDialog parent){
        JTable tblCasieri = frmAdministrareCasieri.getTblCasieri();
        int index = tblCasieri.convertRowIndexToModel(tblCasieri.getSelectedRow());
        if (index == -1) {
            JOptionPane.showMessageDialog(frmAdministrareCasieri, "Va rugam selectati un casier.");
            return;
        }
        Casier c = listaCasieri.get(index);
        frmAddCasier = new FrmAddCasier(parent, true, c);
        frmAddCasier.setCasierController(this);
        frmAddCasier.setLocationRelativeTo(parent);
        frmAddCasier.setVisible(true);
    }
    
    public void actionRemove(){
        JTable tblCasieri = frmAdministrareCasieri.getTblCasieri();
        int index = tblCasieri.convertRowIndexToModel(tblCasieri.getSelectedRow());
        if (index == -1) {
            JOptionPane.showMessageDialog(frmAdministrareCasieri, "Va rugam selectati un casier.");
            return;
        }
        Casier cc = listaCasieri.get(index);
        int raspuns = JOptionPane.showConfirmDialog(frmAdministrareCasieri, String.format("Sunteti sigur ca vreti sa stergeti casierul %s?", cc.getNumeComplet()), "Stergere Casier", JOptionPane.YES_NO_OPTION);
        if (raspuns == JOptionPane.YES_OPTION) {
            casierService.remove(cc);
            listaCasieri = casierService.getAll();
            data = new String[listaCasieri.size()][2];

            int x = 0;
            for (Casier c : listaCasieri) {
                data[x][0] = c.getNumeComplet();
                data[x][1] = c.getCodOperator();
                x++;
            }
            defaultTableModel.setDataVector(data, columnNames);
        }
    }

    public void saveCasier() {
        JTextField txtNume = frmAddCasier.getTxtNume();
        String nume = txtNume.getText();
        JTextField txtPrenume = frmAddCasier.getTxtPrenume();
        String prenume = txtPrenume.getText();
        JTextField txtCodOperator = frmAddCasier.getTxtCodOperator();
        String codOperator = txtCodOperator.getText();
        JPasswordField txtParola = frmAddCasier.getTxtParola();
        String parola = new String(txtParola.getPassword());
        if (isFormValid()) {
            if (casierSelectat == null) {
                casierSelectat = new Casier(nume, prenume, codOperator, parola);
            } else {

                casierSelectat.setCodOperator(codOperator);
                if (!parola.isEmpty()) {
                    casierSelectat.setParola(parola);
                }
            }
            System.out.println("####### Incep salvarea:              #######"+casierSelectat);
            casierService.salveazaCasier(casierSelectat);
            System.out.println("####### Salvare efectuata cu succes! #######"+casierSelectat);
            if (onCasierSaved != null) {
                onCasierSaved.saveCasier(casierSelectat);
            }
        }
    }

    private boolean isFormValid() {
        JTextField txtNume = frmAddCasier.getTxtNume();
        JTextField txtPrenume = frmAddCasier.getTxtPrenume();
        JTextField txtCodOperator = frmAddCasier.getTxtCodOperator();
        JPasswordField txtParola = frmAddCasier.getTxtParola();
        if (txtNume.getText().trim().length() < 3) {
            JOptionPane.showMessageDialog(frmAddCasier, "Numele trebuie sa contina minim 3 caractere!");
            txtNume.requestFocusInWindow();
            return false;
        }
        if (txtPrenume.getText().trim().length() < 3) {
            JOptionPane.showMessageDialog(frmAddCasier, "Prenumele trebuie sa aiba minim 3 caractere!");
            txtPrenume.requestFocusInWindow();
            return false;
        }
        if (txtCodOperator.getText().trim().length() < 2) {
            JOptionPane.showMessageDialog(frmAddCasier, "Codul operator trebuie sa aiba minim 2 caractere!");
            txtCodOperator.requestFocusInWindow();
            return false;
        }
        if (casierSelectat != null && txtParola.getPassword().length == 0) {
            return true;
        }
        if (txtParola.getPassword().length < 6) {
            JOptionPane.showMessageDialog(frmAddCasier, "Parola trebuie sa aiba minim 6 caractere!");
            txtParola.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public interface OnCasierSaved {

        void saveCasier(Casier c);
    }

    public void setOnCasierSaved(OnCasierSaved onCasierSaved) {
        this.onCasierSaved = onCasierSaved;
    }

}
