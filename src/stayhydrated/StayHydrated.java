/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emilie
 */
public class StayHydrated {
    protected static String appConfigPath;
    protected static Properties appProps = new Properties();

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
     
    appConfigPath = "app.properties";
    try {
        appProps.load(new FileInputStream(appConfigPath));
    } catch (FileNotFoundException ex) {
        Logger.getLogger(StayHydrated.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(StayHydrated.class.getName()).log(Level.SEVERE, null, ex);
    }

       
        App app = new App();
        Date today = new Date();
        User activeUser;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.println("Let's Stay Hydrated!" + sdf.format(today));
        
        try {
            File storage = new File(appProps.getProperty("storagePath"));
            if (storage.createNewFile()) {
              System.out.println("File created: " + storage.getName());
            } else {
              System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Oops! Something went wrong" + e);
        }
        
        //create dummy users or read user from store
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
          System.out.println("1) Add intake \n2) View status \n3) Exit \n");  
          Scanner sc = new Scanner(System.in);
            
            switch(sc.nextLine()){
                case "1":
                    System.out.println("Type of drink:");

                    for(int i = 0; i < Liquid.Types.values().length; i++){
                        System.out.println((1+i) +") "+ Liquid.Types.values()[i]);
                    }

                    int typeSelect = sc.nextInt() - 1;

                    System.out.println("How much ml have you taken?");
                    int amountTaken = sc.nextInt();

                    activeUser.addIntake(new Intake(Liquid.Types.values()[typeSelect], (short)amountTaken));
                    break;
                case "2":
                    // print percentage of daily intake
                    System.out.println("list " + activeUser.getDailyIntakeRecord());
                    System.out.println("Intake progress is " + activeUser.getIntakeProgress() + "%");
                    break;
                case "3":
                    terminate = true;
                    break;
                default:
                    System.out.println("INVALID INPUT");
            };

        }
     
            // The End
            System.out.println("See ya!");
    }

    public StayHydrated() {
        this.appConfigPath = "app.properties";
    }
    
}

