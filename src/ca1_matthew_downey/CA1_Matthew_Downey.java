/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_matthew_downey;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amber
 */
public class CA1_Matthew_Downey {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // import scanner to read data from a file using relative path
            Scanner read = new Scanner (new FileReader("student.txt"));
            //use a while loop to read all the data from file
            String lines;
            while ((lines = read.nextLine()) !=null) {
                System.out.println(lines);
                
            }
       
        } catch (Exception e) {
            System.out.println("No more data found");
        }
        
        
    }
    
}
