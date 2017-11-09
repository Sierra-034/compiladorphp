/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.awt.image.BufImgSurfaceData;

/**
 *
 * @author Samuel Gomez
 */
public class FileManager {
    
    public static String read( File fileP )
    {
        FileReader entrada = null;
        String cadena = "";
        
        try 
        {
            entrada = new FileReader(fileP);
            BufferedReader br = new BufferedReader(entrada);
            
            int character = br.read();
            while(character != -1)
            {
                cadena += String.format("%c", (char)character );
                character = br.read();
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return cadena;            
        }
        
    }
}
