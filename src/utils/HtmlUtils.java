/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Stefan
 */
public class HtmlUtils {
    
    public static String createTable(String s){
        String stil="width:70%; border=1px solid;";
        return "<table style="+stil+">"+s+"</table>";
    }
    
    public static String createRow(String s){
        return "<tr>"+s+"</tr>";
    }
    
    public static String createColumn(String s, boolean...detalii){
        if (detalii.length > 0){
            return "<td><b>"+s+"</b></td>";
        }
        return "<td>"+s+"</td>";
    }
    
}
