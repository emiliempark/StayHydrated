/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emilie
 */
public class App {
    public List<User> users = new ArrayList<User>();
    
    public void printInfo(){
        System.out.println(users);
    }
}
