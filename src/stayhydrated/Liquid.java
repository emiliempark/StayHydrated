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
public abstract class Liquid {
   public String type = "";
   public int hydratePercentage;
   public int rate;
   
   public Liquid(String TYPE_NAME, int RATE){
       this.type = TYPE_NAME;
       this.rate = RATE;
   }
   
   public abstract void acceptedAmount();
   
   public abstract void printInfo();
    
    
}
