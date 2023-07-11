package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNoteBooks extends Utility {
    By laptopAndNotebook = By.linkText("Laptops & Notebooks");

    By showAll = By.linkText("Show AllLaptops & Notebooks");

    By price = By.xpath("//p[@class ='price']");

    By highToLow = By.id("input-sort");





    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By poundSterling = By.xpath("//ul[@class = 'dropdown-menu']/li");
    By macbook = By.linkText("MacBook");

    By macbookText = By.xpath("//h1[contains(text(),'MacBook')]");


    By addCartButton =By.xpath("//button[@id='button-cart']");


    By cartMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");


    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");

    By shoppingCartText =  By.xpath("//div[@id='content']//h1");


    By product  = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");

    By quantity = By.xpath("//input[contains(@name, 'quantity')]");

    By update = By.xpath("//button[contains(@data-original-title, 'Update')]");

    By MsgSucc = By.xpath("//div[@id='checkout-cart']/div[1]");

    By total = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");


    public void clickOnPound(){
        clickOnElement(currency);
        selectByContainsTextFromListOfElements(poundSterling, "£Pound Sterling");    }
    public void mouseHoverOnLaptopsAndNotebook() {
        mouseHoverToElementAndClick(laptopAndNotebook);
    }

    public void clickOnLaptopsAndNotebook() {
        clickOnElement(showAll);
    }

    public void clickOnMacbook() {
        clickOnElement(macbook);
    }

    public String textMacbook() {
        return   getTextFromElement(macbookText);
    }

    public void clickOnAddCart() {
        clickOnElement(addCartButton);
    }

    public void clickOnUpdate() {
        clickOnElement(update);
    }
    public String textCartMessage() {
        return   getTextFromElement(cartMessage);
    }

    public String getProduct() {
        return   getTextFromElement(product);
    }

    public void setQuantityTo2() {
        clearTextToElement(quantity);
        sendTextToElement(quantity, "2");
    }


    public String getTotal() {
        return   getTextFromElement(total);
    }

    public void clickOnShopping() {
        clickOnElement(shoppingCart);
    }

    public String textShoppingCartMessage() {
        return   getTextFromElement(shoppingCartText);
    }

    public String textShoppingMacMessage() {
        return   getTextFromElement(MsgSucc);
    }
    public List<Double> getProductPrice(){
        List<WebElement> products = driver.findElements(price);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        return originalProductsPrice;
    }

    public void sortByHightoLow() {
        selectByVisibleTextFromDropDown(highToLow, "Price (High > Low)");
    }








}
