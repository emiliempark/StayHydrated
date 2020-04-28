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
       
        
        // todo: lowercase and check the first character
        boolean terminate = false;
        // print users 
        if(app.users.size() == 0){
            //instanciate new user
            User newUser = new User();
            app.users.add(newUser);
            app.printInfo();
        } 
        
    }
    
}
