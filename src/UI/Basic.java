/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import OS_Soft.*;
import User.Init;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.*;
import javax.imageio.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author malod
 */
public class Basic extends JFrame {

    /**
     * Creates new form Basic
     */
    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice vc = e.getDefaultScreenDevice();

    public Basic() throws IOException {
        setUndecorated(true);
        initComponents();

        strt.setLocation(0, (int) (dim.getHeight() - 60));
        strt.setSize(60, 60);
        jPanel1.setLocation(0, (int) (dim.getHeight() - 577));
        tb.setLocation(strt.getWidth(), (int) (dim.getHeight() - 60));
        tb.setSize((int) dim.getWidth() - 80, 60);
        setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        setLocationRelativeTo(null);
        setVisible(true);
        jPanel1.setVisible(false);
        ppw.setVisible(false);
        jPanel2.setVisible(false);
        BufferedReader br = new BufferedReader(new FileReader("C:\\JBOS\\OS_Data\\Users\\" + User.Init.usrname + "\\wp.dat"));
        String wpst = br.readLine();
        BufferedImage bg = null;
        try {
            bg = ImageIO.read(getClass().getResource(wpst));
        } catch (IOException ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon i = new ImageIcon(bg);
        Image ii = i.getImage();
        wp.setSize(dim.width, dim.height);
        wp.setIcon(new ImageIcon(ii.getScaledInstance(wp.getWidth(), wp.getHeight(), Image.SCALE_SMOOTH)));
        t = new javax.swing.Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (val.equals("sho")) {
                    JButton b1 = new JButton("App Chooser");
                    tb.add(b1);
                } else {
                    tb.remove(tb.getComponentAt(posx, 0));
                }
            }
        });
        User.runFolder.getFiles(wp, new File("C:\\JBOS\\Sys_files\\data"));
        sh();

        try {
            Class.forName("java.sql.DriverManager");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "psbbkkn");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select hour(sysdate()),minute(sysdate()),second(sysdate()),year(sysdate()),month(sysdate()),day(sysdate())");
            rs.first();
            h = rs.getInt("hour(sysdate())");
            m = rs.getInt("minute(sysdate())");
            s = rs.getInt("second(sysdate())");
            y = rs.getInt("year(sysdate())");
            mo = rs.getInt("month(sysdate())");
            d = rs.getInt("day(sysdate())");
            date1.setText(d + "/" + mo + "/" + y);
            time1.setText(h + ":" + m);
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        tii.start();
    }

    public void sh() {
        tii = new javax.swing.Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                s++;
                switch (mo) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        dc = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        dc = 30;
                        break;
                    case 2:
                        if (y % 4 == 0) {
                            dc = 29;
                        } else {
                            dc = 28;
                        }
                }
                if ((h == 24) && (m == 59) && (s == 59) && (d == dc) && (m == 12)) {
                    h = 0;
                    m = 0;
                    s = 0;
                    d = 0;
                    m = 0;
                    y++;
                } else if ((h == 24) && (m == 59) && (s == 59) && (d == dc)) {
                    h = 0;
                    m = 0;
                    s = 0;
                    d = 0;
                    m++;
                } else if ((h == 24) && (m == 59) && (s == 59)) {
                    h = 0;
                    m = 0;
                    s = 0;
                    d++;
                } else if ((m == 59) && (s == 59)) {
                    m = 0;
                    s = 0;
                    h++;
                } else if ((s == 59)) {
                    m++;
                    s = 0;
                }
                date1.setText(d + "/" + mo + "/" + y);
                time1.setText(h + ":" + m);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wps = new javax.swing.JInternalFrame();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        strt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        shut = new javax.swing.JButton();
        ppw = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        tb = new javax.swing.JPanel();
        time1 = new javax.swing.JTextField();
        date1 = new javax.swing.JTextField();
        wp = new javax.swing.JLabel();

        wps.setClosable(true);
        wps.setTitle("Default Wallpaper");
        wps.setVisible(true);

        jButton8.setText("Iron Man");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Terminator");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wpsLayout = new javax.swing.GroupLayout(wps.getContentPane());
        wps.getContentPane().setLayout(wpsLayout);
        wpsLayout.setHorizontalGroup(
            wpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wpsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        wpsLayout.setVerticalGroup(
            wpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wpsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        strt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/atr.jpg"))); // NOI18N
        strt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strtActionPerformed(evt);
            }
        });
        getContentPane().add(strt);
        strt.setBounds(0, 720, 60, 50);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hello, "+User.Init.usrname));
        jPanel1.setLayout(null);

        jButton1.setText("Switch to windows");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 470, 140, 23);

        shut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/pwd.jpg"))); // NOI18N
        shut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shutActionPerformed(evt);
            }
        });
        jPanel1.add(shut);
        shut.setBounds(170, 450, 40, 40);

        ppw.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 255)));
        ppw.setLayout(null);

        jButton2.setText("Power Off");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        ppw.add(jButton2);
        jButton2.setBounds(1, 89, 101, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 255)));

        jButton4.setText("JBOS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Windows");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addGap(3, 3, 3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        ppw.add(jPanel2);
        jPanel2.setBounds(110, 20, 80, 90);

        jButton10.setText("Log off");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        ppw.add(jButton10);
        jButton10.setBounds(0, 53, 100, 30);

        jPanel1.add(ppw);
        ppw.setBounds(220, 370, 110, 120);

        jButton3.setText("Default Apps");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(20, 440, 140, 23);

        jButton6.setText("Customize");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(10, 20, 200, 23);

        jButton7.setText("Set Default Wallpapers");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(10, 50, 200, 23);

        jButton11.setText("CMD");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(20, 403, 60, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 210, 220, 500);

        tb.setBackground(new java.awt.Color(102, 255, 102));

        time1.setEditable(false);

        date1.setEditable(false);

        javax.swing.GroupLayout tbLayout = new javax.swing.GroupLayout(tb);
        tb.setLayout(tbLayout);
        tbLayout.setHorizontalGroup(
            tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbLayout.createSequentialGroup()
                .addGap(0, 1200, Short.MAX_VALUE)
                .addGroup(tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        tbLayout.setVerticalGroup(
            tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbLayout.createSequentialGroup()
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(tb);
        tb.setBounds(60, 710, 1290, 50);

        wp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                wpKeyPressed(evt);
            }
        });
        getContentPane().add(wp);
        wp.setBounds(0, 0, 1360, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void strtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strtActionPerformed
        ppw.setBounds(220, 370, 110, 120);
        jPanel1.setSize(220, 500);
        jPanel1.setVisible(vis);
        if (vis == false) {
            ppw.setVisible(false);
            jPanel2.setVisible(false);
            ppw.setVisible(false);
            sval = true;
            opt = true;
        }
        vis = !vis;
    }//GEN-LAST:event_strtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void shutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shutActionPerformed
        jPanel1.setSize(340, 500);
        ppw.setVisible(sval);
        if (sval == false) {
            jPanel2.setVisible(false);
            opt = true;
            jPanel1.setSize(220, 500);
        }
        sval = !sval;
    }//GEN-LAST:event_shutActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ppw.setSize(200, 120);
        jPanel1.setBounds(0, 221, 430, 500);
        jPanel2.setVisible(opt);
        if (opt == false) {
            jPanel1.setSize(340, 500);
            ppw.setSize(110, 120);
        }
        opt = !opt;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "This will Shut Down your System Completely. Are you sure you want to Continue.?") == 0) {
            try {
                Runtime.getRuntime().exec("cmd /c start sd.bat");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        vis = false;
        strtActionPerformed(evt);
        jPanel1.setSize(220, 500);
        ppw.setSize(110, 120);
        if (JOptionPane.showConfirmDialog(null, "Do you really want to shut down JBOS?") == 0) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jPanel1.setSize(220, 500);
        ppw.setSize(110, 120);
        jPanel2.setVisible(false);
        ppw.setVisible(false);
        jPanel1.setVisible(false);
        wp.add(op);
        op.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        jPanel1.setVisible(false);
        ppw.setSize(110, 120);
        jPanel1.setSize(220, 500);
        ppw.setVisible(false);
        jPanel2.setVisible(false);
        ppw.setVisible(false);
        sval = true;
        opt = true;
        vis = true;
    }//GEN-LAST:event_formMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFileChooser j = new JFileChooser();
        if (j.showOpenDialog(getParent()) == 0) {
            OutputStream out = null;
            try {
                File f = new File(j.getSelectedFile().getAbsolutePath());
                out = new FileOutputStream("C:\\JBOS\\OS_Data\\Users\\" + User.Init.usrname + "\\wp.dat");
                for (byte b : f.getAbsolutePath().getBytes()) {
                    try {
                        out.write(b);
                    } catch (IOException ex) {
                        Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ImageIcon i = new ImageIcon(f.getAbsolutePath());
                Image img = i.getImage();
                Image newimg = img.getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
                ImageIcon i1 = new ImageIcon(newimg);
                wp.setIcon(i1);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        wp.add(wps);
        jPanel1.setVisible(false);
        wps.setLocation(0, 0);
        wps.setSize(350, 90);
        wps.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed
//Wallpaper
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        BufferedImage bg = null;
        try {
            bg = ImageIO.read(getClass().getResource("/UI/imwp.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
        wp.setIcon(new ImageIcon(bg));
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\JBOS\\OS_Data\\Users\\" + User.Init.usrname + "\\wp.dat");
            for (byte b : "/UI/imwp.jpg".getBytes()) {
                try {
                    out.write(b);
                } catch (IOException ex) {
                    Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Image img = new ImageIcon(bg).getImage();
        Image newimg = img.getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon i1 = new ImageIcon(newimg);
        wp.setIcon(i1);
        wps.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        BufferedImage bg = null;
        try {
            bg = ImageIO.read(getClass().getResource("/UI/twp.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
        wp.setIcon(new ImageIcon(bg));
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\JBOS\\OS_Data\\Users\\" + User.Init.usrname + "\\wp.dat");
            for (byte b : "/UI/twp.jpg".getBytes()) {
                try {
                    out.write(b);
                } catch (IOException ex) {
                    Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Image img = new ImageIcon(bg).getImage();
        Image newimg = img.getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon i1 = new ImageIcon(newimg);
        wp.setIcon(i1);
        wps.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed
//*Wallpaper*
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        new User.Init().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void wpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wpKeyPressed
    }//GEN-LAST:event_wpKeyPressed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jPanel1.setSize(220, 500);
        ppw.setSize(110, 120);
        jPanel2.setVisible(false);
        ppw.setVisible(false);
        jPanel1.setVisible(false);
        cmd c = new cmd();
        wp.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static String val = "sho";
    public static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    javax.swing.Timer t, tii;
    public static int posx = 0, h = 0, m = 0, s = 0, d = 0, mo = 0, y = 0, dc = 31;
    public boolean vis = true, sval = true, opt = true, nval = false;
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

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
            java.util.logging.Logger.getLogger(Basic.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Basic.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Basic.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Basic.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Basic().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    Apps.open op = new Apps.open();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel ppw;
    private javax.swing.JButton shut;
    private static javax.swing.JButton strt;
    public javax.swing.JPanel tb;
    private javax.swing.JTextField time1;
    public static javax.swing.JLabel wp;
    private javax.swing.JInternalFrame wps;
    // End of variables declaration//GEN-END:variables
}
