/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stayhydrated;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static stayhydrated.StayHydrated.frame;
import static stayhydrated.StayHydrated.pUser;

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
    // get list of users
    public void selectUser(){
        // add left col panel
        JPanel pUserColLeft = new JPanel(new FlowLayout());
        
        pUser.add(pUserColLeft, BorderLayout.LINE_START);
     
        boolean terminate = false;
        
        while(!terminate){
            
            for(int i = 0; i < this.getNumOfUser(); i++ ){
                
                JButton userButton = new JButton(this.getUser(i).toString());
                userButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object source = e.getSource();
                        
                        System.out.println("test button clicked" + source);
//                        System.out.println((i+1) +") "+ this.getUser(i).toString());
                    }
                });
                pUserColLeft.add(userButton,BorderLayout.LINE_START);
            }
            
            int otherOption = this.getNumOfUser() + 1;
            
            // add user button
            // add right col panel 
            JPanel pUserColRight = new JPanel();
            pUser.add(pUserColRight, BorderLayout.LINE_END);
            
            pUserColRight.setBackground(Color.red);
            JButton addUserBtn = new JButton("Add User");
            
            addUserBtn.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e) {
//                    addUserPopup.setVisible(true);
                    System.out.println("add user button clicked");             
                }
            
            });
            
            pUserColRight.add(addUserBtn);
            
            
//            System.out.println(otherOption +") I wanna create a new user");

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

            }else{
                System.out.println("INVAILD OPTION SELECTED: Please try again!");
            }
        } 
        frame.add(pUser);
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
