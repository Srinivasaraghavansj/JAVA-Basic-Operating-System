package Matrix;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author malod_000
 */
public class matrix {

    int r, c;
    String[][] m;

    public matrix(int row, int col) {
        r = row;
        c = col;
        m = new String[r][c];
    }
    
    public matrix(JTable t) {
        DefaultTableModel tm=(DefaultTableModel)t.getModel();
        r=tm.getRowCount();
        c=tm.getColumnCount();
        m=new String[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                m[i][j]=tm.getValueAt(i, j).toString();
            }
        }
    }

    public void setval(int row, int col, String val) {
        m[row][col] = val;
    }

    public matrix add(matrix b) throws MatrixCompatibilityException {
        if ((r == b.r) && (c == b.c)) {
            matrix res = new matrix(r, c);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    try{
                        res.m[i][j]=Double.toString(Double.parseDouble(m[i][j])+Double.parseDouble(b.m[i][j]));
                    } catch(NumberFormatException e) {
                        res.m[i][j]=m[i][j]+"+"+b.m[i][j];
                    }
                }
            } return res;
        } else {
            throw new MatrixCompatibilityException("ces");
        }
    }

    public double detn() throws MatrixCompatibilityException {
        if (r == c) {
            double sum = 0;
            if (r > 2) {
                for (int rn = 0; rn < r; rn++) {
                    double v = Double.parseDouble(m[0][rn]);
                    matrix t = new matrix(r - 1, c - 1);
                    int cnt = 0;
                    for (int i = 0; i < c - 1; i++) {
                        if (i == rn) {
                            cnt = 1;
                        }
                        for (int j = 0; j < r - 1; j++) {
                            t.m[j][i] = m[j + 1][i + cnt];
                        }
                    }
                    sum = sum + Math.pow(-1, rn + 2) * t.detn() * v;
                }
                return sum;
            } else {
                return (Double.parseDouble(m[0][0]) * Double.parseDouble(m[1][1]) - Double.parseDouble(m[1][0]) * Double.parseDouble(m[0][1]));
            }
        } else {
            throw new MatrixCompatibilityException("x");
        }
    }
    
    public void display(JTable t) {
        DefaultTableModel tm=(DefaultTableModel)t.getModel();
        tm.setColumnCount(0);
        for (int i = 1; i <= c; i++) {
            tm.addColumn("Coloumn " + i);
        }
        tm.setRowCount(r);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tm.setValueAt(m[i][j], i, j);
            }
        }
    }
}
