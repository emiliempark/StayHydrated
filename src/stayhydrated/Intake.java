/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import stayhydrated.Liquid.Types;

/**
 *
 * @author emilie
 */

public class Intake {
    public final Date createdAt = new Date(); // dataforamt 
    String type;

    int amount; // ml
    
    /**
     *
     * @param TYPE
     * @param AMOUNT
     */
    public Intake(Types TYPE, short AMOUNT){

        this.type = TYPE.toString();
        
        // hash map or array of properties?
        Liquid selectedLiquid = null;
        switch(TYPE){
            case WATER: 
                selectedLiquid = new Water(AMOUNT);
                break;
            case COFFEE:
                selectedLiquid = new Coffee(AMOUNT);
                break;
            case TEA:
                selectedLiquid = new Tea(AMOUNT);
                break;
            case JUICE:
                selectedLiquid = new Juice(AMOUNT);
                break;
            case FIZZYDRINK:
                selectedLiquid = new FizzyDrink(AMOUNT);
                break;
            default: 
                System.out.println("INVALID LIQUID TYPE");
        }
        
        if(selectedLiquid != null){
            this.amount = selectedLiquid.acceptedAmount();

        }
    }

    @Override
    public String toString(){
        return this.type+" "+this.amount+"ml "+this.createdAt;
    }
    
    public Map toMap(){
        Map map = new HashMap();
        map.put("type", this.type);
        map.put("amount", this.amount);
        map.put("createdAt", this.createdAt);
        return map;
        
    }
}
