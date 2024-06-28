package com.techelevator;


import java.text.NumberFormat;

public class Product{
    //Attributes------------------->
    private final String name;//Name
    private final double price;//Price
    private final String itemType;//Type of Item Like Candy

    //Constructors---------------->

    public Product(String name, double price, String itemType) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
    }

    public String productInfo(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return (name + " " + formatter.format(price) + " " + itemType);
    }


    //Getter/Setters-------------->

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }


    //Methods---------------------->
}
