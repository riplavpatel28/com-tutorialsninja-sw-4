package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage extends Utility {
    By myAccount = By.xpath("//span[contains(text(),'My Account')]");
    By registerAccount = By.xpath("//h1[contains(text(),'Register Account')]");

    By accountLink = By.xpath("//span[contains(text(),'My Account')]");

    By returningCustomerMsg = By.xpath("//h2[contains(text(),'Returning Customer')]");

    By accountList = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");

    By firstName = By.id("input-firstname");

    By lastName =By.id("input-lastname");

    By email = By.id("input-email");

    By telephone = By.id("input-telephone");

    By password  =By.id("input-password");

    By confirmPassword = By.id("input-confirm");

    By subscribe = By.xpath("//fieldset[3]//input");

    By privacy = By.xpath("//div[@class = 'buttons']//input[@name='agree']");

    By continueButton = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");

    By logout = By.xpath("//h1[contains(text(),'Account Logout')]");

    By finalContinue = By.xpath("//a[contains(text(),'Continue')]");

    By accountCreatedMsg = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    By accountLogoutMsg = By.xpath("//h1[contains(text(),'Account Logout')]");

    By login = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");
    public void clickOnMyAccount(){
        clickOnElement(myAccount);
    }

    public void clickOnAccountLink(){
        clickOnElement(accountLink);
    }

    public String getRegisterAccountMsg(){
        return getTextFromElement(registerAccount);
    }
    public String getReturningCustomerMsg(){
        return getTextFromElement(returningCustomerMsg);
    }
    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements(accountList);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(accountList);
        }
    }

    public void setFirstName(){
        sendTextToElement(firstName, "prime" +  (4));
    }

    public void setLastName(){
        sendTextToElement(lastName, "test" + getAlphaNumericString(4));
    }

    public void setEmailName(){
       sendTextToElement(email, "prime" + getAlphaNumericString(4) + "@gmail.com");
    }

    public void setEmaiLogin(){
        sendTextToElement(email, "prime1233@gmail.com");
    }

    public void setTelephone(){
        sendTextToElement(telephone, "07988112233");
    }

    public void setPassword(){
        sendTextToElement(password, "test1234");
    }

    public void setConfirmPassword(){
        sendTextToElement(confirmPassword, "test1234");
    }

    public void subscribe(){
        selectByContainsTextFromDropDown(subscribe, "Yes");
    }

    public void setPrivacy(){
        clickOnElement(privacy);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }

    public void selectMyAccountOptions(){
        selectMyAccountOptions("Logout");
    }

    public String getAccountLogoutMsg(){
        return  getTextFromElement(accountLogoutMsg);
    }

    public void clickOnfinalContinue(){
        clickOnElement(finalContinue);
    }

    public String accountCreatedMsg(){
        return getTextFromElement(accountCreatedMsg);
    }

    public void loginButton(){
        clickOnElement(login);
    }

}
