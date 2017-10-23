/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import compilador.ComPHP;
import compilador.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Gomez
 */
public class TestCompilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // TODO code application logic here
            ComPHP c = new ComPHP(System.in);
            ComPHP.control();
        } catch (ParseException ex) {
            Logger.getLogger(TestCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
