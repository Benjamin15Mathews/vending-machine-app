package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class VendingMachineTest {
    File inventory = new File("inventoryTest.csv");
    File log = new File("testLog.txt");


    @Test
    public void  test_Feeds_Correct_Money(){
        VendingMachine vendingMachine = new VendingMachine(inventory.getPath(), log.getPath());
        vendingMachine.feedMoney(10);
        Assert.assertEquals(10, vendingMachine.getCurrBalance(),0);
    }

    @Test
    public void  test_Selects_Correct_Product(){
        VendingMachine vendingMachine = new VendingMachine(inventory.getPath(), log.getPath());
        vendingMachine.feedMoney(10);
        vendingMachine.selectProduct("A1");
        Assert.assertEquals(6.95, vendingMachine.getCurrBalance(),0);
    }

    @Test
    public void  test_Selects_wrong_Product_Code(){
        VendingMachine vendingMachine = new VendingMachine(inventory.getPath(), log.getPath());
        vendingMachine.feedMoney(10);
        vendingMachine.selectProduct("Z10");
        Assert.assertEquals(10, vendingMachine.getCurrBalance(),0);
    }

    @Test
    public void  test_Select_Item_with_not_Enough_Money(){
        VendingMachine vendingMachine = new VendingMachine(inventory.getPath(), log.getPath());
        vendingMachine.feedMoney(1);
        vendingMachine.selectProduct("A1");
        Assert.assertEquals(1, vendingMachine.getCurrBalance(),0);
    }
}
