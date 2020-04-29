/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.util.Arrays;
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
        User activeUser;
        System.out.println("Let's Stay Hydrated!");
        
        //create dummy users
        app.addUser("Jelly Beany", 170, 52.5);
        app.addUser("Tofu", 180, 80);
        
        if(app.isUserEmpty()){
            //instanciate new user
            app.addUser();   
        }
        
        app.selectUser();
        activeUser = app.activeUser();
        System.out.println("selected User "+ activeUser);
        
        
            // The End
            System.out.println("See ya!");
    }
    
}

