# Merit America Capstone 1

This app is for a Vending Machine. It allows customers to purchase products of their choice.

## Features

- The vending machine reads its inventory from an input file when the vending machine starts
- it displays a menu to the user
- it dispenses beverages, candy, chips, and gum. Each vending machine item has a Name and a Price.
- it has the ability to be automatically restocked each time it runs.

### Java Features Used
OOP Principles
Data Structures (Map, List)
Command Line Interface
File I/O
JUnit Tests

## How to run and use the project

### Prerequisite:
Java JDK 8 or later 
Maven

* Clone this repository to your local machine using your terminal/Gitbash
* Run `mvn clean compile assembly:single` from your project directory (this will build the project and create a jar file in the target directory).
* Run `java -jar target/m1-java-capstone-vending-machine-1.0-jar-with-dependencies.jar` from your project directory

After running the project, you will be presented with the following options:
    
1. Display Vending Machine Items
2. Purchase
3. Exit

### Display Vending Machine Items

When you selects "(1) Display Vending Machine Items", you will be presented with a list of all items in the vending machine with its quantity remaining:

- Each vending machine product has a slot identifier and a purchase price.
- A product that has run out will indicate that it's SOLD OUT.

### Purchase

When you select option "(2) Purchase", you will be guided through the purchasing process menu:

1. Selecting "(1) Feed Money" allows you to repeatedly feed money into the machine in whole dollar amounts.
    - The "Current Money Provided" indicates how much money you have fed into the machine.
2. Selecting "(2) Select Product" allows you to select a product to purchase.
    - It will show the list of products available and allow you to enter a code to select an item.
    - If the product code doesn't exist, the vending machine informs the customer and returns them to the Purchase menu.
    - If a product is currently sold out, the vending machine informs the customer and returns them to the Purchase menu.
    - If a customer selects a valid product, it's dispensed to the customer.
    - Dispensing an item prints the item name, cost, and the money remaining. Dispensing also returns a message:
        - All chip items prints "Crunch Crunch, Yum!"
        - All candy items prints "Munch Munch, Yum!"
        - All drink items prints "Glug Glug, Yum!"
        - All gum items prints "Chew Chew, Yum!"
    - After the machine dispenses the product, the machine updates its balance accordingly and returns the customer to the Purchase menu.
3. Selecting "(3) Finish Transaction" allows the customer to complete the transaction and receive any remaining change.
    - The machine returns the customer's money using nickels, dimes, and quarters (using the smallest amount of coins possible).
    - The machine's current balance updates to $0 remaining.
4. After completing their purchase, the user returns to the "Main" menu to continue using the vending machine.

### Logging Transactions

The vending machine logs all transactions to prevent theft from the vending machine using a custom logger.

- Each purchase generates a line in a file called `Log.txt`.
- The lines follow the format shown in the following example.
    - The first dollar amount is the amount deposited, spent, or given as change.
    - The second dollar amount is the new balance.
