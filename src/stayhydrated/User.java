/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author emilie
 */
public class User {
    public String name;
    public double height, weight, intakeGoal;
    private final Date createdAt;
    
    public User(String NAME, double HEIGHT, double WEIGHT){
        this.name = NAME;
        this.height = HEIGHT;
        this.weight = WEIGHT;
        this.calcIntakeGoal();
        this.createdAt = new Date();
    };
    
    private void calcIntakeGoal(){
        double min = this.weight * 0.03 ;   
        double max = (this.height + this.weight) / 100;
        double average = (min + max) / 2;

        this.intakeGoal = (double)Math.round(average * 100) /100; // why I need to cast? 
    };
    
    public void printInfo(){
        // remove trailing zeros 
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.printf("Hi %s,%n"
                + "You're %scm tall, %skg light.%n"
                + "Stay hydrated by drinking %s litre(s) of liquid every day.%n",
                this.name, df.format(this.height), df.format(this.weight), df.format(this.intakeGoal));
    }
    
}
