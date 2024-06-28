package com.techelevator.Menu;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PurchaseMenuTest {
    @Test
    public void test_Purchase_Menu_Choices() {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("1", "Feed Money");
        testMap.put("2", "Select Product");
        testMap.put("3", "Finish Transaction");

        Assert.assertEquals(new PurchaseMenu().choices,testMap);
    }
}
