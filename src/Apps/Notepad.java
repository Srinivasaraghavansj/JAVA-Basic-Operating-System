/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps;

import UI.Basic;
import User.Init;
import java.awt.Color;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author malod
 */
public class Notepad extends javax.swing.JInternalFrame {

    /**
     * Creates new form Notepad
     */
    public Notepad() {
        initComponents();
        setResizable(true);
        setClosable(true);
        File ff = new File("C:\\JBOS\\OS_Data\\Users\\" + Init.usrname + "\\Documents\\");
        if (!ff.exists()) {
            ff.mkdir();
        }
    }

    public Notepad(File f) {
        initComponents();
        setResizable(true);
        setClosable(true);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
            ta1.read(br, null);
            br.close();
        } catch (Exception ex) {
        }
        File ff = new File("C:\\JBOS\\OS_Data\\Users\\" + Init.usrname + "\\Documents\\");
        if (!ff.exists()) {
            ff.mkdir();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        t2.setColumns(20);
        t2.setRows(5);
        jScrollPane1.setViewportView(t2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane2.setViewportView(ta1);

        jMenu1.setText("File");

        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser j = new JFileChooser();
        File file = new File("C:\\JBOS\\OS_Data\\Users\\" + Init.usrname + "\\Documents\\");
        j.setCurrentDirectory(file);
        OutputStream out = null;
        if (j.showSaveDialog(this) == 0) {
            File fil = j.getSelectedFile();
            try {
                out = new FileOutputStream(fil);
                for (byte b : ta1.getText().getBytes()) {
                    out.write(b);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                        out = null;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
dispose();
    }//GEN-LAST:event_formInternalFrameClosed

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
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea t2;
    private javax.swing.JTextArea ta1;
    // End of variables declaration//GEN-END:variables
}
