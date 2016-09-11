/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.commons;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pamela
 */
public class WriteUTF8 {
    
        public static void main(String args[]) throws IOException{
            OutputStream os = null;
            try {
                
                String line = "שלום, hello, привет";
                os = new FileOutputStream("E:/pame.csv");
                os.write(239);
                os.write(187);
                os.write(191);
                PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
                w.print(line);
                w.flush();
                w.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(WriteUTF8.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(WriteUTF8.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                os.close();
            }
        }
}
