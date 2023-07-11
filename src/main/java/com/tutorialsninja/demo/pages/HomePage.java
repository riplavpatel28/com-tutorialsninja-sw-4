package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By DesktopsTab = (By.linkText("Desktops"));
    By SelectShowAllDesktops = (By.linkText("Show AllDesktops"));
    By desktopverify = By.xpath("//h2[contains(text(),'Desktops')]");
    //2 method
    By LaptopNotebooksTab = (By.linkText("Laptops & Notebooks"));
    By selectShowAllLaptopsNotebooks = (By.linkText("Show AllLaptops & Notebooks"));
    By LaptopsAndNotebooksTex = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By ComponentsTab = (By.linkText("Components"));
    By SelectShowAllComponents = (By.linkText("Show AllComponents"));
    By ComponentsText = (By.xpath("//h2[contains(text(),'Components')]"));

    By selectMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    public void MouseHoverOnDesktopsTab() {

        mouseHoverToElementAndClick(DesktopsTab);
    }

    public void SelectShowAllDesktops() {

        mouseHoverToElementAndClick(SelectShowAllDesktops);
    }

    public String getDesktopText() {
        return getTextFromElement(desktopverify);
    }

    //2 method
    public void MouseHoverOnLaptopNotebooksTab() {
        mouseHoverToElementAndClick(LaptopNotebooksTab);
    }

    public void SelectShowAllLaptopsNotebooks() {
        mouseHoverToElementAndClick(selectShowAllLaptopsNotebooks);
    }

    public String getLaptopsAndNotebooksText() {
        return getTextFromElement(LaptopsAndNotebooksTex);
    }

    //3 method
    public void mouseHoverOnComponentsTab() {
        mouseHoverToElementAndClick(ComponentsTab);
    }

    public void SelectShowAllComponents() {
        mouseHoverToElementAndClick(SelectShowAllComponents);
    }

    public String verifyComponentsText() {
        return getTextFromElement(ComponentsText);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = getListOfElements(selectMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(selectMenu);
        }
    }

}
