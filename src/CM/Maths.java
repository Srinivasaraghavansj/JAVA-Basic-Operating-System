/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CM;

/**
 *
 * @author Malolan
 */
public abstract class Maths {
    public static int constrain(int no, int llmt, int hlmt) {
        if(no<llmt) {
            return llmt;
        } else if(no>hlmt) {
            return hlmt;
        } else {
            return no;
        }
    }
}
