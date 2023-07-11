package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountspageTest extends Utility {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        myAccountPage.clickOnMyAccount();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter "Register”
        myAccountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        String expectedMessage = "Register Account";
        String actualMessage = myAccountPage.getRegisterAccountMsg();
        Assert.assertEquals( expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        myAccountPage.clickOnAccountLink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = myAccountPage.getReturningCustomerMsg();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        myAccountPage.clickOnAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountPage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        myAccountPage.setFirstName();
        //3.4 Enter Last Name
        myAccountPage.setLastName();
        //3.5 Enter Email
        myAccountPage.setEmailName();
        //3.6 Enter Telephone
        myAccountPage.setTelephone();
        //3.7 Enter Password
        myAccountPage.setPassword();
        //3.8 Enter Password Confirm
        myAccountPage.setConfirmPassword();
        //3.9 Select Subscribe Yes radio button
        myAccountPage.subscribe();
        //3.10 Click on Privacy Policy check box
        myAccountPage.setPrivacy();
        //3.11 Click on Continue button
        myAccountPage.clickOnContinue();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals( "Your Account Has Been Created!",
                myAccountPage.accountCreatedMsg());
        //3.13 Click on Continue button
        myAccountPage.clickOnfinalContinue();
        //3.14 Click on My Account Link.
        myAccountPage.clickOnMyAccount();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountPage.selectMyAccountOptions();
        //3.16 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = myAccountPage.getAccountLogoutMsg();
        Assert.assertEquals(expectedMessage, actualMessage);
        //3.17 Click on Continue button
        myAccountPage.clickOnfinalContinue();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        myAccountPage.clickOnMyAccount();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login”
        myAccountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        myAccountPage.setEmaiLogin();
        //4.4 Enter Password
        myAccountPage.setPassword();
        //4.5 Click on Login button
        myAccountPage.loginButton();
        //4.8 Click on My Account Link.
        myAccountPage.clickOnMyAccount();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountPage.selectMyAccountOptions();
        //4.10 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = myAccountPage.getAccountLogoutMsg();
        Assert.assertEquals( expectedMessage, actualMessage);
        //4.11 Click on Continue button
        myAccountPage.clickOnfinalContinue();
    }

}
