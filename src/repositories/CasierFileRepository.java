/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Casier;

/**
 *
 * @author Stefan
 */
public class CasierFileRepository implements CasierRepository {

    private ArrayList<Casier> listaCasieri;
    private File fisier;

    public CasierFileRepository() {
        fisier = new File("casieri.ser");
        listaCasieri = new ArrayList<>();
        init();
    }

    private void init() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fisier);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listaCasieri = (ArrayList<Casier>) objectInputStream.readObject();
        } catch (IOException ex) {
          //  Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean salveazaCasier(Casier casier) {
        int index = listaCasieri.indexOf(casier);
        if (index == -1) {
            listaCasieri.add(casier);
        } else {
            listaCasieri.set(index, casier);
        }
        save();
        return true;
    }

    @Override
    public void stergereCasier(Casier casier) {
        listaCasieri.remove(casier);
        save();
    }

    @Override
    public Casier login(String codOperator, String parola) {
        for (Casier c : listaCasieri) {
            if (codOperator.equals(c.getCodOperator()) && parola.equals(c.getParola())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Casier> getAll() {
        return listaCasieri;
    }

    private void save() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fout = null;
            fout = new FileOutputStream(fisier);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(listaCasieri);
            fout.close();
        } catch (IOException ex) {
            Logger.getLogger(CasierFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
