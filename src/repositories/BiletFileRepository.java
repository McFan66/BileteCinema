/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dvdrental.Bilet;
import dvdrental.Spectacol;
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
import models.BiletB;
import models.SpectacolB;
import utils.DateUtils;

/**
 *
 * @author Stefan
 */
public class BiletFileRepository  {

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
           // Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean adaugaBilet(Bilet bilet) {
        int index = listaBilete.indexOf(bilet);
        if (index == -1){
            listaBilete.add(bilet);
        }else{
            listaBilete.set(index, bilet);
        }
        save();
        return true;
    }


    public void stergereBilet(Bilet bilet) {
        listaBilete.remove(bilet);
        save();
    }

    public ArrayList<Bilet> getAll() {
        return listaBilete;
    }
/*
    public List<Bilet> cautareBiletDupaSpectacol(Spectacol spectacol) {
        List<BiletB> rezultate = new ArrayList<>();
        for (Bilet b:listaBilete){
            if (b.getNumeSpectacol().contains(spectacol.getTitlu())){
                rezultate.add(b);
            }
        }
        return rezultate;
    }

    @Override
    public List<Bilet> cautareBiletDupaLoc(int rand, int loc) {
        List<BiletB> rezultate = new ArrayList<>();
        for (BiletB b:listaBilete){
            if (b.getRand()==rand && b.getLoc()==loc){
                rezultate.add(b);
            }
        }
        return rezultate;
    }

    @Override
    public List<BiletB> cautareBiletDupaData(Date dataInceput, Date dataSfarsit) {
        dataInceput=DateUtils.getDateWithSpecialHourMinuteSecond(dataInceput);
        dataSfarsit=DateUtils.getDateWithSpecialHourMinuteSecond(dataSfarsit, 23, 59, 59);
        List<BiletB> rezultate = new ArrayList<>();
        for (BiletB b:listaBilete){
            if (b.getDataVanzare().after(dataInceput) && b.getDataVanzare().before(dataSfarsit)){
                rezultate.add(b);
            }
        }
        return rezultate;
    }
*/
    
    
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
