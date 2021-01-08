/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Bilet;
import models.Spectacol;

/**
 *
 * @author Stefan
 */
public class BiletFileRepository implements BiletRepository {

    private ArrayList<Bilet> listaBilete;
    private File fisier;
    public BiletFileRepository(){
        fisier =new File("bilete.ser");
        listaBilete = new ArrayList<>();
        init();
    }
    
    private void init(){
        try {
            FileInputStream fileInputStream = new FileInputStream(fisier);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listaBilete=(ArrayList<Bilet>) objectInputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void adaugaBilet(Bilet bilet) {
        listaBilete.add(bilet);
        save();
    }

    @Override
    public void editareBilet(Bilet bilet) {
        int index = listaBilete.indexOf(bilet);
        if (index !=-1){
            listaBilete.set(index, bilet);
            save();
        }
    }

    @Override
    public void stergereBilet(Bilet bilet) {
        listaBilete.remove(bilet);
        save();
    }

    @Override
    public List<Bilet> getAll() {
        return listaBilete;
    }

    @Override
    public List<Bilet> cautareBiletDupaSpectacol(Spectacol spectacol) {
        List<Bilet> rezultate = new ArrayList<>();
        for (Bilet b:listaBilete){
            if (b.getNumeSpectacol().contains(spectacol.getTitlu())){
                rezultate.add(b);
            }
        }
        return rezultate;
    }

    @Override
    public List<Bilet> cautareBiletDupaLoc(int rand, int loc) {
        List<Bilet> rezultate = new ArrayList<>();
        for (Bilet b:listaBilete){
            if (b.getRand()==rand && b.getLoc()==loc){
                rezultate.add(b);
            }
        }
        return rezultate;
    }

    @Override
    public List<Bilet> cautareBiletDupaData(Date dataStart, Date dataSfarsit) {
        List<Bilet> rezultate = new ArrayList<>();
        for (Bilet b:listaBilete){
            if (b.getSpectacol().getDataOra().after(dataStart) && b.getSpectacol().getDataOra().before(dataSfarsit)){
                rezultate.add(b);
            }
        }
        return rezultate;
    }

    
    
    private void save(){
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(fisier);
            ObjectOutputStream oos =new ObjectOutputStream(fout);
            oos.writeObject(listaBilete);
            fout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BiletFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BiletFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
