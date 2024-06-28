package com.techelevator.Menu;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


public class MainMenuTest {
    @Test
    public void test_MainMenu_Choices() {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("1", "Display Vending Machine Items");
        testMap.put("2", "Purchase");
        testMap.put("3", "Exit");

        Assert.assertEquals(new MainMenu().choices,testMap);
    }
}
