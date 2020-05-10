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
   public Types type;
   public int hydratePercentage;
   public int rate;
   public short enteredAmount;
   public enum Types { 
       WATER("Water"), 
       COFFEE("Coffee"), 
       TEA("Tea"), 
       JUICE("Juice"), 
       FIZZYDRINK("Fizzy Drink");
       
       private final String name;
       
       Types (String NAME){
           this.name = NAME;
       }
       
       
       @Override
       public String toString(){
           return this.name;
       }
       
   }
   
   public Liquid(Types TYPE_NAME, int RATE){
       this.type = TYPE_NAME;
       this.rate = RATE;
   }
   
    /**
     *
     * @return the amount user input * hydrate percentage
     */
    public short acceptedAmount(){
     return (short) (this.enteredAmount * (this.hydratePercentage / 100.0));    
    };
   
   public abstract void printInfo();
    
    
}
