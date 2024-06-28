package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InventoryTest {

    @Test
    public void test_Inventory(){
        Map<String,Product> inventoryList = Inventory.initInventory("inventoryTest.csv");

        Map<String, Product> testList = new HashMap<String,Product>();
        Product A1 = new Product("Potato Crisps", 3.05, "Chip");
        Product A2 = new Product("Stackers", 1.45, "Chip");
        testList.put("A1",A1);
        testList.put("A2",A2);


    }
}
