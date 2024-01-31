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
            //store data from file in an array to check conditions
            String[] parts = lines.split("\\s+");
            System.out.println(lines);
            
            // use if else statment to validate each part from file
            if (parts.length <=3) {
                String firstname = parts[0];
                String surname = parts[1];
                int classnum = Integer.parseInt(parts[2]);
                String studentnum = parts[3];
                System.out.println("Valid data");
            } else  {
                System.out.println("invalid data" + parts);
            }
            
            
                
            }
       
        } catch (Exception e) {
            System.out.println("No more data found");
        }
        
        //validate data from file based on CA requirements
    } public static boolean validData (String firstname ,String surname ,int classnum ,String studentnum) {
             
                    return firstname.matches("[a-zA-Z]+")
                    && surname.matches("[a-zA-Z0-9]+")
                    && classnum >= 1 && classnum <=8
                    &&studentnum.matches("\\d{2}[a-zA-Z]{1,2}\\d+");
    
        //validate student num based on CA requirements
    } public static String validStudentnum(String studentnum) {
        //check first 2 charecters are letter
        if (!"[0-9]+".equals(studentnum.substring(0, 1))) {
            System.out.println("Invalid student number, charecters 1&2 must be numbers");
       
        //check charecter 3 and 4 are letter
        } else if (!"[a-zA-Z]+".equals(studentnum.substring(2, 4))) {
            System.out.println("invalid student number, charecters 3&4 must be letters");
          
        //check charecters 5 onward are numbers
        } else if (!"[0-9]+".equals(studentnum.substring(5, 8))) {
            System.out.println("Invalid student number, charecters 5-8 must be numbers");
           
        //return method implementation to main method
        } return validStudentnum;
        
    //new method to check student type based on class numbers from file
    } public static String studetnType(int classnum){
    //if else statement to see whether student has a very light or light workload and also if they are part-time or full-time
          if (classnum == 1) {
              return "very light";
          }else if (classnum == 2) {
              return "light";
          }else if (classnum >=3 || classnum <=5) {
              return "part time";
          } else {
              return "full time";
          }
    }
    
    
}
