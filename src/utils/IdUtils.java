/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public class IdUtils {
    private static final String IDS_FILE="ids.properties";
    private static Properties prop = new Properties();
    private static void save(){
        OutputStream output = null;
        try {
            output = new FileOutputStream(IDS_FILE);
            // set the properties value
            
            // save properties to project root folder
            prop.store(output, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IdUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IdUtils.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public static void addProperty(String key, int value){
        readData();
        prop.setProperty(key, String.valueOf(value));
        save();
    }
    private static void readData (){
        InputStream input = null;
        try {
            input = new FileInputStream(IDS_FILE);
            // load a properties file
            prop.load(input);
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(IdUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           // Logger.getLogger(IdUtils.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public static int getValueForKey(String key){
        readData();
        return Integer.parseInt(prop.getProperty(key, "0"));
    }
    
    public static void main(String[] args) {
        System.out.println(IdUtils.getValueForKey("object.casier"));
    }
}
