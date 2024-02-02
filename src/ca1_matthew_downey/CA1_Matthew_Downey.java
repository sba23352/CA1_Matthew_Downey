/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_matthew_downey;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * https://github.com/sba23352/CA1_Matthew_Downey.git
 *
 * @author amber
 */
public class CA1_Matthew_Downey {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaring variables and assigning values to them
        BufferedReader read;
        String firstName = "";
        String surname = "";
        int classNum = 0;
        String studentNum = "";
        validStudentnum(studentNum);

        try {
            // import scanner to read data from a file using relative path
            read = new BufferedReader(new FileReader("student.txt"));

            //use a while loop to read all the data from file
            String line = read.readLine();

            //use counter to start count at 1 for readability
            int count = 1;
            while (line != null) {

                //If all checks complete, data is writting to file
                if (count == 3) {
                    System.out.println("Testing parts array: " + line);

                }

                //Prevent infinite loop by resetting count if it exceeds 3
                if (count > 3) {
                    count = 1;

                }

                if (count == 1) {

                    String[] names = line.split(" ");
                    firstName = names[0];
                    surname = names[1];
                    System.out.println("Testing parts array:" + line);

                } else if (count == 2) {
                    classNum = Integer.parseInt(line);
                    System.out.println("Testing parts array:" + line);

                } else if (count == 3) {
                    studentNum = line;

                    //Studentnumber printed out to ensure code has reached this point
                    System.out.println(line);
                    writeTofile(surname, studentNum, classNum);

                }

                //checking to see if the code has made it to this point
                line = read.readLine();
                count++;

            }
            //close reader once it is no longer needed
            read.close();
        } catch (Exception e) {
            System.out.println("No more data found");
            System.out.println(e.toString());
        }

        //validate data from file based on CA requirements
    }

    public static boolean validData(String firstname, String surname, int classnum, String studentNum) {

        return firstname.matches("[a-zA-Z]+")
                && surname.matches("[a-zA-Z0-9]+")
                && classnum >= 1 && classnum <= 8
                && validStudentnum(studentNum);

    }
    //New method to validate student number requirements

    public static boolean validStudentnum(String studentNum) {
        //check first 2 charecters are letter

        try {

            int firstTwo = Integer.parseInt(studentNum.substring(0, 1));
            if (!studentNum.substring(firstTwo).contentEquals("[0-9]+")) {
                System.out.println("Invalid student number, charecters 1&2 must be numbers");
            }
        } catch (Exception e) {
            return true;

        }

        //check charecter 3 and 4 are letter 
        char third = studentNum.charAt(2);
        char fourth = studentNum.charAt(3);
        if ((!Character.isLetter(third) && Character.isLetter(fourth))) {

            System.out.println("invalid student number, charecters 3&4 must be letters");
            return false;
        }

        //check charecters 5 onward are numbers
        int length = studentNum.length();
        try {
            int lastNums = Integer.parseInt(studentNum.substring(5, length));
        } catch (Exception e) {
            System.out.println("Invalid student number, charecters 5 onward must be numbers");
            return false;
        }

        return true;
    }

    //new method to check student type based on class numbers from file
    public static String studentType(int classnum) {

        //if else statement to see whether student has a very light or light workload and also if they are part-time or full-time
        if (classnum == 1) {
            return "very light";

        } else if (classnum == 2) {
            return "light";

        } else if (classnum >= 3 && classnum <= 5) {
            return "part time";

        } else {
            return "full time";
        }
    }

    public static void writeTofile(String surname, String studentNum, int classNum) {
        BufferedWriter writer = null;
        try {
            //use BufferedWriter to write valid data to file "status.txt"
            writer = new BufferedWriter(new FileWriter("status.txt", true));

            //declare workload type based by calling studentType method
            String workload = studentType(classNum);

            //Write to file in the format explained in CA brief
            writer.append(studentNum + "-" + surname + "\n" + workload + "\n");

            //Checking to see the code has made it to this point
            System.out.println("Write to file");

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            //close Writer as it is no longer needed
            writer.close();

        } catch (Exception e) {
            System.out.println("Invalid data:");
        }

    }

}
