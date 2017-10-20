/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javax.swing.JTextPane;

/**
 *
 * @author Samuel Gomez
 */
public class Application extends javax.swing.JFrame {

    private int tabCounter = 0;
    
    /**
     * Creates new form Application
     */
    public Application() {
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
        editM = new javax.swing.JMenu();
        copyM = new javax.swing.JMenuItem();
        cutM = new javax.swing.JMenuItem();
        pasteM = new javax.swing.JMenuItem();
        compileM = new javax.swing.JMenu();
        analize = new javax.swing.JMenuItem();

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
        fileM.add(openFile);

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

        analize.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        analize.setText("Analize Gramar");
        compileM.add(analize);

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
            String tabLabel = String.format("new file %d", tabCounter);
            tabPane.addTab(tabLabel, null, textPane, null);
            
            tabCounter++;                        
        }
    }//GEN-LAST:event_fileMenuActionPerformed

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
    private javax.swing.JMenuItem analize;
    private javax.swing.JMenu compileM;
    private javax.swing.JMenuItem copyM;
    private javax.swing.JMenuItem cutM;
    private javax.swing.JMenu editM;
    private javax.swing.JMenu fileM;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem pasteM;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
