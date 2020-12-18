/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.awt.BorderLayout;
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
import models.Spectacol;

/**
 *
 * @author Stefan
 */
public class SpectacoleFileRepository implements SpectacoleRepository {

    private ArrayList<Spectacol> listaSpectacole;
    
    private File fisier;
    public SpectacoleFileRepository (){
        fisier=new File("spectacole.ser");
        listaSpectacole = new ArrayList<>();
        init();
    }
    
    private void init(){
        try {
            FileInputStream fileInputStream = new FileInputStream(fisier);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listaSpectacole=(ArrayList<Spectacol>) objectInputStream.readObject();
        } catch (IOException ex) {
          //  Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void adaugaSpectacol(Spectacol spectacol) {
        listaSpectacole.add(spectacol);
        save();
    }

    @Override
    public void editareSpectacol(Spectacol spectacol) {
         
//        index = -1;
//        for (int i=0;i<listaSpectacole.size();i++){
//            if (listaSpectacole.get(i).getId()==spectacol.getId()){
//                index = i;
//                break;
//            }
//        }
    }

    @Override
    public void stergeSpectacol(Spectacol spectacol) {
        listaSpectacole.remove(spectacol);
        save();
    }

    @Override
    public List<Spectacol> getAll() {
        return listaSpectacole;
    }

    @Override
    public List<Spectacol> cautareSpectacol(String titlu) {
        List<Spectacol> rezultate = new ArrayList<>();
        for (Spectacol s:listaSpectacole){
            if (s.getTitlu().contains(titlu))
                rezultate.add(s);
        }
//        for (int i=0;i<listaSpectacole.size();i++){
//            if (listaSpectacole.get(i).getTitlu().contains(titlu)){
//                rezultate.add(listaSpectacole.get(i));
//            }
//        }
        return rezultate;
    }
    
    private void save(){
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(fisier);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(listaSpectacole);
           // fout.flush();
           // oos.
           fout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpectacoleFileRepository.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    


    @Override
    public boolean salveazaSpectacol(Spectacol spectacol) {
        int index=listaSpectacole.indexOf(spectacol);
        if (index == -1){
            listaSpectacole.add(spectacol);
        }else
            listaSpectacole.set(index, spectacol);
        save();
        return true;
    }
}
