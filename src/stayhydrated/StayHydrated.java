/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author emilie
 * @git https://github.com/emiliempark/StayHydrated.git
 */
public class StayHydrated extends JFrame {
    
    protected static String appConfigPath;
    protected static Properties appProps = new Properties();
    protected static SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");;
    protected static JFrame frame;
    protected static JPanel pUser;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // create frame
        frame = new JFrame("Stay Hydrated");
        frame.setVisible(true);
        
        // set frame size
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        int windowWidth = 600;
        int windowHeight = 400;
        
        if(windowWidth > screenWidth){
            windowWidth = screenWidth;
        }
        
        if(windowHeight > screenHeight){
            windowHeight = screenHeight;
        }
        
        frame.setSize(windowWidth, windowHeight);
        frame.setLocation(50, 50);
        frame.setLayout(new BorderLayout());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set user panel 
        pUser = new JPanel();
        frame.add(pUser, BorderLayout.NORTH);
        pUser.setLayout(new BoxLayout(pUser, BoxLayout.X_AXIS));
        
        JPanel pContent = new JPanel();
        
        frame.add(pContent, BorderLayout.CENTER);
        pContent.setBackground(Color.pink);
        
        appConfigPath = "app.properties";
        
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (FileNotFoundException e) {
            Logger.getLogger(StayHydrated.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(StayHydrated.class.getName()).log(Level.SEVERE, null, e);
        }

       
        App app = new App();
        Date today = new Date();
        User activeUser;
        
        // get the current date time
        System.out.println("Let's Stay Hydrated!" + sdf.format(today));

        // create storage.txt file
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
        
        // read users from storage.txt
        BufferedReader reader;
        try{ 
            reader = new BufferedReader(new FileReader(appProps.getProperty("storagePath")));
            String line = reader.readLine();
            while(line != null){
                String[] userDeets = line.split(",");
                app.addUser(userDeets[0], Double.parseDouble(userDeets[1]), Double.parseDouble(userDeets[2]), userDeets[3]);
                //read next line
                line = reader.readLine();
            }
            
            reader.close();
        }catch(IOException e){
            System.out.println("Oops! Something went wrong" + e);
        }
        
        if(app.isUserEmpty()){
            // display text field and a button
            // instanciate new user
            app.addUser();   
        }

        boolean terminateApp = false;
        
        while(!terminateApp){
            app.selectUser();
            activeUser = app.activeUser();
            boolean terminateUserActivity = false;
        
            while(!terminateUserActivity){
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
                        terminateUserActivity = true;
                        break;
                    default:
                        System.out.println("INVALID INPUT");
                }
            }
        }
        
        // The End
        System.out.println("See ya!");
    }

    private static String Pattern(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}

