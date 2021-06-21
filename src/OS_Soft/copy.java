/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OS_Soft;

import java.io.*;
import java.util.zip.*;

/**
 *
 * @author Malolan
 */
public abstract class copy {
    public static void copyFile(File source, File dest)
		throws IOException {
	InputStream input = null;
	ZipOutputStream output = null;
	try {
		input = new FileInputStream(source);
		output = new ZipOutputStream(new FileOutputStream(dest));
		byte[] buf = new byte[1024];
		int bytesRead;
		while ((bytesRead = input.read(buf)) > 0) {
			output.write(buf, 0, bytesRead);
		}
	} finally {
	}
}
}
