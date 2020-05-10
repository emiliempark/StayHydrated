/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author emilie
 */
public class App {
    private final List<User> users = new ArrayList<>();
    private int selectedUserIndex;
    
    public int getNumOfUser(){
        return users.size();
    }
    
    public boolean isUserEmpty(){
        return users.isEmpty();
    }
    /**
     *
     * @param INDEX
     * @return
     */
    public User getUser(int INDEX){
        return users.get(INDEX);
    }
    public User activeUser(){
        return users.get(this.selectedUserIndex);
    }
    public void selectUser(){
        boolean terminate = false;
        
        while(!terminate){
            System.out.println("Hi, What's your name?");
            for(int i = 0; i < this.getNumOfUser(); i++ ){
                System.out.println((i+1) +") "+ this.getUser(i).toString());
            }
            int otherOption = this.getNumOfUser() + 1;
            System.out.println(otherOption +") I wanna create a new user");

            int terminateOption = this.getNumOfUser() + 2;
            System.out.println(terminateOption +") I'll come back later, Bye!");

            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();
            // add java.util.InputMismatchException to handle character input
            if(select <= this.getNumOfUser()){
                this.selectedUserIndex = select - 1;
                System.out.println("Oh, " + this.getUser(this.selectedUserIndex)+ "! What would you like to do?");
                terminate = true;
            
            }else if(select == otherOption){
                this.addUser();
                terminate = true;

            }else if(select == terminateOption){
                terminate = true; 
                this.appTerminate();
            }else{
                System.out.println("INVAILD OPTION SELECTED: Please try again!");
            }
        }   
    }

    public void appTerminate(){
        System.exit(0);
    }
    public void addUser(){
        users.add(new User());
    }
    public void addUser(String NAME, double HEIGHT, double WEIGHT, String DATE){
        users.add(new User(NAME, HEIGHT, WEIGHT, DATE));
    } 
    public void printInfo(){
        System.out.println(users);
    }
    @Override
    public String toString(){
        return Arrays.toString(users.toArray());
    }
}
