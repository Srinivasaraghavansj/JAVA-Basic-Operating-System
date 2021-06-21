/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps;

import java.awt.Color;

/**
 *
 * @author Srinivasa Raghavan
 */
public class caal extends javax.swing.JInternalFrame {

    /**
     * Creates new form caal
     */
    double plusminus,firstDouble,secondDouble,totalDouble;
     int plusClick,k=0;
     int minusClick,multiplyClick,divideClick,decimalClick;
    public caal() {
        initComponents();
        setSize(489,494);
    }
    public void eq(){  try{String expr = t1.getText();
            int ind = 0, v = 0, opcnt = 0, ncnt = 0;
            double ans = 0, n[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            char op[] = {' ', ' ', ' ', ' ', ' ', ' '};
            for (int i = 0; i < expr.length(); i++) {
                char ch = expr.charAt(i);
                if (ch == '+') {
                    n[v] = Double.parseDouble(expr.substring(ind, i));
                    if (ncnt == 0) {
                        ans = n[0];
                    }
                    if (v != 0) {
                        ans += n[v];
                    }
                    op[v] = ch;
                    opcnt++;
                    ind = i + 1;
                    v++;
                    ncnt++;
                } else if (ch == '*') {
                    n[v] = Double.parseDouble(expr.substring(ind, i));
                    if (ncnt == 0) {
                        ans = n[0];
                    }
                    if (v != 0) {
                        ans = n[v - 1] * n[v];
                    }
                    op[v] = ch;
                    v++;
                    opcnt++;
                    ind = i + 1;
                    ncnt++;
                } else if (ch == '/') {
                    n[v] = Double.parseDouble(expr.substring(ind, i));
                    if (ncnt == 0) {
                        ans = n[0];
                    }
                    if (v != 0) {
                        ans = n[v - 1] / n[v];
                    }
                    op[v] = ch;
                    v++;
                    opcnt++;
                    ind = i + 1;
                    ncnt++;
                } else if (ch == '-') {
                    n[v] = Double.parseDouble(expr.substring(ind, i));
                    if (ncnt == 0) {
                        ans = n[0];
                    }
                    if (v != 0) {
                        ans = n[v - 1] - n[v];
                    }
                    op[v] = ch;
                    v++;
                    opcnt++;
                    ind = i + 1;
                    ncnt++;
                } else if (i == (expr.length()) - 1) {
                    switch (op[v - 1]) {
                        case '+':
                        ans += Double.parseDouble(expr.substring(ind, i + 1));
                        break;
                        case '*':
                        ans *= Double.parseDouble(expr.substring(ind, i + 1));
                        break;
                        case '/':
                        ans /= Double.parseDouble(expr.substring(ind, i + 1));
                        break;
                        case '-':
                        ans -= Double.parseDouble(expr.substring(ind, i + 1));
                        break;
                    }
                }
            }
            t1.setText(ans + "");

        }
        catch(Exception ex){if(t1.getText().equals("")){t1.setText("0");}
            secondDouble=(Double.parseDouble(String.valueOf(t1.getText())));
            if(plusClick>0){
                totalDouble=firstDouble+secondDouble;
                t1.setText(String.valueOf(totalDouble));
                firstDouble=0;
                secondDouble=0;
                plusClick=0;
            }
            if(minusClick>0){
                totalDouble=firstDouble-secondDouble;
                t1.setText(String.valueOf(totalDouble));
                firstDouble=0;
                secondDouble=0;
                minusClick=0;
            }
            if(multiplyClick>0){
                totalDouble=firstDouble*secondDouble;
                t1.setText(String.valueOf(totalDouble));
                firstDouble=0;
                secondDouble=0;
                multiplyClick=0;
            }
            if(divideClick>0){
                totalDouble=firstDouble/secondDouble;
                t1.setText(String.valueOf(totalDouble));
                firstDouble=0;
                secondDouble=0;
                divideClick=0;}
        }t1.requestFocus();
        jButton33.setForeground(Color.BLACK);
        jButton32.setForeground(Color.BLACK);
        jButton34.setForeground(Color.BLACK);
        jButton38.setForeground(Color.BLACK);}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        t1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BASIC CALCULATOR");

        jButton2.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t1KeyReleased(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 5));
        jPanel4.setLayout(null);

