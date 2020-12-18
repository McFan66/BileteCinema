/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class Sala implements Serializable {
    private int numarLocuri;
    private int numarLinii;
    private int numarColoane;
    private int[][] sala;

    public Sala(int numarLinii, int numarColoane) {
        this.numarLinii = numarLinii;
        this.numarColoane = numarColoane;
    }

    public void configurareSala (int[][] configuratieSala){
        for (int i=0;i<numarLinii;i++){
            for (int j=0;j<numarColoane;j++){
                sala[i][j]=configuratieSala[i][j];
            }
        }
    }
    
    public boolean ocupaLoc (int rand, int loc){
        if (sala[rand][loc]==-1 || sala[rand][loc]==1){
            return false;
        }
        return true;
    }
    
    public void elibereazaLoc (int rand, int loc){
        if (sala[rand][loc]==1){
            sala[rand][loc]=0;
        }
    }
}
