/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author emilie
 */
public class Intake {
    public final Date createdAt = new Date(); // dataforamt 
    ToL type;

    int amount; // ml
    
    
    public Intake(ToL TYPE, int AMOUNT){
        System.out.println("test" + TYPE);
        this.type = TYPE;
        this.amount = AMOUNT;
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
