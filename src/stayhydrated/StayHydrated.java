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

        while(users.numOfUsers == 0 || ! terminate){
            System.out.println("Please create a profile (y)es or (n)o:" );
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            switch(answer){
                case "y":
                    User newUser = new User();
                    System.out.println(newUser.data);
                    newUser.printInfo();
                    
                    // todo: save user profile info
                    users.addUser(newUser.data);
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
