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
public class Coffee extends Liquid{

    public Coffee(short AMOUNT) {
        super(Types.COFFEE, 3);
        this.hydratePercentage = 85;
        this.enteredAmount = AMOUNT;
    }

    @Override
    public void printInfo() {
        // print 
        // coffee is caffeinated beverage
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
