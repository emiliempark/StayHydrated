/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.util.List;
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
        
        App app = new App();
        System.out.println("Let's Stay Hydrated!");
       
        if(app.users.size() == 0){
            //instanciate new user
            User newUser = new User();
            app.users.add(newUser);
            System.out.println(app.users.size());
        } else{
            // print options or user to choose
            // 1) existing users
            // 2) create a new user
            
            // 3) ask user 
            // System.out.println("Are you going to create a profile (y)es or (n)o:" );
            // yes - create a new user, 
            // User newUser = new User();
            // app.users.add(newUser);
            // System.out.println(app.users.size());
            // no- terminate, exception - invalid value;
        }
        
    }
    
}
