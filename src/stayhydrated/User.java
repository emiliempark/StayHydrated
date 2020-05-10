/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author emilie
 */
public class User {
    private String name;
    private double height, weight;
    private Goal goal;
    private final Date createdAt = new Date();
    List<Intake> intakes = new ArrayList<>();
    private double intakeProgressPercentage;
    private int healthRate; // 5stars?
    
    
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
                this.name, df.format(this.height), df.format(this.weight), df.format(this.goal.average));
    }
    
    public String getName(){
        return this.name;
    }
    
    public List<Intake> getDailyIntakeRecord(){
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