        jButton31.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton31.setText("C");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton31);
        jButton31.setBounds(20, 20, 60, 50);

        jButton32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton32.setText("x");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton32);
        jButton32.setBounds(20, 80, 60, 50);

        jButton33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton33.setText("+");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton33);
        jButton33.setBounds(90, 20, 60, 50);

        jButton34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton34.setText("-");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton34);
        jButton34.setBounds(90, 80, 60, 50);

        jButton35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton35.setText("SQR");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton35);
        jButton35.setBounds(90, 200, 60, 50);

        jButton36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton36.setText("Root");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton36);
        jButton36.setBounds(20, 200, 60, 50);

        jButton37.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton37.setText("=");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton37);
        jButton37.setBounds(20, 260, 130, 50);

        jButton38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton38.setText("/");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton38);
        jButton38.setBounds(20, 140, 60, 50);

        jButton39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton39.setText("~");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton39);
        jButton39.setBounds(90, 140, 60, 50);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 5));
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton1.setText("3");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 40, 60, 50);

        jButton7.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton7.setText("1");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(30, 40, 60, 50);

        jButton8.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton8.setText("2");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(110, 40, 60, 50);

        jButton9.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton9.setText("6");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(190, 110, 60, 50);

        jButton10.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton10.setText("5");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(110, 110, 60, 50);

        jButton11.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton11.setText("4");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(30, 110, 60, 50);

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setText(".");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12);
        jButton12.setBounds(190, 240, 60, 50);

        jButton13.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton13.setText("8");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(110, 180, 60, 50);

        jButton14.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton14.setText("7");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14);
        jButton14.setBounds(30, 180, 60, 50);

        jButton15.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton15.setText("0");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15);
        jButton15.setBounds(30, 240, 140, 50);

        jButton16.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jButton16.setText("9");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16);
        jButton16.setBounds(190, 180, 60, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        scaal op = new scaal();
        getParent().add(op);
        setVisible(false);
        op.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
       eq();
    }//GEN-LAST:event_t1ActionPerformed

    private void t1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyPressed

    }//GEN-LAST:event_t1KeyPressed

    private void t1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyReleased
      
    }//GEN-LAST:event_t1KeyReleased

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        t1.setText("");firstDouble=0;secondDouble=0;
        decimalClick=0;t1.requestFocus();
        jButton33.setForeground(Color.BLACK);
        jButton32.setForeground(Color.BLACK);
        jButton34.setForeground(Color.BLACK);
        jButton38.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        if(t1.getText().equals("")){t1.setText("0");}
        firstDouble=(Double.parseDouble(String.valueOf(t1.getText())));
        t1.setText("");
        multiplyClick=1;
        decimalClick=0;t1.requestFocus();jButton32.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        if(t1.getText().equals("")){t1.setText("0");}
        firstDouble=(Double.parseDouble(String.valueOf(t1.getText())));
        t1.setText("");
        plusClick=1;
        decimalClick=0;t1.requestFocus();
        jButton33.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        if(t1.getText().equals("")){t1.setText("0");}
        firstDouble=(Double.parseDouble(String.valueOf(t1.getText())));
        t1.setText("");
        minusClick=1;
        decimalClick=0;t1.requestFocus();jButton34.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        if(t1.getText().equals("")){t1.setText("0");}
        double num,square;
        num=Double.parseDouble(t1.getText());
        square=num*num;
        t1.setText(""+square);t1.requestFocus();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        if(t1.getText().equals("")){t1.setText("0");}
        double num,root;
        num=Double.parseDouble(t1.getText());
        root=Math.sqrt(num);
        t1.setText(""+root);t1.requestFocus();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        try{String expr = t1.getText();
            int ind = 0, v = 0, opcnt = 0, ncnt = 0;
            double ans = 0, n[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            char op[] = {' ', ' ', ' ', ' ', ' ', ' '};
            for (int i = 0; i < expr.length(); i++) {
                char ch = expr.charAt(i);
                if (ch == '+') {
                    n[v] = Double.parseDouble(expr.substring(ind, i));
                    if (ncnt == 0) {
                        ans = n[0];
                    }
                    if (v != 0) {
                        ans += n[v];
                    }
                    op[v] = ch;
                    opcnt++;
                    ind = i + 1;
                    v++;
                    ncnt++;
                } else if (ch == '*') {
                    n[v] = Double.parseDouble(expr.substring(ind, i));
                    if (ncnt == 0) {
                        ans = n[0];
                    }
                    if (v != 0) {
                        ans = n[v - 1] * n[v];
                    }
                    op[v] = ch;
                    v++;
                    opcnt++;
                    ind = i + 1;
                    ncnt++;
                } else if (ch == '/') {
                    n[v] = Double.parseDouble(expr.substring(ind, i));
                    if (ncnt == 0) {
                        ans = n[0];
                    }
                    if (v != 0) {
                        ans = n[v - 1] / n[v];
                    }
                    op[v] = ch;
                    v++;
                    opcnt++;
                    ind = i + 1;
                    ncnt++;
                } else if (ch == '-') {
                    n[v] = Double.parseDouble(expr.substring(ind, i));
                    if (ncnt == 0) {
                        ans = n[0];
                    }
                    if (v != 0) {
                        ans = n[v - 1] - n[v];
                    }
                    op[v] = ch;
                    v++;
                    opcnt++;
                    ind = i + 1;
                    ncnt++;
                } else if (i == (expr.length()) - 1) {
                    switch (op[v - 1]) {
                        case '+':
                        ans += Double.parseDouble(expr.substring(ind, i + 1));
                        break;
                        case '*':
                        ans *= Double.parseDouble(expr.substring(ind, i + 1));
                        break;
                        case '/':
                        ans /= Double.parseDouble(expr.substring(ind, i + 1));
                        break;
                        case '-':
                        ans -= Double.parseDouble(expr.substring(ind, i + 1));
                        break;
                    }
                }
            }
            t1.setText(ans + "");

        }
        catch(Exception ex){if(t1.getText().equals("")){t1.setText("0");}
            secondDouble=(Double.parseDouble(String.valueOf(t1.getText())));
            if(plusClick>0){
                totalDouble=firstDouble+secondDouble;
                t1.setText(String.valueOf(totalDouble));
                firstDouble=0;
                secondDouble=0;
                plusClick=0;
            }
            if(minusClick>0){
                totalDouble=firstDouble-secondDouble;
                t1.setText(String.valueOf(totalDouble));
                firstDouble=0;
                secondDouble=0;
                minusClick=0;
            }
            if(multiplyClick>0){
                totalDouble=firstDouble*secondDouble;
                t1.setText(String.valueOf(totalDouble));
                firstDouble=0;
                secondDouble=0;
                multiplyClick=0;
            }
            if(divideClick>0){
                totalDouble=firstDouble/secondDouble;
                t1.setText(String.valueOf(totalDouble));
                firstDouble=0;
                secondDouble=0;
                divideClick=0;}
        }t1.requestFocus();
        jButton33.setForeground(Color.BLACK);
        jButton32.setForeground(Color.BLACK);
        jButton34.setForeground(Color.BLACK);
        jButton38.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        if(t1.getText().equals("")){t1.setText("0");}
        firstDouble=(Double.parseDouble(String.valueOf(t1.getText())));
        t1.setText("");
        divideClick=1;
        decimalClick=0;t1.requestFocus();jButton38.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        if(t1.getText().equals("")){t1.setText("0");}
        double roundof,round;
        round=Double.parseDouble(t1.getText());
        roundof=Math.round(round);
        t1.setText(""+roundof);t1.requestFocus();
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        t1.setText(t1.getText() + "3");t1.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        t1.setText(t1.getText() + "1");t1.requestFocus();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        t1.setText(t1.getText() + "2");t1.requestFocus();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        t1.setText(t1.getText() + "6");t1.requestFocus();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        t1.setText(t1.getText() + "5");
        t1.requestFocus();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        t1.setText(t1.getText() + "4");t1.requestFocus();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(t1.getText().equals("")){t1.setText("0");}
        for(int j=0;j<t1.getText().length();j++){
            switch(t1.getText().charAt(j)){case '.':k++;}}
        if(k==0){t1.setText(t1.getText()+".");}
        t1.requestFocus();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        t1.setText(t1.getText() + "8");t1.requestFocus();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        t1.setText(t1.getText() + "7");t1.requestFocus();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        t1.setText(t1.getText() + "0");t1.requestFocus();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        t1.setText(t1.getText() + "9");t1.requestFocus();
    }//GEN-LAST:event_jButton16ActionPerformed
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
            java.util.logging.Logger.getLogger(cal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new caal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}

