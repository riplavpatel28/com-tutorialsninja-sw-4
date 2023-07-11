package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {
    By desktopsTab = (By.linkText("Desktops"));
    By showAllDesktops = (By.linkText("Show AllDesktops"));

    By allProductName = (By.xpath("//h4/a"));

    By sortProduct = (By.id("input-sort"));


    By currency = (By.xpath("//span[contains(text(),'Currency')]"));

    By poundSterling = (By.xpath("//ul[@class = 'dropdown-menu']/li"));

    By hpLP3065 = (By.xpath("//a[contains(text(),'HP LP3065')]"));

    By datePicker = (By.xpath("//div[@class = 'input-group date']//button"));

    By monthAndYearPicker = (By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']"));

    By nextPicker = (By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));

    By dayPicker = (By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));

    By quantity = By.name("quantity");

    By addToCart = By.xpath("//button[@id='button-cart']");

    By cartSuccessMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");

    By successMessage = By.xpath("//a[contains(text(),'shopping cart')]");

    By shoppingCart = By.xpath("//div[@id='content']//h1");

    By productName = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");

    By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");

    By modelName= By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");

    By total = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    public void mouseHoverToElementAndClick() {
        mouseHoverToElementAndClick(desktopsTab);
    }

    public void clickOnShowAllDesktop() {
        mouseHoverToElementAndClick(showAllDesktops);
    }

    public ArrayList<String> getAllProductName() {
        List<WebElement> products = driver.findElements(allProductName);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }

    public void sortByZtoA() {
        selectByVisibleTextFromDropDown(sortProduct, "Name (Z - A)");
    }

    public void clickOnPoundCurrency() {
        clickOnElement(currency);
        selectByContainsTextFromDropDown(poundSterling, "£Pound Sterling");
    }

    public void sortByAtoZ() {
        selectByVisibleTextFromDropDown(sortProduct, "Name (A - Z)");
    }

    public void clickOnHPLP3065() {
        clickOnElement(hpLP3065);
    }

    public String getHPLP3065() {
        return getTextFromElement(hpLP3065);
    }

    public void selectDeliveryDate() {
        //2.6 Select Delivery Date "2023-11-30"
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = driver.findElement(monthAndYearPicker).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextPicker);
            }
        }
        List<WebElement> allDates = driver.findElements(dayPicker);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void setQuantityTo1() {
        clearTextToElement(quantity);
        sendTextToElement(quantity, "1");
    }

    public void clickOnAddToCart(){
        clickOnElement(addToCart);
    }

    public String getCartSuccessMessage(){
        return getTextFromElement(cartSuccessMessage);
    }

    public void clickOnCartSuccessMessage(){
        clickOnElement(successMessage);
    }

    public String getShoppingCartText(){
        return getTextFromElement(shoppingCart);
    }

    public String getProductNameHp(){
        return getTextFromElement(productName);
    }

    public String getDate(){
        return getTextFromElement(deliveryDate);
    }

    public String getModel(){
        return getTextFromElement(modelName);
    }

    public String getTotal(){
        return getTextFromElement(total);
    }







}
