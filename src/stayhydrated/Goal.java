/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

/**
 *
 * @author emilie
 */
public class Goal {
    double amount;

    
    public Goal(double HEIGHT, double WEIGHT){
        double min = WEIGHT * 0.03 ;   
        double max = (HEIGHT + WEIGHT) / 100;
        double average = (double)Math.round((min + max) / 2 * 100) / 100;  
        
        this.amount = average;
    }
}
