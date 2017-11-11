
import compilador.ComPHP;
import compilador.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel Gomez
 */
public class TestCompiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            ComPHP c = new ComPHP(System.in);
            ComPHP.gramaticaPrincipal();
        } catch (ParseException ex) {
            Logger.getLogger(TestCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
