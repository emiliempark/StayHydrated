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
        
        UserPool users = new UserPool();
        
        System.out.println("Let's Stay Hydrated!");
       
        
        // todo: lowercase and check the first character
        boolean terminate = false;
        // print users
        users.getAllUsers();
        System.out.println(users.numOfUsers);
        while(users.numOfUsers == 0 || ! terminate){
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
                    
                    
                    User newUser = new User(name, height, weight);
                    System.out.println(newUser.deets);
                    newUser.printInfo();
                    
                    // todo: save user profile info
                    users.addUser(newUser.deets);
                    System.out.println(users.numOfUsers);
                    terminate = true;
                    break;
                case "n":
                    terminate = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        
        users.getAllUsers();
    }
    
}
