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
    public double min;
    public double max;
    public double average;

    
    public Goal(double HEIGHT, double WEIGHT){
        this.min = WEIGHT * 0.03 ;   
        this.max = (HEIGHT + WEIGHT) / 100;
        this.average = (double)Math.round((min + max) / 2 * 100) / 100;  
    }
}
