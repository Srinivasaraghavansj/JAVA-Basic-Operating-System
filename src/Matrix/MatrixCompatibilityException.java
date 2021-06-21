package Matrix;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malod_000
 */
public class MatrixCompatibilityException extends Exception {
    public MatrixCompatibilityException(String v) {
        super("MatrixCompatibilityException: The given matri"+v+" may not be compatible for the operation.");
    }
}
