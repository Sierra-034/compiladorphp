/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import compilador.ComPHP;
import compilador.ParseException;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Samuel Gomez
 */
public class Application extends javax.swing.JFrame {

    private int tabCounter = 0;
    private final JFileChooser fc = new JFileChooser();
    private final Font font = new Font("Consolas", Font.BOLD, 12);
    private final Map<JScrollPane, File> mapaFiles;
    private final Map<JScrollPane, JTextPane> mapaTextPane;
    
    /**
     * Creates new form Application
     */
    public Application() {
        this.mapaFiles = new HashMap();
        this.mapaTextPane = new HashMap();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        fileM = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        saveFile = new javax.swing.JMenuItem();
        saveAsFile = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        closeFile = new javax.swing.JMenuItem();
        closeAllFiles = new javax.swing.JMenuItem();
        editM = new javax.swing.JMenu();
        copyM = new javax.swing.JMenuItem();
        cutM = new javax.swing.JMenuItem();
        pasteM = new javax.swing.JMenuItem();
        compileM = new javax.swing.JMenu();
        analizeGramar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(tabPane, java.awt.BorderLayout.CENTER);

        fileM.setText("File");

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFile.setText("New File");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });
        fileM.add(newFile);

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("Open File");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });
        fileM.add(openFile);
        fileM.add(jSeparator1);

        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });
        fileM.add(saveFile);

        saveAsFile.setText("Save As");
        saveAsFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });
        fileM.add(saveAsFile);
        fileM.add(jSeparator2);

        closeFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        closeFile.setText("Close File");
        closeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });
        fileM.add(closeFile);

        closeAllFiles.setText("Close All Files");
        fileM.add(closeAllFiles);

        menuBar.add(fileM);

        editM.setText("Edit");

        copyM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyM.setText("Copy");
        editM.add(copyM);

        cutM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutM.setText("Cut");
        editM.add(cutM);

        pasteM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteM.setText("Paste");
        editM.add(pasteM);

        menuBar.add(editM);

        compileM.setText("Compile");

        analizeGramar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        analizeGramar.setText("Analize Gramar");
        analizeGramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileCompileActionPerformed(evt);
            }
        });
        compileM.add(analizeGramar);

        menuBar.add(compileM);

        setJMenuBar(menuBar);

        setBounds(0, 0, 616, 439);
    }// </editor-fold>//GEN-END:initComponents

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed
        // TODO add your handling code here:
        
        //Se hizo clic en New File
        if(evt.getSource() == this.newFile)
        {
            JTextPane textPane = new JTextPane();
            textPane.setFont(font);
            JScrollPane scroll = new JScrollPane(textPane);            
            String tabLabel = String.format("new file %d", tabCounter);
            
            this.mapaTextPane.put(scroll, textPane);
            
            tabPane.addTab(tabLabel, null, scroll, null);
            tabPane.setSelectedIndex(tabCounter); 
            
            tabCounter++;                        
        }
        
        //Se hizo clic en Open File
        if(evt.getSource() == this.openFile)
        {
            int returnVal = fc.showOpenDialog(this);
            
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {               
                JTextPane textPane = new JTextPane();                
                textPane.setFont(font);
                JScrollPane scroll = new JScrollPane(textPane);
                File file = fc.getSelectedFile(); 
                
                this.mapaFiles.put(scroll, file);
                this.mapaTextPane.put(scroll, textPane);
                
                tabPane.addTab(file.getName(), null, scroll, null);
                tabPane.setSelectedIndex(tabCounter);
                tabCounter++;  
                
                String cadena = FileManager.read(file);
                textPane.setText(cadena);
            }
        }
        
        //Se hizo clic en saveFile
        if(evt.getSource() == this.saveFile)
        {        
            JScrollPane scroll = (JScrollPane) this.tabPane.getSelectedComponent();
            
            /*  Si el archivo aún no existe en el disco
                entonces abre un JFileChooser para que el 
                usuario pueda elegir la ruta donde se guardará
                el archivo
            */
            if( (this.mapaFiles.get(scroll) == null) && 
                (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) )   
            {
                File file = fc.getSelectedFile();
                JTextPane tp = this.mapaTextPane.get(scroll);
                FileManager.write(file, tp.getText());
                this.mapaFiles.put(scroll, file);
            }
            
            /*  Si el archivo ya tiene una ruta relacionada
                entonces solamente se invoca a dicha ruta 
                y se sobreescribe el archivo con el nuevo contenido
            */
            else if(this.mapaFiles.get(scroll) != null)
            {
                File file = this.mapaFiles.get(scroll);
                JTextPane tp = this.mapaTextPane.get(scroll);
                FileManager.write(file, tp.getText());
            }            
            
        }
        
        //Se hizo clic en Close File
        if(evt.getSource() == this.closeFile)
        {
            this.tabPane.removeTabAt(tabPane.getSelectedIndex());
            this.tabCounter--;
        }
        
        //Se hizo clic en Close
        if(evt.getSource() == this.closeAllFiles)
        {
            this.tabPane.removeAll();
            this.tabCounter = 0;
        }
    }//GEN-LAST:event_fileMenuActionPerformed

    private void fileCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileCompileActionPerformed
        // TODO add your handling code here:
        
        //Se hizo clic en analizaGramar
        if(evt.getSource() == this.analizeGramar)
        {
            BufferedReader br = null;
            try {
                JScrollPane scroll = (JScrollPane) this.tabPane.getSelectedComponent();
                File f = this.mapaFiles.get(scroll);
                br = new BufferedReader(new FileReader(f));
                
                ComPHP c = new ComPHP(br);
                ComPHP.funcion();
                System.out.println("Compiló papu");
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);                
            } catch (ParseException ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_fileCompileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem analizeGramar;
    private javax.swing.JMenuItem closeAllFiles;
    private javax.swing.JMenuItem closeFile;
    private javax.swing.JMenu compileM;
    private javax.swing.JMenuItem copyM;
    private javax.swing.JMenuItem cutM;
    private javax.swing.JMenu editM;
    private javax.swing.JMenu fileM;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem pasteM;
    private javax.swing.JMenuItem saveAsFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}