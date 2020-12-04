/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class MatriceSerializabila implements Serializable {

    private static final long serialVersionUID = 3326965173303943800L;
    
    private int linii;
    private int coloane;
    private int[][] configurare;

    public MatriceSerializabila(int linii, int coloane) {
        this.linii = linii;
        this.coloane = coloane;
        this.configurare = new int[linii][coloane];
    }

    public MatriceSerializabila() {
    }
    
    
    public void enableDisable(int i, int j){
        if (configurare[i][j]==0){
            configurare[i][j]=-1;
        }else
            configurare[i][j]=0;
    }

    public int getLinii() {
        return linii;
    }

    public int getValuetAtLineAndColumn(int i,int j){
        return configurare[i][j-1];
    }
    public void setLinii(int linii) {
        this.linii = linii;
    }

    public int getColoane() {
        return coloane;
    }

    public void setColoane(int coloane) {
        this.coloane = coloane;
    }

    public int[][] getConfigurare() {
        return configurare;
    }

    public void setConfigurare(int[][] configurare) {
        this.configurare = configurare;
    }
    
    public void afisareMatrice (){
        for (int i=0;i<linii;i++){
            for (int j=0;j<coloane;j++){
                System.out.print(configurare[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
