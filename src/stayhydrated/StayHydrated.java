/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author emilie
 */
public class StayHydrated {

    public static void main(String[] args) {
        
        App app = new App();
        Date today = new Date();
        User activeUser;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        System.out.println("Let's Stay Hydrated!" + sdf.format(today));
        
        try {
            File usersFile = new File("test-filename.txt");
            if (usersFile.createNewFile()) {
              System.out.println("File created: " + usersFile.getName());
            } else {
              System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Oops! Something went wrong" + e);
        }
        
        try {
            FileWriter usersFileWriter = new FileWriter("test-filename.txt");
            usersFileWriter.write("I can write to file!!!");
            usersFileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Oops! Something went wrong" + e);
        }

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
    
}

