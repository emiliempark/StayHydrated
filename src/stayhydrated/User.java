/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static stayhydrated.StayHydrated.appProps;
import static stayhydrated.StayHydrated.sdf;

/**
 *
 * @author emilie
 */
public class User {
    private String name;
    private double height, weight;
    private Goal goal;
    private String createdAt;
    List<Intake> intakes = new ArrayList<>();
    private double intakeProgressPercentage;
    private int healthRate; // 5stars?
    
    
    
    public User(String NAME, double HEIGHT, double WEIGHT, String DATE){
        this.name = NAME;
        this.height= HEIGHT;
        this.weight = WEIGHT;
        this.goal = new Goal(this.height, this.weight);
        this.createdAt = DATE;
        
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
        
        this.createdAt = sdf.format(new Date());
        
        this.saveUserToStorage();
        this.printInfo();
    };
   
    public void saveUserToStorage(){
        try {
            FileWriter storageWriter = new FileWriter(appProps.getProperty("storagePath"), true);
            storageWriter.write(this.name + "," + this.height +","+ this.weight + ","+ sdf.format(new Date())+ "\n" );
            storageWriter.close();
            System.out.println("Successfully saved to the storage");
        } catch (IOException e) {
            System.out.println("Oops! Something went wrong" + e);
        }
    }
    public void printInfo(){
        // remove trailing zeros 
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.printf("Hi %s,%n"
                + "You're %scm tall, %skg light.%n"
                + "Stay hydrated by drinking %s litre(s) of liquid every day.%n",
                this.name, df.format(this.height), df.format(this.weight), df.format(this.goal.average));
    }
    
    public String getName(){
        return this.name;
    }
    
    public List<Intake> getDailyIntakeRecord(){
        // read file
        return this.intakes;
    }
    
    public int getIntakeProgress(){

        int totalAmount = 0;
        double goalInML = this.goal.average * 1000;
        for (int i = 0; i < this.intakes.size(); i++){
            totalAmount += this.intakes.get(i).amount;
        }
        
        double calc = totalAmount / goalInML  * 100.0;

        return (int) Math.round(calc);
    }

    public void addIntake(Intake INTAKE_RECORD){
        boolean isAdded = false;
        try{
            this.intakes.add(INTAKE_RECORD);
            isAdded = true;
        } catch(Exception e) {
            throw e;
        }
        if(isAdded){
            System.out.println("Good Job! New intake record added!");
            System.out.println("More things to do?");
        }
        
    }
    
    @Override
    public String toString(){ // return type: String
        return this.getName();
    }
    
}
