package com.techelevator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Application {
	//Program attributes---------------------------------------------------------------->
	private static final String INVENTORY_FILE = "vendingmachine.csv";//INVENTORY FILE
	private static final String LOG_FILE =  "logs/Log.txt";//LOG FILE

	private static final Scanner userInput = new Scanner(System.in);//USER INPUT
	private static final NumberFormat formatter = NumberFormat.getCurrencyInstance();

	public static void main(String[] args){
		VendingMachine vendingMachine = new VendingMachine(INVENTORY_FILE, LOG_FILE);//Create a vending Machine
		Application application = new Application();//Create new App
		application.runVendingMachine(vendingMachine);//Start Program
		}//Main Loop

	//Methods

	public void runVendingMachine(VendingMachine vendingMachine){
		int input;//Var for to hold user input
		while (true) {
			vendingMachine.getMainMenu().printMenu();//Print Main Menu
			try {
				input = Integer.parseInt(userInput.nextLine());//Set Input for Menu Choice
			} catch (Exception e) {
				System.err.println("Invalid Input please use numbers\n");//Catch if not an Int
				continue;
			}
			switch (input){
				case 1 ://Display Items
					vendingMachine.displayItems();
					System.out.println("------------------------------");
					break;
				case 2 ://Purchase
					selectionMenu(vendingMachine);
					vendingMachine.finishTransaction();
					System.out.println("------------------------------");
					break;
				case 3 ://End Program
					System.out.println("Thank you for using the vending machine!");
					userInput.close();
					return;
				case 4 ://Write a Sales report
					vendingMachine.salesReport();
					System.out.println("Sales report written\n");
					break;
				default://Not valid input
					System.err.println("Invalid Choice\n");
					break;
			}//Menu Selection
		}
	}//Main Menu loop

	public void selectionMenu(VendingMachine vendingMachine){
		while (true){
			System.out.println("Current Money Provided: " + formatter.format(vendingMachine.getCurrBalance()) + "\n");
			vendingMachine.getPurchaseMenu().printMenu();
			//System.out.println("------------------------------");
			int selection;
			try {
				selection = Integer.parseInt(userInput.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Invalid input please use numbers\n");
				System.out.println("------------------------------");
				continue;
			}
			switch (selection){
				case 1://Add Money
					System.out.println("Amount in dollars to feed: ");
					try {
						int money = Integer.parseInt(userInput.nextLine());
						vendingMachine.feedMoney(money);
						System.out.println("------------------------------");
					} catch (Exception e){
						System.err.println("Please enter a whole number\n");
						System.out.println("------------------------------");
					}
					break;
				case 2://Buy an item
					vendingMachine.displaySelections();
					System.out.println("------------------------------");
					String string = userInput.nextLine();
					vendingMachine.selectProduct(string);
					System.out.println("------------------------------");
					break;
				case 3://Exit Purchase Menu
					return;
				default://Not a Valid Choice
					System.err.println("Invalid Choice\n");
					System.out.println("------------------------------");

			}

		}
	}
}

