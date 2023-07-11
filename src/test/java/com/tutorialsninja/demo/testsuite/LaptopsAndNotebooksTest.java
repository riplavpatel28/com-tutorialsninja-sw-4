package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.LaptopsAndNoteBooks;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {
    LaptopsAndNoteBooks laptopsAndNotebooks = new LaptopsAndNoteBooks();


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        laptopsAndNotebooks.mouseHoverOnLaptopsAndNotebook();
        //1.2 Click on “Show AllLaptops & Notebooks”
        laptopsAndNotebooks.clickOnLaptopsAndNotebook();
        // Get all the products price and stored into array list
        List<Double> originalProductsPrice = laptopsAndNotebooks.getProductPrice();
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooks.sortByHightoLow();

        // After filter Price (High > Low) Get all the products price and stored into array list
        List<Double> afterSortByPrice = laptopsAndNotebooks.getProductPrice();
        System.out.println(afterSortByPrice);
        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(originalProductsPrice, afterSortByPrice);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        // Select currency as £ Pound Sterling
        laptopsAndNotebooks.clickOnPound();
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        laptopsAndNotebooks.mouseHoverOnLaptopsAndNotebook();
        //2.2 Click on “Show All Laptops & Notebooks”
        laptopsAndNotebooks.clickOnLaptopsAndNotebook();
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooks.sortByHightoLow();
        //2.4 Select Product “MacBook”
        laptopsAndNotebooks.clickOnMacbook();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals( "MacBook", laptopsAndNotebooks.textMacbook());
        //2.6 Click on ‘Add To Cart’ button
        laptopsAndNotebooks.clickOnAddCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(
                laptopsAndNotebooks.textCartMessage()
                        .contains("Success: You have added MacBook to your shopping cart!"));
        //2.8 Click on link “shopping cart” display into success message
        laptopsAndNotebooks.clickOnShopping();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(laptopsAndNotebooks.textShoppingCartMessage().contains("Shopping Cart"));
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals( "MacBook", laptopsAndNotebooks.getProduct());
        //2.11 Change Quantity "2"
        laptopsAndNotebooks.setQuantityTo2();
        //2.12 Click on “Update” Tab
        laptopsAndNotebooks.clickOnUpdate();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue( laptopsAndNotebooks.textShoppingMacMessage().contains("Success: You have modified your shopping cart!"));
        //2.14 Verify the Total £737.45
        Assert.assertEquals( "£737.45", laptopsAndNotebooks.getTotal());
    }
}
