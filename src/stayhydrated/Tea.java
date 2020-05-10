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
public class Tea extends Liquid{
    
    public Tea(short AMOUNT){
        super(Types.TEA, 4);
        this.hydratePercentage = 100;
        this.enteredAmount = AMOUNT;
    }

    @Override
    public void printInfo() {
        // print
        // tea is good :) 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
