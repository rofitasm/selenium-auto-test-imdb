package org.future.rofita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WatchlistPage {

    WebDriver driver;

    String searchKey = "frozen";

    By editButton = By.xpath("//span[text()='EDIT']/parent::a[@title='Edit']");
    By sortByButton = By.id("lister-sort-by-options");
    By gridViewButton = By.xpath("//button[@class='lister-mode-select' and @title='Grid View']");
    By listViewButton = By.xpath("//button[@class='lister-mode-select' and @title='List View']");
    By refineButton = By.xpath("//button[text()='REFINE']");
    By descendingButton = By.xpath("//button[@title='Descending order']");
    By ascendingButton = By.xpath("//button[@title='Ascending order']");

    public WatchlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEdit() {
        driver.findElement(editButton).click();
    }

}
