/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.awt.Container;
import java.awt.Desktop;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author malod
 */
public abstract class runFolder {

    public static void getFiles(Container ParentContainer, final File f) {
        if (!(f.listFiles() == null)) {
            for (final File ff : f.listFiles()) {
                if (ff.isDirectory()) {
                    getFiles(ParentContainer, ff);
                } else if (ff.isFile()) {
                    try {
                        if ((ff.getName().substring(ff.getName().lastIndexOf('.') + 1, ff.getName().length()).toLowerCase()).equals("dat") || (ff.getName().substring(ff.getName().lastIndexOf('.') + 1, ff.getName().length()).toLowerCase()).equals("txt")) {
                            Apps.Notepad n = new Apps.Notepad(ff);
                            ParentContainer.add(n);
                            n.setVisible(true);
                        } else if ((ff.getName().substring(ff.getName().lastIndexOf('.') + 1, ff.getName().length()).toLowerCase()).equals("jar")) {
                            Desktop.getDesktop().open(ff);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(runFolder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
