/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.util.Scanner;

/**
 *
 * @author emilie
 */
public class StayHydrated {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello, no profile found" );
        
        // todo: lowercase and check the first character
        boolean terminate = false;
        
        while(!terminate){
            System.out.println("Please create a profile (y)es or (n)o:" );
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            switch(answer){
                case "y":
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    System.out.println("Height(cm): ");
                    Double height = sc.nextDouble();
                    System.out.println("Weight(kg): ");
                    Double weight = sc.nextDouble();
                    
                    // todo: save user profile info
                    User newUser = new User(name, height, weight);
                    newUser.printInfo();
                    break;
                case "n":
                    terminate = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        
    }
    
}
