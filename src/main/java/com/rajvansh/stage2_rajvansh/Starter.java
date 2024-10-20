/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.rajvansh.stage2_rajvansh;


/**
 *
 * @author Rajvansh
 */
import java.util.Scanner;

public class Starter {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Do you want to run The TesterFile? (yes/no)");
        String option = scanner.nextLine();


        if (option.equalsIgnoreCase("yes")) {
            FlightCenterTester.main(args);
        } else if (option.equalsIgnoreCase("no")) {
            System.out.println("Do you want to run the GUI File? (yes/no)");
            String option2 = scanner.nextLine();
            if (option2.equalsIgnoreCase("yes")) {
                FlightCenterGUI.main(args);   
            } else if (option2.equalsIgnoreCase("no")) {
                FlightCenter.main(args);
            }
                
            
        }
    }
}