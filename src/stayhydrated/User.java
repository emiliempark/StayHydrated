/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.lang.reflect.Field;
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
    private int intakeProgressPercentage;
    private int healthRate; // 5stars?
    
    // static polymorphism
    
    public User(String NAME, double HEIGHT, double WEIGHT){
        this.name = NAME;
        this.height= HEIGHT;
        this.weight = WEIGHT;
        this.goal = new Goal(this.height, this.weight);
    }
    
    public User(){
        
        //loop the process to re-initiate in a case of user enter invalid input
        
        System.out.println("Create a new user" );
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Name: ");
        this.name = sc.nextLine();

        System.out.println("Height(cm): ");
        this.height = sc.nextDouble();

        System.out.println("Weight(kg): ");
        this.weight = sc.nextDouble();

        this.goal = new Goal(this.height, this.weight);

        this.printInfo();
    };
   
    
    public void printInfo(){
        // remove trailing zeros 
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.printf("Hi %s,%n"
                + "You're %scm tall, %skg light.%n"
                + "Stay hydrated by drinking %s litre(s) of liquid every day.%n",
                this.name, df.format(this.height), df.format(this.weight), df.format(this.goal.amount));
    }
    
    public String getName(){
        return this.name;
    }
 
    @Override
    public String toString(){ // return type: String
        return this.getName();
    }
    
}
