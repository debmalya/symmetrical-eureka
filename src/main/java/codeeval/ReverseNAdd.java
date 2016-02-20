/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeeval;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author djash
 */
public class ReverseNAdd {
    
     public static void main(String[] args){
         if (args.length > 0) {
            readFromFile(args[0]);
         } else {
             System.err.println("Input file is not specified.");
         }
     }
     private static void readFromFile(final String arg) {

        try (BufferedReader bf = new BufferedReader(new FileReader(arg))) {
            String eachLine;
            while ((eachLine = bf.readLine()) != null) {
               System.out.println(reverseNAdd(eachLine));
            } 
        } catch (IOException ignore) {
         
        }
        
    }

    public static String reverseNAdd(final String eachLine) {
        int n = 0;
        String original = eachLine;
        StringBuilder changed = new StringBuilder(eachLine).reverse();
        int num = Integer.parseInt(eachLine);
        while (!original.equals(changed.toString())){
            num += Integer.parseInt(changed.toString());
            changed.delete(0, changed.length());
            changed.append(num);
            original = changed.toString();
            changed = changed.reverse();
            n++;
        }
        
        return n + " " + num;
    } 
}
