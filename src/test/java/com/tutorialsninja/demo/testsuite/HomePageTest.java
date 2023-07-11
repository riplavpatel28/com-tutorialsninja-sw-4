package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.MouseHoverOnDesktopsTab();
        //1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        homePage.selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = homePage.getDesktopText();
        Assert.assertEquals( expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.MouseHoverOnLaptopNotebooksTab();
        //2.2 call selectMenu method and pass the menu = “Show AllLaptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(  "Laptops & Notebooks",
                homePage.getLaptopsAndNotebooksText());
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverOnComponentsTab();
        //3.2 call selectMenu method and pass the menu = “Show AllComponents”
        homePage.selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals(
                "Components", homePage.verifyComponentsText());
    }



}
