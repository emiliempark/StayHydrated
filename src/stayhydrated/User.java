/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author emilie
 */
public class User {
    private String name;
    private double height, weight;
    private Goal goal;
    private final Date createdAt = new Date();
    List<Intake> intakes;
    Map<Date,List> dailyIntakes;
    
    public User(){
        
        //loop the process to re-initiate in a case of user enter invalid input
        
        System.out.println("Create a profile (y)es or (n)o:" );
        Scanner sc = new Scanner(System.in);
        String anser = sc.nextLine().substring(0, 1).toLowerCase();
        
        
        switch(anser){
            case "y":
                System.out.println("Name: ");
                this.name = sc.nextLine();

                System.out.println("Height(cm): ");
                this.height = sc.nextDouble();

                System.out.println("Weight(kg): ");
                this.weight = sc.nextDouble();

                this.goal = new Goal(this.height, this.weight);
                
                this.printInfo();

                break;
            case "n":
                break;
            default:
                System.out.println("INVALID INPUT");
                break;
            
        }
        
    };
   
    
    public void printInfo(){
        // remove trailing zeros 
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.printf("Hi %s,%n"
                + "You're %scm tall, %skg light.%n"
                + "Stay hydrated by drinking %s litre(s) of liquid every day.%n",
                this.name, df.format(this.height), df.format(this.weight), df.format(this.goal.amount));
    }
    
}
