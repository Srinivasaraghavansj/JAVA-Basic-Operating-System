/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS_Soft;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.zip.*;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Malolan
 */
public abstract class FilesHandler {

    public static void copyFile(File source, File dest) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
        }
    }

    public static void copyFileFast(File in, File out) 
        throws IOException 
    {
        FileChannel inChannel = new
            FileInputStream(in).getChannel();
        FileChannel outChannel = new
            FileOutputStream(out).getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(),outChannel);
        } 
        catch (IOException e) {
            throw e;
        }
        finally {
            if (inChannel != null) inChannel.close();
            if (outChannel != null) outChannel.close();
        }
    }

    public static void copyFile(File source, File dest, JProgressBar jpb) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead,per=0,tot=0;
            while(input.available()!=0) {
                tot++;
            }
            jpb.setMaximum(100);
            jpb.setValue(per);
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
                per++;
                jpb.setValue(per*100/tot);
            }
        } finally {
        }
    }

    public static void copyFolder(File source, File dest) throws IOException {
        dest.mkdir();
        File[] f = source.listFiles();
        for (int i = 0; i < f.length; i++) {
            if (f[i].isDirectory()) {
                copyFolder(f[i], new File(dest.getAbsolutePath() + "\\" + f[i].getName()));
            } else {
                copyFile(f[i], new File(dest.getAbsolutePath() + "\\" + f[i].getName()));
            }
        }
    }

    public static void copyFolderFast(File source, File dest) throws IOException {
        dest.mkdir();
        File[] f = source.listFiles();
        for (int i = 0; i < f.length; i++) {
            if (f[i].isDirectory()) {
                copyFolderFast(f[i], new File(dest.getAbsolutePath() + "\\" + f[i].getName()));
            } else {
                copyFileFast(f[i], new File(dest.getAbsolutePath() + "\\" + f[i].getName()));
            }
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
