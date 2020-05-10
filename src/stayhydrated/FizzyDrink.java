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
public class FizzyDrink extends Liquid{

    public FizzyDrink(short AMOUNT){
        super(Types.FIZZYDRINK, 1);
        this.hydratePercentage = 70;
        this.enteredAmount = AMOUNT;
    }

    @Override
    public void printInfo() {
        // print
        // fizzy drink is carbonated and contains too much sugar
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
