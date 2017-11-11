/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Gomez
 */
public class FileManager {
    
    public static String read( File fileP )
    {
        BufferedReader br = null;
        String cadena = "";
        
        try 
        {
            br = new BufferedReader(new FileReader(fileP));
            
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
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return cadena;            
        }
        
    }
    
    public static void write( File fileP, String str )
    {
        BufferedWriter bw = null;
        
        try
        {
            bw = new BufferedWriter(new FileWriter(fileP));            
            bw.write(str);
        }
        catch ( IOException ex )
        {
            System.out.println("Error en el archivo");
            ex.printStackTrace();
        }
        finally
        {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
