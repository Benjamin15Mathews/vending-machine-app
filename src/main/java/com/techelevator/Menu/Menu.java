package com.techelevator.Menu;

import java.util.*;

public abstract class Menu {
    //Attributes
    protected Map<String,String> choices = new HashMap<>();


    //Constructors
    public Menu(){
    }

    //Getter/Setters
    public Map<String, String> getChoices() {
        return choices;
    }

    //Methods-------
    public void printMenu() {
        System.out.println("------------------------------");
        for (Map.Entry<String,String> entry : choices.entrySet()){
            System.out.println("(" + entry.getKey() + ")" + " " + entry.getValue());
        }
        System.out.println("------------------------------");
    }
}
