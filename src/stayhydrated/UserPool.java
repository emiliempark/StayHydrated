/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author emilie
 */
public class UserPool {
    public ArrayList<Object> users;
    public int numOfUsers;
    
    public UserPool(){
        this.users = new ArrayList<>();
        this.numOfUsers = this.users.size();
    }
    public void getAllUsers(){
//        Iterator it = this.list.iterator();
//        while(it.hasNext()){
//            
//        }
        
        System.out.println(this.users);
        
    }
    public void getUser(int INDEX){
        this.users.get(INDEX);
    }
    public void addUser(HashMap USER_OBJ){
        this.users.add(USER_OBJ); 
        // update array size
        this.numOfUsers = this.users.size();
    }
    public void editUser(){}
    public void removeUser(){}
    
}
