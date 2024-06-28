package com.techelevator;

import com.techelevator.Menu.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    //Attributes---------------------->
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private final Map<Product, Integer> itemsInMachine = new HashMap<>(); //Store Products with remaining quantity
    private double currBalance; //Current Money In Machine
    private double totalSales;//Gross sales
    private final Map<String, Product> inventory;
    private final Logger logger;


    //Menus
    private final Menu mainMenu = new MainMenu();//Create Main Menu
    private final Menu purchaseMenu = new PurchaseMenu();//Create PurchaseMenu


    //Constructors---------------------->
    public VendingMachine(String inventoryFile, String logFile){
        inventory = Inventory.initInventory(inventoryFile);//Loads Inventory
        logger = new Logger(logFile);//Create New Log File
        for (Map.Entry<String, Product> entry : inventory.entrySet()){//Puts inventory into machine
            itemsInMachine.put(entry.getValue(), 5);
        }
    }

    //Getter/Setters------------------->
    public double getCurrBalance(){
        return currBalance;
    }//Get current Money in Machine

    public Menu getMainMenu() {
        return mainMenu;
    }

    public Menu getPurchaseMenu() {
        return purchaseMenu;
    }

    //Methods-------------------------->
    public void displayItems(){
        for (Map.Entry<String, Product> e : inventory.entrySet()){//For Every Item
            int quantity = itemsInMachine.get(e.getValue());
            if (quantity == 0) {
                System.out.println(e.getValue().productInfo() + ", SOLD OUT");
            } else {
                System.out.println(e.getValue().productInfo() + ",  " +
                        quantity);
            }
        }

    }/*Iterates through map of products and displays their SlotID,Name,Price and Quantity
    if Quantity is 0 list as sold out*/

    public void feedMoney(int wholeDollarIn){
            currBalance += wholeDollarIn;
            logger.log("FEED MONEY: " + formatter.format(wholeDollarIn) + " " + formatter.format(currBalance));
    }//Ask How much

    public void selectProduct(String productCode){
        if (!inventory.containsKey(productCode.toUpperCase())){
            System.err.println("Product code does not exist\n");
        } else if (itemsInMachine.get(inventory.get(productCode.toUpperCase())) == 0) {
            System.err.println("Product is sold out\n");
        } else if (inventory.get(productCode.toUpperCase()).getPrice() > currBalance){
            System.err.println("Not enough money\n");
        } else {
            dispense(productCode.toUpperCase(), inventory.get(productCode.toUpperCase()));
        }

    }/*Iterate through map of products showing their name price and slot name
    If incorrect Slot entered inform customer and ask user again
    If item is sold out tell customer rand ask user again
    If valid runs dispense methods on product and ask user again*/

    /**
     * Subtracts product price from current balance, decrement remaining number of product
     * by 1,
     * @param productCode Product code
     * @param product Product
     */
    public void dispense(String productCode,Product product) {
        currBalance -= product.getPrice();
        itemsInMachine.put(product, itemsInMachine.get(product) - 1);
        System.out.println(product.getName() + " " + formatter.format(product.getPrice())  +
                " remaining balance: " + formatter.format(currBalance));
        funnyMessage(product.getItemType());
        totalSales += product.getPrice();
        logger.log(product.getName() + " " + productCode + " " + formatter.format(product.getPrice())
            + " " + formatter.format(currBalance));

    }

    /**
     * Prints a message based on product type
     */
    private void funnyMessage(String itemType){
        switch (itemType.toLowerCase()){
            case "chip":
                System.out.println("Crunch Crunch, Yum!");
                break;
            case "candy":
                System.out.println("Munch Munch, Yum!");
                break;
            case "drink":
                System.out.println("Glug Glug, Yum!");
                break;
            case "gum":
                System.out.println("Chew Chew, Yum!");
                break;
            default:
                System.out.println("I don't know this type???");
                break;
        }
    }

    /**
     * Calculates change using the least amount of coins and updates currentBalance to $0
     */
    public void finishTransaction() {
        double change = currBalance;
        logger.log("GIVE CHANGE: " + formatter.format(change) + " $0.00");
        int quarters = (int) (100 * currBalance) / 25;
        currBalance -= quarters * 0.25;
        int dimes = (int) (100 * currBalance) / 10;
        currBalance -= dimes * 0.10;
        int nickels = (int) (100 * currBalance) / 5;
        currBalance = 0;

        System.out.println("Change: " + formatter.format(change));
        System.out.println("\tQuarters: " + quarters);
        System.out.println("\tDimes: " + dimes);
        System.out.println("\tNickels: " + nickels);

    }


    /**
     * Writes a sales report to a text file named "Sales Report [current date and time]"
     */
    public void salesReport(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("M.d.y hh.mm.ss a");
        String dateTime = localDateTime.format(dateformat);

        File file = new File("reports/Sales Report " + dateTime + ".txt");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))){
            for (Map.Entry<Product, Integer> entry : itemsInMachine.entrySet()) {
                out.append(entry.getKey().getName()).append("|").append(String.valueOf(5 - entry.getValue())).append("\n");
            }
            out.append("\n");
            out.append("**TOTAL SALES** ").append(formatter.format(totalSales));
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    /**
     * Prints out the product codes, and products
     */
    public void displaySelections(){
        for (Map.Entry<String, Product> e : inventory.entrySet()){
                System.out.println(e.getKey() + ": " + e.getValue().productInfo());
            }
        }

    }
