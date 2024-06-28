package com.techelevator;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    /**Populates the inventory from a file.
     *
     * @return Map<String, Product>
     */
    public static Map<String, Product> initInventory(String fileName){
        Map<String, Product> inventory = new HashMap<>();//Creates a Map to return
        File file = new File(fileName);//Loads File
        try (Scanner scanner = new Scanner(file)) {//Try To Open File
            while (scanner.hasNextLine()){//If There is a next line
                String[] line = scanner.nextLine().split("\\|");
                Product product = new Product(line[1], Double.parseDouble(line[2]), line[3]);
                inventory.put(line[0], product);
            }
        } catch (FileNotFoundException e) {//Catch if unable to open file
            System.err.println(e.getMessage());
        }
        return inventory;//Return Map
    }


}
