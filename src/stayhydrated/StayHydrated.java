/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        App app = new App();
        Date today = new Date();
        User activeUser;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        System.out.println("Let's Stay Hydrated!" + sdf.format(today));
        
        //create dummy users
        app.addUser("Jelly Beany", 170, 52.5);
        app.addUser("Tofu", 180, 80);
        
        if(app.isUserEmpty()){
            //instanciate new user
            app.addUser();   
        }
        
        app.selectUser();
        activeUser = app.activeUser();
        
        
        
        boolean terminate = false;
        
        while(!terminate){
          System.out.println("1) add intake 2) view status 3) Exit");  
          Scanner sc = new Scanner(System.in);
          String select = sc.nextLine();
          switch(select){
              case "1":
                  Intake newRecord = new Intake(ToL.COFFEE, 400);
                  activeUser.addIntake(newRecord);
                  break;
              case "2": 
                   // print percentage of daily intake 
                    System.out.println("Intake progress is " + activeUser.getIntakeProgress() + "%");
                    break;
              case "3":
                  terminate = true;
                  break;
              default:
                  System.out.println("INVALID INPUT");
          };
          
        }

        // rate of intake liquid 5 stars
        
        
        
        
            // The End
            System.out.println("See ya!");
    }
    
}

