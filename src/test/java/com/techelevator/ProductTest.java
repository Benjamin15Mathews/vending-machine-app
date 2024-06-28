package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void test_Product(){
        Product product = new Product("Fritos", 1.45, "Chip");

        //Assert.assertEquals("Fritos", product.getName());
        //Assert.assertEquals(1.45, product.getPrice(),0);
        //Assert.assertEquals("Chip", product.getItemType());
        Assert.assertEquals("Fritos $1.45 Chip", product.productInfo());
    }
}
