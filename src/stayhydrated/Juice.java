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
public final class Juice extends Liquid{
    
    public Juice(short AMOUNT){
        super(Types.JUICE, 2);
        this.hydratePercentage = 70;
        this.enteredAmount = AMOUNT;

    }
    
    @Override
    public void printInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
